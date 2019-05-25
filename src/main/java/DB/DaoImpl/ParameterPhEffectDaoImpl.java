package DB.DaoImpl;
import DB.Dao.ParameterPhEffectDao;
import DB.Entites.ParameterPhEffect;
import DB.ExcelReadWrite.ExcelReadParameterPhEffect;
import DB.Util.ConnectionConfiguration;
//import DB.ExcelReadWrite.ExcelReadParameterPerStage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ParameterPhEffectDaoImpl implements ParameterPhEffectDao {
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

    @Override
    public void insertAll(List<ParameterPhEffect> parameterPhEffectList) {

        for(ParameterPhEffect parameterPhEffect : parameterPhEffectList) {
            this.insert(parameterPhEffect);

        }
        System.out.println("insertAll finished!");
    }

    @Override
    public void autoInsertAll() {
        ExcelReadParameterPhEffect ppeER = new ExcelReadParameterPhEffect();
        List<ParameterPhEffect> parameterPhEffectList = ppeER.readExcelData();
        this.insertAll(parameterPhEffectList);
    }
}

