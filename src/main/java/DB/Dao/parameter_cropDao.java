package DB.Dao;

import DB.Entites.parameter_crop;

import java.sql.ResultSet;
import java.util.List;
public interface parameter_cropDao {

    void insert(parameter_crop parameter_crop);

    parameter_crop selectById(int id);

    List<parameter_crop> selectAll();

    void delete(int id);

    void update(parameter_crop parameter_crop, int id);

    int generateUniqueId();

    void insertAll(List<parameter_crop> parameter_crops);

    void autoInsertAll();
}
