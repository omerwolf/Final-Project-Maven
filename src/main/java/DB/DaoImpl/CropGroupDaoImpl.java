package DB.DaoImpl;

import DB.Dao.Dao;
import DB.Entites.CropGroup;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * the class implements the generic Dao class.
 * responsible for performing actions on the database table `crop_group`.
 */
public class CropGroupDaoImpl implements Dao<CropGroup> {
    /**
     * receives a CropGroup record and inserts it
     * to the `crop_group` table in the database.
     * @param cropGroup - a CropGroup record.
     */
    @Override
    public void insert(CropGroup cropGroup) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO `crop_group` (crop_group_id,crop_group_desc)" +
                    "VALUES (?, ?)");
            preparedStatement.setInt(1, cropGroup.getCropGroupId());
            preparedStatement.setString(2, cropGroup.getCropGroupDesc());
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
     * receives a crop_group_id number, and returns a record that has
     * the same crop_group_id number.
     * @param id - the crop_group_id of the record that will be selected.
     * @return a CropGroup record.
     */
    @Override
    public CropGroup selectById(int id) {
        CropGroup cropGroup = new CropGroup();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM `crop_group` WHERE crop_group_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                cropGroup.setCropGroupId(resultSet.getInt("crop_group_id"));
                cropGroup.setCropGroupDesc(resultSet.getString("crop_group_desc"));
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
        return cropGroup;
    }

    /**
     * selects all CropGroup records in the table 'crop_group',
     * and returns them as a list.
     * @return a list of all CropGroup records from database table 'crop_group'.
     */
    @Override
    public List<CropGroup> selectAll() {
        List<CropGroup> cropGroupList = new ArrayList<CropGroup>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `crop_group`");

            while (resultSet.next()) {
                CropGroup cropGroup = new CropGroup();
                cropGroup.setCropGroupId(resultSet.getInt("crop_group_id"));
                cropGroup.setCropGroupDesc(resultSet.getString("crop_group_desc"));
                cropGroupList.add(cropGroup);
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
        return cropGroupList;
    }

    /**
     * deletes a CropGroup record from the database table `crop_group`
     * with the same crop_group_id as the param.
     * @param id - the crop_group_id of the record to remove.
     */
    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM `crop_group` WHERE crop_group_id = ?");
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
     * takes a CropGroup record with values and a crop_group_id, and updates
     * the record in the table with the same crop_group_id with the values
     * of the other record.
     * @param cropGroup - the CropGroup record to get the values from.
     * @param id - the id position of the CropGroup record to update.
     */
    @Override
    public void update(CropGroup cropGroup, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE `crop_group` SET " +
                    "crop_group_desc = ? WHERE crop_group_id = ?");

            preparedStatement.setString(1, cropGroup.getCropGroupDesc());
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
     * returns an int of the first crop_group_id of a record that does not yet exist
     * in the 'crop_group' table.
     * @return the first unoccupied crop_group_id in the 'crop_group' table.
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
            resultSet = statement.executeQuery("SELECT * FROM `crop_group`");



            while (resultSet.next()) {
                emptySpace = resultSet.getInt("crop_group_id") + 1;

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
     * receives a list of CropGroup records, and inserts all of them
     * to the `crop_group` table.
     * @param cropGroupList - the CropGroup records list to be added to the database.
     */
    @Override
    public void insertAll(List<CropGroup> cropGroupList) {

        for(CropGroup cropGroup : cropGroupList) {
            this.insert(cropGroup);
        }
        System.out.println("insertAll finished!");
    }

    /**
     * insert all CropGroup records that are supposed to be in the database initially.
     */
    @Override
    public void autoInsertAll() {
        String[] cropGroupNames = {"Orchards" , "Field crops"};
        CropGroup cg1 = new CropGroup(1,"Orchards");
        CropGroup cg2 = new CropGroup(2,"Field crops");
        List<CropGroup> cropGroupList = new ArrayList<>();
        cropGroupList.add(cg1);
        cropGroupList.add(cg2);
        this.insertAll(cropGroupList);


    }
}
