package Assignment19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
        static String url = "jdbc:mysql://localhost:3306/symbiosis";
        static String user = "root";
        static String password = "Naman@250106";

        public static Connection getConnection() throws ClassNotFoundException, SQLException{
            Connection con = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            return con;
        }
}
