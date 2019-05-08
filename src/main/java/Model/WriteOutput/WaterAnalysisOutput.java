package Model.WriteOutput;

public class WaterAnalysisOutput {
    private String nutrientSymbol;
    private double waterNutrients;
    private String resultsUnits;
    private double appliedNutrients;
    private double efficiency;
    private double actualNutrientsKg;

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
