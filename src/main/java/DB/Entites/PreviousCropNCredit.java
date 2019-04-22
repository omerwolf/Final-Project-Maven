package DB.Entites;

public class PreviousCropNCredit {

    private int previousCropId;
    private String previousCropName;
    private Integer percent;
    private int nCredit;

    public PreviousCropNCredit() {

    }

    public PreviousCropNCredit(int previousCropId, String previousCropName, Integer percent, int nCredit) {
        this.previousCropId = previousCropId;
        this.previousCropName = previousCropName;
        this.percent = percent;
        this.nCredit = nCredit;
    }

    public int getPreviousCropId() {
        return previousCropId;
    }

    public void setPreviousCropId(int previousCropId) {
        this.previousCropId = previousCropId;
    }

    public String getPreviousCropName() {
        return previousCropName;
    }

    public void setPreviousCropName(String previousCropName) {
        this.previousCropName = previousCropName;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public int getnCredit() {
        return nCredit;
    }

    public void setnCredit(int nCredit) {
        this.nCredit = nCredit;
    }
}
