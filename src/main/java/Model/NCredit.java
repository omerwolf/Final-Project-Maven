package Model;

import Model.WriteOutput.NutrientsOutput;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

public class NCredit {


    public NCredit() {

    }
    public Nutrients nCredit(Parameters p, Nutrients n) {
        SoilNutrients soilNutrients = new SoilNutrients();
        List<Double> nCredits = new ArrayList<>();
        Integer nCreditValue = round(-(p.getUi().getSelectedNCredit()));
        nCredits.add(Double.valueOf(nCreditValue));
        for (int i=1;i<n.getBasicRemoval().size();i++) {
            nCredits.add(0.0);
        }
        soilNutrients.setnCredits(nCredits);
        n.setSoilNutrients(soilNutrients);
        //add to adj table output
        List<NutrientsOutput> nutrientsOutputList = n.getPreSeason().getAdjNutrients();
        NutrientsOutput nutrientsOutputNCredit = new NutrientsOutput("N_Credit",nCredits);
        nutrientsOutputList.add(nutrientsOutputNCredit);
        n.getPreSeason().setAdjNutrients(nutrientsOutputList);
        System.out.println("n credit is" + nCredits);
        return n;
    }
}
