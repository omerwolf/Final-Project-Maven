package DB.Dao;

import java.util.List;

/**
 * a generic database interface.
 * have several actions that can be done on each database.
 * @param <T> - the database's table record.
 */
public interface Dao<T> {
    /**
     * receives a database table's record, and insert it to the table.
     * @param record - a database table's record.
     */
    void insert(T record);

    /**
     * receives an id number, and returns a record that has
     * the same id number.
     * @param id - the id of the record that will be selected.
     * @return selected database table record.
     */
    T selectById(int id);

    /**
     * selects all records of a database table and returns them as a list.
     * @return a list of all the records (entire table) of a database table.
     */
    List<T> selectAll();

    /**
     * deletes a record from a database table with the same id as the param.
     * @param id - the id of the record to remove.
     */
    void delete(int id);

    /**
     * takes a record with values and an id number, and updates
     * the record in the table with the same id number with the values
     * of the other record.
     * @param record - the record to get the values from.
     * @param id - the id position of the record to update.
     */
    void update(T record, int id);

    /**
     * returns an int of the first id of a record that does not yet exist
     * in the database table.
     * @return the first unoccupied id in the database table.
     */
    int generateUniqueId();

    /**
     * receives a list of records, and inserts all of them
     * to the database table.
     * @param recordsList - the record list to be added to the database.
     */
    void insertAll(List<T> recordsList);

    /**
     * insert all records that are supposed to be in the database initially.
     * note: additional records can be added through the insertAll/insert methods.
     */
    void autoInsertAll();
}
