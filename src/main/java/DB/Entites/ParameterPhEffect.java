package DB.Entites;

public class ParameterPhEffect {
    private int effectId;
    private int parameterId;
    private int rangeId;
    private double effect;

    public ParameterPhEffect() {

    }

    public ParameterPhEffect(int effectId, int parameterId, int rangeId, double effect) {
        this.effectId = effectId;
        this.parameterId = parameterId;
        this.rangeId = rangeId;
        this.effect = effect;
    }

    public int getEffectId() {
        return effectId;
    }

    public void setEffectId(int effectId) {
        this.effectId = effectId;
    }

    public int getParameterId() {
        return parameterId;
    }

    public void setParameterId(int parameterId) {
        this.parameterId = parameterId;
    }

    public int getRangeId() {
        return rangeId;
    }

    public void setRangeId(int rangeId) {
        this.rangeId = rangeId;
    }

    public double getEffect() {
        return effect;
    }

    public void setEffect(double effect) {
        this.effect = effect;
    }
}
