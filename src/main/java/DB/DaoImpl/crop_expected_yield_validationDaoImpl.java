package DB.DaoImpl;

import DB.Dao.crop_expected_yield_validationDao;
import DB.Entites.crop_expected_yield_validation;
import DB.Entites.variety_type;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class crop_expected_yield_validationDaoImpl implements crop_expected_yield_validationDao {
    @Override
    public void insert(crop_expected_yield_validation expYield) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO crop_expected_yield_validation" +
                    " (validation_id,crop_id,variety_id,min_yield,max_yield)" +
                    "VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, expYield.getValidation_id());
            preparedStatement.setInt(2, expYield.getCrop_id());
            preparedStatement.setInt(3, expYield.getVariety_id());
            preparedStatement.setDouble(4, expYield.getMin_yield());
            preparedStatement.setDouble(5, expYield.getMax_yield());
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
    public crop_expected_yield_validation selectById(int id) {
        crop_expected_yield_validation expYield = new crop_expected_yield_validation();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM crop_expected_yield_validation " +
                    "WHERE validation_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                expYield.setValidation_id(resultSet.getInt("validation_id"));
                expYield.setCrop_id(resultSet.getInt("crop_id"));
                expYield.setVariety_id(resultSet.getInt("variety_id"));
                expYield.setMin_yield(resultSet.getDouble("min_yield"));
                expYield.setMax_yield(resultSet.getDouble("max_yield"));
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
        return expYield;
    }

    @Override
    public List<crop_expected_yield_validation> selectAll() {
        List<crop_expected_yield_validation> crops = new ArrayList<crop_expected_yield_validation>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM crop_expected_yield_validation");

            while (resultSet.next()) {
                crop_expected_yield_validation expYield = new crop_expected_yield_validation();
                expYield.setValidation_id(resultSet.getInt("validation_id"));
                expYield.setCrop_id(resultSet.getInt("crop_id"));
                expYield.setVariety_id(resultSet.getInt("variety_id"));
                expYield.setMin_yield(resultSet.getDouble("min_yield"));
                expYield.setMax_yield(resultSet.getDouble("max_yield"));
                crops.add(expYield);
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
        return crops;
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM crop_expected_yield_validation" +
                    " WHERE validation_id = ?");
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
    public void update(crop_expected_yield_validation expYield, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE crop_expected_yield_validation SET " +
                    "validation_id = ? crop_id = ? variety_id = ? min_yield = ? max_yield = ? WHERE validation_id = ?");

            preparedStatement.setInt(1, expYield.getValidation_id());
            preparedStatement.setInt(2, expYield.getCrop_id());
            preparedStatement.setInt(3, expYield.getVariety_id());
            preparedStatement.setDouble(4, expYield.getMin_yield());
            preparedStatement.setDouble(5, expYield.getMax_yield());
            preparedStatement.setInt(6, id);
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
        return 0;
    }

    @Override
    public void insertAll(List<crop_expected_yield_validation> expYield) {
        for (crop_expected_yield_validation yield : expYield) {
            this.insert(yield);
        }
        System.out.println("InsertAll finished");
    }

    @Override
    public void autoInsertAll() {
        crop_expected_yield_validation c1 = new crop_expected_yield_validation(1,1,15,20,120);
        crop_expected_yield_validation c2 = new crop_expected_yield_validation(2,2,11,6,30);
        crop_expected_yield_validation c3 = new crop_expected_yield_validation(3,3,16,0.5,3.5);
        crop_expected_yield_validation c4 = new crop_expected_yield_validation(4,4,1,7,45);
        crop_expected_yield_validation c5 = new crop_expected_yield_validation(5,5,4,40,200);
        crop_expected_yield_validation c6 = new crop_expected_yield_validation(6,6,2,1,6);
        crop_expected_yield_validation c7 = new crop_expected_yield_validation(7,6,3,2,10);
        crop_expected_yield_validation c8 = new crop_expected_yield_validation(8,7,7,1,5);
        crop_expected_yield_validation c9 = new crop_expected_yield_validation(9,8,8,50,170);
        crop_expected_yield_validation c10 = new crop_expected_yield_validation(10,9,20,20,60);
        crop_expected_yield_validation c11 = new crop_expected_yield_validation(11,10,21,4,10);
        crop_expected_yield_validation c12 = new crop_expected_yield_validation(12,11,23,5,45);
        crop_expected_yield_validation c13 = new crop_expected_yield_validation(13,12,22,25,125);
        crop_expected_yield_validation c14 = new crop_expected_yield_validation(14,13,25,25,150);
        crop_expected_yield_validation c15 = new crop_expected_yield_validation(15,14,24,15,50);
        crop_expected_yield_validation c16 = new crop_expected_yield_validation(16,15,26,15,60);


        List<crop_expected_yield_validation> expYield = new ArrayList<crop_expected_yield_validation>();
        expYield.add(c1);
        expYield.add(c2);
        expYield.add(c3);
        expYield.add(c4);
        expYield.add(c5);
        expYield.add(c6);
        expYield.add(c7);
        expYield.add(c8);
        expYield.add(c9);
        expYield.add(c10);
        expYield.add(c11);
        expYield.add(c12);
        expYield.add(c13);
        expYield.add(c14);
        expYield.add(c15);
        expYield.add(c16);

        this.insertAll(expYield);
    }

    @Override
    public List<Integer> getMatchVarType(int cropTypeId) {
        List<crop_expected_yield_validation> expYield = this.selectAll();
        List<Integer> matchVarType = new ArrayList<>();
        for (crop_expected_yield_validation exp : expYield) {
            if (exp.getCrop_id() == cropTypeId) {
                matchVarType.add(exp.getVariety_id());
            }
        }
        return matchVarType;
    }
}
