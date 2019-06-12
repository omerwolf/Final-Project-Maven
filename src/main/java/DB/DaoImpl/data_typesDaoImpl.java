package DB.DaoImpl;
import DB.Dao.Dao;
import DB.Entites.data_types;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * the class implements the generic Dao class.
 * responsible for performing actions on the database table `data_types`.
 */
public class data_typesDaoImpl implements Dao<data_types> {
    /**
     * receives a data_types record and inserts it
     * to the `data_types` table in the database.
     * @param dt - a data_types record.
     */
    @Override
    public void insert(data_types dt) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=0");
            preparedStatement = connection.prepareStatement("INSERT INTO data_types (data_type_id,data_type_desc)" +
                    "VALUES (?,?)");
            preparedStatement.setInt(1, dt.getData_type_id());
            preparedStatement.setString(2, dt.getData_type_desc());
            preparedStatement.executeUpdate();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=1");
            System.out.println("Insert: " + dt.getData_type_desc());
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
     * receives a data_type_id number, and returns a record that has
     * the same data_type_id number.
     * @param id - the data_type_id of the record that will be selected.
     * @return a data_types record.
     */
    @Override
    public data_types selectById(int id) {
        data_types dt = new data_types();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM data_types WHERE data_type_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                dt.setData_type_id(resultSet.getInt("data_type_id"));
                dt.setData_type_desc(resultSet.getString("data_type_desc"));
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
        return dt;
    }
    /**
     * selects all data_types records in the table 'data_types',
     * and returns them as a list.
     * @return a list of all data_types records from database table 'data_types'.
     */
    @Override
    public List<data_types> selectAll() {
        List<data_types> dtList = new ArrayList<data_types>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM data_types");

            while (resultSet.next()) {
                data_types dt = new data_types();
                dt.setData_type_id(resultSet.getInt("data_type_id"));
                dt.setData_type_desc(resultSet.getString("data_type_desc"));
                dtList.add(dt);
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
        return dtList;
    }

    /**
     * deletes a data_types record from the database table `data_types`
     * with the same data_type_id as the param.
     * @param id - the data_type_id of the record to remove.
     */
    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM data_types WHERE data_type_id = ?");
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
     * takes a data_types record with values and a data_type_id, and updates
     * the record in the table with the same data_type_id with the values
     * of the other record.
     * @param data_types - the data_types record to get the values from.
     * @param id - the id position of the data_types record to update.
     */
    @Override
    public void update(data_types data_types, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE `data_types` SET " +
                    "data_type_desc = ? WHERE data_type_id = ?");
            preparedStatement.setString(1,data_types.getData_type_desc());
            preparedStatement.setInt(2,id);
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
     * returns an int of the first data_type_id of a record that does not yet exist
     * in the 'data_types' table.
     * @return the first unoccupied data_type_id in the 'data_types' table.
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
            resultSet = statement.executeQuery("SELECT * FROM data_types");
            while (resultSet.next()) {
                emptySpace = resultSet.getInt("data_type_id") + 1;

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
     * receives a list of data_types records, and inserts all of them
     * to the `data_types` table.
     * @param dtList - the data_types records list to be added to the database.
     */
    @Override
    public void insertAll(List<data_types> dtList) {
        for(data_types dataTypes : dtList) {
            this.insert(dataTypes);
        }
        System.out.println("insertAll finished!");

    }

    /**
     * insert all data_types records that are supposed to be in the database initially.
     */
    @Override
    public void autoInsertAll() {
        String[] dts = {"Macro element" , "Secondary element", "Micro element", "element"};
        List<data_types> dataTypesList = new ArrayList<>();
        for (String dataTypeName:dts) {
            data_types dataTypes = new data_types(this.generateUniqueId(),dataTypeName);
            dataTypesList.add(dataTypes);
        }
        this.insertAll(dataTypesList);
    }
}
