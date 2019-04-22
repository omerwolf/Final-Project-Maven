package DB.DaoImpl;

import DB.Dao.SoilDao;
import DB.Entites.Soil;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SoilDaoImpl implements SoilDao {
    @Override
    public void insert(Soil soil) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=0");
            preparedStatement = connection.prepareStatement("INSERT INTO soil_types" +
                    "(`soil_type_id`," +
                    "`soil_type_desc`," +
                    "`n_percent_for_base_dressing`," +
                    "`p_percent_for_base_dressing`," +
                    "`k_percent_for_base_dressing`," +
                    "`annual_som_decomposition_high_temp`," +
                    "`annual_som_decomposition_moderate_temp`," +
                    "`annual_som_decomposition_low_temp`," +
                    "`base_dressing_strategy_id`," +
                    "`rain effect`," +
                    "`default cec`," +
                    "`lower cec`," +
                    "`upper cec`," +
                    "`default bulk density`) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, soil.getId());
            preparedStatement.setString(2, soil.getName());
            preparedStatement.setDouble(3, soil.getnPrecent());
            preparedStatement.setDouble(4, soil.getpPrecent());
            preparedStatement.setDouble(5, soil.getkPrecent());
            preparedStatement.setDouble(6, soil.getSomDecompHigh());
            preparedStatement.setDouble(7, soil.getSomDecompModerate());
            preparedStatement.setDouble(8, soil.getSomDecompLow());
            preparedStatement.setInt(9, soil.getBaseDressingStrategy());
            preparedStatement.setDouble(10, soil.getRainEffect());
            preparedStatement.setInt(11, soil.getDefualtCEC());
            preparedStatement.setInt(12, soil.getLowerCEC());
            preparedStatement.setInt(13, soil.getUpperCEC());
            preparedStatement.setDouble(14, soil.getDefualtBulkDensity());
            preparedStatement.executeUpdate();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=1");
            System.out.println("Insert: " + soil.getName());
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
    public Soil selectById(int id) {
        Soil soil = new Soil();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM soil_types WHERE soil_type_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                soil.setId(resultSet.getInt("soil_type_id"));
                soil.setName(resultSet.getString("soil_type_desc"));
                soil.setnPrecent(resultSet.getDouble("n_percent_for_base_dressing"));
                soil.setpPrecent(resultSet.getDouble("p_percent_for_base_dressing"));
                soil.setkPrecent(resultSet.getDouble("k_percent_for_base_dressing"));
                soil.setSomDecompHigh(resultSet.getDouble("annual_som_decomposition_high_temp"));
                soil.setSomDecompModerate(resultSet.getDouble("annual_som_decomposition_moderate_temp"));
                soil.setSomDecompLow(resultSet.getDouble("annual_som_decomposition_low_temp"));
                soil.setBaseDressingStrategy(resultSet.getInt("base_dressing_strategy_id"));
                soil.setRainEffect(resultSet.getDouble("rain effect"));
                soil.setDefualtCEC(resultSet.getInt("default cec"));
                soil.setLowerCEC(resultSet.getInt("lower cec"));
                soil.setUpperCEC(resultSet.getInt("upper cec"));
                soil.setDefualtBulkDensity(resultSet.getDouble("default bulk density"));
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
        return soil;
    }

    @Override
    public List<Soil> selectAll() {
        List<Soil> soils = new ArrayList<Soil>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM soil_types");

            while (resultSet.next()) {
                Soil soil = new Soil();
                soil.setId(resultSet.getInt("soil_type_id"));
                soil.setName(resultSet.getString("soil_type_desc"));
                soil.setnPrecent(resultSet.getDouble("n_percent_for_base_dressing"));
                soil.setpPrecent(resultSet.getDouble("p_percent_for_base_dressing"));
                soil.setkPrecent(resultSet.getDouble("k_percent_for_base_dressing"));
                soil.setSomDecompHigh(resultSet.getDouble("annual_som_decomposition_high_temp"));
                soil.setSomDecompModerate(resultSet.getDouble("annual_som_decomposition_moderate_temp"));
                soil.setSomDecompLow(resultSet.getDouble("annual_som_decomposition_low_temp"));
                soil.setBaseDressingStrategy(resultSet.getInt("base_dressing_strategy_id"));
                soil.setRainEffect(resultSet.getDouble("rain effect"));
                soil.setDefualtCEC(resultSet.getInt("default cec"));
                soil.setLowerCEC(resultSet.getInt("lower cec"));
                soil.setUpperCEC(resultSet.getInt("upper cec"));
                soil.setDefualtBulkDensity(resultSet.getDouble("default bulk density"));
                soils.add(soil);
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
        return soils;
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM soil_types WHERE soil_type_id = ?");
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
    public void update(Soil soil, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE soil_types SET " +
                    "(`soil_type_id`," +
                    "`soil_type_desc`," +
                    "`n_percent_for_base_dressing`," +
                    "`p_percent_for_base_dressing`," +
                    "`k_percent_for_base_dressing`," +
                    "`annual_som_decomposition_high_temp`," +
                    "`annual_som_decomposition_moderate_temp`," +
                    "`annual_som_decomposition_low_temp`," +
                    "`base_dressing_strategy_id`," +
                    "`rain effect`," +
                    "`default cec`," +
                    "`lower cec`," +
                    "`upper cec`," +
                    "`default bulk density`) " +
                    "WHERE soil_type_id = ?");

            preparedStatement.setInt(1, soil.getId());
            preparedStatement.setString(2, soil.getName());
            preparedStatement.setDouble(3, soil.getnPrecent());
            preparedStatement.setDouble(4, soil.getpPrecent());
            preparedStatement.setDouble(5, soil.getkPrecent());
            preparedStatement.setDouble(6, soil.getSomDecompHigh());
            preparedStatement.setDouble(7, soil.getSomDecompModerate());
            preparedStatement.setDouble(8, soil.getSomDecompLow());
            preparedStatement.setInt(9, soil.getBaseDressingStrategy());
            preparedStatement.setDouble(10, soil.getRainEffect());
            preparedStatement.setInt(11, soil.getDefualtCEC());
            preparedStatement.setInt(12, soil.getLowerCEC());
            preparedStatement.setInt(13, soil.getUpperCEC());
            preparedStatement.setDouble(14, soil.getDefualtBulkDensity());
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
            resultSet = statement.executeQuery("SELECT * FROM soil_types");



            while (resultSet.next()) {
                emptySpace = resultSet.getInt("soil_type_id") + 1;

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
    public void insertAll(List<Soil> soils) {
        soils.sort((Soil s1, Soil s2) -> s1.getName().compareTo(s2.getName()));

        for (Soil soil : soils) {
            soil.setId(this.generateUniqueId());
            this.insert(soil);
        }
        System.out.println("InsertAll finished");
    }

    @Override
    public void autoInsertAll() {
        Soil s1 = new Soil("Sand", .0, 0.15, 0.15, 0.015, 0.01, 0.005, 1, 0.5, 5, 1, 10, 1.71);
        Soil s2 = new Soil("Loamy_sand", 0.1, 0.15, 0.15, 0.015, 0.01, 0.005, 1, 0.45, 8, 5, 13, 1.63);
        Soil s3 = new Soil("Sandy_Loam", 0.1, 0.2, 0.2, 0.015, 0.01, 0.005, 1, 0.35, 10, 5, 13, 1.56);
        Soil s4 = new Soil("Loam", 0.25, 0.4, 0.3, 0.015, 0.01, 0.005, 1, 0.35, 10, 5, 18, 1.42);
        Soil s5 = new Soil("Silt_Loam", 0.2, 0.3, 0.3, 0.015, 0.01, 0.005, 3, 0.3, 15, 8, 22, 1.42);
        Soil s6 = new Soil("Silt", 0.2, 0.25, 0.25, 0.015, 0.01, 0.005, 3, 0.3, 13, 8, 18, 1.52);
        Soil s7 = new Soil("Sandy_Clay_Loam", 0.15, 0.25, 0.25, 0.015, 0.01, 0.005, 3, 0.25, 18, 13, 27, 1.4);
        Soil s8 = new Soil("Clay_Loam", 0.3, 0.6, 0.4, 0.015, 0.01, 0.005, 2, 0.1, 27, 20, 35, 1.32);
        Soil s9 = new Soil("Silty_Clay_Loam", 0.3, 0.45, 0.35, 0.015, 0.01, 0.005, 2, 0.15, 23, 18, 30, 1.27);
        Soil s10 = new Soil("Sandy_Clay", 0.3, 0.45, 0.35, 0.015, 0.01, 0.005, 2, 0.1, 27, 20, 35, 1.32);
        Soil s11 = new Soil("Silty_Clay", 0.3, 0.5, 0.35, 0.015, 0.01, 0.005, 2, 0.1, 27, 20, 35, 1.21);
        Soil s12 = new Soil("Clay", 0.25, 0.4, 0.3, 0.015, 0.01, 0.005, 2, 0.1, 27, 18, 35, 1.19);
        List<Soil> soils = new ArrayList<>();
        soils.add(s1);
        soils.add(s2);
        soils.add(s3);
        soils.add(s4);
        soils.add(s5);
        soils.add(s6);
        soils.add(s7);
        soils.add(s8);
        soils.add(s9);
        soils.add(s10);
        soils.add(s11);
        soils.add(s12);
        this.insertAll(soils);
    }

}
