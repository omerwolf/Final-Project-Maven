package DB.Dao;

import DB.Entites.crop_expected_yield_validation;
import DB.Entites.variety_type;

import java.util.List;

/**
 * an interface for the crop expected yield validation table.
 */
public interface crop_expected_yield_validationDao {

    /**
     * receives a crop expected yield variation record, and insert it to the database.
     * @param expYield - a crop expected yield validation record
     */
    void insert(crop_expected_yield_validation expYield);

    /**
     * receives an id number, and returns a record that has
     * the same id number.
     * @param id - the id of the record that will be selected.
     * @return selected crop expected yield validation record.
     */
    crop_expected_yield_validation selectById(int id);

    /**
     * selects all records from the crop expected yield validation table
     * and returns them as a list.
     * @return a list of all the records (entire table).
     */
    List<crop_expected_yield_validation> selectAll();

    /**
     * deletes a record from a crop expected yield validation table,
     * with the same id as the param.
     * @param id - the id of the record to remove.
     */
    void delete(int id);

    /**
     * takes a crop expected yield validation record with values and an id number,
     * and updates the record in the table with the same id number with the values
     * of the other record.
     * @param expYield - the crop expected yield validation record to get the values from.
     * @param id - the id position of the record to update.
     */
    void update(crop_expected_yield_validation expYield, int id);

    /**
     * returns an int of the first id of a record that does not yet exist
     * in the crop expected yield validation table.
     * @return the first unoccupied id in the crop expected yield validation
     * database table.
     */
    int generateUniqueId();

    /**
     * receives a list of records, and inserts all of them
     * to the database table.
     * @param expYield - the record list to be added to the database.
     */
    void insertAll(List<crop_expected_yield_validation> expYield);

    /**
     * insert all records that are supposed to be in the database initially.
     * note: additional records can be added through the insertAll/insert methods.
     */
    void autoInsertAll();

    /**
     * receives a crop id, and if exists in the crop expected yield validation table
     * in the db, returns a list of all variety types possible for that crop.
     * @param cropTypeId - the crop id to search in the db.
     * @return a list of variety id values for the received crop.
     */
    List<Integer> getMatchVarType(int cropTypeId);
}
