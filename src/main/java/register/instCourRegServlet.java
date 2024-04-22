package register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submitCRegistration")
public class instCourRegServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/registration";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "sultan1369"; // Replace with your MySQL password

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve form data
        String courseId = request.getParameter("courseId");
        String courseName = request.getParameter("courseName");
        String enrollmentDate = request.getParameter("enrollmentDate");
        

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            // Insert data into the database
            String sql = "INSERT INTO instenrollment (courseId, courseName, enrollmentDate) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, courseId);
            pstmt.setString(2, courseName);
            pstmt.setString(3, enrollmentDate);
            

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                out.println("<h2>Registration successful!</h2>");
            } else {
                out.println("<h2>Registration failed!</h2>");
            }
        } catch (SQLException e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
            e.printStackTrace();
        }
    }
}
