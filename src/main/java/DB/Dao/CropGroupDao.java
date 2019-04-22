package DB.Dao;

import DB.Entites.CropGroup;

import java.util.List;

public interface CropGroupDao {

    void insert(CropGroup cropGroup);

    CropGroup selectById(int id);

    List<CropGroup> selectAll();

    void delete(int id);

    void update(CropGroup cropGroup, int id);

    int generateUniqueId();

    void insertAll(String[] cropGroupNames);

    void autoInsertAll();
}
