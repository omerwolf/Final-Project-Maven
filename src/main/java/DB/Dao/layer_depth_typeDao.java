package DB.Dao;

import DB.Entites.layer_depth_type;

import java.util.List;

public interface layer_depth_typeDao {
    void insert(layer_depth_type layerDepthType);

    layer_depth_type selectById(int id);

    List<layer_depth_type> selectAll();

    void delete(int id);

    void update(layer_depth_type layerDepthType, int id);

    int generateUniqueId();

    void insertAll(List<layer_depth_type> layerDepthTypeList);

    void autoInsertAll();
}
