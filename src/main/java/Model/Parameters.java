package Model;

import Analysis.LabAnalysisResults.SoilLabAnalysisResult;
import Analysis.LabAnalysisResults.WaterLabAnalysisResult;
import Analysis.SoilAnalysis.SoilAnalysis;
import Analysis.WaterAnalysis.WaterAnalysis;

import java.util.List;

public class Parameters {

    private UserInput ui;
    private SoilAnalysis sa;
    private WaterAnalysis wa;
    private List<SoilLabAnalysisResult> slar;
    private List<WaterLabAnalysisResult> wlar;
    private List<StageDate> stageDates;
    public Parameters() {

    }
    public Parameters(UserInput ui, SoilAnalysis sa, WaterAnalysis wa,
                      List<SoilLabAnalysisResult> slar, List<WaterLabAnalysisResult> wlar) {
        this.ui = ui;
        this.sa = sa;
        this.wa = wa;
        this.slar = slar;
        this.wlar = wlar;
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

    public SoilAnalysis getSa() {
        return sa;
    }

    public void setSa(SoilAnalysis sa) {
        this.sa = sa;
    }

    public WaterAnalysis getWa() {
        return wa;
    }

    public void setWa(WaterAnalysis wa) {
        this.wa = wa;
    }

    public List<SoilLabAnalysisResult> getSlar() {
        return slar;
    }

    public void setSlar(List<SoilLabAnalysisResult> slar) {
        this.slar = slar;
    }

    public List<WaterLabAnalysisResult> getWlar() {
        return wlar;
    }

    public void setWlar(List<WaterLabAnalysisResult> wlar) {
        this.wlar = wlar;
    }
}
