package Analysis.LabAnalysisResults;

public class WaterLabAnalysisResult {
    private int lab_results_id;
    private int water_analysis_id;
    private int parameter_id;
    private double parameter_value;

    public WaterLabAnalysisResult() {
    }

    public WaterLabAnalysisResult(Integer water_analysis_id, int parameter_id, double parameter_value) {
        this.water_analysis_id = water_analysis_id;
        this.parameter_id = parameter_id;
        this.parameter_value = parameter_value;
    }
    public WaterLabAnalysisResult(int lab_results_id, Integer water_analysis_id, int parameter_id, double parameter_value) {
        this.lab_results_id = lab_results_id;
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

    public int getLab_results_id() {
        return lab_results_id;
    }

    public void setLab_results_id(int lab_results_id) {
        this.lab_results_id = lab_results_id;
    }

    public void setWater_analysis_id(int water_analysis_id) {
        this.water_analysis_id = water_analysis_id;
    }

    @Override
    public String toString() {
        return "WaterLabAnalysisResult{" +
                "lab_results_id=" + lab_results_id +
                ", water_analysis_id=" + water_analysis_id +
                ", parameter_id=" + parameter_id +
                ", parameter_value=" + parameter_value +
                '}';
    }
}
