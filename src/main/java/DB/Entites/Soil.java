package DB.Entites;

public class Soil {
    //Members
    private int id;
    private String name;
    private double nPrecent;
    private double pPrecent;
    private double kPrecent;
    private double somDecompHigh;
    private double somDecompModerate;
    private double somDecompLow;
    private int baseDressingStrategy;
    private double rainEffect;
    private int defualtCEC;
    private int lowerCEC;
    private int upperCEC;
    private double defualtBulkDensity;

    //Constructor
    public Soil(){}

    public Soil(String name, double nPrecent, double pPrecent, double kPrecent, double somDecompHigh,
                double somDecompModerate, double somDecompLow, int baseDressingStrategy, double rainEffect,
                int defualtCEC, int lowerCEC, int upperCEC, double defualtBulkDensity) {
        this.id = 0;
        this.name = name;
        this.nPrecent = nPrecent;
        this.pPrecent = pPrecent;
        this.kPrecent = kPrecent;
        this.somDecompHigh = somDecompHigh;
        this.somDecompModerate = somDecompModerate;
        this.somDecompLow = somDecompLow;
        this.baseDressingStrategy = baseDressingStrategy;
        this.rainEffect = rainEffect;
        this.defualtCEC = defualtCEC;
        this.lowerCEC = lowerCEC;
        this.upperCEC = upperCEC;
        this.defualtBulkDensity = defualtBulkDensity;
    }

    public Soil(Soil s) {
        this.id = s.getId();
        this.name = s.getName();
        this.nPrecent = s.getnPrecent();
        this.pPrecent = s.getpPrecent();
        this.kPrecent = s.getkPrecent();
        this.somDecompHigh = s.getSomDecompHigh();
        this.somDecompModerate = s.getSomDecompModerate();
        this.somDecompLow = s.getSomDecompLow();
        this.baseDressingStrategy = s.getBaseDressingStrategy();
        this.rainEffect = s.getRainEffect();
        this.defualtCEC = s.getDefualtCEC();
        this.lowerCEC = s.getLowerCEC();
        this.upperCEC = s.getUpperCEC();
        this.defualtBulkDensity = s.getDefualtBulkDensity();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getnPrecent() {
        return nPrecent;
    }

    public void setnPrecent(double nPrecent) {
        this.nPrecent = nPrecent;
    }

    public double getpPrecent() {
        return pPrecent;
    }

    public void setpPrecent(double pPrecent) {
        this.pPrecent = pPrecent;
    }

    public double getkPrecent() {
        return kPrecent;
    }

    public void setkPrecent(double kPrecent) {
        this.kPrecent = kPrecent;
    }

    public double getSomDecompHigh() {
        return somDecompHigh;
    }

    public void setSomDecompHigh(double somDecompHigh) {
        this.somDecompHigh = somDecompHigh;
    }

    public double getSomDecompModerate() {
        return somDecompModerate;
    }

    public void setSomDecompModerate(double somDecompModerate) {
        this.somDecompModerate = somDecompModerate;
    }

    public double getSomDecompLow() {
        return somDecompLow;
    }

    public void setSomDecompLow(double somDecompLow) {
        this.somDecompLow = somDecompLow;
    }

    public int getBaseDressingStrategy() {
        return baseDressingStrategy;
    }

    public void setBaseDressingStrategy(int baseDressingStrategy) {
        this.baseDressingStrategy = baseDressingStrategy;
    }

    public double getRainEffect() {
        return rainEffect;
    }

    public void setRainEffect(double rainEffect) {
        this.rainEffect = rainEffect;
    }

    public int getDefualtCEC() {
        return defualtCEC;
    }

    public void setDefualtCEC(int defualtCEC) {
        this.defualtCEC = defualtCEC;
    }

    public int getLowerCEC() {
        return lowerCEC;
    }

    public void setLowerCEC(int lowerCEC) {
        this.lowerCEC = lowerCEC;
    }

    public int getUpperCEC() {
        return upperCEC;
    }

    public void setUpperCEC(int upperCEC) {
        this.upperCEC = upperCEC;
    }

    public double getDefualtBulkDensity() {
        return defualtBulkDensity;
    }

    public void setDefualtBulkDensity(double defualtBulkDensity) {
        this.defualtBulkDensity = defualtBulkDensity;
    }

    @Override
    public String toString() {
        return "Soil{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nPrecent=" + nPrecent +
                ", pPrecent=" + pPrecent +
                ", kPrecent=" + kPrecent +
                ", somDecompHigh=" + somDecompHigh +
                ", somDecompModerate=" + somDecompModerate +
                ", somDecompLow=" + somDecompLow +
                ", baseDressingStrategy=" + baseDressingStrategy +
                ", rainEffect=" + rainEffect +
                ", defualtCEC=" + defualtCEC +
                ", lowerCEC=" + lowerCEC +
                ", upperCEC=" + upperCEC +
                ", defualtBulkDensity=" + defualtBulkDensity +
                '}';
    }
}
