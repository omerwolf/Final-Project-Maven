package Analysis.LabAnalysisResults;
/**
 * represents a lab analysis water result record
 * in the lab_analysis_results table in the db.
 * note: each record represents a single parameter result,
 * therefore there are several records for each water analysis.
 */
public class WaterLabAnalysisResult {
    private int lab_results_id;
    private int water_analysis_id;
    private int parameter_id;
    private double parameter_value;

    /**
     * the default constructor.
     */
    public WaterLabAnalysisResult() {
    }

    /**
     * creates a SoilLabAnalysisResult record in the lab_analysis_results table.
     * @param water_analysis_id - the id of the specific water analysis.
     * @param parameter_id - the parameter id of the nutrient.
     * @param parameter_value - the parameter's(nutrient's) value.
     */
    public WaterLabAnalysisResult(Integer water_analysis_id, int parameter_id, double parameter_value) {
        this.water_analysis_id = water_analysis_id;
        this.parameter_id = parameter_id;
        this.parameter_value = parameter_value;
    }

    /**
     * creates a SoilLabAnalysisResult record in the lab_analysis_results table.
     * @param lab_results_id - the number of the lab result
     * @param water_analysis_id - the id of the specific water analysis.
     * @param parameter_id - the parameter id of the nutrient.
     * @param parameter_value - the parameter's(nutrient's) value.
     */
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

    /**
     * overrides toString method in order to print the record's
     * names and values.
     * @return record's fields name and values.
     */
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
