package Model;

/**
 * Represents a stage in the crop growth,
 * including it's name and a string representing it's start date.
 */
public class CropStage {

    String stageName;
    String stageDate;

    /**
     * The default constructor
     */
    public CropStage(){

    }

    /**
     * Return the crop's stage name
     * @return stageName - The name of the current's crop stage name
     */
    public String getStageName() {
        return stageName;
    }

    /**
     * Sets the stageName
     * @param stageName - The name to set
     */
    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    /**
     * Returns the stage, represented in a string format
     * @return stageDate
     */
    public String getStageDate() {
        return stageDate;
    }

    /**
     * Sets the stageDate
     * @param stageDate - The date to set
     */
    public void setStageDate(String stageDate) {
        this.stageDate = stageDate;
    }
}
