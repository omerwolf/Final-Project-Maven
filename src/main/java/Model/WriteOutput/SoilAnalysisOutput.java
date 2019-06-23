package Model.WriteOutput;

/**
 * Represents a line in a soil analysis table, that is created during the model run,
 * and consists a row description name, and soil analysis results for each of the nutrients.
 */
public class SoilAnalysisOutput {
    private String nutrientSymbol;
    private double nutrientsResults;
    private String analysisStatus;
    private String thresholds;
    private double nutrientBalance;
    private double recommendation;
    private double correction;

    /**
     *
     * @param nutrientSymbol - The nutrient's symbol. the name of the row.
     * @param nutrientsResults - The results amount.
     * @param status - String that says if the amount is sufficient, high or low.
     * @param thresholds - String of thresholds range for the nutrient.
     * @param nutrientBalance - Balance amount.
     * @param recommendation - Recommendation amount.
     * @param correction - Soil correction amount.
     */
    public SoilAnalysisOutput(String nutrientSymbol, double nutrientsResults, String status, String thresholds,
                              double nutrientBalance, double recommendation, double correction) {
        this.nutrientSymbol = nutrientSymbol;
        this.nutrientsResults = nutrientsResults;
        this.analysisStatus = status;
        this.thresholds = thresholds;
        this.nutrientBalance = nutrientBalance;
        this.recommendation = recommendation;
        this.correction = correction;
    }

    public String getNutrientSymbol() {
        return nutrientSymbol;
    }

    public void setNutrientSymbol(String nutrientSymbol) {
        this.nutrientSymbol = nutrientSymbol;
    }

    public double getNutrientsResults() {
        return nutrientsResults;
    }

    public void setNutrientsResults(double nutrientsResults) {
        this.nutrientsResults = nutrientsResults;
    }

    public String getAnalysisStatus() {
        return this.analysisStatus;
    }

    public void setAnalysisStatus(String status) {
        this.analysisStatus = status;
    }

    public String getThresholds() {
        return thresholds;
    }

    public void setThresholds(String thresholds) {
        this.thresholds = thresholds;
    }

    public double getNutrientBalance() {
        return nutrientBalance;
    }

    public void setNutrientBalance(double nutrientBalance) {
        this.nutrientBalance = nutrientBalance;
    }

    public double getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(double recommendation) {
        this.recommendation = recommendation;
    }

    public double getCorrection() {
        return correction;
    }

    public void setCorrection(double correction) {
        this.correction = correction;
    }
}
