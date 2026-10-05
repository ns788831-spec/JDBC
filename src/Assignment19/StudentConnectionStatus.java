package Assignment19;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentConnectionStatus {

    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {

        Connection con = Database.getConnection();

        if (con != null && !con.isClosed()) {

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT 1");

            if (rs.next()) {
                System.out.println(
                    "Student database is connected successfully."
                );
            }

            rs.close();
            stmt.close();
            con.close();

        } else {
            System.out.println("Student database connection failed.");
        }
    }
}