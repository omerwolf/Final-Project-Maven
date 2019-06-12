package DB.Entites;

/**
 * represents a record in the `parameter_per_stage` table
 * in the database.
 */
public class ParameterPerStage {
    private int nutrientPerStageId;
    private int paramPerCropId;
    private int varietyId;
    private int phenologicalStageId;
    private double percent;

    /**
     *
     */
    public ParameterPerStage() {

    }

    /**
     * creates a ParameterPerStage record, receiving all required fields with the exception
     * of the nutrientPerStageId (sets to 0, or will changed later).
     * @param paramPerCropId - the id of the parameter per crop.
     * @param varietyId - the variety of the crop.
     * @param phenologicalStageId - the id of the phenological stage.
     * @param percent - the percentage of the amount in kg that each nutrient needs
     *               in each stage during the season.
     */
    public ParameterPerStage(int paramPerCropId, int varietyId, int phenologicalStageId, double percent) {
        this.nutrientPerStageId = 0;
        this.paramPerCropId = paramPerCropId;
        this.varietyId = varietyId;
        this.phenologicalStageId = phenologicalStageId;
        this.percent = percent;
    }

    /**
     * creates a ParameterPerStage record, receiving all required fields parameters.
     * @param nutrientPerStageId - the id of the nutrients per stage id.
     * @param paramPerCropId - the id of the parameter per crop.
     * @param varietyId - the variety of the crop.
     * @param phenologicalStageId - the id of the phenological stage.
     * @param percent - the percentage of the amount in kg that each nutrient needs
     *                in each stage during the season.
     */
    public ParameterPerStage(int nutrientPerStageId, int paramPerCropId, int varietyId, int phenologicalStageId, double percent) {
        this.nutrientPerStageId = nutrientPerStageId;
        this.paramPerCropId = paramPerCropId;
        this.varietyId = varietyId;
        this.phenologicalStageId = phenologicalStageId;
        this.percent = percent;
    }

    public int getNutrientPerStageId() {
        return nutrientPerStageId;
    }

    public void setNutrientPerStageId(int nutrientPerStageId) {
        this.nutrientPerStageId = nutrientPerStageId;
    }

    public int getParamPerCropId() {
        return paramPerCropId;
    }

    public void setParamPerCropId(int paramPerCropId) {
        this.paramPerCropId = paramPerCropId;
    }

    public int getVarietyId() {
        return varietyId;
    }

    public void setVarietyId(int varietyId) {
        this.varietyId = varietyId;
    }

    public int getPhenologicalStageId() {
        return phenologicalStageId;
    }

    public void setPhenologicalStageId(int phenologicalStageId) {
        this.phenologicalStageId = phenologicalStageId;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    /**
     * overrides toString method in order to print the record's
     * names and values.
     * @return record's fields name and values.
     */
    @Override
    public String toString() {
        return "ParameterPerStage{" +
                "nutrientPerStageId=" + nutrientPerStageId +
                ", paramPerCropId=" + paramPerCropId +
                ", varietyId=" + varietyId +
                ", phenologicalStageId=" + phenologicalStageId +
                ", percent=" + percent +
                '}';
    }
}
