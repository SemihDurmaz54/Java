package tempProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class select_single {

    public static void main(String[] args) {
        try {
            int b = 5;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme1", "root", "");
            String query = "SELECT * FROM müsteri where mid = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, 5);
            try (ResultSet rs = preparedStmt.executeQuery()) {
                int mid = rs.getInt("mid");
                String isim = rs.getString("isim");
                String email = rs.getString("email");
                // print the results
                System.out.format("%s, %s, %s \n", mid, isim, email);
            }
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}
