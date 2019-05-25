package DB.Dao;

import DB.Entites.PhRanges;
import java.util.List;

public interface PhRangesDao {

    void insert(PhRanges phRanges);

    PhRanges selectById(int id);

    List<PhRanges> selectAll();

    void delete(int id);

    void update(PhRanges phRanges, int id);

    int generateUniqueId();

    void insertAll(List<PhRanges> phRangesList);

    void autoInsertAll();
}

