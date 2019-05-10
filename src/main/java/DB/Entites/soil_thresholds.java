package DB.Entites;

public class soil_thresholds {
    int soil_threshold_id;
    int lab_id;
    int extraction_method_id;
    int soil_analysis_id;    //empty
    int parameters_id;
    int uom_id;
    int farm_id;             //empty
    String other_lab_name;   //default null
    String lab_website;      //default null
    String lab_phone;        //default null
    String lab_address;      //default null
    double very_low_threshold;
    double low_threshold;
    double target_value;
    double high_threshold;
    double very_high_threshold;

    public soil_thresholds() {
    }

    public soil_thresholds(int soil_threshold_id, int lab_id, int extraction_method_id, int parameters_id, int uom_id,
                           double very_low_threshold, double low_threshold, double target_threshold,
                           double high_threshold, double very_high_threshold) {
        this.soil_threshold_id = soil_threshold_id;
        this.lab_id = lab_id;
        this.extraction_method_id = extraction_method_id;
        this.parameters_id = parameters_id;
        this.uom_id = uom_id;
        this.very_low_threshold = very_low_threshold;
        this.low_threshold = low_threshold;
        this.target_value = target_threshold;
        this.high_threshold = high_threshold;
        this.very_high_threshold = very_high_threshold;
    }

    public int getSoil_threshold_id() {
        return soil_threshold_id;
    }

    public void setSoil_threshold_id(int soil_threshold_id) {
        this.soil_threshold_id = soil_threshold_id;
    }

    public int getLab_id() {
        return lab_id;
    }

    public void setLab_id(int lab_id) {
        this.lab_id = lab_id;
    }

    public int getExtraction_method_id() {
        return extraction_method_id;
    }

    public void setExtraction_method_id(int extraction_method_id) {
        this.extraction_method_id = extraction_method_id;
    }

    public int getParameters_id() {
        return parameters_id;
    }

    public void setParameters_id(int parameters_id) {
        this.parameters_id = parameters_id;
    }

    public int getUom_id() {
        return uom_id;
    }

    public void setUom_id(int uom_id) {
        this.uom_id = uom_id;
    }

    public double getVery_low_threshold() {
        return very_low_threshold;
    }

    public void setVery_low_threshold(double very_low_threshold) {
        this.very_low_threshold = very_low_threshold;
    }

    public double getLow_threshold() {
        return low_threshold;
    }

    public void setLow_threshold(double low_threshold) {
        this.low_threshold = low_threshold;
    }

    public double getTarget_value() {
        return target_value;
    }

    public void setTarget_value(double target_threshold) {
        this.target_value = target_threshold;
    }

    public double getHigh_threshold() {
        return high_threshold;
    }

    public void setHigh_threshold(double high_threshold) {
        this.high_threshold = high_threshold;
    }

    public double getVery_high_threshold() {
        return very_high_threshold;
    }

    public void setVery_high_threshold(double very_high_threshold) {
        this.very_high_threshold = very_high_threshold;
    }

    @Override
    public String toString() {
        return "soil_thresholds{" +
                "soil_threshold_id=" + soil_threshold_id +
                ", lab_id=" + lab_id +
                ", extraction_method_id=" + extraction_method_id +
                ", parameters_id=" + parameters_id +
                ", uom_id=" + uom_id +
                ", very_low_threshold=" + very_low_threshold +
                ", low_threshold=" + low_threshold +
                ", target_value=" + target_value  +
                ", high_threshold=" + high_threshold +
                ", very_high_threshold=" + very_high_threshold +
                '}';
    }
}

