package DB.Dao;

import DB.Entites.data_types;

import java.sql.ResultSet;
import java.util.List;

public interface data_typesDao {

    void insert(data_types dt);

    data_types selectById(int id);

    List<data_types> selectAll();

    void delete(int id);

    void update(data_types data_types, int id);

    int generateUniqueId();

    void insertAll(String[] data_types_names);

    void autoInsertAll();

}
