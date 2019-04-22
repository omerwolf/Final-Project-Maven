package DB.Entites;

public class variety_type {
    private int variety_id;
    private String variety_name;

    public variety_type() {

    }
    public variety_type(int variety_id, String variety_name) {
        this.variety_id = variety_id;
        this.variety_name = variety_name;
    }
    public variety_type(variety_type vt) {
        this.variety_id = vt.getVariety_id();
        this.variety_name = vt.getVariety_name();

    }

    public int getVariety_id() {
        return variety_id;
    }

    public void setVariety_id(int variety_id) {
        this.variety_id = variety_id;
    }

    public String getVariety_name() {
        return variety_name;
    }

    public void setVariety_name(String variety_name) {
        this.variety_name = variety_name;
    }
}
