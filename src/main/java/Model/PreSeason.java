package Model;

import Model.WriteOutput.NutrientsOutput;
import Model.WriteOutput.SoilAnalysisOutput;
import Model.WriteOutput.WaterAnalysisOutput;

import java.util.ArrayList;
import java.util.List;

public class PreSeason {
    private List<NutrientsOutput> adjNutrients = new ArrayList<>();
    private List<NutrientsOutput> actualNutrients = new ArrayList<>();
    private List<SoilAnalysisOutput> soilAnalysis = new ArrayList<>();
    private List<WaterAnalysisOutput> waterAnalysis = new ArrayList<>();

    public PreSeason() {

    }

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
