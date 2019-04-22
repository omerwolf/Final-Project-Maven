package DB.Entites;

public class fertilization_method {
    private int fert_method_id;
    private String fert_method_desc;

    public fertilization_method() {

    }

    public fertilization_method(int fert_method_id, String fert_method_desc) {
        this.fert_method_id = fert_method_id;
        this.fert_method_desc = fert_method_desc;
    }
    public fertilization_method(fertilization_method fm) {
        this.fert_method_id = fm.getFert_method_id();
        this.fert_method_desc = fm.getFert_method_desc();
    }
    public int getFert_method_id() {
        return fert_method_id;
    }

    public void setFert_method_id(int fert_method_id) {
        this.fert_method_id = fert_method_id;
    }

    public String getFert_method_desc() {
        return fert_method_desc;
    }

    public void setFert_method_desc(String fert_method_desc) {
        this.fert_method_desc = fert_method_desc;
    }
}
