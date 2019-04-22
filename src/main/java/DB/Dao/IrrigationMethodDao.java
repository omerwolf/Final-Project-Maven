package DB.Dao;

import DB.Entites.IrrigationMethod;

import java.util.List;

public interface IrrigationMethodDao {

    void insert(IrrigationMethod irrigationMethod);

    IrrigationMethod selectById(int id);

    List<IrrigationMethod> selectAll();

    void delete(int id);

    void update(IrrigationMethod irrigationMethod, int id);

    int generateUniqueId();

    void insertAll(List<IrrigationMethod> irrigationMethodList);

    void autoInsertAll();
}
