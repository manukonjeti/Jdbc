
import java.sql.*;

public class Jdbc {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/exampledb";
        String username = "root";
        String password = "root";

        try {
            // 1. Load the Driver Class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish a Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // 3. Create a Statement
            Statement statement = connection.createStatement();

            // 4. Execute a Query
            String query = "SELECT * FROM employees";
            ResultSet resultSet = statement.executeQuery(query);

            // 5. Process the Results
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Position: " + resultSet.getString("position"));
            }

            // 6. Close Resources
            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
