package Model;

/**
 * Represents a list the contain information about a specific
 * stage, including it's name, it's starting date, and the amount of
 * nutrients that are needed to be removed during that stage.
 */
public class NutrientsBasicRemovalPerStage {
    private CropStage sd;
    private double n;
    private double p;
    private double k;
    private double ca;
    private double mg;
    private double s;
    private double fe;
    private double mn;
    private double b;
    private double zn;
    private double cu;
    private double mo;

    public NutrientsBasicRemovalPerStage() {

    }

    /**
     * Creates the nutrientsBasicRemovalPerStage object, which contains the amount
     * of removal that is needed for each nutrient in a specific stage during
     * the crop's growth. also contains the stage name, and it's starting date.
     * @param sd
     * @param n
     * @param p
     * @param k
     * @param ca
     * @param mg
     * @param s
     * @param fe
     * @param mn
     * @param b
     * @param zn
     * @param cu
     * @param mo
     */
    public NutrientsBasicRemovalPerStage(CropStage sd, double n, double p, double k,
                                         double ca, double mg, double s, double fe,
                                         double mn, double b, double zn, double cu, double mo) {
        this.sd = sd;
        this.n = n;
        this.p = p;
        this.k = k;
        this.ca = ca;
        this.mg = mg;
        this.s = s;
        this.fe = fe;
        this.mn = mn;
        this.b = b;
        this.zn = zn;
        this.cu = cu;
        this.mo = mo;
    }

    public CropStage getSd() {
        return sd;
    }

    public void setSd(CropStage sd) {
        this.sd = sd;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getCa() {
        return ca;
    }

    public void setCa(double ca) {
        this.ca = ca;
    }

    public double getMg() {
        return mg;
    }

    public void setMg(double mg) {
        this.mg = mg;
    }

    public double getS() {
        return s;
    }

    public void setS(double s) {
        this.s = s;
    }

    public double getFe() {
        return fe;
    }

    public void setFe(double fe) {
        this.fe = fe;
    }

    public double getMn() {
        return mn;
    }

    public void setMn(double mn) {
        this.mn = mn;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getZn() {
        return zn;
    }

    public void setZn(double zn) {
        this.zn = zn;
    }

    public double getCu() {
        return cu;
    }

    public void setCu(double cu) {
        this.cu = cu;
    }

    public double getMo() {
        return mo;
    }

    public void setMo(double mo) {
        this.mo = mo;
    }
    public String print() {
        return sd.getStageName() + " " + sd.getStageDate() + " " +getN() + " " + getP()
                + " " +getK() + " " +getCa() +" " + getMg() + " " +getS() + " " + getFe()
                + " " + getMn() + " " + getB() + " " + getZn() + " " + getCu() +" " + getMo();
    }
}
