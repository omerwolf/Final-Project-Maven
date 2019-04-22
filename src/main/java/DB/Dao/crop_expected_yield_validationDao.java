package DB.Dao;

import DB.Entites.crop_expected_yield_validation;
import DB.Entites.variety_type;

import java.util.List;

public interface crop_expected_yield_validationDao {

    void insert(crop_expected_yield_validation expYield);

    crop_expected_yield_validation selectById(int id);

    List<crop_expected_yield_validation> selectAll();

    void delete(int id);

    void update(crop_expected_yield_validation expYield, int id);

    int generateUniqueId();

    void insertAll(List<crop_expected_yield_validation> expYield);

    void autoInsertAll();

    List<Integer> getMatchVarType(int cropTypeId);
}
