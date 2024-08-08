import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDataBase {
    static final String URL = "jdbc:mysql://localhost:3306/studentmanager";
    static final String User = "root";
    static final String Pass = "123456";

    public static Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, User, Pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
