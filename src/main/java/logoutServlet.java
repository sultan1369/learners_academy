import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/logoutServlet")
public class logoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Clear session information and mark the user as logged out in the database
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");

        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "root";
        String password = "sultan1369";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Update user status in the database
            String sql = "UPDATE users SET logged_in = ? WHERE first_name = ? AND middle_name = ? AND last_name = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setBoolean(1, false);
                stmt.setString(2, firstName);
                stmt.setString(3, middleName);
                stmt.setString(4, lastName);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors
        }

        // Redirect the user to the home page after logout
        response.sendRedirect("logout.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
