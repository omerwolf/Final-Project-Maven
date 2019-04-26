package DB.Entites;

/**
 * represents a record in the variety_type table
 * in the database
 */
public class variety_type {
    private int variety_id;
    private String variety_name;

    /**
     * the default constructor
     */
    public variety_type() {

    }

    /**
     * constructor for creating a variety_type record.
     * @param variety_id - the variety's id.
     * @param variety_name - the variety's name.
     */
    public variety_type(int variety_id, String variety_name) {
        this.variety_id = variety_id;
        this.variety_name = variety_name;
    }

    /**
     * an additional constructor for creating a variety_type record.
     * @param variety_id - the variety's id.
     */
    public variety_type(variety_type variety_id) {
        this.variety_id = variety_id.getVariety_id();
        this.variety_name = variety_id.getVariety_name();

    }

    /**
     * returns the variety's id
     * @return variety_id
     */
    public int getVariety_id() {
        return variety_id;
    }

    /**
     * sets the variety id
     * @param variety_id - the given variety id
     */
    public void setVariety_id(int variety_id) {
        this.variety_id = variety_id;
    }

    /**
     * returns the variety's name
     * @return variety_name
     */
    public String getVariety_name() {
        return variety_name;
    }

    /**
     * sets the variety name
     * @param variety_name - the given variety name
     */
    public void setVariety_name(String variety_name) {
        this.variety_name = variety_name;
    }
}
