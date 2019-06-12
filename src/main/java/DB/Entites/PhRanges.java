package DB.Entites;

/**
 * represents a record in the `ph_ranges` table
 * in the database.
 */
public class PhRanges {
    private int rangeId;
    private String rangeDesc;
    private double minPhRange;
    private double maxPhRange;

    /**
     * the default constructor.
     */
    public PhRanges() {

    }

    /**
     * creates a PhRanges record.
     * @param rangeId - the id of the range of ph.
     * @param rangeDesc - the name of the ph range.
     * @param minPhRange - the minimum possible value of ph in that range.
     * @param maxPhRange - the maximum possible value of ph in that range.
     */
    public PhRanges(int rangeId,String rangeDesc, double minPhRange, double maxPhRange) {
        this.rangeId = rangeId;
        this.rangeDesc = rangeDesc;
        this.minPhRange = minPhRange;
        this.maxPhRange = maxPhRange;
    }

    public int getRangeId() {
        return rangeId;
    }

    public void setRangeId(int rangeId) {
        this.rangeId = rangeId;
    }

    public String getRangeDesc() {
        return rangeDesc;
    }

    public void setRangeDesc(String rangeDesc) {
        this.rangeDesc = rangeDesc;
    }

    public double getMinPhRange() {
        return minPhRange;
    }

    public void setMinPhRange(double minPhRange) {
        this.minPhRange = minPhRange;
    }

    public double getMaxPhRange() {
        return maxPhRange;
    }

    public void setMaxPhRange(double maxPhRange) {
        this.maxPhRange = maxPhRange;
    }
}
