package DB.Entites;

/**
 * represents a record in the `soil_types` table
 * in the database.
 */
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

    /**
     * the default constructor.
     */
    public Soil(){}

    /**
     * creates a Soil record, with all required fields but the id.
     * the id is by default set to 0, but needs to be set later.
     * @param name - the soil's name.
     * @param nPrecent - n nutrient percent for base dressing.
     * @param pPrecent - p nutrient percent for base dressing.
     * @param kPrecent - k nutrient percent for base dressing.
     * @param somDecompHigh - high temperature decomposition som.
     * @param somDecompModerate - moderate temperature decomposition som.
     * @param somDecompLow - low temperature decomposition som.
     * @param baseDressingStrategy - a number that represents the id of a base dressing strategy.
     * @param rainEffect - the percentage of the rain effect.
     * @param defualtCEC - cec default value.
     * @param lowerCEC - lower cec value.
     * @param upperCEC - upper cec value.
     * @param defualtBulkDensity - default bulk density.
     */
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

    /**
     * creates a Soil record, with all required field received as parameters.
     * @param id - the soil id.
     * @param name - the soil's name.
     * @param nPrecent - n nutrient percent for base dressing.
     * @param pPrecent - p nutrient percent for base dressing.
     * @param kPrecent - k nutrient percent for base dressing.
     * @param somDecompHigh - high temperature decomposition som.
     * @param somDecompModerate - moderate temperature decomposition som.
     * @param somDecompLow - low temperature decomposition som.
     * @param baseDressingStrategy - a number that represents the id of a base dressing strategy.
     * @param rainEffect - the percentage of the rain effect.
     * @param defualtCEC - cec default value.
     * @param lowerCEC - lower cec value.
     * @param upperCEC - upper cec value.
     * @param defualtBulkDensity - default bulk density.
     */
    public Soil(int id, String name, double nPrecent, double pPrecent, double kPrecent,
                double somDecompHigh, double somDecompModerate, double somDecompLow,
                int baseDressingStrategy, double rainEffect, int defualtCEC, int lowerCEC,
                int upperCEC, double defualtBulkDensity) {
        this.id = id;
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

    /**
     * creates a Soil record, given another soil as parameter.
     * takes it's parameters and sets its own fields at the received parameter values.
     * @param s - the soil to take from the values.
     */
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

    /**
     * overrides toString method in order to print the record's
     * names and values.
     * @return record's fields name and values.
     */
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
