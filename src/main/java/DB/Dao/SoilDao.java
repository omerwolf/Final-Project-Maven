package DB.Dao;

import DB.Entites.Soil;

import java.sql.ResultSet;
import java.util.List;

public interface SoilDao {

    void insert(Soil soil);

    Soil selectById(int id);

    List<Soil> selectAll();

    void delete(int id);

    void update(Soil soil, int id);

    int generateUniqueId();

    void insertAll(List<Soil> soils);

    void autoInsertAll();

}
