package DB.Entites;

/**
 * represents a record in the `parameter_crop` table
 * in the database.
 */
public class parameter_crop {
    private int param_per_crop_id;
    private int crop_id;
    private int variety_id;
    private int parameter_id;
    private double amount;
    private double base_line;
    private double amount2;

    /**
     * the default constructor.
     */
    public parameter_crop(){

    }

    /**
     * creates a parameter_crop record, receiving all required parameters
     * except the id (which needs to be set later).
     * @param crop_id - the id of the crop.
     * @param variety_id - the id of the crop's variety.
     * @param parameter_id - the id of the current parameter (the nutrient).
     * @param amount - the amount the crop needs throughout the season.
     * @param base_line - base line, used in calculations of basic removal.
     * @param amount2 - additional amount that may be needed (usually zero).
     */
    public parameter_crop(int crop_id, int variety_id, int parameter_id,
                          double amount, double base_line, double amount2) {
        this.param_per_crop_id = 0;
        this.crop_id = crop_id;
        this.variety_id = variety_id;
        this.parameter_id = parameter_id;
        this.amount = amount;
        this.base_line = base_line;
        this.amount2 = amount2;
    }

    /**
     * creates a parameter_crop record, receiving all required parameters.
     * @param param_per_crop_id - the id of the parameter per crop.
     * @param crop_id - the id of the crop.
     * @param variety_id - the id of the crop's variety.
     * @param parameter_id - the id of the current parameter (the nutrient).
     * @param amount - the amount the crop needs throughout the season.
     * @param base_line - base line, used in calculations of basic removal.
     * @param amount2 - additional amount that may be needed (usually zero).
     */
    public parameter_crop(int param_per_crop_id, int crop_id, int variety_id,
                          int parameter_id, double amount, double base_line, double amount2) {
        this.param_per_crop_id = param_per_crop_id;
        this.crop_id = crop_id;
        this.variety_id = variety_id;
        this.parameter_id = parameter_id;
        this.amount = amount;
        this.base_line = base_line;
        this.amount2 = amount2;
    }

    public int getParam_per_crop_id() {
        return param_per_crop_id;
    }

    public void setParam_per_crop_id(int param_per_crop_id) {
        this.param_per_crop_id = param_per_crop_id;
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

    public int getParameter_id() {
        return parameter_id;
    }

    public void setParameter_id(int parameter_id) {
        this.parameter_id = parameter_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBase_line() {
        return base_line;
    }

    public void setBase_line(double base_line) {
        this.base_line = base_line;
    }

    public double getAmount2() {
        return amount2;
    }

    public void setAmount2(double amount2) {
        this.amount2 = amount2;
    }
}
