package Analysis.WaterAnalysis;

import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.time.LocalDate;

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
                            "`is_active`," +
                            "`farm_id`," +
                            "`sample_date`," +
                            "`sample_name`," +
                            "`ib_id`," +
                            "`water_EC`," +
                            "`water_pH`)" +
                    "VALUES (?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, waterAnalyses.getWater_analysis_id());
            preparedStatement.setBoolean(2, waterAnalyses.getIs_active());
            preparedStatement.setInt(3, waterAnalyses.getFarm_id());
            preparedStatement.setDate(4, date);
            preparedStatement.setString(5, waterAnalyses.getSample_name());
            preparedStatement.setInt(6, waterAnalyses.getIb_id());
            preparedStatement.setDouble(7, waterAnalyses.getWater_EC());
            preparedStatement.setDouble(8, waterAnalyses.getWater_pH());
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

    @Override
    public WaterAnalysis selectById(int id) {
        WaterAnalysis waterAnalysis = new WaterAnalysis();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM water_lab_analysis WHERE water_analysis_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                waterAnalysis.setWater_analysis_id(resultSet.getInt("water_analysis_id"));
                waterAnalysis.setIs_active(resultSet.getBoolean("is_active"));
                waterAnalysis.setFarm_id(resultSet.getInt("farm_id"));
                //convert sql date to local date
                Date date = resultSet.getDate("sample_date");
                LocalDate localdate = date.toLocalDate();
                waterAnalysis.setSample_date(localdate);
                waterAnalysis.setSample_name(resultSet.getString("sample_name"));
                waterAnalysis.setIb_id(resultSet.getInt("ib_id"));
                waterAnalysis.setWater_EC(resultSet.getDouble("water_EC"));
                waterAnalysis.setWater_pH(resultSet.getDouble("water_pH"));
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
        return waterAnalysis;
    }

/*  @Override
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
