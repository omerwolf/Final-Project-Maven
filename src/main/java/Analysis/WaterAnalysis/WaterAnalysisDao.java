package Analysis.WaterAnalysis;

/**
 * an interface for the possible actions on the water_lab_analysis
 * table in the db.
 */
public interface WaterAnalysisDao {
    /**
     * inserts a water analysis record into the water_lab_analysis table
     * in the db.
     * @param waterAnalyses - the water analysis record to insert.
     */
    void insert(WaterAnalysis waterAnalyses);
    /**
     * receives an id number, and returns a record that has
     * the same id number.
     * @param id - the id of the record that will be selected.
     * @return selected water analysis record.
     */
    WaterAnalysis selectById(int id);

    //List<WaterAnalysis> selectAll();

    //void delete(int id);

    //void update(WaterAnalysis waterAnalyses, int id);

    //int generateUniqueId();

    //void insertAll(List<WaterAnalysis> waterAnalysesList);

    //void autoInsertAll();


}
