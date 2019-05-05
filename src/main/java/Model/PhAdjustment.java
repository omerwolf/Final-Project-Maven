package Model;

public class PhAdjustment {

    public PhAdjustment() {

    }

    public Nutrients phAdjustment(Parameters p, Nutrients n, double ph) {

        //if pre soil checks, need to read
        double soilPh = p.getUi().getSelectedSoilPH(); //else
        String phDesc;
        if (soilPh < 4.5) {
            phDesc = "Very_Acidic";
        }
        else if (soilPh < 5.5) {
            phDesc = "Acidic";
        }
        else if (soilPh < 7.5) {
            phDesc = "Neutral";
        }
        else if (soilPh < 8.5) {
            phDesc = "Slightly_Alkaline";
        }
        else if (soilPh >= 8.5) {
            phDesc = "Alkaline";
        }
        else {
            phDesc = "NaN";
        }

        return n;
    }
}
