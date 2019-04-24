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

    public void calculateRemoval(Nutrients n) {
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
        double minYield = expected.getMin_yield();
        double maxYield = expected.getMax_yield();
        System.out.println("crop ID is: " + cropId + " variety id is: " + varietyId);

        double corretctionFactor = (1.25-0.75)/(minYield-maxYield); //;
        double yieldCorrection = 1.25 + corretctionFactor*(expectedYield-minYield);

        List<Double> remove = new ArrayList<>();
        for (int i=0;i<a.size();i++) {
            remove.add((a.get(i)*expectedYield + b.get(i))*yieldCorrection);
        }
        nutrients.setBasicRemoval(remove);
        nutrients.setName(name);


        //Calculate Nutrients per stage:
        //Create matrix for caulculations:





    }
}
