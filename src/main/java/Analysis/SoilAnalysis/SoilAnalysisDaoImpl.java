package Analysis.SoilAnalysis;

import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.time.LocalDate;

/**
 * implements the SoilAnalysisDao interface.
 * responsible for executing actions in the soil_lab_analysis table
 * in the db.
 */
public class SoilAnalysisDaoImpl implements SoilAnalysisDao {

    /**
     * inserts a soil analysis record into the soil_lab_analysis table
     * in the db.
     * @param soilAnalysis - the soil analysis record to insert.
     */
    @Override
    public void insert(SoilAnalysis soilAnalysis) {
        //convert LocalDate to SQL Date
        Date date = Date.valueOf(soilAnalysis.getSample_date());

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=0");
            preparedStatement = connection.prepareStatement("INSERT INTO `soil_lab_analysis`" +
                    "(`sample_name`," +
                    "`soil_analysis_id`," +
                    "`farm_id`," +
                    "`sample_date`," +
                    "`lab_id`," +
                    "`soil_type_id`," +
                    "`layer_depth_id`," +
                    "`irrigation_block_id`," +
                    "`organic_matter`," +
                    "`bulk_density`," +
                    "`soil_pH`," +
                    "`soil_EC`," +
                    "`soil_CEC`," +
                    "`is_active`," +
                    "`test_type_id`) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, soilAnalysis.getSample_name());
            preparedStatement.setInt(2, soilAnalysis.getSoil_analysis_id());
            preparedStatement.setInt(3, soilAnalysis.getFarm_id());
            preparedStatement.setDate(4, date);
            preparedStatement.setInt(5, soilAnalysis.getLab_id());
            preparedStatement.setInt(6, soilAnalysis.getSoil_type_id());
            preparedStatement.setInt(7, soilAnalysis.getLayer_depth_id());
            preparedStatement.setInt(8, soilAnalysis.getIrrigation_block_id());
            preparedStatement.setDouble(9, soilAnalysis.getOrganic_matter());
            preparedStatement.setDouble(10, soilAnalysis.getBulk_density());
            preparedStatement.setDouble(11, soilAnalysis.getSoil_pH());
            preparedStatement.setDouble(12, soilAnalysis.getSoil_EC());
            preparedStatement.setDouble(13, soilAnalysis.getSoil_CEC());
            preparedStatement.setBoolean(14, soilAnalysis.isIs_active());
            preparedStatement.setInt(15, soilAnalysis.getTest_type_id());
            preparedStatement.executeUpdate();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=1");
            System.out.println("inserted : " + soilAnalysis);
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
     * @param id - the id of the record that will be selected.
     * @return selected soil analysis record.
     */
    @Override
    public SoilAnalysis selectById(int id) {
        SoilAnalysis soilAnalysis = new SoilAnalysis();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM soil_lab_analysis WHERE soil_analysis_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                soilAnalysis.setSample_name(resultSet.getString("sample_name"));
                soilAnalysis.setSoil_analysis_id(resultSet.getInt("soil_analysis_id"));
                soilAnalysis.setIs_active(resultSet.getBoolean("is_active"));
                soilAnalysis.setFarm_id(resultSet.getInt("farm_id"));
                //convert sql date to local date
                Date date = resultSet.getDate("sample_date");
                LocalDate localdate = date.toLocalDate();
                soilAnalysis.setSample_date(localdate);
                soilAnalysis.setLab_id(resultSet.getInt("lab_id"));
                soilAnalysis.setSoil_type_id(resultSet.getInt("soil_type_id"));
                soilAnalysis.setLayer_depth_id(resultSet.getInt("layer_depth_id"));
                soilAnalysis.setIrrigation_block_id(resultSet.getInt("irrigation_block_id"));
                soilAnalysis.setOrganic_matter(resultSet.getDouble("organic_matter"));
                soilAnalysis.setBulk_density(resultSet.getDouble("bulk_density"));
                soilAnalysis.setSoil_pH(resultSet.getDouble("soil_pH"));
                soilAnalysis.setSoil_EC(resultSet.getDouble("soil_EC"));
                soilAnalysis.setSoil_CEC(resultSet.getDouble("soil_CEC"));
                //soilAnalysis.(resultSet.getInt("test_type_id"));
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
        return soilAnalysis;
    }

}
