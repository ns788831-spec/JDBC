package Assignment19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HospitalLogin {

    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {

        Scanner sc = new Scanner(System.in);

        Connection con = Database.getConnection();

        System.out.print("Enter Login ID: ");
        String loginId = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        String sql =
                "SELECT * FROM hospital_staff " +
                "WHERE login_id = ? AND password = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, loginId);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            String name = rs.getString("name");
            String role = rs.getString("role");

            System.out.println("Login successful.");
            System.out.println("Welcome, " + name);
            System.out.println("Role: " + role);

            if (role.equalsIgnoreCase("Doctor")) {
                System.out.println("Doctor access granted.");
            } else if (role.equalsIgnoreCase("Nurse")) {
                System.out.println("Nurse access granted.");
            }

        } else {
            System.out.println("Invalid Login ID or Password.");
            System.out.println("Access denied.");
        }

        rs.close();
        ps.close();
        con.close();
        sc.close();
    }
}