package Model;

import Model.WriteOutput.NutrientsOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.round;

/**
 * the class is responsible for adding to the adjusted nutrients output table
 * a list of n credit.
 */
public class NCredit {


    public NCredit() {

    }

    /**
     * adds the n credit value from the user input, and adds it
     * to an ncredits list, which is added to the adjusted nutrients table
     * in the PreSeason class member of the nutrients.
     * returned the updated nutrients class.
     * @param p - the parameters data
     * @param n - the nutrients data
     * @return n - the updated nutrients data
     */
    public Nutrients nCredit(Parameters p, Nutrients n) {
        SoilNutrients soilNutrients = new SoilNutrients();
        List<Double> nCredits = new ArrayList<Double>(Collections.nCopies(n.getName().size(),0.0));
        Integer nCreditValue = round(-(p.getUi().getSelectedNCredit()));
        nCredits.set(0,Double.valueOf(nCreditValue));

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
