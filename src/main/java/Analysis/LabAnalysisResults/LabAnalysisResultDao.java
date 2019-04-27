package Analysis.LabAnalysisResults;

import Analysis.SoilAnalysis.SoilLabAnalysisResult;
import Analysis.WaterAnalysis.WaterLabAnalysisResult;

import java.util.List;

public interface LabAnalysisResultDao {

    void insertWater(WaterLabAnalysisResult waterLabAnalysisResult);

    void insertAllWater(List<WaterLabAnalysisResult> waterLabAnalysisResultList);

    void insertSoil(SoilLabAnalysisResult soilLabAnalysisResult);

    void insertAllSoil(List<SoilLabAnalysisResult> soilLabAnalysisResultList);
}
