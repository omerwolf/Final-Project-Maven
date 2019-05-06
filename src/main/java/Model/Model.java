package Model;


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
        Parameters p = new Parameters();
        p.setUi(ui);
        StageDate sd = new StageDate();
        p = sd.stageDate(p);
        for (StageDate d : p.getStageDates()) {
            System.out.println(d.getStageName() + " " + d.getStageDate());
        }
        Nutrients n = new Nutrients();
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
        System.out.println(n.getSoilNutrients().getnCredits().get(0));
        //needs to add a check if lab analysis exists.
        OrganicMatterContribution omc = new OrganicMatterContribution();
        n = omc.organicMatterContribution(p, n);
        PreSeasonNutrientsSoilAnalysis psnsa = new PreSeasonNutrientsSoilAnalysis();
        n = psnsa.PreSeasonNutrientsSoilAnalysis(p, n);
        //SoilAnalysisDao sad = new SoilAnalysisDaoImpl();
        //SoilAnalysis sa =
        //System.out.println(p.getUi().getSelectedCrop().getName());
        //ParameterPerStageDao pps = new ParameterPerStageDaoImpl();
        //pps.autoInsertAll();
    }
}
