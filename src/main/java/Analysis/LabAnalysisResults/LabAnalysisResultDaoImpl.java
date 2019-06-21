package Analysis.LabAnalysisResults;

import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * implements the labAnalysisResultDao interface.
 * responsible for all the actions on the 'lab_analysis_result'
 */
public class LabAnalysisResultDaoImpl implements LabAnalysisResultDao {
    /**
     * inserts a water lab analysis result record into the lab_analysis_results table
     * in the db.
     * @param waterLabAnalysisResult - the water lab analysis result to insert.
     */
    @Override
    public void insertWater(WaterLabAnalysisResult waterLabAnalysisResult) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=0");
            preparedStatement = connection.prepareStatement("INSERT INTO lab_analysis_results " +
                    "(water_analysis_id," +
                    "parameter_id," +
                    "parameter_value) " +
                    "VALUES (?, ?, ?)");
            preparedStatement.setInt(1, waterLabAnalysisResult.getWater_analysis_id());
            preparedStatement.setInt(2, waterLabAnalysisResult.getParameter_id());
            preparedStatement.setDouble(3, waterLabAnalysisResult.getParameter_value());
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
    /**
     * receives a list of water lab analysis results records, and inserts them
     * to the db.
     * @param waterLabAnalysisResultList - a list of water lab analysis result records
     */
    public void insertAllWater(List<WaterLabAnalysisResult> waterLabAnalysisResultList) {
        for (WaterLabAnalysisResult lar : waterLabAnalysisResultList){
            this.insertWater(lar);
        }
        System.out.println("finish insertAll to lab_analysis_results");
    }


    /**
     * inserts a soil lab analysis result record into the lab_analysis_results table
     * in the db.
     * @param soilLabAnalysisResult - the soil lab analysis result to insert.
     */
    @Override
    public void insertSoil (SoilLabAnalysisResult soilLabAnalysisResult){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=0");
            preparedStatement = connection.prepareStatement("INSERT INTO lab_analysis_results " +
                    "(soil_analysis_id," +
                    "parameter_id," +
                    "parameter_value," +
                    "extraction_method_id)" +
                    "VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, soilLabAnalysisResult.getSoil_analysis_id());
            preparedStatement.setInt(2, soilLabAnalysisResult.getParameter_id());
            preparedStatement.setDouble(3, soilLabAnalysisResult.getParameter_value());
            preparedStatement.setInt(4,soilLabAnalysisResult.getExtraction_method_id());
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
    /**
     * receives a list of soil lab analysis results records, and inserts them
     * to the db.
     * @param soilLabAnalysisResultList - a list of water lab analysis result records
     */
    @Override
    public void insertAllSoil (List < SoilLabAnalysisResult > soilLabAnalysisResultList) {
        for (SoilLabAnalysisResult lar : soilLabAnalysisResultList) {
            this.insertSoil(lar);
        }
        System.out.println("finish insertAll to lab_analysis_results");
    }
    /**
     * returns a list of soil lab analysis results that has the given soil analysis id.
     * @param soilAnalasisId - the id of the soil lab results to extract from the db.
     * @return a list of all soil lab results with the same given id.
     */
    @Override
    public List<SoilLabAnalysisResult> selectAllSoilById(int soilAnalasisId) {
        List<SoilLabAnalysisResult> results = new ArrayList<SoilLabAnalysisResult>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `lab_analysis_results` WHERE soil_analysis_id = " + soilAnalasisId);

            while (resultSet.next()) {
                SoilLabAnalysisResult result = new SoilLabAnalysisResult();
                result.setLab_results_id(resultSet.getInt("lab_results_id"));
                result.setSoil_analysis_id(resultSet.getInt("soil_analysis_id"));
                result.setParameter_id(resultSet.getInt("parameter_id"));
                result.setParameter_value(resultSet.getInt("parameter_value"));
                result.setExtraction_method_id(resultSet.getInt("extraction_method_id"));
                results.add(result);
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
        return results;
    }
    /**
     * returns a list of water lab analysis results that has the given water analysis id.
     * @param waterAnalasisId - the id of the water lab results to extract from the db.
     * @return a list of all water lab results with the same given id.
     */
    @Override
    public List<WaterLabAnalysisResult> selectAllWaterById(int waterAnalasisId) {
        List<WaterLabAnalysisResult> results = new ArrayList<WaterLabAnalysisResult>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `lab_analysis_results` WHERE water_analysis_id = " + waterAnalasisId);

            while (resultSet.next()) {
                WaterLabAnalysisResult result = new WaterLabAnalysisResult();
                result.setLab_results_id(resultSet.getInt("lab_results_id"));
                result.setWater_analysis_id(resultSet.getInt("water_analysis_id"));
                result.setParameter_id(resultSet.getInt("parameter_id"));
                result.setParameter_value(resultSet.getInt("parameter_value"));
                results.add(result);
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
        return results;
    }

}