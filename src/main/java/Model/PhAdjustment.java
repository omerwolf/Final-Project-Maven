package Model;

import DB.Dao.Dao;
import DB.DaoImpl.ParameterPhEffectDaoImpl;
import DB.DaoImpl.PhRangesDaoImpl;
import DB.Entites.ParameterPhEffect;
import DB.Entites.PhRanges;
import Model.WriteOutput.NutrientsOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * Updates the summary of the nutrients in the adjustment table output
 * by multiplying them with the ph effect values.
 */
public class PhAdjustment {

    public PhAdjustment() {

    }

    /**
     * Gets the soilPh in order to get the proper range of the ph values.
     * Calculates the effects for each parameter, and then multiply them by
     * the nutrients amount summary values in order to get the updated amount for each nutrient,
     * which is affected by the soil ph value.
     * @param p - The parameters data.
     * @param n - The nutrients data.
     * @param sample - A sampling point during the crop's growth
     * @return
     */
    public Nutrients phAdjustment(Parameters p, Nutrients n, double sample) {

        double soilPh = 0;
        //System.out.println(p.getSa().getSoil_pH());
        if (p.getSa() != null) { //top table of pre soil is active (technically exists)
            if (sample == 0) { // 0 = pre season
                if (p.getSa().getSoil_pH() != null) { //if pre soil value of ph isn't null
                    soilPh = p.getSa().getSoil_pH();
                } else {
                    soilPh = p.getUi().getSelectedSoilPH(); //else
                }
            }
        }
        else {
            soilPh = p.getUi().getSelectedSoilPH();
        }
        String phDesc;
        if (soilPh < 4.5) {
            phDesc = "Very_Acidic";
        }
        else if (soilPh < 5.5) {
            phDesc = "Acidic";
        }
        else if (soilPh < 7.5) {
            phDesc = "Neutral";
        }
        else if (soilPh < 8.5) {
            phDesc = "Slightly_Alkaline";
        }
        else if (soilPh >= 8.5) {
            phDesc = "Alkaline";
        }
        else {
            phDesc = "NaN";
        }
        // if a description for the ph value could be given
        if (!phDesc.equals("NaN")) {
            int rangeId = 0;
            Dao<PhRanges> phRangesDao = new PhRangesDaoImpl();
            List<PhRanges> phRangesList = phRangesDao.selectAll();
            //extracting the range id from the db
            for (PhRanges pr:phRangesList) {
                if (pr.getRangeDesc().equals(phDesc)) {
                    rangeId = pr.getRangeId();
                }
            }
            System.out.println("the range is: " +rangeId);
            Dao<ParameterPhEffect> pped = new ParameterPhEffectDaoImpl();
            List<ParameterPhEffect> parameterPhEffectList = pped.selectAll();
            List<Double> rangePhValues = new ArrayList<>();
            //extract the ph effect for each nutrient, using the previously calculated rangeId
            for (ParameterPhEffect ppe:parameterPhEffectList) {
                if (ppe.getRangeId() == rangeId) {
                    rangePhValues.add(ppe.getEffect());
                    System.out.println("effect is:" + ppe.getEffect());
                }
            }
            List<NutrientsOutput> nutrientsOutputList = n.getPreSeason().getAdjNutrients();
            List<Double> summary = nutrientsOutputList.get(nutrientsOutputList.size()-1).nutrientsList();
            List<Double> phValues = new ArrayList<>();
            System.out.println("rangephvalues size is: " + rangePhValues.size());
            System.out.println("summary size is: " + summary.size());
            //apply the effects on the summary values
            for (int i=0;i<rangePhValues.size();i++) {
                System.out.println(i);
                phValues.add(summary.get(i) *(1+rangePhValues.get(i)));
            }
            NutrientsOutput phAdjustedOutput = new NutrientsOutput("pH_Adjusted", phValues);
            nutrientsOutputList.add(phAdjustedOutput);
            n.getPreSeason().setAdjNutrients(nutrientsOutputList);
        }
        else {
            //copy the summary row to the ph row (as there won't be an effect)
            List<NutrientsOutput> nutrientsOutputList = n.getPreSeason().getAdjNutrients();
            List<Double> summary = nutrientsOutputList.get(nutrientsOutputList.size()-1).nutrientsList();
            List<Double> phValues = new ArrayList<>();
            for (Double nutrientSummary:summary) {
                phValues.add(nutrientSummary);
            }
            NutrientsOutput phAdjustedOutput = new NutrientsOutput("pH_Adjusted", phValues);
            nutrientsOutputList.add(phAdjustedOutput);
            n.getPreSeason().setAdjNutrients(nutrientsOutputList);
        }
        //printing final table if adj nutrients
        for (int i=0;i<n.getPreSeason().getAdjNutrients().size();i++) {
            System.out.println(n.getPreSeason().getAdjNutrients().get(i).getStageName() + ":"
                    + n.getPreSeason().getAdjNutrients().get(i));
        }
        return n;
    }
}
