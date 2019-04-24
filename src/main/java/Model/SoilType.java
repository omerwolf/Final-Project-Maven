package Model;

public class SoilType {

    private UserInput ui;

    public SoilType() {

    }
    public SoilType(UserInput ui) {
        this.ui = ui;
    }

    public void soilType(Nutrients n) {
        //if lab analysis data?

        //else
        String soilType = ui.getSelectedSoil().getName();

    }
}
