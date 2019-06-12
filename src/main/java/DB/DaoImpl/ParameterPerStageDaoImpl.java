package DB.DaoImpl;
import DB.Dao.Dao;
import DB.Entites.ParameterPerStage;
import DB.Util.ConnectionConfiguration;
import DB.ExcelReadWrite.ExcelReadParameterPerStage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * the class implements the generic Dao class.
 * responsible for performing actions on the database table `parameter_per_stage`.
 */
public class ParameterPerStageDaoImpl implements Dao<ParameterPerStage> {
    /**
     * receives a ParameterPerStage record and inserts it
     * to the `parameter_per_stage` table in the database.
     * @param parameterPerStage - a ParameterPerStage record.
     */
    @Override
    public void insert(ParameterPerStage parameterPerStage) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO `parameter_per_stage` " +
                    "(nutrient_per_stage_id," +
                    "param_per_crop_id," +
                    " variety_id," +
                    " `phenological stage_id`," +
                    " percent)" +
                    "VALUES (?, ?, ?, ? , ?)");
            preparedStatement.setInt(1, parameterPerStage.getNutrientPerStageId());
            preparedStatement.setInt(2, parameterPerStage.getParamPerCropId());
            preparedStatement.setInt(3, parameterPerStage.getVarietyId());
            preparedStatement.setInt(4, parameterPerStage.getPhenologicalStageId());
            preparedStatement.setDouble(5, parameterPerStage.getPercent());
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
     * receives a nutrient_per_stage_id number, and returns a record that has
     * the same nutrient_per_stage_id number.
     * @param id - the nutrient_per_stage_id of the record that will be selected.
     * @return a ParameterPerStage record.
     */
    @Override
    public ParameterPerStage selectById(int id) {
        ParameterPerStage parameterPerStage = new ParameterPerStage();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM `parameter_per_stage` WHERE nutrient_per_stage_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                parameterPerStage.setNutrientPerStageId(resultSet.getInt("nutrient_per_stage_id"));
                parameterPerStage.setParamPerCropId(resultSet.getInt("param_per_crop_id"));
                parameterPerStage.setVarietyId(resultSet.getInt("variety_id"));
                parameterPerStage.setPhenologicalStageId(resultSet.getInt("phenological stage_id"));
                parameterPerStage.setPercent(resultSet.getDouble("percent"));
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
        return parameterPerStage;
    }

    /**
     * selects all ParameterPerStage records in the table 'parameter_per_stage',
     * and returns them as a list.
     * @return a list of all ParameterPerStage records from database table 'parameter_per_stage'.
     */
    @Override
    public List<ParameterPerStage> selectAll() {
        List<ParameterPerStage> parameterPerStageList = new ArrayList<ParameterPerStage>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `parameter_per_stage`");

            while (resultSet.next()) {
                ParameterPerStage parameterPerStage = new ParameterPerStage();
                parameterPerStage.setNutrientPerStageId(resultSet.getInt("nutrient_per_stage_id"));
                parameterPerStage.setParamPerCropId(resultSet.getInt("param_per_crop_id"));
                parameterPerStage.setVarietyId(resultSet.getInt("variety_id"));
                parameterPerStage.setPhenologicalStageId(resultSet.getInt("phenological stage_id"));
                parameterPerStage.setPercent(resultSet.getDouble("percent"));
                parameterPerStageList.add(parameterPerStage);
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
        return parameterPerStageList;
    }

    /**
     * deletes a ParameterPerStage record from the database table `parameter_per_stage`
     * with the same nutrient_per_stage_id as the param.
     * @param id - the nutrient_per_stage_id of the record to remove.
     */
    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM `parameter_per_stage` WHERE nutrient_per_stage_id = ?");
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
     * takes a ParameterPerStage record with values and a nutrient_per_stage_id, and updates
     * the record in the table with the same nutrient_per_stage_id with the values
     * of the other record.
     * @param parameterPerStage - the ParameterPerStage record to get the values from.
     * @param id - the id position of the ParameterPerStage record to update.
     */
    @Override
    public void update(ParameterPerStage parameterPerStage, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE `parameter_per_stage` SET " +
                    "param_per_crop_id = ?," +
                    " variety_id = ?," +
                    " `phenological stage_id` = ?," +
                    " percent = ? WHERE nutrient_per_stage_id = ?");

            preparedStatement.setInt(1, parameterPerStage.getParamPerCropId());
            preparedStatement.setInt(2, parameterPerStage.getVarietyId());
            preparedStatement.setInt(3, parameterPerStage.getPhenologicalStageId());
            preparedStatement.setDouble(4, parameterPerStage.getPercent());
            preparedStatement.setInt(5, id);
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
     * returns an int of the first nutrient_per_stage_id of a record that does not yet exist
     * in the 'parameter_per_stage' table.
     * @return the first unoccupied nutrient_per_stage_id in the 'parameter_per_stage' table.
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
            resultSet = statement.executeQuery("SELECT * FROM `parameter_per_stage`");



            while (resultSet.next()) {
                emptySpace = resultSet.getInt("nutrient_per_stage_id") + 1;

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
     * receives a list of ParameterPerStage records, and inserts all of them
     * to the `parameter_per_stage` table.
     * @param parameterPerStageList - the ParameterPerStage records list
     * to be added to the database.
     */
    @Override
    public void insertAll(List<ParameterPerStage> parameterPerStageList) {

        for(ParameterPerStage parameterPerStage : parameterPerStageList) {
            this.insert(parameterPerStage);

        }
        System.out.println("insertAll finished!");
    }

    /**
     * insert all ParameterPerStage records that are supposed to be in the database initially.
     * note: in this implementation class, it does that by reading from the excel.
     */
    @Override
    public void autoInsertAll() {
        ExcelReadParameterPerStage ppsER = new ExcelReadParameterPerStage();
        List<ParameterPerStage> parameterPerStageList = ppsER.readExcelData();
        this.insertAll(parameterPerStageList);
    }
}
