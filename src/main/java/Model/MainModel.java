package Model;

import Analysis.LabAnalysisResults.*;
import Analysis.SoilAnalysis.*;
import Analysis.WaterAnalysis.*;
import DB.Dao.*;
import DB.DaoImpl.*;
import DB.Entites.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainModel {

    public static void main(String[] args) {
        String name = "presoil";
        int cropId = 8;
        variety_type vt = getVarietyType(cropId);
        int soilId = 3;
        int selectedNCredit = 12;
        int irrigationMethod = 1;
        Double irrigationVolume = 350.0;
        int fertilizationMethod = 3;
        Boolean selectedBaseDressing = true;
        Double soilCorrection = 1.0;
        Double ph = 5.5;
        String date = "02/01/2016";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateTime = LocalDate.parse(date, formatter);
        UserInput ui = new UserInput(name,getCrop(cropId),vt,getSoil(soilId),getExpectedYield(vt.getVariety_id()),
                selectedNCredit,getIrrigationMethod(irrigationMethod),irrigationVolume,
                getFertilizationMethod(fertilizationMethod),selectedBaseDressing, soilCorrection,ph,null);
        Model model = new Model(111,19,ui);
        model.init();

        SoilAnalysisDao sad = new SoilAnalysisDaoImpl();
        WaterAnalysisDao wad = new WaterAnalysisDaoImpl();
        LabAnalysisResultDao lard = new LabAnalysisResultDaoImpl();
        List<SoilLabAnalysisResult> soilLabAnalysisResults = lard.selectAllSoilById(111);
        /*for (SoilLabAnalysisResult s : soilLabAnalysisResults) {
            System.out.println(s);
            System.out.println("///////////////////");
        }

        System.out.println("******************");*/

        List<WaterLabAnalysisResult> waterLabAnalysisResults = lard.selectAllWaterById(19);
        /*for (WaterLabAnalysisResult w : waterLabAnalysisResults) {
            System.out.println(w);
            System.out.println("///////////////////");
        }*/


    }

    public static Crop getCrop(int id) {
        Dao<Crop> cd = new CropDaoImpl();
        Crop c = cd.selectById(id);
        return c;
    }

    public static variety_type getVarietyType (int cropId) {
        crop_expected_yield_validationDao ceyv = new crop_expected_yield_validationDaoImpl();
        List<Integer> matchVarTypeId = ceyv.getMatchVarType(cropId);

        Dao<variety_type> varTypeDao = new variety_typeDaoImpl();
        List<variety_type> matchVarType = new ArrayList<>();
        for (int id : matchVarTypeId) {
            variety_type vt = varTypeDao.selectById(id);
            matchVarType.add(vt);
        }
        variety_type vt = matchVarType.get(0);
        return vt;
    }

    public static Soil getSoil(int id) {
        Dao<Soil> sd = new SoilDaoImpl();
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
        int expectedYield = rnd.nextInt((maxRangeInt - minRangeInt) + 1) + minRangeInt;
        double expectedYieldD = (double) expectedYield;
        //System.out.println("chosen expected yield " + expectedYieldD);
        expectedYieldD = 100;
        return expectedYieldD;
    }

    public static IrrigationMethod getIrrigationMethod(int irrigationMethodId) {
        Dao<IrrigationMethod> imd = new IrrigationMethodDaoImpl();
        IrrigationMethod im = imd.selectById(irrigationMethodId);
        return im;
    }

    public static fertilization_method getFertilizationMethod(int fertilizationMethodId) {
        Dao<fertilization_method> fmd = new fertilization_methodDaoImpl();
        fertilization_method fm = fmd.selectById(fertilizationMethodId);
        return fm;
    }
}
