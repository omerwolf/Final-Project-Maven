package DB.DaoImpl;

import DB.Dao.LabAnalysisResultDao;
import DB.Entites.LabAnalysisResult;
import DB.Util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class LabAnalysisResultDaoImpl implements LabAnalysisResultDao {

    @Override
    public void insert(LabAnalysisResult labAnalysisResult) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=0");
            preparedStatement = connection.prepareStatement("INSERT INTO lab_analysis_results " +
                    "(tissue_analysis_id," +
                    "soil_analysis_id," +
                    "water_analysis_id," +
                    "parameter_id," +
                    "parameter_value)" +
                    "VALUES (?, ?, ?, ?, ?)");
            if(labAnalysisResult.getTissue_analysis_id() == null && labAnalysisResult.getWater_analysis_id() == null) {
                preparedStatement = connection.prepareStatement("INSERT INTO lab_analysis_results " +
                        "(soil_analysis_id," +
                        "parameter_id," +
                        "parameter_value)" +
                        "VALUES (?, ?, ?)");
                preparedStatement.setInt(1, labAnalysisResult.getSoil_analysis_id());
            } else if(labAnalysisResult.getTissue_analysis_id() == null && labAnalysisResult.getSoil_analysis_id() == null){
                preparedStatement = connection.prepareStatement("INSERT INTO lab_analysis_results " +
                        "(water_analysis_id," +
                        "parameter_id," +
                        "parameter_value)" +
                        "VALUES (?, ?, ?)");
                preparedStatement.setInt(1, labAnalysisResult.getWater_analysis_id());
            }else if(labAnalysisResult.getWater_analysis_id() == null && labAnalysisResult.getSoil_analysis_id() == null){
                preparedStatement = connection.prepareStatement("INSERT INTO lab_analysis_results " +
                        "(tissue_analysis_id," +
                        "parameter_id," +
                        "parameter_value) " +
                        "VALUES (?, ?, ?)");
                preparedStatement.setInt(1, labAnalysisResult.getTissue_analysis_id());
            }else {
               System.out.println("more or less null lab analysis id");
            }

            preparedStatement.setInt(2, labAnalysisResult.getParameter_id());
            preparedStatement.setDouble(3, labAnalysisResult.getParameter_value());
            preparedStatement.executeUpdate();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=1");
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
    public void insertAll(List<LabAnalysisResult> labAnalysisResultList) {
        for (LabAnalysisResult lar : labAnalysisResultList){
            this.insert(lar);
        }
        System.out.println("finish insertAll to lab_analysis_results");
    }
}
