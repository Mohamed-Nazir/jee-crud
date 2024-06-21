package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class  DatabaseConnector {
    private static final String url = "jdbc:mysql://localhost:3306/jeedb";
    private static final String username = "root";
    private static final String password = "password";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return con;
    }
}
