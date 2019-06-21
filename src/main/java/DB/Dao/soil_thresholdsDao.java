package DB.Dao;

import DB.Entites.soil_thresholds;

import java.util.List;

/**
 * an interface for the soil thresholds table.
 */
public interface soil_thresholdsDao {
    /**
     * receives a soil threshold record, and inserts it to the table.
     * @param st - a soil analysis record
     */
    void insert(soil_thresholds st);

    /**
     * receives an id number, and returns a record that has
     * the same id number.
     * @param soil_threshold_id - the id of the soil analysis record that will be selected.
     * @return selected soil analysis record.
     */
    soil_thresholds selectById(int soil_threshold_id);

    /**
     * selects all records from the soil analysis table
     * and returns them as a list.
     * @return a list of all the soil analysis records.
     */
    List<soil_thresholds> selectAll();

    /**
     * insert all soil thresholds records that are supposed to be in the database initially.
     * note: additional soil thresholds records can be added through the insert method.
     */
    void autoInsertAll();
}
