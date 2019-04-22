package DB.Dao;

import DB.Entites.pheonological_stage;
import java.sql.ResultSet;
import java.util.List;
public interface pheonological_stageDao {

    void insert(pheonological_stage soil);

    pheonological_stage selectById(int id);

    List<pheonological_stage> selectAll();

    void delete(int id);

    void update(pheonological_stage soil, int id);

    int generateUniqueId();

    void insertAll(List<pheonological_stage> soils);

    void autoInsertAll();
}
