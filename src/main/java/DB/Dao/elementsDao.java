package DB.Dao;

import DB.Entites.elements;
import java.util.List;

public interface elementsDao {

    void insert(elements element);

    elements selectById(int id);

    List<elements> selectAll();

    void delete(int id);

    void update(elements element, int id);

    int generateUniqueId();

    void insertAll(List<elements> elements);

    void autoInsertAll();
}
