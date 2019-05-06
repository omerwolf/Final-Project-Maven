package Analysis.LabAnalysisResults;

public class SoilLabAnalysisResult{
    private int lab_results_id;
    private Integer soil_analysis_id;
    private int parameter_id;
    private double parameter_value;
    private int extraction_method_id;

    public SoilLabAnalysisResult() {
    }

    public SoilLabAnalysisResult(int lab_results_id, int soil_analysis_id, int parameter_id, double parameter_value, int extraction_method_id){
        this.lab_results_id = lab_results_id;
        this.soil_analysis_id = soil_analysis_id;
        this.parameter_id = parameter_id;
        this.parameter_value = parameter_value;
        this.extraction_method_id = extraction_method_id;
    }
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
