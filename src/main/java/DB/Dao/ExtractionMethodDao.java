package DB.Dao;

import DB.Entites.ExtractionMethod;

import java.util.List;

public interface ExtractionMethodDao {
    void insert(ExtractionMethod em);
    void insertAll();
    List<ExtractionMethod> selectAll();
}
