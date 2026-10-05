package Assignment19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {

    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {

        Scanner sc = new Scanner(System.in);

        Connection con = Database.getConnection();

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        String sql =
                "SELECT * FROM login_users WHERE username = ? AND password = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid username or password.");
        }

        rs.close();
        ps.close();
        con.close();
        sc.close();
    }
}