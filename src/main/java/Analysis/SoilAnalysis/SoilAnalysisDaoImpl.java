package Analysis.SoilAnalysis;

import DB.Util.ConnectionConfiguration;

import java.sql.*;

public class SoilAnalysisDaoImpl implements SoilAnalysisDao {

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
                    "`test_type_id`) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
            preparedStatement.setDouble(13, soilAnalysis.getSoil_CEC());
            preparedStatement.setInt(14, soilAnalysis.getTest_type_id());
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

}
