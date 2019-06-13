package Model;

import DB.Dao.Dao;
import DB.DaoImpl.FertilizationMethodEfficiencyDaoImpl;
import DB.Entites.FertilizationMethodEfficiency;
import DB.Entites.IrrigationMethod;
import DB.Entites.fertilization_method;
import Model.WriteOutput.NutrientsOutput;
import Model.WriteOutput.WaterAnalysisOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * responsible for creating the output for the water analysis output, in addition
 * for updating the actual nutrients output table.
 */
public class NutrientsWaterAnalysis {

    public NutrientsWaterAnalysis() {

    }

    /**
     * calculates the actual fertilization, water contribution and total fertilization values and adds
     * them to the adjusted nutrients output table.
     * in addition, creates the nutrients additions from the water analysis, creates an output table, and
     * updates the nutrients data.
     * @param p - the parameters data.
     * @param n - the nutrients data.
     * @return n - the updated nutrients data.
     */
    public Nutrients nutrientsWaterAnalysis(Parameters p, Nutrients n) {
        String[] nutrientsName = {"N" , "P" , "K", "Ca", "Mg", "S", "Fe" , "B", "Mn",  "Zn", "Cu", "Mo"} ;
        IrrigationMethod im = p.getUi().getSelectedIrrigationMethod();
        double irrigationVolume = p.getUi().getSelectedIrrigationVolume();
        //double wettedArea = im.getIrrigation_method_wetted_area();
        fertilization_method fm = p.getUi().getSelectedFertilizationMethod();
        Dao<FertilizationMethodEfficiency> fmed = new FertilizationMethodEfficiencyDaoImpl();
        List<FertilizationMethodEfficiency> fmList = fmed.selectAll();
        List<Double> fertEfficientFactors = new ArrayList<>();
        for (FertilizationMethodEfficiency fme:fmList) {
            if (fme.getFert_method_id() == fm.getFert_method_id()) {
                fertEfficientFactors.add(fme.getFert_method_efficiency());
                System.out.print(fme.getFert_method_efficiency() + ", ");
            }
        }
        //String[] fertEfficienctNames = new String[fertEfficientFactors.size()]; redundant?

        List<Double> waterNutrients = new ArrayList<>(Collections.nCopies(nutrientsName.length,0.0));
        String[] resultsUnit = new String[nutrientsName.length];
        List<Double> appliedNutrients = new ArrayList<>(Collections.nCopies(nutrientsName.length,0.0));
        List<Double> efficiency = new ArrayList<>(Collections.nCopies(nutrientsName.length,0.0));
        List<Double> actualNutrientsKg = new ArrayList<>(Collections.nCopies(nutrientsName.length,0.0));
        System.out.println();
        if (p.getWa() != null) { // need to validate with offer
            for (int i = 0; i < nutrientsName.length; i++) {
                waterNutrients.set(i, p.getWlar().get(i).getParameter_value());
                System.out.print("water nutrient " + (i + 1) + " " + waterNutrients.get(i));
                resultsUnit[i] = "'ppm'"; // add uom and get from there - check with ofer
                appliedNutrients.set(i, waterNutrients.get(i) * irrigationVolume / 100);
                System.out.print("applied nutrient " + (i + 1) + " " + appliedNutrients.get(i));
                efficiency.set(i, fertEfficientFactors.get(i) * im.getIrrigation_method_efficiency());
                System.out.print("efficiency " + (i + 1) + " " + efficiency.get(i));
                actualNutrientsKg.set(i, efficiency.get(i) * appliedNutrients.get(i));
                System.out.print("actual nutrients " + (i + 1) + " " + actualNutrientsKg.get(i));
                System.out.println();
            }
            List<WaterAnalysisOutput> waoList = new ArrayList<>();
            for (int i = 0; i < nutrientsName.length; i++) {
                WaterAnalysisOutput wao = new WaterAnalysisOutput(nutrientsName[i], waterNutrients.get(i), resultsUnit[i],
                        appliedNutrients.get(i), efficiency.get(i), actualNutrientsKg.get(i));
                waoList.add(wao);
            }
            n.getPreSeason().setWaterAnalysis(waoList); //sets the table in preSeason class
            for (int i = 0; i < nutrientsName.length; i++) {
                System.out.println(n.getPreSeason().getWaterAnalysis().get(i));
            }


            double[] oxide = {1, 2.29, 1.2, 1.4, 1.6, 1, 1, 1, 1, 1, 1, 1};
            double[] waterContribution = new double[oxide.length];
            for (int i = 0; i < waterContribution.length; i++) {
                waterContribution[i] = -Math.round(actualNutrientsKg.get(i) * oxide[i]);
            }
            List<NutrientsOutput> actualNutrients = n.getPreSeason().getActualNutrients();
            NutrientsOutput waterContributionOutput = toNutrientOutput(waterContribution, "Water_Contribution");
            actualNutrients.add(waterContributionOutput);
            double[] totalFertilization = new double[oxide.length];
            double[] arrayActualFertilization = {actualNutrients.get(4).getN(), actualNutrients.get(4).getP205(),
                    actualNutrients.get(4).getK20(), actualNutrients.get(4).getCa0(), actualNutrients.get(4).getMg0(), actualNutrients.get(4).getS(),
                    actualNutrients.get(4).getFe(), actualNutrients.get(4).getB(), actualNutrients.get(4).getMn(), actualNutrients.get(4).getZn()
                    , actualNutrients.get(4).getCu(), actualNutrients.get(4).getMo()};
            for (int i = 0; i < oxide.length; i++) {
                totalFertilization[i] = arrayActualFertilization[i] + waterContribution[i];
            }
            NutrientsOutput totalFertilizationOutput = toNutrientOutput(totalFertilization, "Total_Fertilization");
            actualNutrients.add(totalFertilizationOutput);
            System.out.println(actualNutrients);
        }
        return n;
    }

    /**
     * takes a double array and a name, and convert them to NutrientOutput - a row
     * in an output table.
     * @param output - the output array to be converted
     * @param name - the row name to add to the output table
     * @return nutrientsOutput - the output array, converted to NutrientsOutput class
     */
    public NutrientsOutput toNutrientOutput(double [] output, String name) {
        NutrientsOutput nutrientsOutput = new NutrientsOutput(name,output[0],output[1],output[2],
                output[3],output[4],output[5],output[6],output[7],output[8],output[9],output[10], output[11]);
        return nutrientsOutput;
    }
}
