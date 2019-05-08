package Model.WriteOutput;

public class NutrientsOutput {
    private String stageName;
    private double N;
    private double P205;
    private double K20;
    private double Ca0;
    private double Mg0;
    private double S;
    private double Fe;
    private double B;
    private double Mn;
    private double Zn;
    private double Cu;
    private double Mo;

    public NutrientsOutput(String stageName, double n, double p205, double k20, double ca0, double mg0, double s,
                           double fe, double b, double mn, double zn, double cu, double mo) {
        this.stageName = stageName;
        N = n;
        P205 = p205;
        K20 = k20;
        Ca0 = ca0;
        Mg0 = mg0;
        S = s;
        Fe = fe;
        B = b;
        Mn = mn;
        Zn = zn;
        Cu = cu;
        Mo = mo;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public double getN() {
        return N;
    }

    public void setN(double n) {
        N = n;
    }

    public double getP205() {
        return P205;
    }

    public void setP205(double p205) {
        P205 = p205;
    }

    public double getK20() {
        return K20;
    }

    public void setK20(double k20) {
        K20 = k20;
    }

    public double getCa0() {
        return Ca0;
    }

    public void setCa0(double ca0) {
        Ca0 = ca0;
    }

    public double getMg0() {
        return Mg0;
    }

    public void setMg0(double mg0) {
        Mg0 = mg0;
    }

    public double getS() {
        return S;
    }

    public void setS(double s) {
        S = s;
    }

    public double getFe() {
        return Fe;
    }

    public void setFe(double fe) {
        Fe = fe;
    }

    public double getB() {
        return B;
    }

    public void setB(double b) {
        B = b;
    }

    public double getMn() {
        return Mn;
    }

    public void setMn(double mn) {
        Mn = mn;
    }

    public double getZn() {
        return Zn;
    }

    public void setZn(double zn) {
        Zn = zn;
    }

    public double getCu() {
        return Cu;
    }

    public void setCu(double cu) {
        Cu = cu;
    }

    public double getMo() {
        return Mo;
    }

    public void setMo(double mo) {
        Mo = mo;
    }

    @Override
    public String toString() {
        return "NutrientsOutput{" +
                "stageName='" + stageName + '\'' +
                ", N=" + N +
                ", P205=" + P205 +
                ", K20=" + K20 +
                ", Ca0=" + Ca0 +
                ", Mg0=" + Mg0 +
                ", S=" + S +
                ", Fe=" + Fe +
                ", B=" + B +
                ", Mn=" + Mn +
                ", Zn=" + Zn +
                ", Cu=" + Cu +
                ", Mo=" + Mo +
                '}';
    }
}
