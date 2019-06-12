package DB.DaoImpl;

import DB.Dao.Dao;
import DB.Entites.IrrigationMethod;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * the class implements the generic Dao class.
 * responsible for performing actions on the database table `irrigation_method`.
 */
public class IrrigationMethodDaoImpl implements Dao<IrrigationMethod> {
    /**
     * receives an IrrigationMethod record and inserts it
     * to the `irrigation_method` table in the database.
     * @param irrigationMethod - an IrrigationMethod record.
     */
    @Override
    public void insert(IrrigationMethod irrigationMethod) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO `irrigation_method` " +
                    "(irrigation_method_desc," +
                    "irrigation_method_efficiency," +
                    "irrigation_method_wetted_area)" +
                    "VALUES (?, ?, ?)");
            preparedStatement.setString(1, irrigationMethod.getIrrigation_method_desc());
            preparedStatement.setDouble(2, irrigationMethod.getIrrigation_method_efficiency());
            preparedStatement.setDouble(3, irrigationMethod.getIrrigation_method_wetted_area());
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
     * receives an irrigation_method_id number, and returns a record that has
     * the same irrigation_method_id number.
     * @param id - the irrigation_method_id of the record that will be selected.
     * @return an IrrigationMethod record
     */
    @Override
    public IrrigationMethod selectById(int id) {
        IrrigationMethod irrigationMethod = new IrrigationMethod();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM `irrigation_method` WHERE irrigation_method_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                irrigationMethod.setIrrigation_method_id(resultSet.getInt("irrigation_method_id"));
                irrigationMethod.setIrrigation_method_desc(resultSet.getString("irrigation_method_desc"));
                irrigationMethod.setIrrigation_method_efficiency(resultSet.getDouble("irrigation_method_efficiency"));
                irrigationMethod.setIrrigation_method_wetted_area(resultSet.getDouble("irrigation_method_wetted_area"));
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
        return irrigationMethod;
    }

    /**
     * selects all IrrigationMethod records in the table 'irrigation_method',
     * and returns them as a list.
     * @return a list of all IrrigationMethod records from database table 'irrigation_method'.
     */
    @Override
    public List<IrrigationMethod> selectAll() {
        List<IrrigationMethod> irrigationMethodList = new ArrayList<IrrigationMethod>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `irrigation_method`");

            while (resultSet.next()) {
                IrrigationMethod irrigationMethod = new IrrigationMethod();
                irrigationMethod.setIrrigation_method_id(resultSet.getInt("irrigation_method_id"));
                irrigationMethod.setIrrigation_method_desc(resultSet.getString("irrigation_method_desc"));
                irrigationMethod.setIrrigation_method_efficiency(resultSet.getDouble("irrigation_method_efficiency"));
                irrigationMethod.setIrrigation_method_wetted_area(resultSet.getDouble("irrigation_method_wetted_area"));
                irrigationMethodList.add(irrigationMethod);
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
        return irrigationMethodList;
    }

    /**
     * deletes an IrrigationMethod record from the database table `irrigation_method`
     * with the same irrigation_method_id as the param.
     * @param id - the irrigation_method_id of the record to remove.
     */
    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM `irrigation_method` WHERE irrigation_method_id = ?");
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
     * takes an IrrigationMethod record with values and an irrigation_method_id, and updates
     * the record in the table with the same irrigation_method_id with the values
     * of the other record.
     * @param irrigationMethod - the IrrigationMethod record to get the values from.
     * @param id - the id position of the IrrigationMethod record to update.
     */
    @Override
    public void update(IrrigationMethod irrigationMethod, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE `irrigation_method` SET " +
                    "irrigation_method_desc = ?," +
                    " irrigation_method_efficiency = ?," +
                    " irrigation_method_wetted_area = ? WHERE irrigation_method_id = ?");

            preparedStatement.setString(1, irrigationMethod.getIrrigation_method_desc());
            preparedStatement.setDouble(2, irrigationMethod.getIrrigation_method_efficiency());
            preparedStatement.setDouble(3, irrigationMethod.getIrrigation_method_wetted_area());
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
     * returns an int of the first irrigation_method_id of a record that does not yet exist
     * in the 'irrigation_method' table.
     * @return the first unoccupied irrigation_method_id in the 'irrigation_method' table.
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
            resultSet = statement.executeQuery("SELECT * FROM `irrigation_method`");



            while (resultSet.next()) {
                emptySpace = resultSet.getInt("irrigation_method_id") + 1;

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
     * receives a list of IrrigationMethod records, and inserts all of them
     * to the `irrigation_method` table.
     * @param irrigationMethodList - the IrrigationMethod records list to be added to the database.
     */
    @Override
    public void insertAll(List<IrrigationMethod> irrigationMethodList) {

        for(IrrigationMethod irrigationMethod : irrigationMethodList) {
            this.insert(irrigationMethod);

        }
        System.out.println("insertAll finished!");
    }

    /**
     * insert all IrrigationMethod records that are supposed to be in the database initially.
     */
    @Override
    public void autoInsertAll() {
        IrrigationMethod irrigationMethod1 = new IrrigationMethod("Drip",0.9,0.5);
        IrrigationMethod irrigationMethod2 = new IrrigationMethod("SDI",0.9,0.5);
        IrrigationMethod irrigationMethod3 = new IrrigationMethod("Sprinklers",0.75,1);
        IrrigationMethod irrigationMethod4 = new IrrigationMethod("Pivot",0.8,1);
        IrrigationMethod irrigationMethod5 = new IrrigationMethod("Flooding",0.6,1);
        List<IrrigationMethod> irrigationMethodList = new ArrayList<>();
        irrigationMethodList.add(irrigationMethod1);
        irrigationMethodList.add(irrigationMethod2);
        irrigationMethodList.add(irrigationMethod3);
        irrigationMethodList.add(irrigationMethod4);
        irrigationMethodList.add(irrigationMethod5);
        this.insertAll(irrigationMethodList);

    }
}
