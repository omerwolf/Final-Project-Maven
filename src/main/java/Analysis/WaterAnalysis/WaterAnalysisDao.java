package Analysis.WaterAnalysis;

public interface WaterAnalysisDao {
    void insert(WaterAnalysis waterAnalyses);

    WaterAnalysis selectById(int id);

    //List<WaterAnalysis> selectAll();

    //void delete(int id);

    //void update(WaterAnalysis waterAnalyses, int id);

    //int generateUniqueId();

    //void insertAll(List<WaterAnalysis> waterAnalysesList);

    //void autoInsertAll();


}
