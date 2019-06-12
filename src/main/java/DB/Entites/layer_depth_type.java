package DB.Entites;

/**
 * represents a record in the `layer_depth_type` table
 * in the database.
 */
public class layer_depth_type {

    private int layer_depth_id;
    private String layer_depth_name;
    private short layer_min;
    private short layer_max;

    /**
     * the default constructor.
     */
    public layer_depth_type(){

    }

    /**
     * creates a layer_depth_type record with all required parameters
     * but the id number(should be set later).
     * @param layer_depth_name - a string representing a range between the layer's
     *                         min and max values.
     * @param layer_min - the minimum value of the layer.
     * @param layer_max - the maximum value of the layer.
     */
    public layer_depth_type(String layer_depth_name, short layer_min, short layer_max) {
        this.layer_depth_id = 0;
        this.layer_depth_name = layer_depth_name;
        this.layer_min = layer_min;
        this.layer_max = layer_max;
    }

    /**
     * creates a layer_depth_type record with all required parameters.
     * @param layer_depth_id - the id of the layer.
     * @param layer_depth_name - a string representing a range between the layer's
     *                         min and max values.
     * @param layer_min - the minimum value of the layer.
     * @param layer_max - the maximum value of the layer.
     */
    public layer_depth_type(int layer_depth_id, String layer_depth_name, short layer_min, short layer_max) {
        this.layer_depth_id = layer_depth_id;
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
