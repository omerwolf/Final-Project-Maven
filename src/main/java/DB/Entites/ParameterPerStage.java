package DB.Entites;

public class ParameterPerStage {
    private int nutrientPerStageId;
    private int paramPerCropId;
    private int varietyId;
    private int phenologicalStageId;
    private double percent;

    public ParameterPerStage() {

    }

    public ParameterPerStage(int paramPerCropId, int varietyId, int phenologicalStageId, double percent) {
        this.nutrientPerStageId = 0;
        this.paramPerCropId = paramPerCropId;
        this.varietyId = varietyId;
        this.phenologicalStageId = phenologicalStageId;
        this.percent = percent;
    }

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
