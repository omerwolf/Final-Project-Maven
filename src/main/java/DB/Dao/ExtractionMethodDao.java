package DB.Dao;

import DB.Entites.ExtractionMethod;

import java.util.List;

/**
 * an interface for the extraction methods table.
 */
public interface ExtractionMethodDao {
    /**
     * receives an extraction method record, and inserts it to the database.
     * @param em - an extraction method record.
     */
    void insert(ExtractionMethod em);

    /**
     * inserts all extraction methods to the database.
     */
    void insertAll();

    /**
     * selects all extraction methods from the database table
     * and returns them as a list.
     * @return a list of all the extraction methods records (entire table)
     * of a database table.
     */
    List<ExtractionMethod> selectAll();
}
