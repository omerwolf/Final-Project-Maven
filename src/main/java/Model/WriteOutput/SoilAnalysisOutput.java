package Model.WriteOutput;

public class SoilAnalysisOutput {
    private String nutrientSymbol;
    private double nutrientsResults;
    private String analysisStatus;
    private String thresholds;
    private double nutrientBalance;
    private double recommendation;
    private double correction;

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
