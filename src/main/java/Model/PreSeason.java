package Model;

import Model.WriteOutput.NutrientsOutput;
import Model.WriteOutput.SoilAnalysisOutput;
import Model.WriteOutput.WaterAnalysisOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * The class contains info about the amount of each nutrient that the crop needs throughout the season.
 * It contains lists that gives info about the soil analysis and water analysis.
 * Those lists will be written to an excel during the model's run.
 */
public class PreSeason {
    private List<NutrientsOutput> adjNutrients = new ArrayList<>();
    private List<NutrientsOutput> actualNutrients = new ArrayList<>();
    private List<SoilAnalysisOutput> soilAnalysis = new ArrayList<>();
    private List<WaterAnalysisOutput> waterAnalysis = new ArrayList<>();

    /**
     * default constructor
     */
    public PreSeason() {

    }

    /**
     * 2nd constructor, receiving several output lists.
     * @param adjNutrients - A list with info about the adjustments to the amount of each nutrient.
     * @param actualNutrients - A list with info about the actual amount needed for each nutrient.
     * @param soilAnalysis - A list that interprets the soil analysis.
     * @param waterAnalysis - A list with info about the amount additions from the water analysis.
     */
    public PreSeason(List<NutrientsOutput> adjNutrients, List<NutrientsOutput> actualNutrients,
                     List<SoilAnalysisOutput> soilAnalysis, List<WaterAnalysisOutput> waterAnalysis) {
        this.adjNutrients = adjNutrients;
        this.actualNutrients = actualNutrients;
        this.soilAnalysis = soilAnalysis;
        this.waterAnalysis = waterAnalysis;
    }

    public List<NutrientsOutput> getAdjNutrients() {
        return adjNutrients;
    }

    public void setAdjNutrients(List<NutrientsOutput> adjNutrients) {
        this.adjNutrients = adjNutrients;
    }

    public List<NutrientsOutput> getActualNutrients() {
        return actualNutrients;
    }

    public void setActualNutrients(List<NutrientsOutput> actualNutrients) {
        this.actualNutrients = actualNutrients;
    }

    public List<SoilAnalysisOutput> getSoilAnalysis() {
        return soilAnalysis;
    }

    public void setSoilAnalysis(List<SoilAnalysisOutput> soilAnalysis) {
        this.soilAnalysis = soilAnalysis;
    }

    public List<WaterAnalysisOutput> getWaterAnalysis() {
        return waterAnalysis;
    }

    public void setWaterAnalysis(List<WaterAnalysisOutput> waterAnalysis) {
        this.waterAnalysis = waterAnalysis;
    }
}
