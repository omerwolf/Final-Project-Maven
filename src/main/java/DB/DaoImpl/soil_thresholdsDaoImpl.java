package DB.DaoImpl;

import DB.Dao.soil_thresholdsDao;
import DB.Entites.soil_thresholds;
import DB.ExcelReadWrite.ERsoil_thresholds;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * implements the soil_thresholdsDao interface.
 * responsible for performing actions on the database table `soil_thresholds`.
 */
public class soil_thresholdsDaoImpl implements soil_thresholdsDao {

    /**
     * receives a soil threshold record, and inserts it to the table.
     * @param st - a soil analysis record
     */
    @Override
    public void insert(soil_thresholds st) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=0");
            preparedStatement = connection.prepareStatement("INSERT INTO `soil_thresholds` " +
                    "(soil_threshold_id,"+
                    "lab_id,"+
                    "extraction_method_id,"+
                    "parameter_id,"+
                    "uom_id,"+
                    "very_low_threshold,"+
                    "low_threshold,"+
                    "high_threshold,"+
                    "very_high_threshold,"+
                    "target_value) "+
                    "VALUES (?, ?, ?, ? , ?, ?, ?, ?, ? , ?)");
            preparedStatement.setInt(1, st.getSoil_threshold_id());
            preparedStatement.setInt(2, st.getLab_id());
            preparedStatement.setInt(3, st.getExtraction_method_id());
            preparedStatement.setInt(4, st.getParameters_id());
            preparedStatement.setInt(5, st.getUom_id());
            preparedStatement.setDouble(6,st.getVery_low_threshold());
            preparedStatement.setDouble(7, st.getLow_threshold());
            preparedStatement.setDouble(8, st.getHigh_threshold());
            preparedStatement.setDouble(9, st.getVery_high_threshold());
            preparedStatement.setDouble(10, st.getTarget_value());
            preparedStatement.executeUpdate();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=0");
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
     * receives an id number, and returns a record that has
     * the same id number.
     * @param soil_threshold_id - the id of the soil analysis record that will be selected.
     * @return selected soil analysis record.
     */
    @Override
    public soil_thresholds selectById(int soil_threshold_id) {
        soil_thresholds soilThresholds = new soil_thresholds();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();

            preparedStatement = connection.prepareStatement("SELECT * FROM `parameter_per_stage` WHERE nutrient_per_stage_id = ?");
            preparedStatement.setInt(1, soil_threshold_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                soilThresholds.setSoil_threshold_id(resultSet.getInt("soil_threshold_id"));
                soilThresholds.setLab_id(resultSet.getInt("lab_id"));
                soilThresholds.setExtraction_method_id(resultSet.getInt("extraction_method_id"));
                soilThresholds.setParameters_id(resultSet.getInt("parameter_id"));
                soilThresholds.setUom_id(resultSet.getInt("uom_id"));
                soilThresholds.setVery_low_threshold(resultSet.getDouble("very_low_threshold"));
                soilThresholds.setLow_threshold(resultSet.getDouble("low_threshold"));
                soilThresholds.setHigh_threshold(resultSet.getDouble("high_threshold"));
                soilThresholds.setVery_high_threshold(resultSet.getDouble("very_high_threshold"));
                soilThresholds.setTarget_value(resultSet.getDouble("target_value"));
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
        return soilThresholds;

    }

    /**
     * selects all records from the soil analysis table
     * and returns them as a list.
     * @return a list of all the soil analysis records.
     */
    @Override
    public List<soil_thresholds> selectAll() {
        List<soil_thresholds> soil_thresholdsList = new ArrayList<soil_thresholds>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `soil_thresholds`");

            while (resultSet.next()) {
                soil_thresholds soil_thresholds = new soil_thresholds();
                soil_thresholds.setSoil_threshold_id(resultSet.getInt("soil_threshold_id"));
                soil_thresholds.setLab_id(resultSet.getInt("lab_id"));
                soil_thresholds.setExtraction_method_id(resultSet.getInt("extraction_method_id"));
                soil_thresholds.setParameters_id(resultSet.getInt("parameter_id"));
                soil_thresholds.setUom_id(resultSet.getInt("uom_id"));
                soil_thresholds.setVery_low_threshold(resultSet.getDouble("very_low_threshold"));
                soil_thresholds.setLow_threshold(resultSet.getDouble("low_threshold"));
                soil_thresholds.setHigh_threshold(resultSet.getDouble("high_threshold"));
                soil_thresholds.setVery_high_threshold(resultSet.getDouble("very_high_threshold"));
                soil_thresholds.setTarget_value(resultSet.getDouble("target_value"));
                soil_thresholdsList.add(soil_thresholds);
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
        return soil_thresholdsList;
    }

    /**
     * insert all soil thresholds records that are supposed to be in the database initially.
     * they are read directly from the excel file, using the ERsoil_thresholds class.
     * note: additional soil thresholds records can be added through the insert method.
     */
    public void autoInsertAll(){
        ERsoil_thresholds ERst = new ERsoil_thresholds();
        List<soil_thresholds> soil_thresholdsList = ERst.readExcelData();
        for (soil_thresholds st : soil_thresholdsList){
            this.insert(st);
            System.out.println("INSERT:: " + st + "/n");
        }

    }
}
