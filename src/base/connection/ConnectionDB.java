package base.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String HOST;
    private static final String PORT;
    private static final String DATABASE;
    private static final String USER;
    private static final String PASSWORD;
    private static final String URL_PARAMS;
    private static final String URL;

    static {
        HOST = "localhost";
        PORT = "3306";
        DATABASE = "tienda";
        USER = "root";
        PASSWORD = "root";
        URL_PARAMS = "?serverTimezone=UTC";
        URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE+URL_PARAMS;
        loadDriver();
    }

    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection succeed");

        }catch (SQLException e){
            System.out.println("cant connect to the database "+DATABASE);
            System.out.println(e.getMessage());
        }
        return connection;
    }

    private static void loadDriver(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println("Error loading the driver");
            System.exit(1);
        }
    }

}
