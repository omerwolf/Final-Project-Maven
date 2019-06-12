package DB.Entites;

/**
 * represents a record in the `previous_crop_n_credit` table
 * in the database.
 */
public class PreviousCropNCredit {

    private int previousCropId;
    private String previousCropName;
    private Integer percent;
    private int nCredit;

    /**
     * the default constructor.
     */
    public PreviousCropNCredit() {

    }

    /**
     * creates a PreviousCropNCredit record.
     * @param previousCropId - the id of the previous crop.
     * @param previousCropName - the name of the previous crop.
     * @param percent - the percentage.
     * @param nCredit - the amount of nCredit.
     */
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

    /**
     * overrides toString method in order to print the record's
     * names and values.
     * @return record's fields name and values.
     */
    @Override
    public String toString() {
        return "PreviousCropNCredit{" +
                "previousCropId=" + previousCropId +
                ", previousCropName='" + previousCropName + '\'' +
                ", percent=" + percent +
                ", nCredit=" + nCredit +
                '}';
    }
}
