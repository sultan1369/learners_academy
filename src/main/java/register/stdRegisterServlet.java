package register;

import java.io.IOException;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/stdRegister")
public class stdRegisterServlet extends HttpServlet {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/registration";
    private static final String USER = "root";
    private static final String PASS = "sultan1369";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String institute = request.getParameter("institute");
        String course = request.getParameter("course");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            String sql = "INSERT INTO student (First_Name, Middle_Name, Last_Name, Date_Of_Birth, Gender, Email, Institute_Name, Course, Set_Username, Set_Password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, middleName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, dob);
            preparedStatement.setString(5, gender);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, institute);
            preparedStatement.setString(8, course);
            preparedStatement.setString(9, username);
            preparedStatement.setString(10, password);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
            	out.println("<h3>Registration Succesfully!</h3>");

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
