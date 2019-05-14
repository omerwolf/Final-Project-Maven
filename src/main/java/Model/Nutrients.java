package Model;
import DB.Entites.Soil;

import java.util.ArrayList;
import java.util.List;

public class Nutrients {
    private List<Double> basicRemoval = new ArrayList<>();
    private List<String> name = new ArrayList<>();
    private Soil soil;
    private List <NutrientsBasicRemovalPerStage> basicRemovalPerStages = new ArrayList<>();
    private SoilNutrients soilNutrients;
    private PreSeason preSeason;

    public Nutrients() {

    }

    public List<Double> getBasicRemoval() {
        return basicRemoval;
    }

    public void setBasicRemoval(List<Double> basicRemoval) {
        this.basicRemoval = basicRemoval;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public Soil getSoil() {
        return soil;
    }

    public void setSoil(Soil soil) {
        this.soil = soil;
    }

    public List<NutrientsBasicRemovalPerStage> getBasicRemovalPerStages() {
        return basicRemovalPerStages;
    }

    public void setBasicRemovalPerStages(List<NutrientsBasicRemovalPerStage> basicRemovalPerStages) {
        this.basicRemovalPerStages = basicRemovalPerStages;
    }

    public SoilNutrients getSoilNutrients() {
        return soilNutrients;
    }

    public void setSoilNutrients(SoilNutrients soilNutrients) {
        this.soilNutrients = soilNutrients;
    }

    public PreSeason getPreSeason() {
        return preSeason;
    }

    public void setPs(PreSeason preSeason) {
        this.preSeason = preSeason;
    }
}
