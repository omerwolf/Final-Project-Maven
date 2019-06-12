package DB.DaoImpl;

import DB.Dao.Dao;
import DB.Entites.parameter_crop;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * the class implements the generic Dao class.
 * responsible for performing actions on the database table `parameter_crop`.
 */
public class parameter_cropDaoImpl implements Dao<parameter_crop> {
    /**
     * receives a parameter_crop record and inserts it
     * to the `parameter_crop` table in the database.
     * @param parameter_crop - a parameter_crop record.
     */
    @Override
    public void insert(parameter_crop parameter_crop) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=0");
            preparedStatement = connection.prepareStatement("INSERT INTO parameter_crop" +
                    "(`param_per_crop_id`," +
                    "`crop_id`," +
                    "`variety_id`," +
                    "`parameter_id`," +
                    "`amount`," +
                    "`base_line`," +
                    "`amount2`) " +
                    "VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, parameter_crop.getParam_per_crop_id());
            preparedStatement.setInt(2, parameter_crop.getCrop_id());
            preparedStatement.setInt(3, parameter_crop.getVariety_id());
            preparedStatement.setInt(4, parameter_crop.getParameter_id());
            preparedStatement.setDouble(5, parameter_crop.getAmount());
            preparedStatement.setDouble(6, parameter_crop.getBase_line());
            preparedStatement.setDouble(7, parameter_crop.getAmount2());
            preparedStatement.executeUpdate();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=1");
            //System.out.println("Insert: " + soil.getName());
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
     * receives a param_per_crop_id number, and returns a record that has
     * the same param_per_crop_id number.
     * @param id - the param_per_crop_id of the record that will be selected.
     * @return a parameter_crop record.
     */
    @Override
    public parameter_crop selectById(int id) {
        parameter_crop parameter_crop = new parameter_crop();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM parameter_crop WHERE param_per_crop_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                parameter_crop.setParam_per_crop_id(resultSet.getInt("param_per_crop_id"));
                parameter_crop.setCrop_id(resultSet.getInt("crop_id"));
                parameter_crop.setVariety_id(resultSet.getInt("variety_id"));
                parameter_crop.setParameter_id(resultSet.getInt("parameter_id"));
                parameter_crop.setAmount(resultSet.getDouble("amount"));
                parameter_crop.setBase_line(resultSet.getDouble("base_line"));
                parameter_crop.setAmount2(resultSet.getDouble("amount2"));
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
        return parameter_crop;
    }

    /**
     * selects all parameter_crop records in the table 'parameter_crop',
     * and returns them as a list.
     * @return a list of all parameter_crop records from database table 'parameter_crop'.
     */
    @Override
    public List<parameter_crop> selectAll() {
        List<parameter_crop> parameter_crops = new ArrayList<parameter_crop>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM parameter_crop");

            while (resultSet.next()) {
                parameter_crop parameter_crop = new parameter_crop();
                parameter_crop.setParam_per_crop_id(resultSet.getInt("param_per_crop_id"));
                parameter_crop.setCrop_id(resultSet.getInt("crop_id"));
                parameter_crop.setVariety_id(resultSet.getInt("variety_id"));
                parameter_crop.setParameter_id(resultSet.getInt("parameter_id"));
                parameter_crop.setAmount(resultSet.getDouble("amount"));
                parameter_crop.setBase_line(resultSet.getDouble("base_line"));
                parameter_crop.setAmount2(resultSet.getDouble("amount2"));
                parameter_crops.add(parameter_crop);
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
        return parameter_crops;
    }

    /**
     * deletes a parameter_crop record from the database table `parameter_crop`
     * with the same param_per_crop_id as the param.
     * @param id - the param_per_crop_id of the record to remove.
     */
    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM parameter_crop WHERE param_per_crop_id = ?");
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
     * takes a parameter_crop record with values and a param_per_crop_id, and updates
     * the record in the table with the same param_per_crop_id with the values
     * of the other record.
     * @param parameter_crop - the parameter_crop record to get the values from.
     * @param id - the id position of the parameter_crop record to update.
     */
    @Override
    public void update(parameter_crop parameter_crop, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE parameter_crop SET " +
                    "(`param_per_crop_id`," +
                    "`crop_id`," +
                    "`variety_id`," +
                    "`parameter_id`," +
                    "`amount`," +
                    "`base_line`," +
                    "`amount2`," +
                    "WHERE param_per_crop_id = ?");

            preparedStatement.setInt(1, parameter_crop.getParam_per_crop_id());
            preparedStatement.setInt(2, parameter_crop.getCrop_id());
            preparedStatement.setInt(3, parameter_crop.getVariety_id());
            preparedStatement.setInt(4, parameter_crop.getParameter_id());
            preparedStatement.setDouble(5, parameter_crop.getAmount());
            preparedStatement.setDouble(6, parameter_crop.getBase_line());
            preparedStatement.setDouble(7,parameter_crop.getAmount2());
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
     * returns an int of the first param_per_crop_id of a record that does not yet exist
     * in the 'parameter_crop' table.
     * @return the first unoccupied param_per_crop_id in the 'parameter_crop' table.
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
            resultSet = statement.executeQuery("SELECT * FROM parameter_crop");



            while (resultSet.next()) {
                emptySpace = resultSet.getInt("param_per_crop_id") + 1;

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
     * receives a list of parameter_crop records, and inserts all of them
     * to the `parameter_crop` table.
     * @param parameter_crops - the parameter_crop records list to be added to the database.
     */
    @Override
    public void insertAll(List<parameter_crop> parameter_crops) {
        //soils.sort((Soil s1, Soil s2) -> s1.getName().compareTo(s2.getName()));

        for (parameter_crop parameter_crop : parameter_crops) {
            parameter_crop.setParam_per_crop_id(this.generateUniqueId());
            this.insert(parameter_crop);
        }
        System.out.println("InsertAll finished");
    }

    /**
     * insert all parameter_crop records that are supposed to be in the database initially.
     */
    @Override
    public void autoInsertAll() {
        parameter_crop pc1 = new parameter_crop(8,	8,	1,	2.408,	0.000, 0);
        parameter_crop pc2 = new parameter_crop(8,	8,	2,	0.193,	0.000, 0);
        parameter_crop pc3 = new parameter_crop(8,	8,	3,	2.639,	0.000, 0);
        parameter_crop pc4 = new parameter_crop(8,	8,	4,	0.429,	0.000, 0);
        parameter_crop pc5 = new parameter_crop(8,	8,	5,	0.188,	0.000, 0);
        parameter_crop pc6 = new parameter_crop(8,	8,	6,	0.000,	0.000, 0);
        parameter_crop pc7 = new parameter_crop(8,	8,	7,	0.000,	0.000, 0);
        parameter_crop pc8 = new parameter_crop(8,	8,	8,	0.000,	0.000, 0);
        parameter_crop pc9 = new parameter_crop(8,	8,	9,	0.000,	0.000, 0);
        parameter_crop pc10 = new parameter_crop(8,	8,	10,	0.000,	0.000, 0);
        parameter_crop pc11 = new parameter_crop(8,	8,	11,	0.000,	0.000, 0);
        parameter_crop pc12 = new parameter_crop(8,	8,	12,	0.000,	0.000, 0);
        parameter_crop pc13 = new parameter_crop(6,	2,	1,	62.510,	157.500, 0);
        parameter_crop pc14 = new parameter_crop(6,	2,	2,	2.958,	4.258, 0);
        parameter_crop pc15 = new parameter_crop(6,	2,	3,	28.955,	83.333, 0);
        parameter_crop pc16 = new parameter_crop(6,	2,	4,	0.000,	38.571, 0);
        parameter_crop pc17 = new parameter_crop(6,	2,	5,	0.000,	25.313, 0);
        parameter_crop pc18 = new parameter_crop(6,	2,	6,	10.420,	6.750, 0);
        parameter_crop pc19 = new parameter_crop(6,	2,	7,	0.000,	2.000, 0);
        parameter_crop pc20 = new parameter_crop(6,	2,	8,	0.000,	2.000, 0);
        parameter_crop pc21 = new parameter_crop(6,	2,	9,	0.000,	0.750, 0);
        parameter_crop pc22 = new parameter_crop(6,	2,	10,	0.000,	2.000, 0);
        parameter_crop pc23 = new parameter_crop(6,	2,	11,	0.000,	1.000, 0);
        parameter_crop pc24 = new parameter_crop(6,	2,	12,	0.000,	0.000, 0);
        parameter_crop pc25 = new parameter_crop(6,	3,	1,	24.300,	157.500, 0);
        parameter_crop pc26 = new parameter_crop(6,	3,	2,	2.958,	4.258, 0);
        parameter_crop pc27 = new parameter_crop(6,	3,	3,	28.955,	83.333, 0);
        parameter_crop pc28 = new parameter_crop(6,	3,	4,	0.000,	38.571, 0);
        parameter_crop pc29 = new parameter_crop(6,	3,	5,	0.000,	25.313, 0);
        parameter_crop pc30 = new parameter_crop(6,	3,	6,	5.210,	6.750, 0);
        parameter_crop pc31 = new parameter_crop(6,	3,	7,	0.000,	2.000, 0);
        parameter_crop pc32 = new parameter_crop(6,	3,	8,	0.000,	2.000, 0);
        parameter_crop pc33 = new parameter_crop(6,	3,	9,	0.000,	0.750, 0);
        parameter_crop pc34 = new parameter_crop(6,	3,	10,	0.000,	2.000, 0);
        parameter_crop pc35 = new parameter_crop(6,	3,	11,	0.000,	1.000, 0);
        parameter_crop pc36 = new parameter_crop(6,	3,	12,	0.000,	0.000, 0);
        parameter_crop pc37 = new parameter_crop(7,	7,	1,	93.60,	0, 0);
        parameter_crop pc38 = new parameter_crop(7,	7,	2,	8.65,	0, 0);
        parameter_crop pc39 = new parameter_crop(7,	7,	3,	68.75,	0, 0);
        parameter_crop pc40 = new parameter_crop(7,	7,	4,	0,	0, 0);
        parameter_crop pc41 = new parameter_crop(7,	7,	5,	0,	0, 0);
        parameter_crop pc42 = new parameter_crop(7,	7,	6,	0,	0, 0);
        parameter_crop pc43 = new parameter_crop(7,	7,	7,	0,	0, 0);
        parameter_crop pc44 = new parameter_crop(7,	7,	8,	0.000,	0, 0);
        parameter_crop pc45 = new parameter_crop(7,	7,	9,	0.000,	0, 0);
        parameter_crop pc46 = new parameter_crop(7,	7,	10,	0.000,	0, 0);
        parameter_crop pc47 = new parameter_crop(7,	7,	11,	0.000,	0, 0);
        parameter_crop pc48 = new parameter_crop(7,	7,	12,	0.000,	0, 0);
        parameter_crop pc49 = new parameter_crop(4,	1,	1,	9.450,	32, 0);
        parameter_crop pc50 = new parameter_crop(4,	1,	2,	0.550,	2.10, 0);
        parameter_crop pc51 = new parameter_crop(4,	1,	3,	7.000,	23.33, 0);
        parameter_crop pc52 = new parameter_crop(4,	1,	4,	0.000,	0, 0);
        parameter_crop pc53 = new parameter_crop(4,	1,	5,	0.000,	0, 0);
        parameter_crop pc54 = new parameter_crop(4,	1,	6,	0.000,	0, 0);
        parameter_crop pc55 = new parameter_crop(4,	1,	7,	0.000,	0, 0);
        parameter_crop pc56 = new parameter_crop(4,	1,	8,	0.000,	0, 0);
        parameter_crop pc57 = new parameter_crop(4,	1,	9,	0.000,	0, 0);
        parameter_crop pc58 = new parameter_crop(4,	1,	10,	0.000,	0, 0);
        parameter_crop pc59 = new parameter_crop(4,	1,	11,	0.000,	0, 0);
        parameter_crop pc60 = new parameter_crop(4,	1,	12,	0.000,	0, 0);
        parameter_crop pc61 = new parameter_crop(2,	10,	1,	14.440,	0, 0);
        parameter_crop pc62 = new parameter_crop(2,	10,	2,	1.297,	0, 0);
        parameter_crop pc63 = new parameter_crop(2,	10,	3,	9.817,	0, 0);
        parameter_crop pc64 = new parameter_crop(2,	10,	4,	1.500,	0, 0);
        parameter_crop pc65 = new parameter_crop(2,	10,	5,	0.875,	0, 0);
        parameter_crop pc66 = new parameter_crop(2,	10,	6,	3.200,	0, 0);
        parameter_crop pc67 = new parameter_crop(2,	10,	7,	0.100,	0, 0);
        parameter_crop pc68 = new parameter_crop(2,	10,	8,	0.030,	0, 0);
        parameter_crop pc69 = new parameter_crop(2,	10,	9,	0.055,	0, 0);
        parameter_crop pc70 = new parameter_crop(2,	10,	10,	0.250,	0, 0);
        parameter_crop pc71 = new parameter_crop(2,	10,	11,	0.008,	0, 0);
        parameter_crop pc72 = new parameter_crop(2,	10,	12,	0.004,	0, 0);
        parameter_crop pc73 = new parameter_crop(1,	15,	1,	4.375,	0, 0);
        parameter_crop pc74 = new parameter_crop(1,	15,	2,	0.324,	0, 0);
        parameter_crop pc75 = new parameter_crop(1,	15,	3,	5.447,	0, 0);
        parameter_crop pc76 = new parameter_crop(1,	15,	4,	0.571,	0, 0);
        parameter_crop pc77 = new parameter_crop(1,	15,	5,	0.25,	0, 0);
        parameter_crop pc78 = new parameter_crop(1,	15,	6,	0.5,	0, 0);
        parameter_crop pc79 = new parameter_crop(1,	15,	7,	0,	0, 0);
        parameter_crop pc80 = new parameter_crop(1,	15,	8,	0,	0, 0);
        parameter_crop pc81 = new parameter_crop(1,	15,	9,	0,	0, 0);
        parameter_crop pc82 = new parameter_crop(1,	15,	10,	0,	0, 0);
        parameter_crop pc83 = new parameter_crop(1,	15,	11,	0,	0, 0);
        parameter_crop pc84 = new parameter_crop(1,	15,	12,	0,	0, 0);
        List<parameter_crop> parameter_crops = new ArrayList<>();
        parameter_crops.add(pc1);
        parameter_crops.add(pc2);
        parameter_crops.add(pc3);
        parameter_crops.add(pc4);
        parameter_crops.add(pc5);
        parameter_crops.add(pc6);
        parameter_crops.add(pc7);
        parameter_crops.add(pc8);
        parameter_crops.add(pc9);
        parameter_crops.add(pc10);
        parameter_crops.add(pc11);
        parameter_crops.add(pc12);
        parameter_crops.add(pc13);
        parameter_crops.add(pc14);
        parameter_crops.add(pc15);
        parameter_crops.add(pc16);
        parameter_crops.add(pc17);
        parameter_crops.add(pc18);
        parameter_crops.add(pc19);
        parameter_crops.add(pc20);
        parameter_crops.add(pc21);
        parameter_crops.add(pc22);
        parameter_crops.add(pc23);
        parameter_crops.add(pc24);
        parameter_crops.add(pc25);
        parameter_crops.add(pc26);
        parameter_crops.add(pc27);
        parameter_crops.add(pc28);
        parameter_crops.add(pc29);
        parameter_crops.add(pc30);
        parameter_crops.add(pc31);
        parameter_crops.add(pc32);
        parameter_crops.add(pc33);
        parameter_crops.add(pc34);
        parameter_crops.add(pc35);
        parameter_crops.add(pc36);
        parameter_crops.add(pc37);
        parameter_crops.add(pc38);
        parameter_crops.add(pc39);
        parameter_crops.add(pc40);
        parameter_crops.add(pc41);
        parameter_crops.add(pc42);
        parameter_crops.add(pc43);
        parameter_crops.add(pc44);
        parameter_crops.add(pc45);
        parameter_crops.add(pc46);
        parameter_crops.add(pc47);
        parameter_crops.add(pc48);
        parameter_crops.add(pc49);
        parameter_crops.add(pc50);
        parameter_crops.add(pc51);
        parameter_crops.add(pc52);
        parameter_crops.add(pc53);
        parameter_crops.add(pc54);
        parameter_crops.add(pc55);
        parameter_crops.add(pc56);
        parameter_crops.add(pc57);
        parameter_crops.add(pc58);
        parameter_crops.add(pc59);
        parameter_crops.add(pc60);
        parameter_crops.add(pc61);
        parameter_crops.add(pc62);
        parameter_crops.add(pc63);
        parameter_crops.add(pc64);
        parameter_crops.add(pc65);
        parameter_crops.add(pc66);
        parameter_crops.add(pc67);
        parameter_crops.add(pc68);
        parameter_crops.add(pc69);
        parameter_crops.add(pc70);
        parameter_crops.add(pc71);
        parameter_crops.add(pc72);
        parameter_crops.add(pc73);
        parameter_crops.add(pc74);
        parameter_crops.add(pc75);
        parameter_crops.add(pc76);
        parameter_crops.add(pc77);
        parameter_crops.add(pc78);
        parameter_crops.add(pc79);
        parameter_crops.add(pc80);
        parameter_crops.add(pc81);
        parameter_crops.add(pc82);
        parameter_crops.add(pc83);
        parameter_crops.add(pc84);
        this.insertAll(parameter_crops);
    }
}
