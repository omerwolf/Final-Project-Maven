package Model;

public class SoilType {

    private UserInput ui;

    public SoilType() {

    }
    public SoilType(UserInput ui) {
        this.ui = ui;
    }

    public Nutrients soilType(Parameters p, Nutrients n) {
        //if lab analysis is active, read soil info from there (should be in the db at this stage).

        //else
        //take soil from simulation data
        n.setSoil(p.getUi().getSelectedSoil());
        return n;
    }
}
