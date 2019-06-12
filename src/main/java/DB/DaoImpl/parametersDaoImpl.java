package DB.DaoImpl;

import DB.Dao.Dao;
import DB.Entites.parameters;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * the class implements the generic Dao class.
 * responsible for performing actions on the database table `parameters`.
 */
public class parametersDaoImpl implements Dao<parameters> {
    /**
     * receives a parameters record and inserts it
     * to the `parameters` table in the database.
     * @param parameters - a parameters record.
     */
    @Override
    public void insert(parameters parameters) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=0");
            preparedStatement = connection.prepareStatement("INSERT INTO parameters" +
                    "(`parameter_id`," +
                    "`element_id`," +
                    "`data_type_id`," +
                    "`very_low_factor`," +
                    "`low_factor`," +
                    "`high_factor`," +
                    "`very_high_factor`," +
                    "`pre_low_factor`," +
                    "`pre_high_factor`) " +
                    "VALUES (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, parameters.getParameter_id());
            preparedStatement.setInt(2, parameters.getElement_id());
            preparedStatement.setInt(3, parameters.getData_type_id());
            preparedStatement.setDouble(4, parameters.getVery_low_factor());
            preparedStatement.setDouble(5, parameters.getLow_factor());
            preparedStatement.setDouble(6, parameters.getHigh_factor());
            preparedStatement.setDouble(7, parameters.getVery_high_factor());
            preparedStatement.setDouble(8, parameters.getPre_low_factor());
            preparedStatement.setDouble(9, parameters.getPre_high_factor());
            preparedStatement.executeUpdate();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=1");
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
     * receives a parameter_id number, and returns a record that has
     * the same parameter_id number.
     * @param id - the parameter_id of the record that will be selected.
     * @return a parameters record.
     */
    @Override
    public parameters selectById(int id) {
        parameters parameters = new parameters();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM parameters WHERE parameter_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                parameters.setParameter_id(resultSet.getInt("parameter_id"));
                parameters.setElement_id(resultSet.getInt("element_id"));
                parameters.setData_type_id(resultSet.getInt("data_type_id"));
                parameters.setVery_low_factor(resultSet.getDouble("very_low_factor"));
                parameters.setLow_factor(resultSet.getDouble("low_factor"));
                parameters.setHigh_factor(resultSet.getDouble("high_factor"));
                parameters.setVery_high_factor(resultSet.getDouble("very_high_factor"));
                parameters.setPre_low_factor(resultSet.getDouble("pre_low_factor"));
                parameters.setPre_high_factor(resultSet.getDouble("pre_high_factor"));
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
        return parameters;
    }

    /**
     * selects all parameters records in the table 'parameters',
     * and returns them as a list.
     * @return a list of all parameters records from database table 'parameters'.
     */
    @Override
    public List<parameters> selectAll() {
        List<parameters> parametersList = new ArrayList<parameters>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM parameters");

            while (resultSet.next()) {
                parameters parameters = new parameters();
                parameters.setParameter_id(resultSet.getInt("parameter_id"));
                parameters.setElement_id(resultSet.getInt("element_id"));
                parameters.setData_type_id(resultSet.getInt("data_type_id"));
                parameters.setVery_low_factor(resultSet.getDouble("very_low_factor"));
                parameters.setLow_factor(resultSet.getDouble("low_factor"));
                parameters.setHigh_factor(resultSet.getDouble("high_factor"));
                parameters.setVery_high_factor(resultSet.getDouble("very_high_factor"));
                parameters.setPre_low_factor(resultSet.getDouble("pre_low_factor"));
                parameters.setPre_high_factor(resultSet.getDouble("pre_high_factor"));
                parametersList.add(parameters);
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
        return parametersList;
    }

    /**
     * deletes a parameters record from the database table `parameters`
     * with the same parameter_id as the param.
     * @param id - the parameter_id of the record to remove.
     */
    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM parameters WHERE parameter_id = ?");
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
     * takes a parameters record with values and a parameter_id, and updates
     * the record in the table with the same parameter_id with the values
     * of the other record.
     * @param parameters - the parameters record to get the values from.
     * @param id - the id position of the parameters record to update.
     */
    @Override
    public void update(parameters parameters, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE parameters SET " +
                    "(`parameter_id`," +
                    "`element_id`," +
                    "`data_type_id`," +
                    "`very_low_factor`," +
                    "`low_factor`," +
                    "`high_factor`," +
                    "`very_high_factor`," +
                    "`pre_low_factor`," +
                    "`pre_high_factor`) " +
                    "WHERE parameter_id = ?");

            preparedStatement.setInt(1, parameters.getParameter_id());
            preparedStatement.setInt(2, parameters.getElement_id());
            preparedStatement.setInt(3, parameters.getData_type_id());
            preparedStatement.setDouble(4, parameters.getVery_low_factor());
            preparedStatement.setDouble(5, parameters.getLow_factor());
            preparedStatement.setDouble(6, parameters.getHigh_factor());
            preparedStatement.setDouble(7, parameters.getVery_high_factor());
            preparedStatement.setDouble(8, parameters.getPre_low_factor());
            preparedStatement.setDouble(9, parameters.getPre_high_factor());
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
     * returns an int of the first parameter_id of a record that does not yet exist
     * in the 'parameters' table.
     * @return the first unoccupied parameter_id in the 'parameters' table.
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
            resultSet = statement.executeQuery("SELECT * FROM parameters");



            while (resultSet.next()) {
                emptySpace = resultSet.getInt("parameter_id") + 1;

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
     * receives a list of parameters records, and inserts all of them
     * to the `parameters` table.
     * @param parametersList - the parameters records list to be added to the database.
     */
    @Override
    public void insertAll(List<parameters> parametersList) {

        for (parameters parameters : parametersList) {
            parameters.setParameter_id(this.generateUniqueId());
            this.insert(parameters);
        }
        System.out.println("InsertAll finished");
    }

    /**
     * insert all parameters records that are supposed to be in the database initially.
     */
    @Override
    public void autoInsertAll() {
        parameters p1 = new parameters(1,1,1,1,1,1,1,1);
        parameters p2 = new parameters(2,1,0.2,0.1,0.1,0.2,0.5,0.5);
        parameters p3 = new parameters(3,1,0.2,0.1,0.1,0.2,0.5,0.5);
        parameters p4 = new parameters(4,2,0.2,0.1,0.1,0.2,0.5,0.5);
        parameters p5 = new parameters(5,2,0.2,0.1,0.1,0.2,0.5,0.5);
        parameters p6 = new parameters(6,2,1,1,1,1,1,1);
        parameters p7 = new parameters(7,3,0,0,0,0,0,0);
        parameters p8 = new parameters(8,3,0,0,0,0,0,0);
        parameters p9 = new parameters(9,3,0,0,0,0,0,0);
        parameters p10 = new parameters(10,3,0,0,0,0,0,0);
        parameters p11 = new parameters(11,3,0,0,0,0,0,0);
        parameters p12 = new parameters(12,3,0,0,0,0,0,0);
        List<parameters> parametersList = new ArrayList<>();
        parametersList.add(p1);
        parametersList.add(p2);
        parametersList.add(p3);
        parametersList.add(p4);
        parametersList.add(p5);
        parametersList.add(p6);
        parametersList.add(p7);
        parametersList.add(p8);
        parametersList.add(p9);
        parametersList.add(p10);
        parametersList.add(p11);
        parametersList.add(p12);
        this.insertAll(parametersList);
    }
}
