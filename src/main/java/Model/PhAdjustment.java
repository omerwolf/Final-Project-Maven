package Model;

public class PhAdjustment {

    public PhAdjustment() {

    }

    public Nutrients phAdjustment(Parameters p, Nutrients n, double sample) {

        double soilPh = 0;
        System.out.println(p.getSa().getSoil_pH());
        if (true) { //if general excel table of pre soil is active - check if needed
            if (sample == 0) { // 0 = pre season
                if (p.getSa().getSoil_pH() != null) { //if pre soil value of ph isn't null
                    soilPh = p.getSa().getSoil_pH();
                } else {
                    soilPh = p.getUi().getSelectedSoilPH(); //else
                }
            }
        }
        else {
            soilPh = p.getUi().getSelectedSoilPH();
        }
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
        //factors - take column with the ph adjustment desc for each nutrient - check with ofer
        //to row
        //later
        return n;
    }
}
