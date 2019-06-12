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
import Model.WriteOutput.WriteOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model {
    final Integer soilAnalysisId;
    final Integer waterAnalysisId;
    final UserInput ui;



    public Model(Integer soilAnalysisId, Integer waterAnalysisId, UserInput ui) {
        this.soilAnalysisId = soilAnalysisId;
        this.waterAnalysisId = waterAnalysisId;
        this.ui = ui;

    }

    public void init() {
        SoilAnalysisDao sad = new SoilAnalysisDaoImpl();
        WaterAnalysisDao wad = new WaterAnalysisDaoImpl();
        SoilAnalysis sa = null;
        WaterAnalysis wa = null;
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
        List<SoilLabAnalysisResult> soilLabAnalysisResults = lard.selectAllSoilById(111); //temporal - lower table
        List<WaterLabAnalysisResult> waterLabAnalysisResults = lard.selectAllWaterById(19); //temporal - lower table


        Parameters p = new Parameters(ui, sa, wa, soilLabAnalysisResults, waterLabAnalysisResults);
        List<NutrientsOutput> nutrientsOutputs = new ArrayList<>();
        PreSeason ps = new PreSeason(); //add preseason - location of creation may change
        StageDate sd = new StageDate();
        p = sd.stageDate(p);
        for (CropStage d : p.getCropStages()) {
            System.out.println(d.getStageName() + " " + d.getStageDate());
        }
        Nutrients n;
        NutrientsBasicRemoval nbr = new NutrientsBasicRemoval(ui);
        n = nbr.calculateRemoval(p);
        String basicRemoval = "Basic Removal";
        nutrientsOutputs.add(addNutrientOutput(n,basicRemoval)); //add basic removal for output table
        List<NutrientsBasicRemovalPerStage> lista = n.getBasicRemovalPerStages();
        for (NutrientsBasicRemovalPerStage na : lista) {
            System.out.println(na.print());
        }

        SoilType st = new SoilType();
        n = st.soilType(p, n);
        NCredit ncredit = new NCredit();
        n = ncredit.nCredit(p, n);
        System.out.println(n.getSoilNutrients().getnCredits().get(0));
        //needs to add a check if lab analysis exists.
        OrganicMatterContribution omc = new OrganicMatterContribution();
        n = omc.organicMatterContribution(p, n);
        PreSeasonNutrientsSoilAnalysis psnsa = new PreSeasonNutrientsSoilAnalysis();
        n = psnsa.PreSeasonNutrientsSoilAnalysis(p, n);
        OrganicNitrogenLogic onl = new OrganicNitrogenLogic();
        n = onl.calculateOnl(p,n);

        n = calculateSummaryAdjTable(p,n);
        //if pre season, write to output the soil Analysis output (nutrients->preseason->soilanalysis



        PhAdjustment pha = new PhAdjustment();
        n = pha.phAdjustment(p,n,0);
        FertilizationEfficiency fe = new FertilizationEfficiency();
        n = fe.calculateFertilizationEfficiency(p,n);
        NutrientsWaterAnalysis nwa = new NutrientsWaterAnalysis();
        n = nwa.nutrientsWaterAnalysis(p,n);

        exportOutputTables(n);
    }

    public void testSoilAnalysisOutput(SoilAnalysis sa) {
        System.out.println("soil analysis id " + sa.getSoil_analysis_id());
        System.out.println("farm id " + sa.getFarm_id());
        System.out.println("sample date " + sa.getSample_date());
        System.out.println("lab id " + sa.getLab_id());
        System.out.println("test type id " + sa.getTest_type_id());
        System.out.println("sample name " + sa.getSample_name());
        System.out.println("irrigation block " + sa.getIrrigation_block_id());
        System.out.println("soil ph " + sa.getSoil_pH());
        System.out.println("soil ec " + sa.getSoil_EC());
        System.out.println("soil cec " + sa.getSoil_CEC());
        System.out.println("layer depth id " + sa.getLayer_depth_id());
        System.out.println("soil type id " + sa.getSoil_type_id());
        System.out.println("bulk density " + sa.getBulk_density());
        System.out.println("organic matter " + sa.getOrganic_matter());
    }

    public NutrientsOutput addNutrientOutput(Nutrients n, String name) {
        List<Double> basicR = n.getBasicRemoval();
        NutrientsOutput nutrientsOutput = new NutrientsOutput(name, basicR.get(0),basicR.get(1),basicR.get(2),
                basicR.get(3),basicR.get(4),basicR.get(5),basicR.get(6),basicR.get(7),basicR.get(8),basicR.get(9)
                ,basicR.get(10),basicR.get(11));
        return nutrientsOutput;
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
}
