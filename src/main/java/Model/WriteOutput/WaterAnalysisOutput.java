package Model.WriteOutput;

/**
 * Represents a line in the water analysis table, that is created during the model run,
 * and consists a row description name, and water analysis results for each of the nutrients.
 */
public class WaterAnalysisOutput {
    private String nutrientSymbol;
    private double waterNutrients;
    private String resultsUnits;
    private double appliedNutrients;
    private double efficiency;
    private double actualNutrientsKg;

    /**
     *
     * @param nutrientSymbol - The symbol of the nutrients. the row's name.
     * @param waterNutrients - The amount of water nutrients from the water lab results.
     * @param resultsUnits - Default is ppm.
     * @param appliedNutrients - The amount of each nutrient to apply.
     * @param efficiency - Efficiency of multiplication of the fertilization efficiency
     *                   and the irrigation efficiency.
     * @param actualNutrientsKg
     */
    public WaterAnalysisOutput(String nutrientSymbol, double waterNutrients, String resultsUnits,
                               double appliedNutrients, double efficiency, double actualNutrientsKg) {
        this.nutrientSymbol = nutrientSymbol;
        this.waterNutrients = waterNutrients;
        this.resultsUnits = resultsUnits;
        this.appliedNutrients = appliedNutrients;
        this.efficiency = efficiency;
        this.actualNutrientsKg = actualNutrientsKg;
    }

    public String getNutrientSymbol() {
        return nutrientSymbol;
    }

    public void setNutrientSymbol(String nutrientSymbol) {
        this.nutrientSymbol = nutrientSymbol;
    }

    public double getWaterNutrients() {
        return waterNutrients;
    }

    public void setWaterNutrients(double waterNutrients) {
        this.waterNutrients = waterNutrients;
    }

    public String getResultsUnits() {
        return resultsUnits;
    }

    public void setResultsUnits(String resultsUnits) {
        this.resultsUnits = resultsUnits;
    }

    public double getAppliedNutrients() {
        return appliedNutrients;
    }

    public void setAppliedNutrients(double appliedNutrients) {
        this.appliedNutrients = appliedNutrients;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    public double getActualNutrientsKg() {
        return actualNutrientsKg;
    }

    public void setActualNutrientsKg(double actualNutrientsKg) {
        this.actualNutrientsKg = actualNutrientsKg;
    }

    /**
     * Overrides toString method in order to print the WaterAnalysisOutput
     * field names and values.
     * @return WaterAnalysisOutput's field names and values.
     */
    @Override
    public String toString() {
        return "WaterAnalysisOutput{" +
                "nutrientSymbol='" + nutrientSymbol + '\'' +
                ", waterNutrients=" + waterNutrients +
                ", resultsUnits='" + resultsUnits + '\'' +
                ", appliedNutrients=" + appliedNutrients +
                ", efficiency=" + efficiency +
                ", actualNutrientsKg=" + actualNutrientsKg +
                '}';
    }
}
