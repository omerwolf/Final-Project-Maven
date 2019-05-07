package Analysis.SoilAnalysis;

public interface SoilAnalysisDao {
    void insert(SoilAnalysis soilAnalysis);

    //void insertAll(List<SoilAnalysis> SoilAnalysisList);

    SoilAnalysis selectById(int id);

    //List<WaterAnalysis> selectAll();

    //void delete(int id);

    //void update(WaterAnalysis waterAnalyses, int id);

    //int generateUniqueId();

    //void autoInsertAll();


}
