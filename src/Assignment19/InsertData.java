package Assignment19;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class InsertData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner ss = new Scanner(System.in);
        Connection cc = Database.getConnection();

        System.out.print("Enter the name of the student: ");
        String name = ss.nextLine();

        System.out.print("Enter the marks of the student: ");
        int marks = ss.nextInt();
        ss.nextLine(); 

        String sql = "insert into students(name, marks) values(?, ?)";

        PreparedStatement ps = cc.prepareStatement(sql);
        ps.setString(1, name);
        ps.setInt(2, marks);

        int i = ps.executeUpdate();
        if (i > 0) {
            System.out.println("Data inserted successfully!");
        } else {
            System.out.println("Data insertion failed.");
        }
        ss.close();
        cc.close();
    }

}
