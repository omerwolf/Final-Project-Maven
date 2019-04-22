package DB.Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfiguration {

    public static Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab analysis?useSSL=false", "root", "230682");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}

