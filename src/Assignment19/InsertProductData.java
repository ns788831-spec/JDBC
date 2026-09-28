package Assignment19;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class InsertProductData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner ss = new Scanner(System.in);
        Connection cc = Database.getConnection();

        System.out.print("Enter the product ID: ");
        int pID = ss.nextInt();
        ss.nextLine(); 

        System.out.print("Enter the name of the product: ");
        String name = ss.nextLine();

        System.out.print("Enter the quantity of the product: ");
        int qty= ss.nextInt();
        ss.nextLine(); 

        System.out.print("Enter the price of the product: ");
        int price = ss.nextInt();
        ss.nextLine(); 

        String sql = "insert into products(productID, name, qty, price) values(?, ?, ?, ?)";

        PreparedStatement ps = cc.prepareStatement(sql);
        ps.setInt(1, pID);
        ps.setString(2, name);
        ps.setInt(3, qty);
        ps.setInt(4, price);

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
