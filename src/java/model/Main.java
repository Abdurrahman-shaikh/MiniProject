package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/miniprojectdb?useSSL=false";
        String username = "azmi"; // Replace with your MySQL username
        String password = "Pass@#11221"; // Replace with your MySQL password

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Define the SQL query to insert data into the user_table
            String sql = "INSERT INTO user_table (email, firstname, lastname, dob, mobileno, gender) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";

            // Create a PreparedStatement to execute the query
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                // Set the values for the placeholders in the query
                pstmt.setString(1, "example@email1.com");
                pstmt.setString(2, "John");
                pstmt.setString(3, "Doe");
                pstmt.setString(4, "1990-01-01");
                pstmt.setString(5, "1234567890");
                pstmt.setInt(6, 1); // Assuming 1 represents male and 2 represents female

                // Execute the query to insert data
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Data inserted successfully into user_table.");
                } else {
                    System.out.println("Data insertion into user_table failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors
        }
    }
}
