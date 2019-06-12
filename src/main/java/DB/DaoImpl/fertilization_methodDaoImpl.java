package DB.DaoImpl;

import DB.Dao.Dao;
import DB.Entites.fertilization_method;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * the class implements the generic Dao class.
 * responsible for performing actions on the database table `fertilization method`.
 */
public class fertilization_methodDaoImpl implements Dao<fertilization_method> {
    /**
     * receives a fertilization_method record and inserts it
     * to the `fertilization method` table in the database.
     * @param fertilization_method - a fertilization_method record.
     */
    @Override
    public void insert(fertilization_method fertilization_method) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO `fertilization method` (fert_method_id,fert_method_desc)" +
                    "VALUES (?, ?)");
            preparedStatement.setInt(1, fertilization_method.getFert_method_id());
            preparedStatement.setString(2, fertilization_method.getFert_method_desc());
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
     * receives a fert_method_id number, and returns a record that has
     * the same fert_method_id number.
     * @param id - the fert_method_id of the record that will be selected.
     * @return a fertilization_method record.
     */
    @Override
    public fertilization_method selectById(int id) {
        fertilization_method fertilization_method = new fertilization_method();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM `fertilization method` WHERE fert_method_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                fertilization_method.setFert_method_id(resultSet.getInt("fert_method_id"));
                fertilization_method.setFert_method_desc(resultSet.getString("fert_method_desc"));
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
        return fertilization_method;
    }

    /**
     * selects all fertilization_method records in the table 'fertilization method',
     * and returns them as a list.
     * @return a list of all fertilization_method records from database table 'fertilization method'.
     */
    @Override
    public List<fertilization_method> selectAll() {
        List<fertilization_method> fertilization_methods = new ArrayList<fertilization_method>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `fertilization method`");

            while (resultSet.next()) {
                fertilization_method fertilization_method = new fertilization_method();
                fertilization_method.setFert_method_id(resultSet.getInt("fert_method_id"));
                fertilization_method.setFert_method_desc(resultSet.getString("fert_method_desc"));
                fertilization_methods.add(fertilization_method);
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
        return fertilization_methods;
    }

    /**
     * deletes a fertilization_method record from the database table `fertilization method`
     * with the same fert_method_id as the param.
     * @param id - the fert_method_id of the record to remove.
     */
    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM `fertilization method` WHERE fert_method_id = ?");
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
     * takes a fertilization_method record with values and a fert_method_id, and updates
     * the record in the table with the same fert_method_id with the values
     * of the other record.
     * @param fertilization_method - the fertilization_method record to get the values from.
     * @param id - the id position of the fertilization_method record to update.
     */
    @Override
    public void update(fertilization_method fertilization_method, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE `fertilization method` SET " +
                    "fert_method_desc = ? WHERE fert_method_id = ?");

            preparedStatement.setString(1, fertilization_method.getFert_method_desc());
            preparedStatement.setInt(2, id);
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
     * returns an int of the first fert_method_id of a record that does not yet exist
     * in the 'fertilization method' table.
     * @return the first unoccupied fert_method_id in the 'fertilization method' table.
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
            resultSet = statement.executeQuery("SELECT * FROM `fertilization method`");
            while (resultSet.next()) {
                emptySpace = resultSet.getInt("fert_method_id") + 1;

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
     * receives a list of fertilization_method records, and inserts all of them
     * to the `fertilization method` table.
     * @param fertilizationMethodList - the fertilization_method records list
     * to be added to the database.
     */
    @Override
    public void insertAll(List<fertilization_method> fertilizationMethodList) {

        for(fertilization_method fertMethod : fertilizationMethodList) {
            this.insert(fertMethod);
        }
        System.out.println("insertAll finished!");
    }

    /**
     * insert all fertilization_method records that are supposed to be in the database initially.
     */
    @Override
    public void autoInsertAll() {
        String[] fertMethodNames = {"Soil Application", "Band Application" ,"Drip Fertigation", "SDI Fertigation" ,
                "Sprinklers Fertigation", "Pivot Fertigation", "Flooding"};
        List<fertilization_method> fertilizationMethodList = new ArrayList<>();
        for (String fertMethodName:fertMethodNames) {
            fertilization_method fertMethod = new fertilization_method(this.generateUniqueId(),fertMethodName);
            fertilizationMethodList.add(fertMethod);
        }
        this.insertAll(fertilizationMethodList);


    }
}
