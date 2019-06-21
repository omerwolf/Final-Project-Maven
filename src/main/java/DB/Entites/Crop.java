package DB.Entites;

/**
 * represents a record in the `crop type`
 * in the database.
 */
public class Crop {
    private int id;
    private String name;
    private int crop_group_id;

    /**
     * the default constructor
     */
    public Crop() {
    }

    /**
     * 2nd constructor, receives name and crop group id
     * @param name - the crop's name
     * @param crop_group_id - the crop's group id
     */
    public Crop(String name, int crop_group_id) {
        this.id = 0;
        this.name = name;
        this.crop_group_id = crop_group_id;
    }

    /**
     * constructor, receives all parameters in the crop table
     * @param id - the crop's id
     * @param name - the crop's name
     * @param crop_group_id - the crop's group id
     */
    public Crop(int id, String name, int crop_group_id) {
        this.id = id;
        this.name = name;
        this.crop_group_id = crop_group_id;
    }

    /**
     * constructor, receives another crop
     * @param c - a crop
     */
    public Crop(Crop c) {
        this.name = c.getName();
        this.id = c.getId();
    }

    /**
     * returns the crop's id
     * @return id - the crop's id
     */
    public int getId() {
        return id;
    }

    /**
     * receives an id and sets the crop's id to it's value
     * @param id - the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * returns the crops name
     * @return name - the crop's name
     */
    public String getName() {
        return name;
    }

    /**
     * receives a name and sets the crop's name to it's value
     * @param name - the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns the crop's group id
     * @return crop_group_id - the crop's group id
     */
    public int getCrop_group_id() {
        return crop_group_id;
    }

    /**
     * receives a crop group id and sets the crop's group id to it's value
     * @param crop_group_id - the crop group id to set
     */
    public void setCrop_group_id(int crop_group_id) {
        this.crop_group_id = crop_group_id;
    }

    /**
     * overrides toString func.
     * used for printing the values
     * @return the class name values + values
     */
    @Override
    public String toString() {
        return "Crop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", crop_group_id=" + crop_group_id +
                '}';
    }
}