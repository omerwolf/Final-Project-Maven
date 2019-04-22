package DB.Dao;

import DB.Entites.variety_type;

import java.util.List;
public interface variety_typeDao {
    void insert(variety_type variety_type);

    variety_type selectById(int id);

    List<variety_type> selectAll();

    void delete(int id);

    void update(variety_type variety_type, int id);

    int generateUniqueId();

    void insertAll(String[] variety_type_names);

    void autoInsertAll();
}
