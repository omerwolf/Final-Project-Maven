package DB.Dao;

import DB.Entites.PreviousCropNCredit;

import java.util.List;

public interface PreviousCropNCreditDao {

    void insert(PreviousCropNCredit previousCropNCredit);

    PreviousCropNCredit selectById(int id);

    List<PreviousCropNCredit> selectAll();

    void delete(int id);

    void update(PreviousCropNCredit previousCropNCredit, int id);

    int generateUniqueId();

    void insertAll(List<PreviousCropNCredit> previousCropNCreditList);

    void autoInsertAll();
}
