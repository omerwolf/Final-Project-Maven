package DB.Dao;

import DB.Entites.ParameterPerStage;

import java.util.List;

public interface ParameterPerStageDao {

    void insert(ParameterPerStage parameterPerStage);

    ParameterPerStage selectById(int id);

    List<ParameterPerStage> selectAll();

    void delete(int id);

    void update(ParameterPerStage parameterPerStage, int id);

    int generateUniqueId();

    void insertAll(List<ParameterPerStage> parameterPerStageList);

    void autoInsertAll();
}
