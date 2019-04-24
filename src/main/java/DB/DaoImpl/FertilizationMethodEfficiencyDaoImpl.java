package DB.DaoImpl;

import DB.Dao.FertilizationMethodEfficiencyDao;
import DB.Entites.FertilizationMethodEfficiency;
import DB.Util.ConnectionConfiguration;
import Tools.ERFertilizationMethodEfficiency;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class FertilizationMethodEfficiencyDaoImpl implements FertilizationMethodEfficiencyDao{
    @Override
    public void insert(FertilizationMethodEfficiency fertilizationMethodEfficiency) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO `fertilization_method_efficiency` " +
                    "(fert_method_efficiency_id," +
                    "fert_method_id," +
                    "parameter_id," +
                    "fert_method_efficiency)" +
                    "VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, fertilizationMethodEfficiency.getFert_method_efficiency_id());
            preparedStatement.setInt(2, fertilizationMethodEfficiency.getFert_method_id());
            preparedStatement.setInt(3, fertilizationMethodEfficiency.getParameter_id());
            preparedStatement.setDouble(4, fertilizationMethodEfficiency.getFert_method_efficiency());
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
    public FertilizationMethodEfficiency selectById(int id) {
        FertilizationMethodEfficiency fertilizationMethodEfficiency = new FertilizationMethodEfficiency();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM `fertilization_method_efficiency` " +
                    "WHERE fert_method_efficiency_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                fertilizationMethodEfficiency.setFert_method_efficiency_id(resultSet.getInt("fert_method_efficiency_id"));
                fertilizationMethodEfficiency.setFert_method_id(resultSet.getInt("fert_method_id"));
                fertilizationMethodEfficiency.setParameter_id(resultSet.getInt("parameter_id"));
                fertilizationMethodEfficiency.setFert_method_efficiency(resultSet.getDouble("fert_method_efficiency"));
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
        return fertilizationMethodEfficiency;
    }

    @Override
    public List<FertilizationMethodEfficiency> selectAll() {
        List<FertilizationMethodEfficiency> fertilizationMethodEfficiencyList = new ArrayList<FertilizationMethodEfficiency>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `fertilization_method_efficiency`");

            while (resultSet.next()) {
                FertilizationMethodEfficiency fertilizationMethodEfficiency = new FertilizationMethodEfficiency();
                fertilizationMethodEfficiency.setFert_method_efficiency_id(resultSet.getInt("fert_method_efficiency_id"));
                fertilizationMethodEfficiency.setFert_method_id(resultSet.getInt("fert_method_id"));
                fertilizationMethodEfficiency.setParameter_id(resultSet.getInt("parameter_id"));
                fertilizationMethodEfficiency.setFert_method_efficiency(resultSet.getDouble("fert_method_efficiency"));
                fertilizationMethodEfficiencyList.add(fertilizationMethodEfficiency);
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
        return fertilizationMethodEfficiencyList;
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM `fertilization_method_efficiency` WHERE fert_method_efficiency_id = ?");
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
    public void update(FertilizationMethodEfficiency fertilizationMethodEfficiency, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE `fertilization_method_efficiency` SET " +
                    "fert_method_id = ?," +
                    "parameter_id = ?," +
                    " fert_method_efficiency = ? WHERE fert_method_efficiency_id = ?");
            preparedStatement.setInt(1, fertilizationMethodEfficiency.getFert_method_id());
            preparedStatement.setInt(2, fertilizationMethodEfficiency.getParameter_id());
            preparedStatement.setDouble(3, fertilizationMethodEfficiency.getFert_method_efficiency());
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
            resultSet = statement.executeQuery("SELECT * FROM `fertilization_method_efficiency`");



            while (resultSet.next()) {
                emptySpace = resultSet.getInt("fert_method_efficiency_id") + 1;

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
    public void insertAll(List<FertilizationMethodEfficiency> fertilizationMethodEfficiencyList) {

        for(FertilizationMethodEfficiency fertilizationMethodEfficiency : fertilizationMethodEfficiencyList) {
            fertilizationMethodEfficiency.setFert_method_efficiency_id(this.generateUniqueId());
            this.insert(fertilizationMethodEfficiency);

        }
        System.out.println("insertAll finished!");
    }

    @Override
    public void autoInsertAll() {
        ERFertilizationMethodEfficiency ERFertilizationMethodEfficiency= new ERFertilizationMethodEfficiency();
        List<FertilizationMethodEfficiency> ERFertilizationMethodEfficiencyList = ERFertilizationMethodEfficiency.readExcelData();
        this.insertAll(ERFertilizationMethodEfficiencyList);
    }
}
