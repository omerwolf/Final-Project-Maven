package DB.DaoImpl;

import DB.Dao.fertilization_methodDao;
import DB.Entites.fertilization_method;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class fertilization_methodDaoImpl implements fertilization_methodDao{
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

    @Override
    public void insertAll(String[] fert_method_names) {

        for(String fert_method_name : fert_method_names) {
            fertilization_method fertilization_method = new fertilization_method();
            fertilization_method.setFert_method_desc(fert_method_name);
            fertilization_method.setFert_method_id(this.generateUniqueId());
            this.insert(fertilization_method);

        }
        System.out.println("insertAll finished!");
    }

    @Override
    public void autoInsertAll() {
        String[] fert_methods_names = {"Soil Application", "Band Application" ,"Drip Fertigation", "SDI Fertigation" ,
                "Sprinklers Fertigation", "Pivot Fertigation", "Flooding"};
        this.insertAll(fert_methods_names);


    }
}
