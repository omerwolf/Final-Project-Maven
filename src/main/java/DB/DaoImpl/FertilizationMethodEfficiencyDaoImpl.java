package DB.DaoImpl;

import DB.Dao.Dao;
import DB.Entites.FertilizationMethodEfficiency;
import DB.Util.ConnectionConfiguration;
import DB.ExcelReadWrite.ERFertilizationMethodEfficiency;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * the class implements the generic Dao class.
 * responsible for performing actions on the database table `fertilization_method_efficiency`.
 */
public class FertilizationMethodEfficiencyDaoImpl implements Dao<FertilizationMethodEfficiency> {
    /**
     * receives a FertilizationMethodEfficiency record and inserts it
     * to the `fertilization_method_efficiency` table in the database.
     * @param fertilizationMethodEfficiency - a FertilizationMethodEfficiency record.
     */
    @Override
    public void insert(FertilizationMethodEfficiency fertilizationMethodEfficiency) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO `fertilization_method_efficiency` " +
                    "(fert_method_efficiency_id," +
                    "fert_method_id," +
                    "parameter_id," +
                    "fert_method_efficiency)" +
                    "VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, fertilizationMethodEfficiency.getFert_method_efficiency_id());
            preparedStatement.setInt(2, fertilizationMethodEfficiency.getFert_method_id());
            preparedStatement.setInt(3, fertilizationMethodEfficiency.getParameter_id());
            preparedStatement.setDouble(4, fertilizationMethodEfficiency.getFert_method_efficiency());
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
     * receives a fert_method_efficiency_id number, and returns a record that has
     * the same fert_method_efficiency_id number.
     * @param id - the fert_method_efficiency_id of the record that will be selected.
     * @return a FertilizationMethodEfficiency record
     */
    @Override
    public FertilizationMethodEfficiency selectById(int id) {
        FertilizationMethodEfficiency fertilizationMethodEfficiency = new FertilizationMethodEfficiency();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM `fertilization_method_efficiency` " +
                    "WHERE fert_method_efficiency_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                fertilizationMethodEfficiency.setFert_method_efficiency_id(resultSet.getInt("fert_method_efficiency_id"));
                fertilizationMethodEfficiency.setFert_method_id(resultSet.getInt("fert_method_id"));
                fertilizationMethodEfficiency.setParameter_id(resultSet.getInt("parameter_id"));
                fertilizationMethodEfficiency.setFert_method_efficiency(resultSet.getDouble("fert_method_efficiency"));
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
        return fertilizationMethodEfficiency;
    }

    /**
     * selects all FertilizationMethodEfficiency records in the table 'fertilization_method_efficiency',
     * and returns them as a list.
     * @return a list of all FertilizationMethodEfficiency records
     * from database table 'fertilization_method_efficiency'.
     */
    @Override
    public List<FertilizationMethodEfficiency> selectAll() {
        List<FertilizationMethodEfficiency> fertilizationMethodEfficiencyList = new ArrayList<FertilizationMethodEfficiency>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `fertilization_method_efficiency`");

            while (resultSet.next()) {
                FertilizationMethodEfficiency fertilizationMethodEfficiency = new FertilizationMethodEfficiency();
                fertilizationMethodEfficiency.setFert_method_efficiency_id(resultSet.getInt("fert_method_efficiency_id"));
                fertilizationMethodEfficiency.setFert_method_id(resultSet.getInt("fert_method_id"));
                fertilizationMethodEfficiency.setParameter_id(resultSet.getInt("parameter_id"));
                fertilizationMethodEfficiency.setFert_method_efficiency(resultSet.getDouble("fert_method_efficiency"));
                fertilizationMethodEfficiencyList.add(fertilizationMethodEfficiency);
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
        return fertilizationMethodEfficiencyList;
    }

    /**
     * deletes a FertilizationMethodEfficiency record from the database table `fertilization_method_efficiency`
     * with the same fert_method_efficiency_id as the param.
     * @param id - the fert_method_efficiency_id of the record to remove.
     */
    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM `fertilization_method_efficiency` WHERE fert_method_efficiency_id = ?");
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
     * takes a FertilizationMethodEfficiency record with values and a fert_method_efficiency_id,
     * and updates the record in the table with the same fert_method_efficiency_id
     * with the values of the other record.
     * @param fertilizationMethodEfficiency - the FertilizationMethodEfficiency record
     * to get the values from.
     * @param id - the id position of the FertilizationMethodEfficiency record to update.
     */
    @Override
    public void update(FertilizationMethodEfficiency fertilizationMethodEfficiency, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE `fertilization_method_efficiency` SET " +
                    "fert_method_id = ?," +
                    "parameter_id = ?," +
                    " fert_method_efficiency = ? WHERE fert_method_efficiency_id = ?");
            preparedStatement.setInt(1, fertilizationMethodEfficiency.getFert_method_id());
            preparedStatement.setInt(2, fertilizationMethodEfficiency.getParameter_id());
            preparedStatement.setDouble(3, fertilizationMethodEfficiency.getFert_method_efficiency());
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
     * returns an int of the first fert_method_efficiency_id of a record that does not yet exist
     * in the 'fertilization_method_efficiency' table.
     * @return the first unoccupied fert_method_efficiency_id in the
     * 'fertilization_method_efficiency' table.
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
            resultSet = statement.executeQuery("SELECT * FROM `fertilization_method_efficiency`");



            while (resultSet.next()) {
                emptySpace = resultSet.getInt("fert_method_efficiency_id") + 1;

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
     * receives a list of FertilizationMethodEfficiency records, and inserts all of them
     * to the `fertilization_method_efficiency` table.
     * @param fertilizationMethodEfficiencyList - the FertilizationMethodEfficiency
     * records list to be added to the database.
     */
    @Override
    public void insertAll(List<FertilizationMethodEfficiency> fertilizationMethodEfficiencyList) {

        for(FertilizationMethodEfficiency fertilizationMethodEfficiency : fertilizationMethodEfficiencyList) {
            fertilizationMethodEfficiency.setFert_method_efficiency_id(this.generateUniqueId());
            this.insert(fertilizationMethodEfficiency);

        }
        System.out.println("insertAll finished!");
    }

    /**
     * insert all FertilizationMethodEfficiency records that are supposed
     * to be in the database initially.
     * note: in this implementation class, it does that by reading from the excel.
     */
    @Override
    public void autoInsertAll() {
        ERFertilizationMethodEfficiency ERFertilizationMethodEfficiency= new ERFertilizationMethodEfficiency();
        List<FertilizationMethodEfficiency> ERFertilizationMethodEfficiencyList = ERFertilizationMethodEfficiency.readExcelData();
        this.insertAll(ERFertilizationMethodEfficiencyList);
    }
}
