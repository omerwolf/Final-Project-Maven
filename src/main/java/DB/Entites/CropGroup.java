package DB.Entites;

public class CropGroup {

    private int cropGroupId;
    private String cropGroupDesc;

    public CropGroup() {

    }

    public CropGroup(int cropGroupId, String cropGroupDesc) {
        this.cropGroupId = cropGroupId;
        this.cropGroupDesc = cropGroupDesc;
    }

    public int getCropGroupId() {
        return cropGroupId;
    }

    public void setCropGroupId(int cropGroupId) {
        this.cropGroupId = cropGroupId;
    }

    public String getCropGroupDesc() {
        return cropGroupDesc;
    }

    public void setCropGroupDesc(String cropGroupDesc) {
        this.cropGroupDesc = cropGroupDesc;
    }
}
