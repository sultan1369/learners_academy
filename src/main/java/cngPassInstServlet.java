import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/changePassword2")
public class cngPassInstServlet extends HttpServlet {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/registration";
    private static final String USER = "root";
    private static final String PASS = "sultan1369";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Add validation for new password and confirm password matching
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            
            String sql = "UPDATE instructor SET set_Password=? WHERE set_Username=? AND set_Password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, "set_Username"); // Replace "username" with the actual username
            preparedStatement.setString(3, currentPassword);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                out.println("<h3>Password changed successfully!</h3>");
            } else {
                out.println("<h3>Failed to change password. Please check your current password!</h3>");
            }

            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
