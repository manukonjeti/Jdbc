import java.sql.*;

public class JdbcCRUD {

    String url = "jdbc:mysql://localhost:3306/exampledb";
    String username = "root";
    String password = "root";
    Connection con;
    Statement st;

    // Constructor to initialize connection and statement
    public JdbcCRUD() {
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            con = DriverManager.getConnection(url, username, password);

            // Create statement
            st = con.createStatement();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Database connection error", e);
        }
    }

    public void insertStudent() {
        String query = "INSERT INTO STUDENTS(id, name) VALUES(101, 'john')";
        try {
            // Execute the query
            int rows = st.executeUpdate(query);
            System.out.println("Rows affected: " + rows);
        } catch (SQLException e) {
            throw new RuntimeException("Error executing query", e);
        }
    }

    public void closeResources() {
        try {
            if (st != null) st.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error closing resources: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JdbcCRUD jdbcCRUD = new JdbcCRUD();  // Initialize connection and statement
        jdbcCRUD.insertStudent();            // Insert a student record
        jdbcCRUD.closeResources();           // Close all resources
    }
}
