package Model;

import java.util.ArrayList;
import java.util.List;

public class SoilNutrients {
    private List<Double> nCredits = new ArrayList<>();
    private List<Double> som = new ArrayList<>();

    public SoilNutrients() {

    }

    public List<Double> getnCredits() {
        return nCredits;
    }

    public void setnCredits(List<Double> nCredits) {
        this.nCredits = nCredits;
    }

    public List<Double> getSom() {
        return som;
    }

    public void setSom(List<Double> som) {
        this.som = som;
    }
}
