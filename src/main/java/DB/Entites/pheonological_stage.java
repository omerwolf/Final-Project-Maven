package DB.Entites;

/**
 * represents a record in the `pheonological stage` table
 * in the database.
 */
public class pheonological_stage {
    private int pheonological_stage_id;
    private String pheonological_stage_desc;
    private int crop_id;
    private int pheonological_stage_duration_days;
    private Integer pheonological_stage_duration_gdd;

    /**
     * the default constructor.
     */
    public pheonological_stage() {

    }

    /**
     * creates a pheonological_stage record, without receiving pheonological stage id,
     * which is set in this constructor by default to 1, but than changed later.
     * @param pheonological_stage_desc - the name of the current crop's stage.
     * @param crop_id - the crop's id.
     * @param pheonological_stage_duration_days - crop's stage duration.
     * @param pheonological_stage_duration_gdd - growing degree days duration (usually null).
     */
    public pheonological_stage( String pheonological_stage_desc,
                               int crop_id, int pheonological_stage_duration_days,
                               Integer pheonological_stage_duration_gdd) {
        this.pheonological_stage_id = 1;
        this.pheonological_stage_desc = pheonological_stage_desc;
        this.crop_id = crop_id;
        this.pheonological_stage_duration_days = pheonological_stage_duration_days;
        this.pheonological_stage_duration_gdd = pheonological_stage_duration_gdd;
    }

    /**
     * creates a pheonological_stage record.
     * @param pheonological_stage_id - the id of the phenological stage
     * @param pheonological_stage_desc - the name of the current crop's stage.
     * @param crop_id - the crop's id.
     * @param pheonological_stage_duration_days - crop's stage duration.
     * @param pheonological_stage_duration_gdd - growing degree days duration (usually null).
     */
    public pheonological_stage(int pheonological_stage_id, String pheonological_stage_desc,
                               int crop_id, int pheonological_stage_duration_days,
                               Integer pheonological_stage_duration_gdd) {
        this.pheonological_stage_id = pheonological_stage_id;
        this.pheonological_stage_desc = pheonological_stage_desc;
        this.crop_id = crop_id;
        this.pheonological_stage_duration_days = pheonological_stage_duration_days;
        this.pheonological_stage_duration_gdd = pheonological_stage_duration_gdd;
    }

    public int getPheonological_stage_id() {
        return pheonological_stage_id;
    }

    public void setPheonological_stage_id(int pheonological_stage_id) {
        this.pheonological_stage_id = pheonological_stage_id;
    }

    public String getPheonological_stage_desc() {
        return pheonological_stage_desc;
    }

    public void setPheonological_stage_desc(String pheonological_stage_desc) {
        this.pheonological_stage_desc = pheonological_stage_desc;
    }

    public int getCrop_id() {
        return crop_id;
    }

    public void setCrop_id(int crop_id) {
        this.crop_id = crop_id;
    }

    public int getPheonological_stage_duration_days() {
        return pheonological_stage_duration_days;
    }

    public void setPheonological_stage_duration_days(int pheonological_stage_duration_days) {
        this.pheonological_stage_duration_days = pheonological_stage_duration_days;
    }

    public Integer getPheonological_stage_duration_gdd() {
        return pheonological_stage_duration_gdd;
    }

    public void setPheonological_stage_duration_gdd(Integer pheonological_stage_duration_gdd) {
        this.pheonological_stage_duration_gdd = pheonological_stage_duration_gdd;
    }
}
