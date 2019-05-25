package DB.Dao;

import DB.Entites.ParameterPhEffect;

import java.util.List;

public interface ParameterPhEffectDao {

    void insert(ParameterPhEffect parameterPhEffect);

    ParameterPhEffect selectById(int id);

    List<ParameterPhEffect> selectAll();

    void delete(int id);

    void update(ParameterPhEffect parameterPhEffect, int id);

    int generateUniqueId();

    void insertAll(List<ParameterPhEffect> parameterPhEffectList);

    void autoInsertAll();
}
