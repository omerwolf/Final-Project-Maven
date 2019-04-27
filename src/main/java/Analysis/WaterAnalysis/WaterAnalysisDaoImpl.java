package Analysis.WaterAnalysis;

import DB.Util.ConnectionConfiguration;

import java.sql.*;

public class WaterAnalysisDaoImpl implements WaterAnalysisDao {
    @Override
    public void insert(WaterAnalysis waterAnalyses) {
        //convert LocalDate to SQL Date
        Date date = Date.valueOf(waterAnalyses.getSample_date());

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=0");
            preparedStatement = connection.prepareStatement("INSERT INTO `water_lab_analysis`" +
                            "(`water_analysis_id`," +
                            "`farm_id`," +
                            "`sample_date`," +
                            "`sample_name`," +
                            "`ib_id`," +
                            "`water_EC`," +
                            "`water_pH`)" +
                    "VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, waterAnalyses.getWater_analysis_id());
            preparedStatement.setInt(2, waterAnalyses.getFarm_id());
            preparedStatement.setDate(3, date);
            preparedStatement.setString(4, waterAnalyses.getSample_name());
            preparedStatement.setInt(5, waterAnalyses.getIb_id());
            preparedStatement.setDouble(6, waterAnalyses.getWater_EC());
            preparedStatement.setDouble(7, waterAnalyses.getWater_pH());
            preparedStatement.executeUpdate();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=1");
            System.out.println("inserted : " + waterAnalyses);
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
/*
    @Override
    public WaterAnalysis selectById(int id) {
        return null;
    }

    @Override
    public List<WaterAnalysis> selectAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(WaterAnalysis waterAnalyses, int id) {

    }

    @Override
    public int generateUniqueId() {
        return 0;
    }

    @Override
    public void insertAll(List<WaterAnalysis> waterAnalysesList) {

    }

    @Override
    public void autoInsertAll() {

    }
    */
}
