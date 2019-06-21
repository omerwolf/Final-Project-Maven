package Analysis.LabAnalysisResults;

import java.util.List;

/**
 * an interface for the possible actions on the lab_analysis_results
 * table in the db.
 */
public interface LabAnalysisResultDao {
    /**
     * inserts a water lab analysis result record into the lab_analysis_results table
     * in the db.
     * @param waterLabAnalysisResult - the water lab analysis result to insert.
     */
    void insertWater(WaterLabAnalysisResult waterLabAnalysisResult);

    /**
     * receives a list of water lab analysis results records, and inserts them
     * to the db.
     * @param waterLabAnalysisResultList - a list of water lab analysis result records
     */
    void insertAllWater(List<WaterLabAnalysisResult> waterLabAnalysisResultList);

    /**
     * inserts a soil lab analysis result record into the lab_analysis_results table
     * in the db.
     * @param soilLabAnalysisResult - the soil lab analysis result to insert.
     */
    void insertSoil(SoilLabAnalysisResult soilLabAnalysisResult);

    /**
     * receives a list of soil lab analysis results records, and inserts them
     * to the db.
     * @param soilLabAnalysisResultList - a list of water lab analysis result records
     */
    void insertAllSoil(List<SoilLabAnalysisResult> soilLabAnalysisResultList);

    /**
     * returns a list of soil lab analysis results that has the given soil analysis id.
     * @param soilAnalasisId - the id of the soil lab results to extract from the db.
     * @return a list of all soil lab results with the same given id.
     */
    List<SoilLabAnalysisResult> selectAllSoilById(int soilAnalasisId);

    /**
     * returns a list of water lab analysis results that has the given water analysis id.
     * @param waterAnalasisId - the id of the water lab results to extract from the db.
     * @return a list of all water lab results with the same given id.
     */
    List<WaterLabAnalysisResult> selectAllWaterById(int waterAnalasisId);
}
