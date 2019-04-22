package DB.DaoImpl;

import DB.Dao.layer_depth_typeDao;
import DB.Entites.layer_depth_type;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class layer_depth_typeDaoImpl implements layer_depth_typeDao{

    @Override
    public void insert(layer_depth_type layerDepthType) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=0");
            preparedStatement = connection.prepareStatement("INSERT INTO layer_depth_type" +
                    "(`layer_depth_id`," +
                    "`layer_depth_name`," +
                    "`layer_min`," +
                    "`layer_max`) " +
                    "VALUES (?,?,?,?)");
            preparedStatement.setInt(1, layerDepthType.getLayer_depth_id());
            preparedStatement.setString(2, layerDepthType.getLayer_depth_name());
            preparedStatement.setShort(3, layerDepthType.getLayer_min());
            preparedStatement.setShort(4, layerDepthType.getLayer_max());
            preparedStatement.executeUpdate();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=1");
            System.out.println("Insert: " + layerDepthType.getLayer_depth_name());
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
    public layer_depth_type selectById(int id) {
        layer_depth_type layerDepthType = new layer_depth_type();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM layer_depth_type WHERE layer_depth_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                layerDepthType.setLayer_depth_id(resultSet.getInt("layer_depth_id"));
                layerDepthType.setLayer_depth_name(resultSet.getString("layer_depth_name"));
                layerDepthType.setLayer_min(resultSet.getShort("layer_min"));
                layerDepthType.setLayer_max(resultSet.getShort("layer_max"));
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
        return layerDepthType;
    }

    @Override
    public List<layer_depth_type> selectAll() {
        List<layer_depth_type> layerDepthTypes = new ArrayList<layer_depth_type>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM layer_depth_type");

            while (resultSet.next()) {
                layer_depth_type layerDepthType = new layer_depth_type();
                layerDepthType.setLayer_depth_id(resultSet.getInt("layer_depth_id"));
                layerDepthType.setLayer_depth_name(resultSet.getString("layer_depth_name"));
                layerDepthType.setLayer_min(resultSet.getShort("layer_min"));
                layerDepthType.setLayer_max(resultSet.getShort("layer_max"));
                layerDepthTypes.add(layerDepthType);
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
        return layerDepthTypes;
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM layer_depth_type WHERE layer_depth_id = ?");
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
    public void update(layer_depth_type layerDepthType, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE layer_depth_type SET " +
                    "(`layer_depth_id`," +
                    "`layer_depth_name`," +
                    "`layer_min`," +
                    "`layer_max`) " +
                    "WHERE layer_depth_id = ?");

            preparedStatement.setInt(1, layerDepthType.getLayer_depth_id());
            preparedStatement.setString(2, layerDepthType.getLayer_depth_name());
            preparedStatement.setShort(3, layerDepthType.getLayer_min());
            preparedStatement.setShort(4, layerDepthType.getLayer_max());
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
            resultSet = statement.executeQuery("SELECT * FROM layer_depth_type");



            while (resultSet.next()) {
                emptySpace = resultSet.getInt("layer_depth_id") + 1;

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
    public void insertAll(List<layer_depth_type> layerDepthTypeList) {

        for (layer_depth_type layerDepthType : layerDepthTypeList) {
            layerDepthType.setLayer_depth_id(this.generateUniqueId());
            this.insert(layerDepthType);
        }
        System.out.println("InsertAll finished");
    }

    @Override
    public void autoInsertAll() {
        layer_depth_type ldt1 = new layer_depth_type("0-30",(short)0,(short)30);
        layer_depth_type ldt2 = new layer_depth_type("0-15",(short)0,(short)15);
        layer_depth_type ldt3 = new layer_depth_type("15-30",(short)15,(short)30);
        layer_depth_type ldt4 = new layer_depth_type("30-60",(short)30,(short)60);
        layer_depth_type ldt5 = new layer_depth_type("30-45",(short)30,(short)45);
        layer_depth_type ldt6 = new layer_depth_type("45-60",(short)45,(short)60);
        layer_depth_type ldt7 = new layer_depth_type("60-90",(short)60,(short)90);
        layer_depth_type ldt8 = new layer_depth_type("60-75",(short)60,(short)75);
        layer_depth_type ldt9 = new layer_depth_type("75-90",(short)75,(short)90);
        List<layer_depth_type> layerDepthTypeList = new ArrayList<>();
        layerDepthTypeList.add(ldt1);
        layerDepthTypeList.add(ldt2);
        layerDepthTypeList.add(ldt3);
        layerDepthTypeList.add(ldt4);
        layerDepthTypeList.add(ldt5);
        layerDepthTypeList.add(ldt6);
        layerDepthTypeList.add(ldt7);
        layerDepthTypeList.add(ldt8);
        layerDepthTypeList.add(ldt9);
        this.insertAll(layerDepthTypeList);
    }
}
