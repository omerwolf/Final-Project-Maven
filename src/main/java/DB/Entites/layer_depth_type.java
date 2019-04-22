package DB.Entites;

public class layer_depth_type {

    private int layer_depth_id;
    private String layer_depth_name;
    private short layer_min;
    private short layer_max;

    public layer_depth_type(){

    }

    public layer_depth_type(String layer_depth_name, short layer_min, short layer_max) {
        this.layer_depth_id = 0;
        this.layer_depth_name = layer_depth_name;
        this.layer_min = layer_min;
        this.layer_max = layer_max;
    }

    public int getLayer_depth_id() {
        return layer_depth_id;
    }

    public void setLayer_depth_id(int layer_depth_id) {
        this.layer_depth_id = layer_depth_id;
    }

    public String getLayer_depth_name() {
        return layer_depth_name;
    }

    public void setLayer_depth_name(String layer_depth_name) {
        this.layer_depth_name = layer_depth_name;
    }

    public short getLayer_min() {
        return layer_min;
    }

    public void setLayer_min(short layer_min) {
        this.layer_min = layer_min;
    }

    public short getLayer_max() {
        return layer_max;
    }

    public void setLayer_max(short layer_max) {
        this.layer_max = layer_max;
    }
}
