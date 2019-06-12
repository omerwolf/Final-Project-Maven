package DB.Entites;

/**
 * represents a record in the `crop_group` table
 * in the database.
 */
public class CropGroup {
    private int cropGroupId;
    private String cropGroupDesc;

    /**
     * default constructor
     */
    public CropGroup() {

    }

    /**
     * the constructor receives all parameters required that represent the record
     * @param cropGroupId - the id value of the crop group
     * @param cropGroupDesc - the name of the crop group
     */
    public CropGroup(int cropGroupId, String cropGroupDesc) {
        this.cropGroupId = cropGroupId;
        this.cropGroupDesc = cropGroupDesc;
    }

    /**
     * returns the id value of the crop group
     * @return cropGroupId - the id value of the crop group
     */
    public int getCropGroupId() {
        return cropGroupId;
    }

    /**
     * sets the crop group id with the given value
     * @param cropGroupId - the value to set to the crop group id
     */
    public void setCropGroupId(int cropGroupId) {
        this.cropGroupId = cropGroupId;
    }

    /**
     * returns the description of the crop group (it's name)
     * @return cropGroupDesc - the crop group description
     */
    public String getCropGroupDesc() {
        return cropGroupDesc;
    }

    /**
     * sets the value of the description (the name) with the given value
     * @param cropGroupDesc - the description (name) of the crop group to set
     */
    public void setCropGroupDesc(String cropGroupDesc) {
        this.cropGroupDesc = cropGroupDesc;
    }
}
