package DB.Dao;

import DB.Entites.LabAnalysisResult;

import java.util.List;

public interface LabAnalysisResultDao {

    void insert(LabAnalysisResult labAnalysisResult);

    void insertAll(List<LabAnalysisResult> labAnalysisResultList);
}
