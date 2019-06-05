package Model;

import java.util.ArrayList;
import java.util.List;
import DB.Dao.*;
import DB.DaoImpl.*;
import DB.Entites.*;
import Model.WriteOutput.NutrientsOutput;

/**
 * the class is responsible for calculation of the amount of removal
 * that is needed for each of the nutrients - total and per stage.
 */
public class NutrientsBasicRemoval {

    private UserInput ui;

    /**
     * the constructor receives the user input.
     * @param ui - the user's input.
     */
    public NutrientsBasicRemoval(UserInput ui) {
        this.ui = ui;
    }

    /**
     * calculates the amount of removal in kg which is needed
     * for each nutrient total, and for each stage of the crop's growth, pre season.
     * sets the removal calculations in the nutrients class, and then returns it.
     * @param parameters - the parameters data
     * @return nutrients - crop's nutrients data
     */
    public Nutrients calculateRemoval(Parameters parameters) {
        Nutrients nutrients = new Nutrients();
        PreSeason ps = new PreSeason();
        nutrients.setPs(ps);
        //a is nutrients removal in Kg per 1 MT yield
        List<Double> a = new ArrayList<>();
        //b is basic nutrients removal (independent from yield)
        List<Double> b = new ArrayList<>();
        List<String> name = new ArrayList<>();
        int cropId = ui.getSelectedCrop().getId();
        int varietyId = ui.getSelectedVarType().getVariety_id();

        crop_expected_yield_validationDao expectedDao = new crop_expected_yield_validationDaoImpl();
        parameter_cropDao parameterCropDao = new parameter_cropDaoImpl();
        elementsDao elem = new elementsDaoImpl();

        List<crop_expected_yield_validation> expectedList = expectedDao.selectAll();
        List<parameter_crop> parameterCropList = parameterCropDao.selectAll();
        parameter_crop pc1 = parameterCropDao.selectById(2);
        int select = 0;
        //get the correct validation id, based on the crop id and variety id
        for (crop_expected_yield_validation ev:expectedList) {
            if (ev.getVariety_id() == varietyId && ev.getCrop_id() == cropId) {
                select = ev.getValidation_id();
                break;
            }
        }
        //for each nutrient, get the total amount and base line
        for (parameter_crop pc:parameterCropList) {
            if (pc.getVariety_id() == varietyId && pc.getCrop_id() == cropId) {
                a.add(pc.getAmount());
                b.add(pc.getBase_line());
                name.add(elem.selectById(pc.getParameter_id()).getSymbol());
                System.out.println(pc.getAmount());
            }
        }
        //select the previously calculated validation id, in order to get min and max yield values
        crop_expected_yield_validation expected = expectedDao.selectById(select);
        //needs to see how to calculate
        double expectedYield =ui.getSelectedexpectedYield();
        System.out.println("expected yield is" +expectedYield);
        double minYield = expected.getMin_yield();
        System.out.println("min yield is: " + minYield);
        double maxYield = expected.getMax_yield();
        System.out.println("max yield is: " + maxYield);
        System.out.println("crop ID is: " + cropId + " variety id is: " + varietyId);

        double correctionFactor = (1.25-0.75)/(minYield-maxYield);
        System.out.println("correction is:" + correctionFactor);
        double yieldCorrection = 1.25 + correctionFactor*(expectedYield-minYield);
        System.out.println("yield correction is: " + yieldCorrection);
        //list that contains the amount of each nutrient that needs to be removed
        List<Double> remove = new ArrayList<>();
        for (int i=0;i<a.size();i++) {
            //calculate each removal amount by using a formula
            remove.add((a.get(i)*expectedYield + b.get(i))*yieldCorrection);
            System.out.println("remove:" + remove.get(i));
        }
        nutrients.setBasicRemoval(remove);
        nutrients.setName(name);

        //per stage removal calculation
        ParameterPerStageDao  ppsd= new ParameterPerStageDaoImpl();
        List<ParameterPerStage> pps = ppsd.selectAll();
        System.out.println("parameter per stage id at 0 is: " + pps.get(0).getPhenologicalStageId());
        List<ParameterPerStage> ppst = new ArrayList<>();
        //add all parameter per stage info, based on the variety number id
        for (ParameterPerStage parameterPerStage:pps) {
            if (varietyId == ui.getSelectedVarType().getVariety_id()) {
                ppst.add(parameterPerStage);
            }
        }
        List<Double> removalPerStage = new ArrayList<>();
        int countermaster = 0;
        //traverse each stage
        for (int i = 0; i<parameters.getCropStages().size(); i++) {
            int counter = i;
            //traverse each nutrient amount in a given stage
            for (int j=0;j<nutrients.getBasicRemoval().size();j++) {
                //calculates the percentage of the total calculated amount to remove for current stage
                removalPerStage.add((ppst.get(counter).getPercent())*nutrients.getBasicRemoval().get(j));
                counter+=parameters.getCropStages().size();
                countermaster++;
            }
        }
        //a list in which each object represents a stage nutrients to remove
        List<NutrientsBasicRemovalPerStage> nbrpsList = new ArrayList<>();
        int counter = 0;
        int multi = 0;
        //add to list the breakdown of basic removal per stage
        System.out.println("removal per stage size is" + removalPerStage.size());
        //creates a class for each 12 nutrients removal per stage
        for (int i=0;i<removalPerStage.size();i+=nutrients.getBasicRemoval().size()) {
            NutrientsBasicRemovalPerStage nbrps = new NutrientsBasicRemovalPerStage(parameters.getCropStages().get(counter),
                    removalPerStage.get(multi), removalPerStage.get(multi+1),
                    removalPerStage.get(multi+2), removalPerStage.get(multi+3),
                    removalPerStage.get(multi+4), removalPerStage.get(multi+5),
                    removalPerStage.get(multi+6), removalPerStage.get(multi+7),
                    removalPerStage.get(multi+8), removalPerStage.get(multi+9),
                    removalPerStage.get(multi+10), removalPerStage.get(multi+11));
            nbrpsList.add(nbrps);
            counter++;
            multi+=nutrients.getBasicRemoval().size();
        }
        nutrients.setBasicRemovalPerStages(nbrpsList);

        //adding basic removal to nutrients output table
        List<NutrientsOutput> nutrientsOutputList = new ArrayList<>();
        NutrientsOutput nOutputBasicRemoval = new NutrientsOutput("Basic_Removal", remove);
        nutrientsOutputList.add(nOutputBasicRemoval);
        //updates in the nutrient class the adj nutrients output list
        nutrients.getPreSeason().setAdjNutrients(nutrientsOutputList);
        return nutrients;
    }
}
