package Analysis.WaterAnalysis;

import java.time.LocalDate;

public class WaterAnalysis {
    final int test_type_id = 2;

    private int water_analysis_id;
    private boolean is_active;
    private int farm_id;
    private LocalDate sample_date;
    private String sample_name;
    private int ib_id; //irigation block ID
    private double water_EC;
    private double water_pH;
    private Integer id_status = null; //default


    public WaterAnalysis() {
    }

    public WaterAnalysis(int water_analysis_id, boolean is_active, int farm_id, LocalDate sample_date,
                            String sample_name, int ib_id, double water_EC, double water_pH) {
        this.water_analysis_id = water_analysis_id;
        this.is_active = is_active;
        this.farm_id = farm_id;
        this.sample_date = sample_date;
        this.sample_name = sample_name;
        this.ib_id = ib_id;
        this.water_EC = water_EC;
        this.water_pH = water_pH;
    }

    public int getWater_analysis_id() {
        return water_analysis_id;
    }

    public void setWater_analysis_id(int water_analysis_id) {
        this.water_analysis_id = water_analysis_id;
    }

    public boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public int getFarm_id() {
        return farm_id;
    }

    public void setFarm_id(int farm_id) {
        this.farm_id = farm_id;
    }

    public LocalDate getSample_date() {
        return sample_date;
    }

    public void setSample_date(LocalDate sample_date) {
        this.sample_date = sample_date;
    }

    public String getSample_name() {
        return sample_name;
    }

    public void setSample_name(String sample_name) {
        this.sample_name = sample_name;
    }

    public int getIb_id() {
        return ib_id;
    }

    public void setIb_id(int ib_id) {
        this.ib_id = ib_id;
    }

    public double getWater_EC() {
        return water_EC;
    }

    public void setWater_EC(double water_EC) {
        this.water_EC = water_EC;
    }

    public double getWater_pH() {
        return water_pH;
    }

    public void setWater_pH(double wateR_pH) {
        this.water_pH = wateR_pH;
    }

    public Integer getId_status() {
        return id_status;
    }

    public void setId_status(Integer id_status) {
        this.id_status = id_status;
    }

    public int getTest_type_id() {
        return test_type_id;
    }

    @Override
    public String toString() {
        return "WaterAnalysis{" +
                "water_analysis_id=" + water_analysis_id +
                ", is_active=" + is_active +
                ", farm_id=" + farm_id +
                ", sample_date=" + sample_date +
                ", sample_name='" + sample_name + '\'' +
                ", ib_id=" + ib_id +
                ", water_EC=" + water_EC +
                ", water_pH=" + water_pH +
                ", id_status=" + id_status +
                '}';
    }
}
