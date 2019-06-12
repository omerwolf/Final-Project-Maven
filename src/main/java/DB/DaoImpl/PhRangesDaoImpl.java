package DB.DaoImpl;

import DB.Dao.Dao;
import DB.Entites.PhRanges;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * the class implements the generic Dao class.
 * responsible for performing actions on the database table `ph_ranges`.
 */
public class PhRangesDaoImpl implements Dao<PhRanges> {
    /**
     * receives a PhRanges record and inserts it
     * to the `ph_ranges` table in the database.
     * @param phRanges - a PhRanges record.
     */
    @Override
    public void insert(PhRanges phRanges) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=0");
            preparedStatement = connection.prepareStatement("INSERT INTO ph_ranges" +
                    "(`range_id`," +
                    "`range_desc`," +
                    "`min_ph_range`," +
                    "`max_ph_range`) " +
                    "VALUES (?,?,?,?)");
            preparedStatement.setInt(1, phRanges.getRangeId());
            preparedStatement.setString(2, phRanges.getRangeDesc());
            preparedStatement.setDouble(3, phRanges.getMinPhRange());
            preparedStatement.setDouble(4, phRanges.getMaxPhRange());
            preparedStatement.executeUpdate();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=1");
            System.out.println("Insert: " + phRanges.getRangeDesc());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * receives a range_id number, and returns a record that has
     * the same range_id number.
     * @param id - the range_id of the record that will be selected.
     * @return a PhRanges record.
     */
    @Override
    public PhRanges selectById(int id) {
        PhRanges phRanges = new PhRanges();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM ph_ranges WHERE range_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                phRanges.setRangeId(resultSet.getInt("range_id"));
                phRanges.setRangeDesc(resultSet.getString("range_desc"));
                phRanges.setMinPhRange(resultSet.getDouble("min_ph_range"));
                phRanges.setMaxPhRange(resultSet.getDouble("max_ph_range"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return phRanges;
    }

    /**
     * selects all PhRanges records in the table 'ph_ranges',
     * and returns them as a list.
     * @return a list of all PhRanges records from database table 'ph_ranges'.
     */
    @Override
    public List<PhRanges> selectAll() {
        List<PhRanges> phRangesList = new ArrayList<PhRanges>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM ph_ranges");

            while (resultSet.next()) {
                PhRanges phRanges = new PhRanges();
                phRanges.setRangeId(resultSet.getInt("range_id"));
                phRanges.setRangeDesc(resultSet.getString("range_desc"));
                phRanges.setMinPhRange(resultSet.getDouble("min_ph_range"));
                phRanges.setMaxPhRange(resultSet.getDouble("max_ph_range"));
                phRangesList.add(phRanges);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return phRangesList;
    }

    /**
     * deletes a PhRanges record from the database table `ph_ranges`
     * with the same range_id as the param.
     * @param id - the range_id of the record to remove.
     */
    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM ph_ranges WHERE range_id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * takes a PhRanges record with values and a range_id, and updates
     * the record in the table with the same range_id with the values
     * of the other record.
     * @param phRanges - the PhRanges record to get the values from.
     * @param id - the id position of the PhRanges record to update.
     */
    @Override
    public void update(PhRanges phRanges, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE ph_ranges SET " +
                    "(`range_desc`," +
                    "`min_ph_range`," +
                    "`max_ph_range`) " +
                    "WHERE range_id = ?");

            preparedStatement.setString(1, phRanges.getRangeDesc());
            preparedStatement.setDouble(2, phRanges.getMinPhRange());
            preparedStatement.setDouble(3, phRanges.getMaxPhRange());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * returns an int of the first range_id of a record that does not yet exist
     * in the 'ph_ranges' table.
     * @return the first unoccupied range_id in the 'ph_ranges' table.
     */
    @Override
    public int generateUniqueId() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int emptySpace = 1;
        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM ph_ranges");



            while (resultSet.next()) {
                emptySpace = resultSet.getInt("range_id") + 1;

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return emptySpace;
    }

    /**
     * receives a list of PhRanges records, and inserts all of them
     * to the `ph_ranges` table.
     * @param phRangesList - the PhRanges records list to be added to the database.
     */
    @Override
    public void insertAll(List<PhRanges> phRangesList) {
        //soils.sort((Soil s1, Soil s2) -> s1.getName().compareTo(s2.getName()));

        for (PhRanges phRanges : phRangesList) {
            //phRanges.setElement_id(this.generateUniqueId());
            this.insert(phRanges);
        }
        System.out.println("InsertAll finished");
    }

    /**
     * insert all PhRanges records that are supposed to be in the database initially.
     */
    @Override
    public void autoInsertAll() {
        PhRanges pr1 = new PhRanges(1, "Very_Acidic", 0, 4.5);
        PhRanges pr2 = new PhRanges(2, "Acidic", 4.51, 5.5);
        PhRanges pr3 = new PhRanges(3, "Neutral", 5.51, 7.5);
        PhRanges pr4 = new PhRanges(4, "Slightly_Alkaline", 7.51, 8.5);
        PhRanges pr5 = new PhRanges(5, "Alkaline", 8.51, 14);
        List<PhRanges> phRangesList = new ArrayList<>();
        phRangesList.add(pr1);
        phRangesList.add(pr2);
        phRangesList.add(pr3);
        phRangesList.add(pr4);
        phRangesList.add(pr5);
        this.insertAll(phRangesList);
    }
}
