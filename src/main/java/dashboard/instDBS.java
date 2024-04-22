package dashboard;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;

@WebServlet(urlPatterns = {"/dashboard", "/dashboard.jsp"})
public class instDBS extends HttpServlet {
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

            String sql = "SELECT * FROM instructor where set_Username='"+request.getParameter("username")+"'";
            ResultSet result = stmt.executeQuery(sql);

            // Create a request attribute to pass data to the JSP
           
            User user = new User();
    		//process the result(select)
    		if(result.next()) {
    			user.setfirstName(result.getString(2));
    			user.setmiddleName(result.getString(3));
    			user.setlastName(result.getString(4));
    			user.setgender1(result.getString(5));
    			user.dob(result.getString(6));
    			user.setemail(result.getString(7));
    		}
    		
    		
    		session.setAttribute("user", user);
    		
    		response.sendRedirect("instructor.jsp");
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
