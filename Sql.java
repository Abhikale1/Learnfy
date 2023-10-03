import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactForm {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/learnify";
        String username = "root";
        String password = "";
        
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            
            String name = args[0];
            String email = args[1];
            String subject = args[2];
            String message = args[3];
            
            String sql = "INSERT INTO contact (name, email, subject, message) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, subject);
            statement.setString(4, message);
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Record inserted successfully!");
            } else {
                System.out.println("Failed to insert record.");
            }
            
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}