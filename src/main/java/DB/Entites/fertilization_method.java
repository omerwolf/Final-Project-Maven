package DB.Entites;

/**
 * represents a record in the fertilization_method table.
 * in the database.
 */
public class fertilization_method {
    private int fert_method_id;
    private String fert_method_desc;

    /**
     * the default constructor
     */
    public fertilization_method() {

    }

    /**
     * a constructor for the class - receives id and description
     * @param fert_method_id - the id of the fertilization method
     * @param fert_method_desc - the description of the fertilization method
     */
    public fertilization_method(int fert_method_id, String fert_method_desc) {
        this.fert_method_id = fert_method_id;
        this.fert_method_desc = fert_method_desc;
    }

    /**
     * another constructor for the class - receives another fertilization method
     * @param fm - the fertilization method to copy the fields from
     */
    public fertilization_method(fertilization_method fm) {
        this.fert_method_id = fm.getFert_method_id();
        this.fert_method_desc = fm.getFert_method_desc();
    }

    /**
     * returns the id of the fertilization method
     * @return fert_method_id
     */
    public int getFert_method_id() {
        return fert_method_id;
    }

    /**
     * sets the fertilization method id
     * @param fert_method_id - the id to set.
     */
    public void setFert_method_id(int fert_method_id) {
        this.fert_method_id = fert_method_id;
    }

    /**
     * returns the fertilization method's description
     * @return fert_method_desc
     */
    public String getFert_method_desc() {
        return fert_method_desc;
    }

    /**
     * sets the fertilization method desc
     * @param fert_method_desc - the description to set
     */
    public void setFert_method_desc(String fert_method_desc) {
        this.fert_method_desc = fert_method_desc;
    }
}
