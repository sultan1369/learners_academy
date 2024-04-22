package register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/instrReg")
public class instRegServlet extends HttpServlet {
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
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
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
            
            String sql = "INSERT INTO instructor (First_Name, Middle_Name, Last_Name, Gender, Date_Of_Birth, Email, Set_Username, set_Password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, middleName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, dob);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, username);
            preparedStatement.setString(8, password);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                out.println("<h3>Registration successful!</h3>");
            } else {
                out.println("<h3>Registration failed!</h3>");
            }

            preparedStatement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
