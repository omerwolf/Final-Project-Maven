package DB.DaoImpl;

import DB.Dao.elementsDao;
import DB.Entites.elements;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class elementsDaoImpl implements elementsDao{
    @Override
    public void insert(elements element) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=0");
            preparedStatement = connection.prepareStatement("INSERT INTO elements" +
                    "(`element_id`," +
                    "`symbol`," +
                    "`description`) " +
                    "VALUES (?,?,?)");
            preparedStatement.setInt(1, element.getElement_id());
            preparedStatement.setString(2, element.getSymbol());
            preparedStatement.setString(3, element.getDescription());
            preparedStatement.executeUpdate();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=1");
            System.out.println("Insert: " + element.getDescription());
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
    public elements selectById(int id) {
        elements element = new elements();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM elements WHERE element_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                element.setElement_id(resultSet.getInt("element_id"));
                element.setSymbol(resultSet.getString("symbol"));
                element.setDescription(resultSet.getString("description"));
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
        return element;
    }

    @Override
    public List<elements> selectAll() {
        List<elements> elements = new ArrayList<elements>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM elements");

            while (resultSet.next()) {
                elements element = new elements();
                element.setElement_id(resultSet.getInt("element_id"));
                element.setSymbol(resultSet.getString("symbol"));
                element.setDescription(resultSet.getString("description"));
                elements.add(element);
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
        return elements;
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM elements WHERE element_id = ?");
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
    public void update(elements element, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE elements SET " +
                    "(`element_id`," +
                    "`symbol`," +
                    "`description`) " +
                    "WHERE element_id = ?");

            preparedStatement.setInt(1, element.getElement_id());
            preparedStatement.setString(2, element.getSymbol());
            preparedStatement.setString(3, element.getDescription());
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
            resultSet = statement.executeQuery("SELECT * FROM elements");



            while (resultSet.next()) {
                emptySpace = resultSet.getInt("element_id") + 1;

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
    public void insertAll(List<elements> elements) {
        //soils.sort((Soil s1, Soil s2) -> s1.getName().compareTo(s2.getName()));

        for (elements element : elements) {
            element.setElement_id(this.generateUniqueId());
            this.insert(element);
        }
        System.out.println("InsertAll finished");
    }

    @Override
    public void autoInsertAll() {
        elements e1 = new elements("N","Nitrogen");
        elements e2 = new elements("P","Phosphorus");
        elements e3 = new elements("K","Potassium");
        elements e4 = new elements("Ca","Calcium");
        elements e5 = new elements("Mg","Magnesium");
        elements e6 = new elements("S","Sulfur");
        elements e7 = new elements("Fe","Iron");
        elements e8 = new elements("Mn","Manganese");
        elements e9 = new elements("B","Boron");
        elements e10 = new elements("Zn","Zinc");
        elements e11 = new elements("Cu","Copper");
        elements e12 = new elements("Mo","Molybdenum");
        elements e13 = new elements("N-NH4","Ammoniacal Nitrogen");
        elements e14 = new elements("N-NO3","Nitrate Nitrogen");
        elements e15 = new elements("N-NH2","Ureic Nitrogen");
        elements e16 = new elements("Cl","Chloride");
        elements e17 = new elements("Na","Sodium");
        elements e18 = new elements("HCO3","Bicarbonate");
        elements e19 = new elements("Al","Aluminum");
        List<elements> elements = new ArrayList<>();
        elements.add(e1);
        elements.add(e2);
        elements.add(e3);
        elements.add(e4);
        elements.add(e5);
        elements.add(e6);
        elements.add(e7);
        elements.add(e8);
        elements.add(e9);
        elements.add(e10);
        elements.add(e11);
        elements.add(e12);
        elements.add(e13);
        elements.add(e14);
        elements.add(e15);
        elements.add(e16);
        elements.add(e17);
        elements.add(e18);
        elements.add(e19);
        this.insertAll(elements);
    }
}
