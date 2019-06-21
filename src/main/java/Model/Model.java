package Model;


import Analysis.LabAnalysisResults.LabAnalysisResultDao;
import Analysis.LabAnalysisResults.LabAnalysisResultDaoImpl;
import Analysis.LabAnalysisResults.SoilLabAnalysisResult;
import Analysis.LabAnalysisResults.WaterLabAnalysisResult;
import Analysis.SoilAnalysis.SoilAnalysis;
import Analysis.SoilAnalysis.SoilAnalysisDao;
import Analysis.SoilAnalysis.SoilAnalysisDaoImpl;
import Analysis.WaterAnalysis.*;
import Model.WriteOutput.NutrientsOutput;
import Model.WriteOutput.SoilAnalysisOutput;
import Model.WriteOutput.WaterAnalysisOutput;
import Model.WriteOutput.WriteOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * responsible for running the model.
 * receives input from the user, and optionally input of soil/water/tissue analysis),
 * and use them throughout the model in order to get an output of the expected amounts
 * that are needed for each one of the nutrients for the requested crop to grow.
 */
public class Model {
    final Integer soilAnalysisId;
    final Integer waterAnalysisId;
    final UserInput ui;


    /**
     * creates the model class. receives user input, and soil and water analysis(can be null).
     * @param soilAnalysisId - the id of the soil analysis info which was inserted as an input.
     * @param waterAnalysisId - the id of the water analysis info which was inserted as an input.
     * @param ui - the user input.
     */
    public Model(Integer soilAnalysisId, Integer waterAnalysisId, UserInput ui) {
        this.soilAnalysisId = soilAnalysisId;
        System.out.println("i have an id at it is: " + soilAnalysisId);
        this.waterAnalysisId = waterAnalysisId;
        System.out.println("i have an id at it is: " + waterAnalysisId);
        this.ui = ui;
        //System.out.println(ui.toString());

    }

    /**
     * initiates the model. calls all necessary classes and methods,
     * in order to calculate the output, which is then created
     * as an excel file.
     */
    public void init() {
        SoilAnalysisDao sad = new SoilAnalysisDaoImpl();
        WaterAnalysisDao wad = new WaterAnalysisDaoImpl();
        SoilAnalysis sa = null; //general soil analysis data record
        WaterAnalysis wa = null; // general water analysis data record
        if (soilAnalysisId != null) {
            System.out.println("soil analysis isn't null and id is: " + soilAnalysisId);
            sa = sad.selectById(soilAnalysisId); //temporal - top table
        }
        if (waterAnalysisId != null) {
            wa = wad.selectById(waterAnalysisId); // temporal - top table
        }

        System.out.println("the crop is: " + ui.getSelectedCrop().getName());
        System.out.println("the variety is: " + ui.getSelectedVarType().getVariety_name());
        LabAnalysisResultDao lard = new LabAnalysisResultDaoImpl();
        List<SoilLabAnalysisResult> soilLabAnalysisResults = null;
        List<WaterLabAnalysisResult> waterLabAnalysisResults = null;
        //creates soil/water analysis lab results records (if soil/water analysis isn't null)
        if (soilAnalysisId != null) {
            soilLabAnalysisResults = lard.selectAllSoilById(soilAnalysisId);
        }
        if (waterAnalysisId != null) {
            waterLabAnalysisResults = lard.selectAllWaterById(waterAnalysisId);
        }


        Parameters p = new Parameters(ui, sa, wa, soilLabAnalysisResults, waterLabAnalysisResults);
        StageDate sd = new StageDate();
        p = sd.stageDate(p);
        for (CropStage d : p.getCropStages()) {
            System.out.println(d.getStageName() + " " + d.getStageDate());
        }
        Nutrients n;
        NutrientsBasicRemoval nbr = new NutrientsBasicRemoval(ui);
        n = nbr.calculateRemoval(p);
        List<NutrientsBasicRemovalPerStage> lista = n.getBasicRemovalPerStages();
        for (NutrientsBasicRemovalPerStage na : lista) {
            System.out.println(na.print());
        }

        SoilType st = new SoilType();
        n = st.soilType(p, n);
        NCredit ncredit = new NCredit();
        n = ncredit.nCredit(p, n);

        //if lab analysis exists, proceed for the following calculations.
        if (p.getSa() != null) {
            OrganicMatterContribution omc = new OrganicMatterContribution();
            n = omc.organicMatterContribution(p, n);
            PreSeasonNutrientsSoilAnalysis psnsa = new PreSeasonNutrientsSoilAnalysis();
            n = psnsa.PreSeasonNutrientsSoilAnalysis(p, n);
            OrganicNitrogenLogic onl = new OrganicNitrogenLogic();
            n = onl.calculateOnl(p, n);
        }

        n = roundResults(n);
        n = calculateSummaryAdjTable(p,n);
        //if pre season, write to output the soil Analysis output (nutrients->preseason->soilanalysis



        PhAdjustment pha = new PhAdjustment();
        n = pha.phAdjustment(p,n,0);
        FertilizationEfficiency fe = new FertilizationEfficiency();
        n = fe.calculateFertilizationEfficiency(p,n);
        NutrientsWaterAnalysis nwa = new NutrientsWaterAnalysis();
        n = nwa.nutrientsWaterAnalysis(p,n);

        //creates the output tables
        exportOutputTables(n);
    }

    /**
     * calculates the summary of the nutrients in the adjustment table.
     * @param p - the parameters data.
     * @param n - the nutrients data.
     * @return the nutrients data, updated.
     */
    public Nutrients calculateSummaryAdjTable(Parameters p, Nutrients n) {

        List<NutrientsOutput> nutrientsOutputList = n.getPreSeason().getAdjNutrients();
        List<Double> summary = new ArrayList<Double>(Collections.nCopies(12,0.0));
        for (int i=0;i<nutrientsOutputList.size();i++) {
            List<Double> currentNutrientOutput = nutrientsOutputList.get(i).nutrientsList();
            for (int j=0;j<currentNutrientOutput.size();j++) {
                summary.set(j, summary.get(j) + currentNutrientOutput.get(j));
            }
        }
        //negative sums will receive a 0 value.
        for (int i=0;i<summary.size();i++) {
            if (summary.get(i) < 0) {
                summary.set(i, 0.0);
            }
        }
        System.out.println("summary is: "+summary);
        NutrientsOutput summaryOutput = new NutrientsOutput("summary",summary);
        nutrientsOutputList.add(summaryOutput);
        n.getPreSeason().setAdjNutrients(nutrientsOutputList);
        return n;
    }

    /**
     * creates an excel file for all tables (adjustment nutrients, actual nutrients,
     * water analysis and soil analysis).
     * @param n - the nutrients data.
     */
    public void exportOutputTables(Nutrients n) {
        System.out.println("ui something is " + ui.getSelectedSoil().getName());
        WriteOutput writeOutput = new WriteOutput(ui);
        try {
        writeOutput.writeNutrientsOutput(n.getPreSeason().getAdjNutrients());
        writeOutput.writeNutrientsOutput(n.getPreSeason().getActualNutrients());
        writeOutput.writeSoilAnalysisOutput(n.getPreSeason().getSoilAnalysis());
        writeOutput.writeWaterAnalysisOutput(n.getPreSeason().getWaterAnalysis());
        }
        catch(Exception e) {
            System.out.println("there was an error with one or more of the outputs");
            System.out.println(e.getMessage());
        }
    }

    /**
     * rounds the adjustment nutrients table and the actual nutrient table
     * values, so that each value won't have too many digits after the
     * decimal point.
     * @param n - the nutrients data
     * @return the nutrients data, updated with the rounded values.
     */
    public Nutrients roundResults(Nutrients n) {
        List<NutrientsOutput> adjust = n.getPreSeason().getAdjNutrients();
        List<NutrientsOutput> actual = n.getPreSeason().getActualNutrients();
        for (int i=0;i<adjust.size();i++) {
            adjust.get(i).round();
        }
        for (int i=0;i<actual.size();i++) {
            actual.get(i).round();
        }
        return n;
    }
}
