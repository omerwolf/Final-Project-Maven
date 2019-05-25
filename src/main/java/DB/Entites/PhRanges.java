package DB.Entites;

public class PhRanges {
    private int rangeId;
    private String rangeDesc;
    private double minPhRange;
    private double maxPhRange;

    public PhRanges() {

    }
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
