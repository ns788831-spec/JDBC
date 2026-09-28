package Assignment19;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReadData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection cc = Database.getConnection();

        String sql = "select * from students";

        PreparedStatement ss = cc.prepareStatement(sql);

        ResultSet rs = ss.executeQuery();

        System.out.println("ID\tName\tMarks");

        while (rs.next()) {
            System.out.println(
            rs.getInt(1) + "\t" +
            rs.getString(2) + "\t" +
            rs.getInt(3)
            );
        }

        cc.close();
        
    }
}
