package bd.edu.seu.scenepractice.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static final String DB_HOST="localhost";
    private static final  String DB_NAME="hotel";
    private static final String DB_USER_NAME="root";
    private static final  String DB_PASSWORD="windo12@sql#";
    private static final String DB_URL="jdbc:mysql://" +DB_HOST+"/" + DB_NAME;


    private static Connection connection;

 //object
    private static SingletonConnection singleton=new SingletonConnection();

 //constructor
    private SingletonConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
 //getter


    public static Connection getConnection() {
        return connection;
    }
}
