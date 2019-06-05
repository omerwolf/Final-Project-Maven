package Model;

import Analysis.LabAnalysisResults.SoilLabAnalysisResult;
import Analysis.LabAnalysisResults.WaterLabAnalysisResult;
import Analysis.SoilAnalysis.SoilAnalysis;
import Analysis.WaterAnalysis.WaterAnalysis;

import java.util.List;

/**
 * the class contains the parameters used during the execution of the model.
 * they are used in order to calculate all the adjustments needed for the soil
 * and water nutrients of a crop.
 */
public class Parameters {

    private UserInput ui;
    private SoilAnalysis sa;
    private WaterAnalysis wa;
    private List<SoilLabAnalysisResult> slar;
    private List<WaterLabAnalysisResult> wlar;
    private List<CropStage> cropStages;
    private int duration;
    public Parameters() {

    }

    /**
     * constructor - builds the parameters class
     * @param ui - all the relevant input of the user, at the beginning of the program.
     * @param sa - tha base data for the soil analysis (id, date, name, etc.)
     * @param wa - the base data for the water analysis(id, date, name, etc.)
     * @param slar - the soil lab analysis results of each nutrient, including extraction method
     * @param wlar - the water lab analysis results of each nutrient
     */
    public Parameters(UserInput ui, SoilAnalysis sa, WaterAnalysis wa,
                      List<SoilLabAnalysisResult> slar, List<WaterLabAnalysisResult> wlar) {
        this.ui = ui;
        this.sa = sa;
        this.wa = wa;
        this.slar = slar;
        this.wlar = wlar;
    }

    /**
     * return the cropStages
     * @return cropStages - the dates of each stage of the crop's growth
     */
    public List<CropStage> getCropStages() {
        return cropStages;
    }

    /**
     * sets the dates of each stage of the crop's growth,
     * which are calculated in the CropStage class.
     * @param cropStages
     */
    public void setCropStages(List<CropStage> cropStages) {
        this.cropStages = cropStages;
    }

    /**
     * returns the user input.
     * @return ui - the user input at the beginning of a season.
     */

    public UserInput getUi() {
        return ui;
    }

    /**
     * sets the user input.
     * @param ui - the user input for the crop.
     */
    public void setUi(UserInput ui) {
        this.ui = ui;
    }

    /**
     * returns the Soil Analysis data
     * @return sa - the soil analysis base data
     */
    public SoilAnalysis getSa() {
        return sa;
    }

    /**
     * sets the soil analysis data, if provided.
     * @param sa - the soil analysis base data to set
     */
    public void setSa(SoilAnalysis sa) {
        this.sa = sa;
    }

    /**
     * returns the water analysis data
     * @return wa - the water analysis base data
     */
    public WaterAnalysis getWa() {
        return wa;
    }

    /**
     * sets the water analysis data, if provided.
     * @param wa - the water analysis base data to set
     */
    public void setWa(WaterAnalysis wa) {
        this.wa = wa;
    }

    /**
     * returns a list of soil lab analysis data.
     * @return slar - a list, in which each record contains
     * soil lab analysis info for a specific nutrient.
     */
    public List<SoilLabAnalysisResult> getSlar() {
        return slar;
    }

    /**
     * sets a list of soil lab analysis results for each nutrient
     * @param slar - the list of soil lab analysis data to set.
     */
    public void setSlar(List<SoilLabAnalysisResult> slar) {
        this.slar = slar;
    }
    /**
     * returns a list of water lab analysis data.
     * @return wlar - a list, in which each record contains
     * water lab analysis info for a specific nutrient.
     */
    public List<WaterLabAnalysisResult> getWlar() {
        return wlar;
    }
    /**
     * sets a list of water lab analysis results for each nutrient
     * @param wlar - the list of water lab analysis data to set.
     */
    public void setWlar(List<WaterLabAnalysisResult> wlar) {
        this.wlar = wlar;
    }

    /**
     * returns the duration of the crop's growth
     * @return duration - duration of the crop's growth
     */
    public int getDuration() {
        return duration;
    }

    /**
     * sets the amount of days it takes to grow to crop
     * @param duration - the duration to set
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }
}
