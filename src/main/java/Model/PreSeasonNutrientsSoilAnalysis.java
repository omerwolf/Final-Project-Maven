package Model;

import DB.Entites.Soil;

public class PreSeasonNutrientsSoilAnalysis {

    public PreSeasonNutrientsSoilAnalysis() {

    }

    public Nutrients PreSeasonNutrientsSoilAnalysis(Parameters p, Nutrients n) {
        // p factor assigns - to complete

        //preseason active yes check - to complete

        //analysisResults =
        Soil soil = n.getSoil();
        System.out.println("Soil is:" + soil.getName());





        return n;
    }
}
