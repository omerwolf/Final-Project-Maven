package Analysis.LabAnalysisResults;

import java.util.List;

public interface LabAnalysisResultDao {

    void insertWater(WaterLabAnalysisResult waterLabAnalysisResult);

    void insertAllWater(List<WaterLabAnalysisResult> waterLabAnalysisResultList);

    void insertSoil(SoilLabAnalysisResult soilLabAnalysisResult);

    void insertAllSoil(List<SoilLabAnalysisResult> soilLabAnalysisResultList);

    List<SoilLabAnalysisResult> selectAllSoilById(int soilAnalasisId);

    List<WaterLabAnalysisResult> selectAllWaterById(int waterAnalasisId);
}
