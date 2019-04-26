package Model;

import java.util.ArrayList;
import java.util.List;
import DB.Dao.*;
import DB.DaoImpl.*;
import DB.Entites.*;
public class NutrientsBasicRemoval {

    private UserInput ui;
    public NutrientsBasicRemoval(UserInput ui) {
        this.ui = ui;
    }

    public Nutrients calculateRemoval(Parameters parameters) {
        Nutrients nutrients = new Nutrients();
        List<Double> a = new ArrayList<>();
        List<Double> b = new ArrayList<>();
        List<String> name = new ArrayList<>();
        int cropId = ui.getSelectedCrop().getId();
        int varietyId = ui.getSelectedVarType().getVariety_id();

        crop_expected_yield_validationDao expectedDao = new crop_expected_yield_validationDaoImpl();
        parameter_cropDao parameterCropDao = new parameter_cropDaoImpl();
        elementsDao elem = new elementsDaoImpl();

        List<crop_expected_yield_validation> expectedList = expectedDao.selectAll();
        List<parameter_crop> parameterCropList = parameterCropDao.selectAll();
        //parameterCropDao.autoInsertAll();
        System.out.println(parameterCropList.size());
        parameter_crop pc1 = parameterCropDao.selectById(2);
        System.out.println(pc1.getVariety_id());
        int select = 0;
        for (crop_expected_yield_validation ev:expectedList) {
            if (ev.getVariety_id() == varietyId && ev.getCrop_id() == cropId) {
                select = ev.getValidation_id();
                break;
            }
        }
        for (parameter_crop pc:parameterCropList) {
            if (pc.getVariety_id() == varietyId && pc.getCrop_id() == cropId) {
                a.add(pc.getAmount());
                b.add(pc.getBase_line());
                name.add(elem.selectById(pc.getParameter_id()).getSymbol());
                System.out.println(pc.getAmount());
            }
        }
        crop_expected_yield_validation expected = expectedDao.selectById(select);
        //needs to see how to calculate
        double expectedYield =ui.getSelectedexpectedYield();
        System.out.println("expected yield is" +expectedYield);
        double minYield = expected.getMin_yield();
        System.out.println("min yield is: " + minYield);
        double maxYield = expected.getMax_yield();
        System.out.println("max yield is: " + maxYield);
        System.out.println("crop ID is: " + cropId + " variety id is: " + varietyId);

        double corretctionFactor = (1.25-0.75)/(minYield-maxYield); //;
        double yieldCorrection = 1.25 + corretctionFactor*(expectedYield-minYield);

        List<Double> remove = new ArrayList<>();
        for (int i=0;i<a.size();i++) {
            remove.add((a.get(i)*expectedYield + b.get(i))*yieldCorrection);
            System.out.println("remove:" + remove.get(i));
        }
        nutrients.setBasicRemoval(remove);
        nutrients.setName(name);

        //Calculate Nutrients per stage:
        //Create matrix for caulculations:

        ParameterPerStageDao  ppsd= new ParameterPerStageDaoImpl();
        List<ParameterPerStage> pps = ppsd.selectAll();
        System.out.println("parameter per stage id at 0 is: " + pps.get(0).getPhenologicalStageId());
        List<ParameterPerStage> ppst = new ArrayList<>();
        for (ParameterPerStage parameterPerStage:pps) {
            if (varietyId == ui.getSelectedVarType().getVariety_id()) {
                ppst.add(parameterPerStage);
            }
        }
        List<Double> removalPerStage = new ArrayList<>();
        int countermaster = 0;
        //System.out.println("the stage dates size is: " + parameters.getStageDates().size());
        for (int i=0;i<parameters.getStageDates().size();i++) {
            int counter = i;
            for (int j=0;j<nutrients.getBasicRemoval().size();j++) {
                //System.out.println("counter is: " + counter);
                removalPerStage.add((ppst.get(counter).getPercent())*nutrients.getBasicRemoval().get(j));
                counter+=parameters.getStageDates().size();
                countermaster++;
            }
            //NutrientsBasicRemovalPerStage nb = new NutrientsBasicRemovalPerStage();
            //nb.setN(nutrients.getBasicRemoval().get())

        }
        List<NutrientsBasicRemovalPerStage> nbrpsList = new ArrayList<>();
        List<Double> copy = nutrients.getBasicRemoval();
        int counter =0;
        int multi = 0;
        for (int i=0;i<removalPerStage.size();i+=nutrients.getBasicRemoval().size()) {
            NutrientsBasicRemovalPerStage nbrps = new NutrientsBasicRemovalPerStage(parameters.getStageDates().get(counter),
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
        return nutrients;


    }
}
