package Assignment19;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionStatus {

    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {

        Connection con = Database.getConnection();

        if (con != null && !con.isClosed()) {
            System.out.println("Database connected successfully.");
        } else {
            System.out.println("Database connection failed.");
        }

        con.close();
    }
}