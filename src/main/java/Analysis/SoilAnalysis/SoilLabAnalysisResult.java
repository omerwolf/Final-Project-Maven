package Analysis.SoilAnalysis;

public class SoilLabAnalysisResult{
    private Integer soil_analysis_id;
    private int parameter_id;
    private double parameter_value;
    private int extraction_method_id;

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
}
