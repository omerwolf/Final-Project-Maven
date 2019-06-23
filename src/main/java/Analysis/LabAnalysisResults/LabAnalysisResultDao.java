package Analysis.LabAnalysisResults;

import java.util.List;

/**
 * An interface for the possible actions on the lab_analysis_results
 * table in the db.
 */
public interface LabAnalysisResultDao {
    /**
     * Inserts a water lab analysis result record into the lab_analysis_results table
     * in the db.
     * @param waterLabAnalysisResult - the water lab analysis result to insert.
     */
    void insertWater(WaterLabAnalysisResult waterLabAnalysisResult);

    /**
     * Receives a list of water lab analysis results records, and inserts them
     * to the db.
     * @param waterLabAnalysisResultList - a list of water lab analysis result records
     */
    void insertAllWater(List<WaterLabAnalysisResult> waterLabAnalysisResultList);

    /**
     * Inserts a soil lab analysis result record into the lab_analysis_results table
     * in the db.
     * @param soilLabAnalysisResult - The soil lab analysis result to insert.
     */
    void insertSoil(SoilLabAnalysisResult soilLabAnalysisResult);

    /**
     * Receives a list of soil lab analysis results records, and inserts them
     * to the db.
     * @param soilLabAnalysisResultList - A list of water lab analysis result records
     */
    void insertAllSoil(List<SoilLabAnalysisResult> soilLabAnalysisResultList);

    /**
     * Returns a list of soil lab analysis results that has the given soil analysis id.
     * @param soilAnalasisId - The id of the soil lab results to extract from the db.
     * @return A list of all soil lab results with the same given id.
     */
    List<SoilLabAnalysisResult> selectAllSoilById(int soilAnalasisId);

    /**
     * Returns a list of water lab analysis results that has the given water analysis id.
     * @param waterAnalasisId - The id of the water lab results to extract from the db.
     * @return A list of all water lab results with the same given id.
     */
    List<WaterLabAnalysisResult> selectAllWaterById(int waterAnalasisId);
}
