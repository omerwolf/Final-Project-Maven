package DB.Entites;

public class parameters {
    private int parameter_id;
    private int element_id;
    private int data_type_id;
    private double very_low_factor;
    private double low_factor;
    private double high_factor;
    private double very_high_factor;
    private double pre_low_factor;
    private double pre_high_factor;

    public parameters(){

    }

    public parameters(int element_id, int data_type_id, double very_low_factor,
                      double low_factor, double high_factor, double very_high_factor,
                      double pre_low_factor, double pre_high_factor) {
        this.parameter_id = 0;
        this.element_id = element_id;
        this.data_type_id = data_type_id;
        this.very_low_factor = very_low_factor;
        this.low_factor = low_factor;
        this.high_factor = high_factor;
        this.very_high_factor = very_high_factor;
        this.pre_low_factor = pre_low_factor;
        this.pre_high_factor = pre_high_factor;
    }

    public int getParameter_id() {
        return parameter_id;
    }

    public void setParameter_id(int parameter_id) {
        this.parameter_id = parameter_id;
    }

    public int getElement_id() {
        return element_id;
    }

    public void setElement_id(int element_id) {
        this.element_id = element_id;
    }

    public int getData_type_id() {
        return data_type_id;
    }

    public void setData_type_id(int data_type_id) {
        this.data_type_id = data_type_id;
    }

    public double getVery_low_factor() {
        return very_low_factor;
    }

    public void setVery_low_factor(double very_low_factor) {
        this.very_low_factor = very_low_factor;
    }

    public double getLow_factor() {
        return low_factor;
    }

    public void setLow_factor(double low_factor) {
        this.low_factor = low_factor;
    }

    public double getHigh_factor() {
        return high_factor;
    }

    public void setHigh_factor(double high_factor) {
        this.high_factor = high_factor;
    }

    public double getVery_high_factor() {
        return very_high_factor;
    }

    public void setVery_high_factor(double very_high_factor) {
        this.very_high_factor = very_high_factor;
    }

    public double getPre_low_factor() {
        return pre_low_factor;
    }

    public void setPre_low_factor(double pre_low_factor) {
        this.pre_low_factor = pre_low_factor;
    }

    public double getPre_high_factor() {
        return pre_high_factor;
    }

    public void setPre_high_factor(double pre_high_factor) {
        this.pre_high_factor = pre_high_factor;
    }
}
