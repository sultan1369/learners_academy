package login;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/instrLogin")
public class instLogServlet extends HttpServlet {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/registration";
    private static final String USER = "root";
    private static final String PASS = "sultan1369";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            
            String sql = "SELECT * FROM instructor WHERE Set_Username='" + username + "' AND Set_Password='" + password + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                request.getRequestDispatcher("dashboard").forward(request, response);                // Redirect to instructor dashboard or any other page
            } else {
                out.println("<h3>Login failed! Invalid username or password.</h3>");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
