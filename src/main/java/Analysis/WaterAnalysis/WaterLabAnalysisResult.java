package Analysis.WaterAnalysis;

public class WaterLabAnalysisResult {
    private int water_analysis_id;
    private int parameter_id;
    private double parameter_value;

    public WaterLabAnalysisResult(Integer water_analysis_id, int parameter_id, double parameter_value) {
        this.water_analysis_id = water_analysis_id;
        this.parameter_id = parameter_id;
        this.parameter_value = parameter_value;
    }

    public Integer getWater_analysis_id() {
        return water_analysis_id;
    }

    public void setWater_analysis_id(Integer water_analysis_id) {
        this.water_analysis_id = water_analysis_id;
    }

    public int getParameter_id() {
        return parameter_id;
    }

    public void setParameter_id(int parameter_id) {
        this.parameter_id = parameter_id;
    }

    public double getParameter_value() {
        return parameter_value;
    }

    public void setParameter_value(double parameter_value) {
        this.parameter_value = parameter_value;
    }
}
