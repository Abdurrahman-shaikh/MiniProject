package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyDb {

    private String firstName;
    private String lastName;
    private String dob;
    private String mobileno;
    private int gender;
    private String email;
    private int rowsAffected;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int isAffected() {
        return rowsAffected;
    }

    public void insertUserData() {
        String url = "jdbc:mysql://localhost:3306/miniprojectdb?useSSL=false";
        String username = "azmi";
        String password = "Pass@#11221";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO user_table (firstname, lastname, dob, mobileno, gender, email) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, dob);
            pstmt.setString(4, mobileno);
            pstmt.setInt(5, gender);
            pstmt.setString(6, email);

            rowsAffected = pstmt.executeUpdate(); // Get the number of rows affected

            conn.close(); // Close the connection when done
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle exceptions and database errors
        }
    }
}
