package Model;

import DB.Dao.layer_depth_typeDao;
import DB.Dao.soil_thresholdsDao;
import DB.DaoImpl.layer_depth_typeDaoImpl;
import DB.DaoImpl.soil_thresholdsDaoImpl;
import DB.Entites.Soil;
import DB.Entites.layer_depth_type;
import DB.Entites.soil_thresholds;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PreSeasonNutrientsSoilAnalysis {

    public PreSeasonNutrientsSoilAnalysis() {

    }

    public Nutrients PreSeasonNutrientsSoilAnalysis(Parameters p, Nutrients n) {
        double soilCorrectionFactor = p.getUi().getSelectedSoilCorrection();
        //read p factors from parameters table (in system table) - need to add
        //yes no activation if - to complete/check with ofer


        Soil soil = n.getSoil();
        int layerDepthId = p.getSa().getLayer_depth_id();
        layer_depth_typeDao ldtd = new layer_depth_typeDaoImpl();
        layer_depth_type ldt = ldtd.selectById(layerDepthId);
        double layerAvg = (double)(ldt.getLayer_max() - ldt.getLayer_min());
        double layerDepth = layerAvg/100; // divide value (taken from DB) by 100
        double db;
        if (p.getSa().getBulk_density() != null) {
            db = 1000 * p.getSa().getBulk_density();
        }
        else {
            db = 1000 * n.getSoil().getDefualtBulkDensity(); //get default value
        }
        double cec;
        if (p.getSa().getSoil_CEC() != null) {
            cec = p.getSa().getSoil_CEC();
        }
        else {
            soil.getDefualtCEC(); //default bulk density in matlab - seems like a mistake
        }

        double soilWeight = db * layerDepth * 10000; //soil weight in kg/ha

        double wettedArea = p.getUi().getSelectedIrrigationVolume(); //wetted area is different?


        //determine phenological stage - to be complete
        Boolean preSeason;
        String stage;
        LocalDate userDate = p.getUi().getSelectedDate();
        if (userDate == null) {
            userDate = LocalDate.now();
        }
        LocalDate sampleDate = p.getSa().getSample_date();
        if (sampleDate.isBefore(userDate)) {
            stage = "pre-season";
            preSeason = true;
        }
        else {
            stage = p.getStageDates().get(0).stageName; //get the name of first stage of crop
            preSeason = false;
        }
        soil_thresholdsDao std = new soil_thresholdsDaoImpl();
        List<soil_thresholds> stList = std.selectAll(); //get thresholds (currently includes n thresholds)
        List<String> nutrientNames = Arrays.asList("N", "P" ,"K" ,"Ca" ,"Mg" ,"S" ,"Fe" ,"B" ,"Mn" ,"Zn", "Cu" ,"Mo");
        List<String> thString;
        //a bit more

        List<Double> soilNutrientsResults = new ArrayList<Double>(Collections.nCopies(nutrientNames.size(),0.0));
        List<String> analysisStatus = new ArrayList<String>(Collections.nCopies(nutrientNames.size(),null));
        List<String> soilThresholds = new ArrayList<String>(Collections.nCopies(nutrientNames.size(),null));
        List<Double> soilNutrients_Balance = new ArrayList<Double>(Collections.nCopies(nutrientNames.size(),0.0));
        List<Double> soilReccomendation = new ArrayList<Double>(Collections.nCopies(nutrientNames.size(),0.0));
        List<Double> soilCorrection = new ArrayList<Double>(Collections.nCopies(nutrientNames.size(),0.0));

        double nh4 = p.getSlar().get(12).getParameter_value(); //13th element value - can be done in the long way.
        double n03 = p.getSlar().get(13).getParameter_value(); //14th element value - can be done in the long way.
        //double nOrganic = p.getSlar().get(19).getParameter_value(); //20th element value - can be done in the long way.
        double nOrganic = 0; //should be read from slar (needs to add to lab_results
        double nTotal = nh4 + n03; //skipped null check, since it does not appear in final soil analysis input




        return n;
    }
}
