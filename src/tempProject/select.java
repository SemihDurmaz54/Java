package tempProject;

import java.sql.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class select {

    public static void main(String[] args) {
        try {
            int b=5;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme1", "root", "");
            //String query = "SELECT * FROM müsteri where mid = ?";
            String query = "SELECT * FROM müsteri";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            //preparedStmt.setInt(1, 5);
            //preparedStmt.setString(1, "a");
            //Statement st = con.createStatement();

            ResultSet rs = preparedStmt.executeQuery();
            rs.last();
            System.out.println(rs.getRow()); 
            rs.beforeFirst();


            while (rs.next()) {
                int mid = rs.getInt("mid");
                String isim = rs.getString("isim");
                String email = rs.getString("email");
                // print the results
                System.out.format("%s, %s, %s \n", mid, isim, email );
            }
            rs.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}
