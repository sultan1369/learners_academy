package dashboard;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.student; // Import Student class
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;

@WebServlet(urlPatterns = {"/dashboard1", "/dashboard1.jsp"})
public class stdDBS extends HttpServlet {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/registration";
    private static final String USER = "root";
    private static final String PASS = "sultan1369";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
        
    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM student where set_Username='"+request.getParameter("username")+"'";
            ResultSet result = stmt.executeQuery(sql);

            // Create a request attribute to pass data to the JSP
           
            student student = new student(); // Change User to Student
    		//process the result(select)
    		if(result.next()) {
    			student.setstudentId(result.getInt(1));
    			student.setfirstName(result.getString(2));
    			student.setmiddleName(result.getString(3));
    			student.setlastName(result.getString(4));
    			student.setdob(result.getString(5));
    			student.setgender(result.getString(6));
    			
    			student.setemail(result.getString(7));
    			student.setInstitute(result.getString(8));
    			student.setcourse(result.getString(9));
    		}
    		
    		
    		session.setAttribute("student", student); // Change user to student
    		
    		response.sendRedirect("student.jsp");
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
