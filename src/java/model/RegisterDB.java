package model;
import java.sql.*;

public class RegisterDB {

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

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);

            String getMaxUidSQL = "SELECT MAX(uid) FROM user_table";
            pstmt = conn.prepareStatement(getMaxUidSQL);
            rs = pstmt.executeQuery();
            int maxUid = 0;
            if (rs.next()) {
                maxUid = rs.getInt(1);
            }

            int nextUid = maxUid + 1;

            String sql = "INSERT INTO user_table (uid, firstname, lastname, dob, mobileno, gender, email) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, nextUid); // Use the manually incremented uid
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, dob);
            pstmt.setString(5, mobileno);
            pstmt.setInt(6, gender);
            pstmt.setString(7, email);
            rowsAffected = pstmt.executeUpdate();
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
