package DB.Dao;

import DB.Entites.fertilization_method;
import java.util.List;

public interface fertilization_methodDao {

    void insert(fertilization_method fert_method);

    fertilization_method selectById(int id);

    List<fertilization_method> selectAll();

    void delete(int id);

    void update(fertilization_method fert_method, int id);

    int generateUniqueId();

    void insertAll(String[] fert_method_names);

    void autoInsertAll();
}
