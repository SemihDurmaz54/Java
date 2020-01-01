package tempProject;

import java.sql.*;

public class update {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme1", "root", "");

            // create the java mysql update preparedstatement
            String query = "update müsteri set isim = ? where mid = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, "Aliiiiiiiiiiiiiiiiim");
            preparedStmt.setInt(2, 5);
            preparedStmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}
