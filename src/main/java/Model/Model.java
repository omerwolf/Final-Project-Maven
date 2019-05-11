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

import java.util.ArrayList;
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
        StageDate sd = new StageDate();
        p = sd.stageDate(p);
        for (StageDate d : p.getStageDates()) {
            System.out.println(d.getStageName() + " " + d.getStageDate());
        }
        Nutrients n = new Nutrients();
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
        PhAdjustment pha = new PhAdjustment();
        n = pha.phAdjustment(p,n,0);
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
}
