package Model;

import DB.Dao.layer_depth_typeDao;
import DB.DaoImpl.layer_depth_typeDaoImpl;
import DB.Entites.Soil;
import DB.Entites.layer_depth_type;

public class PreSeasonNutrientsSoilAnalysis {

    public PreSeasonNutrientsSoilAnalysis() {

    }

    public Nutrients PreSeasonNutrientsSoilAnalysis(Parameters p, Nutrients n) {
        // p factor assigns - to complete

        //yes no activation if - to complete/check with ofer


        Soil soil = n.getSoil();
        int layerDepthId = p.getSa().getLayer_depth_id();
        layer_depth_typeDao ldtd = new layer_depth_typeDaoImpl();
        layer_depth_type ldt = ldtd.selectById(layerDepthId);
        double layerAvg = (double)(ldt.getLayer_min() + ldt.getLayer_max())/2;
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

        //th checks - will be filled after th table is added to db


        return n;
    }
}
