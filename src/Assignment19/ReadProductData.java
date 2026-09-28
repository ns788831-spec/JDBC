package Assignment19;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReadProductData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection cc = Database.getConnection();

        String sql = "select * from products";

        PreparedStatement ss = cc.prepareStatement(sql);

        ResultSet rs = ss.executeQuery();

        System.out.println("PID\tName\t\tQty\tPrice");

        while (rs.next()) {
            String name = rs.getString(2);
    
            String namePadding = name.length() < 8 ? "\t\t" : "\t";

            System.out.println(
                rs.getInt(1) + "\t" +
                name + namePadding +
                rs.getInt(3) + "\t" +
                rs.getInt(4)
            );
        }
        cc.close();
        
    }
}
