package DB.Dao;

import DB.Entites.soil_thresholds;

import java.util.List;

public interface soil_thresholdsDao {
    void insert(soil_thresholds st);
    soil_thresholds selectById(int soil_threshold_id);
    void autoInsertAll();
}
