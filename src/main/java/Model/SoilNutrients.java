package Model;

import java.util.ArrayList;
import java.util.List;

public class SoilNutrients {
    private List<Integer> nCredits = new ArrayList<>();

    public SoilNutrients() {

    }

    public List<Integer> getnCredits() {
        return nCredits;
    }

    public void setnCredits(List<Integer> nCredits) {
        this.nCredits = nCredits;
    }
}
