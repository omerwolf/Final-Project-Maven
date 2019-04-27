package Model;

import java.util.List;

public class Parameters {

    private UserInput ui;
    private List<StageDate> stageDates;
    public Parameters() {

    }

    public List<StageDate> getStageDates() {
        return stageDates;
    }

    public void setStageDates(List<StageDate> stageDates) {
        this.stageDates = stageDates;
    }

    public UserInput getUi() {
        return ui;
    }

    public void setUi(UserInput ui) {
        this.ui = ui;
    }
}
