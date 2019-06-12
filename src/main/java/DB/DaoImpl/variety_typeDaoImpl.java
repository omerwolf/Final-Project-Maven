package DB.DaoImpl;

import DB.Dao.Dao;
import DB.Entites.variety_type;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * the class implements the generic Dao class.
 * responsible for performing actions on the database table `variety_type`.
 */
public class variety_typeDaoImpl implements Dao<variety_type> {
    /**
     * receives a variety_type record and inserts it
     * to the `variety_type` table in the database.
     * @param variety_type - a variety_type record.
     */
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
    /**
     * receives a variety_id number, and returns a record that has
     * the same variety_id number.
     * @param id - the variety_id of the record that will be selected.
     * @return a variety_type record.
     */
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

    /**
     * selects all variety_type records in the table 'variety_type',
     * and returns them as a list.
     * @return a list of all variety_type records from database table 'variety_type'.
     */
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

    /**
     * deletes a variety_type record from the database table `variety_type`
     * with the same variety_id as the param.
     * @param id - the variety_id of the record to remove.
     */
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

    /**
     * takes a variety_type record with values and a variety_id, and updates
     * the record in the table with the same variety_id with the values
     * of the other record.
     * @param variety_type - the variety_type record to get the values from.
     * @param id - the id position of the variety_type record to update.
     */
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

    /**
     * returns an int of the first variety_id of a record that does not yet exist
     * in the 'variety_type' table.
     * @return the first unoccupied variety_id in the 'variety_type' table.
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

    /**
     * receives a list of variety_type records, and inserts all of them
     * to the `variety_type` table.
     * @param varietyTypeList - the variety_type records list to be added to the database.
     */
    @Override
    public void insertAll(List<variety_type> varietyTypeList) {

        for(variety_type varietyType : varietyTypeList) {
            this.insert(varietyType);
        }
        System.out.println("insertAll finished!");
    }

    /**
     * insert all variety_type records that are supposed to be in the database initially.
     */
    @Override
    public void autoInsertAll() {
        String[] varietyNames = {"Hass", "Arabica" ,"Robusta", "Sugarcane - General" , "Pima", "Upland",
                "Akalfi", "Processing tomatoes - general", "Grain - Short", "Grain - Medium" , "Grain - Long",
                "Silage - Short", "Silage - Medium" , "Silage - Long", "Potatoes - General", "Almond",
                "Avocado 1st year", "Avocado 2nd year", "Avocado 3rd year", "Strawberries - General",
                "Soybeans - General", "Table grapes - General", "Wine grapes - General", "Pomegranade - General",
                "Onion - General", "Or"};
        List<variety_type> varietyTypeList = new ArrayList<>();
        for (String name:varietyNames) {
            variety_type varietyType = new variety_type(this.generateUniqueId(),name);
            varietyTypeList.add(varietyType);
        }
        this.insertAll(varietyTypeList);


    }
}
