package Analysis.SoilAnalysis;

import java.time.LocalDate;

public class SoilAnalysis {

    final int test_type_id = 1;
    private String sample_name;
    private int soil_analysis_id;
    private boolean is_active;
    private int farm_id;
    private LocalDate sample_date;
    private int lab_id;
    private int soil_type_id;
    private int layer_depth_id;
    private int irrigation_block_id;
    private double organic_matter;
    private Double bulk_density;
    private Double soil_pH;
    private double soil_EC;
    private Double soil_CEC;

    public SoilAnalysis() {
    }

    public SoilAnalysis(String sample_name, int soil_analysis_id, boolean is_active, int farm_id, LocalDate sample_date,
                        int lab_id, int soil_type_id, int layer_depth_id, int irrigation_block_id, double organic_matter,
                        Double bulk_density, Double soil_pH, double soil_EC, Double soil_CEC) {
        this.sample_name = sample_name;
        this.soil_analysis_id = soil_analysis_id;
        this.is_active = is_active;
        this.farm_id = farm_id;
        this.sample_date = sample_date;
        this.lab_id = lab_id;
        this.soil_type_id = soil_type_id;
        this.layer_depth_id = layer_depth_id;
        this.irrigation_block_id = irrigation_block_id;
        this.organic_matter = organic_matter;
        this.bulk_density = bulk_density;
        this.soil_pH = soil_pH;
        this.soil_EC = soil_EC;
        this.soil_CEC = soil_CEC;
    }

    public int getTest_type_id() {
        return test_type_id;
    }

    public int getSoil_analysis_id() {
        return soil_analysis_id;
    }

    public void setSoil_analysis_id(int soil_analysis_id) {
        this.soil_analysis_id = soil_analysis_id;
    }

    public String getSample_name() {
        return sample_name;
    }

    public void setSample_name(String sample_name) {
        this.sample_name = sample_name;
    }

    public boolean isIs_active() {
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

    public int getLab_id() {
        return lab_id;
    }

    public void setLab_id(int lab_id) {
        this.lab_id = lab_id;
    }

    public int getSoil_type_id() {
        return soil_type_id;
    }

    public void setSoil_type_id(int soil_type_id) {
        this.soil_type_id = soil_type_id;
    }

    public int getLayer_depth_id() {
        return layer_depth_id;
    }

    public void setLayer_depth_id(int layer_depth_id) {
        this.layer_depth_id = layer_depth_id;
    }

    public int getIrrigation_block_id() {
        return irrigation_block_id;
    }

    public void setIrrigation_block_id(int irrigation_block_id) {
        this.irrigation_block_id = irrigation_block_id;
    }

    public double getOrganic_matter() {
        return organic_matter;
    }

    public void setOrganic_matter(double organic_matter) {
        this.organic_matter = organic_matter;
    }

    public Double getBulk_density() {
        return bulk_density;
    }

    public void setBulk_density(Double bulk_density) {
        this.bulk_density = bulk_density;
    }

    public Double getSoil_pH() {
        return soil_pH;
    }

    public void setSoil_pH(Double soil_pH) {
        this.soil_pH = soil_pH;
    }

    public double getSoil_EC() {
        return soil_EC;
    }

    public void setSoil_EC(double soil_EC) {
        this.soil_EC = soil_EC;
    }

    public Double getSoil_CEC() {
        return soil_CEC;
    }

    public void setSoil_CEC(Double soil_CEC) {
        this.soil_CEC = soil_CEC;
    }

    @Override
    public String toString() {
        return "SoilAnalysis{" +
                "test_type_id=" + test_type_id +
                ", soil_analysis_id=" + soil_analysis_id +
                ", sample_name='" + sample_name + '\'' +
                ", farm_id=" + farm_id +
                ", sample_date=" + sample_date +
                ", lab_id=" + lab_id +
                ", soil_type_id=" + soil_type_id +
                ", layer_depth_id=" + layer_depth_id +
                ", irrigation_block_id=" + irrigation_block_id +
                ", organic_matter=" + organic_matter +
                ", bulk_density=" + bulk_density +
                ", soil_pH=" + soil_pH +
                ", soil_EC=" + soil_EC +
                ", soil_CEC=" + soil_CEC +
                ", is_active=" + is_active +
                '}';
    }
}