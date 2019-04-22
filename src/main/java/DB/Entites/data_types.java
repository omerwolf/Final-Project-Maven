package DB.Entites;

public class data_types {
    private int data_type_id;
    private String data_type_desc;

    public data_types() {

    }

    public data_types(int data_type_id, String data_type_desc) {
        this.data_type_id = data_type_id;
        this.data_type_desc = data_type_desc;
    }

    public int getData_type_id() {
        return data_type_id;
    }

    public String getData_type_desc() {
        return data_type_desc;
    }

    public void setData_type_id(int data_type_id) {
        this.data_type_id = data_type_id;
    }

    public void setData_type_desc(String data_type_desc) {
        this.data_type_desc = data_type_desc;
    }
}
