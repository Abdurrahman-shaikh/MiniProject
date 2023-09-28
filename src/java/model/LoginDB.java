package model;

import java.sql.*;

public class LoginDB {

    private String myEmail;
    private String password;
    private boolean isAuthenticated;

    public void setMyEmail(String myEmail) {
        this.myEmail = myEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void login() throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/miniprojectdb?useSSL=false&allowPublicKeyRetrieval=true"; // Add allowPublicKeyRetrieval=true
        String user = "azmi";
        String pass = "Pass@#11221";
        String query = "SELECT * FROM login_table WHERE email = ? AND password = ?";
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement pstmt = con.prepareStatement(query);

            // Set parameters for the query
            pstmt.setString(1, myEmail);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            // Check if a row was returned (authentication successful)
            isAuthenticated = rs.next();

            con.close(); // Close the connection when done

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any SQL exceptions here
        }
    }
}
