package Model;

import Analysis.LabAnalysisResults.SoilLabAnalysisResult;
import Analysis.LabAnalysisResults.WaterLabAnalysisResult;
import Analysis.SoilAnalysis.SoilAnalysis;
import Analysis.WaterAnalysis.WaterAnalysis;

import java.util.List;

/**
 * The class contains the parameters used during the execution of the model.
 * They are used in order to calculate all the adjustments needed for the soil
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
     * Constructor - builds the parameters class
     * @param ui - All the relevant input of the user, at the beginning of the program.
     * @param sa - Tha base data for the soil analysis (id, date, name, etc.)
     * @param wa - The base data for the water analysis(id, date, name, etc.)
     * @param slar - The soil lab analysis results of each nutrient, including extraction method
     * @param wlar - The water lab analysis results of each nutrient
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
     * Return the cropStages
     * @return cropStages - The dates of each stage of the crop's growth
     */
    public List<CropStage> getCropStages() {
        return cropStages;
    }

    /**
     * Sets the dates of each stage of the crop's growth,
     * which are calculated in the CropStage class.
     * @param cropStages
     */
    public void setCropStages(List<CropStage> cropStages) {
        this.cropStages = cropStages;
    }

    /**
     * Returns the user input.
     * @return ui - The user input at the beginning of a season.
     */

    public UserInput getUi() {
        return ui;
    }

    /**
     * Sets the user input.
     * @param ui - The user input for the crop.
     */
    public void setUi(UserInput ui) {
        this.ui = ui;
    }

    /**
     * Returns the Soil Analysis data
     * @return sa - The soil analysis base data
     */
    public SoilAnalysis getSa() {
        return sa;
    }

    /**
     * Sets the soil analysis data, if provided.
     * @param sa - The soil analysis base data to set
     */
    public void setSa(SoilAnalysis sa) {
        this.sa = sa;
    }

    /**
     * Returns the water analysis data
     * @return wa - The water analysis base data
     */
    public WaterAnalysis getWa() {
        return wa;
    }

    /**
     * Sets the water analysis data, if provided.
     * @param wa - The water analysis base data to set
     */
    public void setWa(WaterAnalysis wa) {
        this.wa = wa;
    }

    /**
     * Returns a list of soil lab analysis data.
     * @return slar - A list, in which each record contains
     * soil lab analysis info for a specific nutrient.
     */
    public List<SoilLabAnalysisResult> getSlar() {
        return slar;
    }

    /**
     * Sets a list of soil lab analysis results for each nutrient
     * @param slar - The list of soil lab analysis data to set.
     */
    public void setSlar(List<SoilLabAnalysisResult> slar) {
        this.slar = slar;
    }
    /**
     * Returns a list of water lab analysis data.
     * @return wlar - A list, in which each record contains
     * water lab analysis info for a specific nutrient.
     */
    public List<WaterLabAnalysisResult> getWlar() {
        return wlar;
    }
    /**
     * Sets a list of water lab analysis results for each nutrient
     * @param wlar - The list of water lab analysis data to set.
     */
    public void setWlar(List<WaterLabAnalysisResult> wlar) {
        this.wlar = wlar;
    }

    /**
     * Returns the duration of the crop's growth
     * @return duration - Duration of the crop's growth
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the amount of days it takes to grow to crop
     * @param duration - The duration to set
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }
}
