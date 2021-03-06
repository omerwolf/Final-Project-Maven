package DB.Entites;

/**
 * represents a record in the `irrigation_method` table
 * in the database.
 */
public class IrrigationMethod {
    private int irrigation_method_id;
    private String irrigation_method_desc;
    private double irrigation_method_efficiency;
    private double irrigation_method_wetted_area;

    /**
     * the default constructor.
     */
    public IrrigationMethod() {

    }

    /**
     * creates an IrrigationMethod record (method id should be set later).
     * @param irrigation_method_desc - the name of the irrigation method.
     * @param irrigation_method_efficiency - the irrigation method efficiency (0-1).
     * @param irrigation_method_wetted_area - the amount of wetted area (0-1).
     */
    public IrrigationMethod(String irrigation_method_desc, double irrigation_method_efficiency,
                            double irrigation_method_wetted_area) {
        this.irrigation_method_desc = irrigation_method_desc;
        this.irrigation_method_efficiency = irrigation_method_efficiency;
        this.irrigation_method_wetted_area = irrigation_method_wetted_area;
    }

    /**
     * creates an IrrigationMethod record receiving all required fields.
     * @param irrigation_method_id - the id of the irrigation method.
     * @param irrigation_method_desc - the name of the irrigation method.
     * @param irrigation_method_efficiency - the irrigation method efficiency (0-1).
     * @param irrigation_method_wetted_area - the amount of wetted area (0-1).
     */
    public IrrigationMethod(int irrigation_method_id, String irrigation_method_desc,
                            double irrigation_method_efficiency, double irrigation_method_wetted_area) {
        this.irrigation_method_id = irrigation_method_id;
        this.irrigation_method_desc = irrigation_method_desc;
        this.irrigation_method_efficiency = irrigation_method_efficiency;
        this.irrigation_method_wetted_area = irrigation_method_wetted_area;
    }

    /**
     * creates an IrrigationMethod record, receiving all the field values from another
     * IrrigationMethod record being received as a paramter.
     * @param im - other IrrigationMethod record.
     */
    public IrrigationMethod(IrrigationMethod im) {
        this.irrigation_method_id = im.getIrrigation_method_id();
        this.irrigation_method_desc = im.getIrrigation_method_desc();
        this.irrigation_method_efficiency = im.getIrrigation_method_efficiency();
        this.irrigation_method_wetted_area = im.getIrrigation_method_wetted_area();
    }

    public int getIrrigation_method_id() {
        return irrigation_method_id;
    }

    public void setIrrigation_method_id(int irrigation_method_id) {
        this.irrigation_method_id = irrigation_method_id;
    }

    public String getIrrigation_method_desc() {
        return irrigation_method_desc;
    }

    public void setIrrigation_method_desc(String irrigation_method_desc) {
        this.irrigation_method_desc = irrigation_method_desc;
    }

    public double getIrrigation_method_efficiency() {
        return irrigation_method_efficiency;
    }

    public void setIrrigation_method_efficiency(double irrigation_method_efficiency) {
        this.irrigation_method_efficiency = irrigation_method_efficiency;
    }

    public double getIrrigation_method_wetted_area() {
        return irrigation_method_wetted_area;
    }

    public void setIrrigation_method_wetted_area(double irrigation_method_wetted_area) {
        this.irrigation_method_wetted_area = irrigation_method_wetted_area;
    }

    /**
     * overrides toString method in order to print the record's
     * names and values.
     * @return record's fields name and values.
     */
    @Override
    public String toString() {
        return "IrrigationMethod{" +
                "irrigation_method_id=" + irrigation_method_id +
                ", irrigation_method_desc='" + irrigation_method_desc + '\'' +
                ", irrigation_method_efficiency=" + irrigation_method_efficiency +
                ", irrigation_method_wetted_area=" + irrigation_method_wetted_area +
                '}';
    }
}
