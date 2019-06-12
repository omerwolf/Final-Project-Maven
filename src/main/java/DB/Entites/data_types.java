package DB.Entites;

/**
 * represents a record in the `data_types` table
 * in the database.
 */
public class data_types {
    private int data_type_id;
    private String data_type_desc;

    /**
     * the default constructor.
     */
    public data_types() {

    }

    /**
     * a constructor that receives the data type id+description.
     * @param data_type_id - the id of the data type.
     * @param data_type_desc - the description of the data type.
     */
    public data_types(int data_type_id, String data_type_desc) {
        this.data_type_id = data_type_id;
        this.data_type_desc = data_type_desc;
    }

    /**
     * returns the data type id.
     * @return data_type_id.
     */
    public int getData_type_id() {
        return data_type_id;
    }

    /**
     * returns the data type description.
     * @return data_type_desc.
     */
    public String getData_type_desc() {
        return data_type_desc;
    }

    /**
     * sets the data type id.
     * @param data_type_id - the id to be set in this class.
     */
    public void setData_type_id(int data_type_id) {
        this.data_type_id = data_type_id;
    }

    /**
     * sets the date type description.
     * @param data_type_desc - the description to be set in this class.
     */
    public void setData_type_desc(String data_type_desc) {
        this.data_type_desc = data_type_desc;
    }
}
