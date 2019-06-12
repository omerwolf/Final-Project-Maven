package Model;

import DB.Dao.Dao;
import DB.DaoImpl.elementsDaoImpl;
import DB.DaoImpl.layer_depth_typeDaoImpl;
import DB.Entites.elements;
import DB.Entites.layer_depth_type;
import Model.WriteOutput.NutrientsOutput;

import java.util.*;

/**
 * responsible for the calculation of the Organic Nitrogen.
 */
public class OrganicNitrogenLogic {

    public OrganicNitrogenLogic() {

    }

    /**
     * takes the nOrganic value from the db.
     * if not null or 0, removes from adjustment nutrient table the som and n credit,
     * and calculates the kg, which will be added to adjustment nutrient table.
     * otherwise just adds it as a list of zeroes.
     * returns the updated nutrients data.
     * @param p - the parameters data.
     * @param n - the nutrients data.
     * @return n - the updated nutrients data.
     */
    public Nutrients calculateOnl(Parameters p, Nutrients n) {

        //getting the layer depth range values
        int layerDepthId = p.getSa().getLayer_depth_id();
        Dao<layer_depth_type> ldtd = new layer_depth_typeDaoImpl();
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

        double soilWeight = db * layerDepth * 10000 ; // soil weight in kg/ha
        double wettedArea = p.getUi().getSelectedIrrigationMethod().getIrrigation_method_wetted_area();

        List<NutrientsOutput> nutrientsOutputList = n.getPreSeason().getAdjNutrients();
        List<String> nutrientNames = Arrays.asList("N", "P" ,"K" ,"Ca" ,"Mg" ,"S" ,"Fe" ,"B" ,"Mn" ,"Zn", "Cu" ,"Mo");
        List<Double> soilRecommendation = new ArrayList<Double>(Collections.nCopies(nutrientNames.size(),0.0));
        Dao<elements> ed = new elementsDaoImpl();
        elements e = ed.selectById(20); //select norganic - id=20 (may change actual name)
        Double nOrganic = null;
        for (int i=0;i<p.getSlar().size();i++) {
            if (p.getSlar().get(i).getParameter_id() == e.getElement_id()) {
                nOrganic = p.getSlar().get(i).getParameter_value();
            }
        }
        //nOrganic = 5.0; //for testing with value, will be removed
        if (nOrganic != null && nOrganic!= 0) {
            double kg = (nOrganic * soilWeight)/(Math.pow(10,6)) * wettedArea;
            soilRecommendation.set(0, -kg);

            Iterator<NutrientsOutput> iter = nutrientsOutputList.iterator();
            //delete n credit and som from adj nutrients table
            while (iter.hasNext()) {
                NutrientsOutput nutrientsOutput = iter.next();
                if (nutrientsOutput.getStageName().equals("N_Credit") || nutrientsOutput.getStageName().equals("SOM")) {
                    iter.remove();
                }
            }

        }
        NutrientsOutput organicN = new NutrientsOutput("Organic_N", soilRecommendation);
        nutrientsOutputList.add(organicN);
        n.getPreSeason().setAdjNutrients(nutrientsOutputList);

        return n;
    }
}
