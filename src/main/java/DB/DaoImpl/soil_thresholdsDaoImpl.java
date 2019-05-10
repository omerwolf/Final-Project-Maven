package DB.DaoImpl;

import DB.Dao.soil_thresholdsDao;
import DB.Entites.soil_thresholds;
import DB.ExcelReadWrite.ERsoil_thresholds;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.List;

public class soil_thresholdsDaoImpl implements soil_thresholdsDao {


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
    public void autoInsertAll(){
        ERsoil_thresholds ERst = new ERsoil_thresholds();
        List<soil_thresholds> soil_thresholdsList = ERst.readExcelData();
        for (soil_thresholds st : soil_thresholdsList){
            this.insert(st);
            System.out.println("INSERT:: " + st + "/n");
        }

    }
}
