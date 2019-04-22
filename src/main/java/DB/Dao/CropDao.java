package DB.Dao;

import DB.Entites.Crop;

import java.util.List;

public interface CropDao {

    void insert(Crop crop);

    Crop selectById(int id);

    List<Crop> selectAll();

    void delete(int id);

    void update(Crop crop, int id);

    int generateUniqueId();

    void insertAll(List<Crop> cropsName);

    void autoInsertAll();
}
