package DB.Dao;

import DB.Entites.FertilizationMethodEfficiency;

import java.util.List;

public interface FertilizationMethodEfficiencyDao {

    void insert(FertilizationMethodEfficiency fertilizationMethodEfficiency);

    FertilizationMethodEfficiency selectById(int id);

    List<FertilizationMethodEfficiency> selectAll();

    void delete(int id);

    void update(FertilizationMethodEfficiency fertilizationMethodEfficiency, int id);

    int generateUniqueId();

    void insertAll(List<FertilizationMethodEfficiency> fertilizationMethodEfficiencyList);

    void autoInsertAll();
}
