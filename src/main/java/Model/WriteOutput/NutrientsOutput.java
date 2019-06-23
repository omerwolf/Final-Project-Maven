package Model.WriteOutput;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a line in two output tables, that is created during the model run,
 * and consists a row description name, and amounts for each of the 12 nutrients.
 * Used for adjustment table and actual nutrients table.
 */
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

    /**
     * Creates a NutrientsOutput row in an output table.
     * @param stageName - The row name.
     * @param n - N nutrient amount.
     * @param p205 - P nutrient amount.
     * @param k20 - K nutrient amount.
     * @param ca0 - Ca nutrient amount.
     * @param mg0 - Mg nutrient amount.
     * @param s - S nutrient amount.
     * @param fe - Fe nutrient amount.
     * @param b - B nutrient amount.
     * @param mn - Mn nutrient amount.
     * @param zn - Zn nutrient amount.
     * @param cu - Cu nutrient amount.
     * @param mo - Mo nutrient amount.
     */
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

    /**
     * Receives a row name and a list of amounts for each nutrient, and sets
     * each one of its members with the list's amounts.
     * @param stageName - The row name.
     * @param nutrients - A list of all 12 nutrients amounts.
     */
    public NutrientsOutput(String stageName, List<Double> nutrients) {
        this.stageName = stageName;
        N = nutrients.get(0);
        P205 = nutrients.get(1);
        K20 = nutrients.get(2);
        Ca0 = nutrients.get(3);
        Mg0 = nutrients.get(4);
        S = nutrients.get(5);
        Fe = nutrients.get(6);
        B = nutrients.get(7);
        Mn = nutrients.get(8);
        Zn = nutrients.get(9);
        Cu = nutrients.get(10);
        Mo = nutrients.get(11);
    }
    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public List<Double> nutrientsList() {
        List<Double> nutrientsValues = Arrays.asList(getN(),getP205(),getK20(), getCa0(),
                getMg0(),getS(),getFe(),getB(),getMn(),getZn(),getCu(),getMo());
        return nutrientsValues;
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

    /**
     * Overrides toString method in order to print the NutrientsOutput
     * field names and values.
     * @return NutrientsOutput's field names and values.
     */
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

    /**
     * Rounds the values of the output.
     */
    public void round() {
        List<Double> list = Arrays.asList(N,P205,K20,Ca0,Mg0,S,Fe,B,Mn,Zn,Cu,Mo);
        for (int i=0;i<list.size();i++) {
            double e = list.get(i);
            e = new BigDecimal(e).setScale(2, RoundingMode.FLOOR).doubleValue();
            list.set(i,e);
        }
        N = list.get(0);
        P205 = list.get(1);
        K20 = list.get(2);
        Ca0 = list.get(3);
        Mg0 = list.get(4);
        S = list.get(5);
        Fe = list.get(6);
        B = list.get(7);
        Mn = list.get(8);
        Zn = list.get(9);
        Cu = list.get(10);
        Mo = list.get(11);
        //list.add
    }
}
