package DB.Entites;

public class FertilizationMethodEfficiency {
    private int fert_method_efficiency_id;
    private int parameter_id;
    private double fert_method_efficiency;


    public FertilizationMethodEfficiency() {

    }
    public FertilizationMethodEfficiency(int fert_method_efficiency_id, int parameter_id, double fert_method_efficiency) {
        this.fert_method_efficiency_id = fert_method_efficiency_id;
        this.parameter_id = parameter_id;
        this.fert_method_efficiency = fert_method_efficiency;
    }

    public int getFert_method_efficiency_id() {
        return fert_method_efficiency_id;
    }

    public void setFert_method_efficiency_id(int fert_method_efficiency_id) {
        this.fert_method_efficiency_id = fert_method_efficiency_id;
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


