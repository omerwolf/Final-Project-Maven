package Model;

/**
 * represents a stage in the crop growth.
 * including it's name and a string representing it's start date.
 */
public class CropStage {

    String stageName;
    String stageDate;

    /**
     * the default constructor
     */
    public CropStage(){

    }

    /**
     * return the crop's stage name
     * @return stageName - the name of the current's crop stage name
     */
    public String getStageName() {
        return stageName;
    }

    /**
     * sets the stageName
     * @param stageName - the name to set
     */
    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    /**
     * returns the stage, represented in a string format
     * @return stageDate
     */
    public String getStageDate() {
        return stageDate;
    }

    /**
     * sets the stageDate
     * @param stageDate - the date to set
     */
    public void setStageDate(String stageDate) {
        this.stageDate = stageDate;
    }
}
