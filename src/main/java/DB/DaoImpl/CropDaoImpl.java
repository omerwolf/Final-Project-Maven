package DB.DaoImpl;


import DB.Dao.Dao;
import DB.Entites.Crop;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * the class implements the generic Dao class.
 * responsible for performing actions on the database table `crop type`.
 */
public class CropDaoImpl implements Dao<Crop> {
    /**
     * receives a crop record and inserts it
     * to the `crop type` table in the database.
     * @param crop - a crop record.
     */
    @Override
    public void insert(Crop crop) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO `crop type` (crop_id,crop_name,crop_group_id)" +
                    "VALUES (?, ?, ?)");
            preparedStatement.setInt(1, crop.getId());
            preparedStatement.setString(2, crop.getName());
            preparedStatement.setInt(3, crop.getCrop_group_id());
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
     * receives a crop_id number, and returns a record that has
     * the same crop_id number.
     * @param id - the crop_id of the record that will be selected.
     * @return a Crop record.
     */
    @Override
    public Crop selectById(int id) {
        Crop crop = new Crop();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM `crop type` WHERE crop_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                crop.setId(resultSet.getInt("crop_id"));
                crop.setName(resultSet.getString("crop_name"));
                crop.setCrop_group_id(resultSet.getInt("crop_group_id"));
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
        return crop;
    }

    /**
     * selects all Crop records in the table 'crop type',
     * and returns them as a list.
     * @return a list of all Crop records from database table 'crop type'.
     */
    @Override
    public List<Crop> selectAll() {
        List<Crop> crops = new ArrayList<Crop>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `crop type`");

            while (resultSet.next()) {
                Crop crop = new Crop();
                crop.setId(resultSet.getInt("crop_id"));
                crop.setName(resultSet.getString("crop_name"));
                crop.setCrop_group_id(resultSet.getInt("crop_group_id"));
                crops.add(crop);
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
        return crops;
    }

    /**
     * deletes a Crop record from the database table `crop type`
     * with the same crop_id as the param.
     * @param id - the crop_id of the record to remove.
     */
    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM `crop type` WHERE crop_id = ?");
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
     * takes a Crop record with values and a crop_id, and updates
     * the record in the table with the same crop_id with the values
     * of the other record.
     * @param crop - the Crop record to get the values from.
     * @param id - the id position of the Crop record to update.
     */
    @Override
    public void update(Crop crop, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE `crop type` SET " +
                    "crop_name = ?, crop_group_id = ? WHERE crop_id = ?");

            preparedStatement.setString(1, crop.getName());
            preparedStatement.setInt(2, crop.getCrop_group_id());
            preparedStatement.setInt(3, id);
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
     * returns an int of the first crop_id of a record that does not yet exist
     * in the 'crop type' table.
     * @return the first unoccupied crop_id in the 'crop type' table.
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
            resultSet = statement.executeQuery("SELECT * FROM `crop type`");



            while (resultSet.next()) {
                emptySpace = resultSet.getInt("crop_id") + 1;

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
     * receives a list of Crop records, and inserts all of them
     * to the `crop type` table.
     * @param cropList - the Crop records list to be added to the database.
     */
    @Override
    public void insertAll(List<Crop> cropList) {

        for(Crop crop : cropList) {
            crop.setId(this.generateUniqueId());
            this.insert(crop);

        }
        System.out.println("insertAll finished!");
    }
    /**
     * insert all Crop records that are supposed to be in the database initially.
     */
    @Override
    public void autoInsertAll() {
        Crop crop1 = new Crop("Potato" , 2);
        Crop crop2 = new Crop("Corn", 2);
        Crop crop3 = new Crop("Almonds", 1);
        Crop crop4 = new Crop("Avocado" , 1);
        Crop crop5 = new Crop("Sugarcane", 2);
        Crop crop6 = new Crop("Coffee", 1);
        Crop crop7 = new Crop("Cotton", 2);
        Crop crop8 = new Crop("Processing Tomatoes", 2);
        Crop crop9 = new Crop("Strawberries", 2);
        Crop crop10 = new Crop("Soybeans", 2);
        Crop crop11 = new Crop("Wine grapes", 1);
        Crop crop12 = new Crop("Table grapes" , 1);
        Crop crop13 = new Crop("Onion" , 2);
        Crop crop14 = new Crop("Pomegranade", 1);
        Crop crop15 = new Crop("Citrus", 1);
        List<Crop> cropList = new ArrayList<>();
        cropList.add(crop1);
        cropList.add(crop2);
        cropList.add(crop3);
        cropList.add(crop4);
        cropList.add(crop5);
        cropList.add(crop6);
        cropList.add(crop7);
        cropList.add(crop8);
        cropList.add(crop9);
        cropList.add(crop10);
        cropList.add(crop11);
        cropList.add(crop12);
        cropList.add(crop13);
        cropList.add(crop14);
        cropList.add(crop15);
        this.insertAll(cropList);

    }
}
