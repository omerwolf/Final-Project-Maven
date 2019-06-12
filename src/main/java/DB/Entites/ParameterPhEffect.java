package DB.Entites;

/**
 * represents a record in the `parameter_ph_effect` table
 * in the database.
 */
public class ParameterPhEffect {
    private int effectId;
    private int parameterId;
    private int rangeId;
    private double effect;

    /**
     * the default constructor.
     */
    public ParameterPhEffect() {

    }

    /**
     *
     * @param effectId - the id of the effect.
     * @param parameterId - the id of the paramter (nutrient).
     * @param rangeId - the id representing the range of the ph.
     * @param effect - represents the percentage of the effect
     *              of the ph on each one of the nutrients.
     */
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
