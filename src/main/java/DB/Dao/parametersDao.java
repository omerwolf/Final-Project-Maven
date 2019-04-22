package DB.Dao;
import DB.Entites.parameters;

import java.sql.ResultSet;
import java.util.List;
public interface parametersDao {

    void insert(parameters parameters);

    parameters selectById(int id);

    List<parameters> selectAll();

    void delete(int id);

    void update(parameters parameters, int id);

    int generateUniqueId();

    void insertAll(List<parameters> parametersList);

    void autoInsertAll();
}
