package DB.Entites;

/**
 * represents a record in the crop_expected_yield_validation
 * in the database.
 */
public class crop_expected_yield_validation {
    private int validation_id;
    private int crop_id;
    private int variety_id;
    private double min_yield;
    private double max_yield;

    /**
     * default constructor
     */
    public crop_expected_yield_validation() {
    }

    /**
     * the constructor receives all parameters that represents the record
     * @param validation_id - the validation id
     * @param crop_id - the crop id
     * @param variety_id - the variety id
     * @param min_yield - the min yield value
     * @param max_yield - the max yield value
     */
    public crop_expected_yield_validation(int validation_id, int crop_id, int variety_id, double min_yield,
                                          double max_yield) {
        this.validation_id = validation_id;
        this.crop_id = crop_id;
        this.variety_id = variety_id;
        this.min_yield = min_yield;
        this.max_yield = max_yield;
    }

    /**
     * returns the validation id
     * @return validation_id - the validation id
     */
    public int getValidation_id() {
        return validation_id;
    }

    /**
     * receives a validation id and sets its value
     * @param validation_id - the validation id to set
     */
    public void setValidation_id(int validation_id) {
        this.validation_id = validation_id;
    }

    /**
     * returns the crop id
     * @return crop_id - the crop id
     */
    public int getCrop_id() {
        return crop_id;
    }

    /**
     * receives a crop id and sets its value
     * @param crop_id - the crop id to set
     */
    public void setCrop_id(int crop_id) {
        this.crop_id = crop_id;
    }

    /**
     * return the variety id
     * @return variety_id - the variety id
     */
    public int getVariety_id() {
        return variety_id;
    }

    /**
     * receives a variety id and sets its value
     * @param variety_id - the variety id to set
     */
    public void setVariety_id(int variety_id) {
        this.variety_id = variety_id;
    }

    /**
     * returns the min yield value
     * @return min_yield - the minimum yield value
     */
    public double getMin_yield() {
        return min_yield;
    }

    /**
     * receives a min yield value and sets its value
     * @param min_yield - the minimum yield value to set
     */
    public void setMin_yield(double min_yield) {
        this.min_yield = min_yield;
    }
    /**
     * returns the max yield value
     * @return max_yield - the maximum yield value
     */
    public double getMax_yield() {
        return max_yield;
    }
    /**
     * receives a max yield value and sets its value
     * @param max_yield - the maximum yield value to set
     */
    public void setMax_yield(double max_yield) {
        this.max_yield = max_yield;
    }

    /**
     * overrides toString function.
     * used for printing the class values
     * @return the class members name + values.
     */
    @Override
    public String toString() {
        return "crop_expected_yield_validation{" +
                "validation_id=" + validation_id +
                ", crop_id=" + crop_id +
                ", variety_id=" + variety_id +
                ", min_yield=" + min_yield +
                ", max_yield=" + max_yield +
                '}';
    }
}
