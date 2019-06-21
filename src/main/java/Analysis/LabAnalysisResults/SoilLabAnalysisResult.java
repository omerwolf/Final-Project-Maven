package Analysis.LabAnalysisResults;

/**
 * represents a lab analysis soil result record
 * in the lab_analysis_results table in the db.
 * note: each record represents a single parameter result,
 * therefore there are several records for each soil analysis.
 */
public class SoilLabAnalysisResult{
    private int lab_results_id;
    private Integer soil_analysis_id;
    private int parameter_id;
    private double parameter_value;
    private int extraction_method_id;

    /**
     * the default constructor
     */
    public SoilLabAnalysisResult() {
    }

    /**
     * creates a SoilLabAnalysisResult record in the lab_analysis_results table.
     * @param lab_results_id - the number of the lab result
     * @param soil_analysis_id - the id of the specific soil analysis.
     * @param parameter_id - the parameter id of the nutrient.
     * @param parameter_value - the parameter's(nutrient's) value.
     * @param extraction_method_id - the extraction method id.
     */
    public SoilLabAnalysisResult(int lab_results_id, int soil_analysis_id, int parameter_id, double parameter_value, int extraction_method_id){
        this.lab_results_id = lab_results_id;
        this.soil_analysis_id = soil_analysis_id;
        this.parameter_id = parameter_id;
        this.parameter_value = parameter_value;
        this.extraction_method_id = extraction_method_id;
    }

    /**
     * creates a SoilLabAnalysisResult record in the lab_analysis_results table.
     * @param soil_analysis_id - the id of the specific soil analysis.
     * @param parameter_id - the parameter id of the nutrient.
     * @param parameter_value - the parameter's(nutrient's) value.
     * @param extraction_method_id - the extraction method id.
     */
    public SoilLabAnalysisResult(int soil_analysis_id, int parameter_id, double parameter_value, int extraction_method_id){
        this.soil_analysis_id = soil_analysis_id;
        this.parameter_id = parameter_id;
        this.parameter_value = parameter_value;
        this.extraction_method_id = extraction_method_id;
    }

    public Integer getSoil_analysis_id() {
        return soil_analysis_id;
    }

    public void setSoil_analysis_id(Integer soil_analysis_id) {
        this.soil_analysis_id = soil_analysis_id;
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

    public int getExtraction_method_id() {
        return extraction_method_id;
    }

    public void setExtraction_method_id(int extraction_method_id) {
        this.extraction_method_id = extraction_method_id;
    }

    public int getLab_results_id() {
        return lab_results_id;
    }

    public void setLab_results_id(int lab_results_id) {
        this.lab_results_id = lab_results_id;
    }

    /**
     * overrides toString method in order to print the record's
     * names and values.
     * @return record's fields name and values.
     */
    @Override
    public String toString() {
        return "SoilLabAnalysisResult{" +
                "lab_results_id=" + lab_results_id +
                ", soil_analysis_id=" + soil_analysis_id +
                ", parameter_id=" + parameter_id +
                ", parameter_value=" + parameter_value +
                ", extraction_method_id=" + extraction_method_id +
                '}';
    }
}
