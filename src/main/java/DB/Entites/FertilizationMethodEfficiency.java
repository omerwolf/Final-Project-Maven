package DB.Entites;

/**
 * represents a record in the fertilization_method_efficiency table
 * in the database.
 */
public class FertilizationMethodEfficiency {
    private int fert_method_efficiency_id;
    private int fert_method_id;
    private int parameter_id;
    private double fert_method_efficiency;

    /**
     * default constructor.
     */
    public FertilizationMethodEfficiency() {

    }

    /**
     * creates a FertilizationMethodEfficiency record.
     * @param fert_method_efficiency_id - the fertilization method efficiency id
     * @param fert_method_id - the fertilization method id.
     * @param parameter_id - the parameter id.
     * @param fert_method_efficiency - the efficiency (double between 0-1).
     */
    public FertilizationMethodEfficiency(int fert_method_efficiency_id, int fert_method_id, int parameter_id, double fert_method_efficiency) {
        this.fert_method_efficiency_id = fert_method_efficiency_id;
        this.fert_method_id = fert_method_id;
        this.parameter_id = parameter_id;
        this.fert_method_efficiency = fert_method_efficiency;
    }


    public int getFert_method_efficiency_id() {
        return fert_method_efficiency_id;
    }

    public void setFert_method_efficiency_id(int fert_method_efficiency_id) {
        this.fert_method_efficiency_id = fert_method_efficiency_id;
    }

    public int getFert_method_id() {
        return fert_method_id;
    }

    public void setFert_method_id(int fert_method_id) {
        this.fert_method_id = fert_method_id;
    }

    public int getParameter_id() {
        return parameter_id;
    }

    public void setParameter_id(int parameter_id) {
        this.parameter_id = parameter_id;
    }

    public double getFert_method_efficiency() {
        return fert_method_efficiency;
    }

    public void setFert_method_efficiency(double fert_method_efficiency) {
        this.fert_method_efficiency = fert_method_efficiency;
    }
}


