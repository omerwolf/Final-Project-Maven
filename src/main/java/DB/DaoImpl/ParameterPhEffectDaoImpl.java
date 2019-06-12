package DB.DaoImpl;
import DB.Dao.Dao;
import DB.Entites.ParameterPhEffect;
import DB.ExcelReadWrite.ExcelReadParameterPhEffect;
import DB.Util.ConnectionConfiguration;
//import DB.ExcelReadWrite.ExcelReadParameterPerStage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * the class implements the generic Dao class.
 * responsible for performing actions on the database table `parameter_ph_effect`.
 */
public class ParameterPhEffectDaoImpl implements Dao<ParameterPhEffect> {
    /**
     * receives a ParameterPhEffect record and inserts it
     * to the `parameter_ph_effect` table in the database.
     * @param parameterPhEffect - a ParameterPhEffect record.
     */
    @Override
    public void insert(ParameterPhEffect parameterPhEffect) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO `parameter_ph_effect` " +
                    "(effect_id," +
                    "parameter_id," +
                    "range_id," +
                    "effect)" +
                    "VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, parameterPhEffect.getEffectId());
            preparedStatement.setInt(2, parameterPhEffect.getParameterId());
            preparedStatement.setInt(3, parameterPhEffect.getRangeId());
            preparedStatement.setDouble(4, parameterPhEffect.getEffect());
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
     * receives a effect_id number, and returns a record that has
     * the same effect_id number.
     * @param id - the effect_id of the record that will be selected.
     * @return a ParameterPhEffect record.
     */
    @Override
    public ParameterPhEffect selectById(int id) {
        ParameterPhEffect parameterPhEffect = new ParameterPhEffect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM `parameter_ph_effect` WHERE effect_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                parameterPhEffect.setEffectId(resultSet.getInt("effect_id"));
                parameterPhEffect.setParameterId(resultSet.getInt("parameter_id"));
                parameterPhEffect.setRangeId(resultSet.getInt("range_id"));
                parameterPhEffect.setEffect(resultSet.getDouble("effect"));
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
        return parameterPhEffect;
    }

    /**
     * selects all ParameterPhEffect records in the table 'parameter_ph_effect',
     * and returns them as a list.
     * @return a list of all ParameterPhEffect records from database table 'parameter_ph_effect'.
     */
    @Override
    public List<ParameterPhEffect> selectAll() {
        List<ParameterPhEffect> parameterPhEffectList = new ArrayList<ParameterPhEffect>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `parameter_ph_effect`");

            while (resultSet.next()) {
                ParameterPhEffect parameterPhEffect = new ParameterPhEffect();
                parameterPhEffect.setEffectId(resultSet.getInt("effect_id"));
                parameterPhEffect.setParameterId(resultSet.getInt("parameter_id"));
                parameterPhEffect.setRangeId(resultSet.getInt("range_id"));
                parameterPhEffect.setEffect(resultSet.getDouble("effect"));
                parameterPhEffectList.add(parameterPhEffect);
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
        return parameterPhEffectList;
    }

    /**
     * deletes a ParameterPhEffect record from the database table `parameter_ph_effect`
     * with the same effect_id as the param.
     * @param id - the effect_id of the record to remove.
     */
    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM `parameter_ph_effect` WHERE effect_id = ?");
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
     * takes a ParameterPhEffect record with values and a effect_id, and updates
     * the record in the table with the same effect_id with the values
     * of the other record.
     * @param parameterPhEffect - the ParameterPhEffect record to get the values from.
     * @param id - the id position of the ParameterPhEffect record to update.
     */
    @Override
    public void update(ParameterPhEffect parameterPhEffect, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE `parameter_ph_effect` SET " +
                    "parameter_id = ?," +
                    "range_id = ?," +
                    "effect = ? WHERE effect_id = ?");

            preparedStatement.setInt(1, parameterPhEffect.getParameterId());
            preparedStatement.setInt(2, parameterPhEffect.getRangeId());
            preparedStatement.setDouble(3, parameterPhEffect.getEffect());
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
     * returns an int of the first effect_id of a record that does not yet exist
     * in the 'parameter_ph_effect' table.
     * @return the first unoccupied effect_id in the 'parameter_ph_effect' table.
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
            resultSet = statement.executeQuery("SELECT * FROM `parameter_ph_effect`");



            while (resultSet.next()) {
                emptySpace = resultSet.getInt("effect_id") + 1;

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
     * receives a list of ParameterPhEffect records, and inserts all of them
     * to the `parameter_ph_effect` table.
     * @param parameterPhEffectList - the ParameterPhEffect records list
     * to be added to the database.
     */
    @Override
    public void insertAll(List<ParameterPhEffect> parameterPhEffectList) {

        for(ParameterPhEffect parameterPhEffect : parameterPhEffectList) {
            this.insert(parameterPhEffect);

        }
        System.out.println("insertAll finished!");
    }

    /**
     * insert all ParameterPhEffect records that are supposed to be in the database initially.
     * note: in this implementation class, it does that by reading from the excel.
     */
    @Override
    public void autoInsertAll() {
        ExcelReadParameterPhEffect ppeER = new ExcelReadParameterPhEffect();
        List<ParameterPhEffect> parameterPhEffectList = ppeER.readExcelData();
        this.insertAll(parameterPhEffectList);
    }
}

