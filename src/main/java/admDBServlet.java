import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/admin")
public class admDBServlet extends HttpServlet {
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

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            Class.forName(JDBC_DRIVER);
            String sql = "UPDATE admin SET First_Name=?, Middle_Name=?, Last_Name=?, Date_Of_Birth=?, Gender=?, Email=? WHERE id=?"; // Assuming you have an 'id' column in your 'students' table
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, middleName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, dob);
            preparedStatement.setString(5, gender);
            preparedStatement.setString(6, email);
            // Set 'id' parameter value accordingly
            preparedStatement.setInt(7, 123); // Replace '123' with the actual student id

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                out.println("<h3>Student details updated successfully!</h3>");
            } else {
                out.println("<h3>Failed to update student details!</h3>");
            }

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }
    }
}
