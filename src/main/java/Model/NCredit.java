package Model;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

public class NCredit {


    public NCredit() {

    }
    public Nutrients nCredit(Parameters p, Nutrients n) {
        SoilNutrients soilNutrients = new SoilNutrients();
        List<Integer> nCredits = new ArrayList<>();
        nCredits.add(round(-(p.getUi().getSelectedNCredit())));
        for (int i=1;i<n.getBasicRemoval().size();i++) {
            nCredits.add(0);
        }
        //add to a table
        soilNutrients.setnCredits(nCredits);
        n.setSoilNutrients(soilNutrients);
        return n;
    }
}
