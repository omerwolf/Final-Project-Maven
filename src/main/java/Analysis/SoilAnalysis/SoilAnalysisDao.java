package Analysis.SoilAnalysis;

/**
 * an interface for the possible actions on the soil_lab_analysis
 * table in the db.
 */
public interface SoilAnalysisDao {
    /**
     * inserts a soil analysis record into the soil_lab_analysis table
     * in the db.
     * @param soilAnalysis - the soil analysis record to insert.
     */
    void insert(SoilAnalysis soilAnalysis);

    /**
     * receives an id number, and returns a record that has
     * the same id number.
     * @param id - the id of the record that will be selected.
     * @return selected soil analysis record.
     */
    SoilAnalysis selectById(int id);

    //void insertAll(List<SoilAnalysis> SoilAnalysisList);

    //List<WaterAnalysis> selectAll();

    //void delete(int id);

    //void update(WaterAnalysis waterAnalyses, int id);

    //int generateUniqueId();

    //void autoInsertAll();


}
