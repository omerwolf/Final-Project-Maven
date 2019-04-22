package DB.DaoImpl;

import DB.Dao.variety_typeDao;
import DB.Entites.variety_type;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class variety_typeDaoImpl implements variety_typeDao {
    @Override
    public void insert(variety_type variety_type) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO `variety_type` (variety_id,variety_name)" +
                    "VALUES (?, ?)");
            preparedStatement.setInt(1, variety_type.getVariety_id());
            preparedStatement.setString(2, variety_type.getVariety_name());
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
    public variety_type selectById(int id) {
        variety_type variety_type = new variety_type();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM `variety_type` WHERE variety_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                variety_type.setVariety_id(resultSet.getInt("variety_id"));
                variety_type.setVariety_name(resultSet.getString("variety_name"));
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
        return variety_type;
    }

    @Override
    public List<variety_type> selectAll() {
        List<variety_type> variety_types = new ArrayList<variety_type>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `variety_type`");

            while (resultSet.next()) {
                variety_type variety_type = new variety_type();
                variety_type.setVariety_id(resultSet.getInt("variety_id"));
                variety_type.setVariety_name(resultSet.getString("variety_name"));
                variety_types.add(variety_type);
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
        return variety_types;
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM `variety_type` WHERE variety_id = ?");
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
    public void update(variety_type variety_type, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE `variety_type` SET " +
                    "variety_name = ? WHERE variety_id = ?");

            preparedStatement.setString(1, variety_type.getVariety_name());
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
            resultSet = statement.executeQuery("SELECT * FROM `variety_type`");
            while (resultSet.next()) {
                emptySpace = resultSet.getInt("variety_id") + 1;

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
    public void insertAll(String[] varietyNames) {

        for(String varietyName : varietyNames) {
            variety_type variety_type = new variety_type();
            variety_type.setVariety_name(varietyName);
            variety_type.setVariety_id(this.generateUniqueId());
            this.insert(variety_type);

        }
        System.out.println("insertAll finished!");
    }

    @Override
    public void autoInsertAll() {
        String[] varietyNames = {"Hass", "Arabica" ,"Robusta", "Sugarcane - General" , "Pima", "Upland",
                "Akalfi", "Processing tomatoes - general", "Grain - Short", "Grain - Medium" , "Grain - Long",
                "Silage - Short", "Silage - Medium" , "Silage - Long", "Potatoes - General", "Almond",
                "Avocado 1st year", "Avocado 2nd year", "Avocado 3rd year", "Strawberries - General",
                "Soybeans - General", "Table grapes - General", "Wine grapes - General", "Pomegranade - General",
                "Onion - General", "Or"};
        this.insertAll(varietyNames);


    }
}
