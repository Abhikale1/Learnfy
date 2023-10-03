import java.sql.*;

public class Login {
    public static void main(String[] args) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // database connection here
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "learnify");
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM registration WHERE email = ?");
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String dbPassword = rs.getString("password");
                if (dbPassword.equals(password)) {
                    // valid email and password
                } else {
                    System.out.println("<h2>Invalid Email or Password</h2>");
                }
            } else {
                System.out.println("<h2>Invalid Email or Password</h2>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}