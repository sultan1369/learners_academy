package register;

import java.io.IOException;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/courseSRegistration")
public class scrServlet extends HttpServlet {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/registration";
    private static final String USER = "root";
    private static final String PASS = "sultan1369";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String studentId = request.getParameter("studentId");
        String courseId = request.getParameter("courseId");
        String courseName = request.getParameter("courseName");
        String instructorId = request.getParameter("instructorId");
        String enrollmentDate = request.getParameter("enrollmentDate");
        

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            String sql = "INSERT INTO studentenrollment (idstudent, idcourse, course_name, idinstructor, enrollment_date) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, studentId);
            preparedStatement.setString(2, courseId);
            preparedStatement.setString(3, courseName);
            preparedStatement.setString(4, instructorId);
            preparedStatement.setString(5, enrollmentDate);
           

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
            	out.println("<html><head><style>body { font-family: Arial, sans-serif; } h2 { color: blue; text-align: center; } </style></head><body><h2>Registration Successful!</h2></body></html>");
            } else {
                out.println("<h3>Registration failed!</h3>");
            }
        } catch (ClassNotFoundException | SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
