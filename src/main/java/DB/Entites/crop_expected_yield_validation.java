package DB.Entites;

public class crop_expected_yield_validation {
    private int validation_id;
    private int crop_id;
    private int variety_id;
    private double min_yield;
    private double max_yield;

    public crop_expected_yield_validation() {
    }

    public crop_expected_yield_validation(int validation_id, int crop_id, int variety_id, double min_yield,
                                          double max_yield) {
        this.validation_id = validation_id;
        this.crop_id = crop_id;
        this.variety_id = variety_id;
        this.min_yield = min_yield;
        this.max_yield = max_yield;
    }

    public int getValidation_id() {
        return validation_id;
    }

    public void setValidation_id(int validation_id) {
        this.validation_id = validation_id;
    }

    public int getCrop_id() {
        return crop_id;
    }

    public void setCrop_id(int crop_id) {
        this.crop_id = crop_id;
    }

    public int getVariety_id() {
        return variety_id;
    }

    public void setVariety_id(int variety_id) {
        this.variety_id = variety_id;
    }

    public double getMin_yield() {
        return min_yield;
    }

    public void setMin_yield(double min_yield) {
        this.min_yield = min_yield;
    }

    public double getMax_yield() {
        return max_yield;
    }

    public void setMax_yield(double max_yield) {
        this.max_yield = max_yield;
    }
}
