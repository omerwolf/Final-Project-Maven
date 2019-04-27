package Analysis.LabAnalysisResults;

public  class LabAnalysisResult {
    private Integer tissue_analysis_id;
    private Integer soil_analysis_id;
    private Integer water_analysis_id;
    private int parameter_id;
    private double parameter_value;
    private int uom_id;
    private int extraction_analysis_id;
    private int extraction_method_id;

    public LabAnalysisResult() {
    }

    public LabAnalysisResult(Integer tissue_analysis_id, Integer soil_analysis_id, Integer water_analysis_id,
                             int parameter_id, double parameter_value) {
        this.tissue_analysis_id = tissue_analysis_id;
        this.soil_analysis_id = soil_analysis_id;
        this.water_analysis_id = water_analysis_id;
        this.parameter_id = parameter_id;
        this.parameter_value = parameter_value;
    }

    public Integer getTissue_analysis_id() {
        return tissue_analysis_id;
    }

    public void setTissue_analysis_id(int tissue_analysis_id) {
        this.tissue_analysis_id = tissue_analysis_id;
    }

    public Integer getSoil_analysis_id() {
        return soil_analysis_id;
    }

    public void setSoil_analysis_id(int soil_analysis_id) {
        this.soil_analysis_id = soil_analysis_id;
    }

    public Integer getWater_analysis_id() {
        return water_analysis_id;
    }

    public void setWater_analysis_id(int water_analysis_id) {
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
