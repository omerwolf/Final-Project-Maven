package DB.DaoImpl;

import DB.Dao.ExtractionMethodDao;
import DB.Entites.ExtractionMethod;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExtractionMethodDaoImpl implements ExtractionMethodDao {
    @Override
    public void insert(ExtractionMethod em) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO extraction_methods" +
                    " (extraction_method_id,extraction_method_desc) " +
                    "VALUES (?, ?)");
            preparedStatement.setInt(1, em.getExtraction_method_id());
            preparedStatement.setString(2, em.getExtraction_method_desc());
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
    public void insertAll() {
        this.insert(new ExtractionMethod(1,"Olsen"));
        this.insert(new ExtractionMethod(2, "Ammonium Acetate"));
        this.insert(new ExtractionMethod(3, "KCl 40"));
        this.insert(new ExtractionMethod(4, "DTPA"));
        this.insert(new ExtractionMethod(5, "Hot water"));
        this.insert(new ExtractionMethod(6, "Ammonium Oxalate"));
        this.insert(new ExtractionMethod(7, "Saturated paste"));
        this.insert(new ExtractionMethod(8, "1M KCl"));
        this.insert(new ExtractionMethod(9, "Bray"));
        this.insert(new ExtractionMethod(10, "Melich3"));
        this.insert(new ExtractionMethod(11, "Kjeldahl"));
    }

    @Override
    public List<ExtractionMethod> selectAll() {
        List<ExtractionMethod> extractionMethods = new ArrayList<ExtractionMethod>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM extraction_methods");

            while (resultSet.next()) {
                ExtractionMethod em = new ExtractionMethod();
                em.setExtraction_method_id(resultSet.getInt("extraction_method_id"));
                em.setExtraction_method_desc(resultSet.getString("extraction_method_desc"));
                extractionMethods.add(em);
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
        return extractionMethods;
    }
}
