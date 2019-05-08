package ModelTests;

import DB.Dao.*;
import DB.DaoImpl.*;
import DB.Entites.*;
import Model.UserInput;
import Model.WriteOutput.NutrientsOutput;
import Model.WriteOutput.SoilAnalysisOutput;
import Model.WriteOutput.WaterAnalysisOutput;
import Model.WriteOutput.WriteOutput;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


import static java.time.LocalDate.now;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;




import org.junit.BeforeClass;
import org.junit.Test;

public class WriteOutputTest{
    private static WriteOutput writeOutput;

    @BeforeClass
    public static void init(){
        int cropId = 8;
        variety_type vt = getVarietyType(cropId);
        int soilId = 3;
        int selectedNCredit = 12;
        int irrigationMethod = 1;
        Double irrigationVolume = 2.0;
        int fertilizationMethod = 1;
        Boolean selectedBaseDressing = true;
        Double soilCorrection = 1.0;
        Double ph = 5.5;
        LocalDate localDate = now();
        UserInput ui = new UserInput("aaa",getCrop(cropId),vt,getSoil(soilId),getExpectedYield(vt.getVariety_id()),
                selectedNCredit,getIrrigationMethod(irrigationMethod),irrigationVolume,
                getFertilizationMethod(fertilizationMethod),selectedBaseDressing, soilCorrection,ph,localDate);

        writeOutput  = new WriteOutput(ui);
    }

    @Test
    public void TestNutrientsOutput(){

        List<NutrientsOutput> nutrientsOutputList = new ArrayList<NutrientsOutput>();

        NutrientsOutput no0 = new NutrientsOutput("0",5,0,0,0,0,0,0,0,0,0,0,0);
        NutrientsOutput no1 = new NutrientsOutput("1",1,1,1,1,1,1,1,1,1,1,1,1);
        NutrientsOutput no2 = new NutrientsOutput("2",2,2,2,2,2,2,2,2,2,2,2,2);
        NutrientsOutput no3 = new NutrientsOutput("3",3,3,3,3,3,3,3,3,3,3,3,3);
        NutrientsOutput no4 = new NutrientsOutput("4",4,4,4,4,4,4,4,4,4,4,4,4);
        nutrientsOutputList.add(no0);
        nutrientsOutputList.add(no1);
        nutrientsOutputList.add(no2);
        nutrientsOutputList.add(no3);
        nutrientsOutputList.add(no4);



        try {
            this.writeOutput.writeNutrientsOutput(nutrientsOutputList);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void TestWaterAnalysisOutput(){

        List<WaterAnalysisOutput> waterAnalysisOutputList = new ArrayList<WaterAnalysisOutput>();

        WaterAnalysisOutput no0 = new WaterAnalysisOutput("0",0,"ppm",0,0,0);
        WaterAnalysisOutput no1 = new WaterAnalysisOutput("1",1,"ppm",1,1,1);
        WaterAnalysisOutput no2 = new WaterAnalysisOutput("2",2,"ppm",2,2,2);
        WaterAnalysisOutput no3 = new WaterAnalysisOutput("3",3,"ppm",3,3,3);
        WaterAnalysisOutput no4 = new WaterAnalysisOutput("4",4,"ppm",4,4,4);
        waterAnalysisOutputList.add(no0);
        waterAnalysisOutputList.add(no1);
        waterAnalysisOutputList.add(no2);
        waterAnalysisOutputList.add(no3);
        waterAnalysisOutputList.add(no4);
        try {
            this.writeOutput.writeWaterAnalysisOutput(waterAnalysisOutputList);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void TestSoilAnalysisOutput(){

        List<SoilAnalysisOutput> soilAnalysisOutputsList = new ArrayList<SoilAnalysisOutput>();

        SoilAnalysisOutput no0 = new SoilAnalysisOutput("0",0,"0","0",0,0,0);
        SoilAnalysisOutput no1 = new SoilAnalysisOutput("1",1,"1","1",1,1,1);
        SoilAnalysisOutput no2 = new SoilAnalysisOutput("2",2,"2","2",2,2,2);
        SoilAnalysisOutput no3 = new SoilAnalysisOutput("3",3,"3","3",3,3,3);
        SoilAnalysisOutput no4 = new SoilAnalysisOutput("4",4,"4","4",4,4,4);
        soilAnalysisOutputsList.add(no0);
        soilAnalysisOutputsList.add(no1);
        soilAnalysisOutputsList.add(no2);
        soilAnalysisOutputsList.add(no3);
        soilAnalysisOutputsList.add(no4);
        try {
            this.writeOutput.writeSoilAnalysisOutput(soilAnalysisOutputsList);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Crop getCrop(int id) {
        CropDao cd = new CropDaoImpl();
        Crop c = cd.selectById(id);
        return c;
    }

    public static variety_type getVarietyType (int cropId) {
        crop_expected_yield_validationDao ceyv = new crop_expected_yield_validationDaoImpl();
        List<Integer> matchVarTypeId = ceyv.getMatchVarType(cropId);

        variety_typeDao varTypeDao = new variety_typeDaoImpl();
        List<variety_type> matchVarType = new ArrayList<>();
        for (int id : matchVarTypeId) {
            variety_type vt = varTypeDao.selectById(id);
            matchVarType.add(vt);
        }
        variety_type vt = matchVarType.get(0);
        return vt;
    }

    public static Soil getSoil(int id) {
        SoilDao sd = new SoilDaoImpl();
        Soil s = sd.selectById(id);
        return s;
    }

    public static double getExpectedYield(int varTypeId) {
        Double minRange = null;
        Double maxRange = null;
        crop_expected_yield_validationDao ceyv = new crop_expected_yield_validationDaoImpl();
        List<crop_expected_yield_validation> expYieldList = ceyv.selectAll();
        for (crop_expected_yield_validation c : expYieldList) {
            if (c.getVariety_id() == varTypeId) {
                minRange = c.getMin_yield();
                maxRange = c.getMax_yield();
                break;
            }
        }
        //the conversion is used in order to not work with fractions (for testing)
        int minRangeInt = minRange.intValue();
        int maxRangeInt = maxRange.intValue();
        Random rnd = new Random();
        int expectedYield = rnd.nextInt((maxRangeInt - maxRangeInt) + 1) + minRangeInt;
        double expectedYieldD = (double) expectedYield;
        return expectedYieldD;
    }

    public static IrrigationMethod getIrrigationMethod(int irrigationMethodId) {
        IrrigationMethodDao imd = new IrrigationMethodDaoImpl();
        IrrigationMethod im = imd.selectById(irrigationMethodId);
        return im;
    }

    public static fertilization_method getFertilizationMethod(int fertilizationMethodId) {
        fertilization_methodDao fmd = new fertilization_methodDaoImpl();
        fertilization_method fm = fmd.selectById(fertilizationMethodId);
        return fm;
    }

}
