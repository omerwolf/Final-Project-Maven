package Model;

import DB.Dao.SoilDao;
import DB.Dao.layer_depth_typeDao;
import DB.DaoImpl.SoilDaoImpl;
import DB.DaoImpl.layer_depth_typeDaoImpl;
import DB.Entites.Soil;
import DB.Entites.layer_depth_type;

public class OrganicNitrogenLogic {

    public OrganicNitrogenLogic() {

    }

    public Nutrients calculateOnl(Parameters p, Nutrients n) {

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

        double soilWeight = db * layerDepth * 10000 ; // soil weight in kg/ha
        double wettedArea = p.getUi().getSelectedIrrigationVolume(); //wetted area is different?

        Double nOrganic = 32.0; //needs to be read from analysis - add column?
        if (nOrganic != null && nOrganic!= 0) {
            double kg = (nOrganic * soilWeight)/(Math.pow(10,6)) * wettedArea;
            //after pre soil calc
        }

        //organic n - check with ofer
        return n;
    }
}
