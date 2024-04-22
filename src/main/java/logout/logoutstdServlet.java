package logout;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/logoutStdServlet")
public class logoutstdServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Clear session attributes
        HttpSession session = request.getSession();
        session.removeAttribute("student");
        session.invalidate();

        // Set response headers to prevent caching
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.

        // Redirect to the home page if not logged in, otherwise redirect to login page
        if (session.getAttribute("student") == null) {
            response.sendRedirect("index.html");
        } else {
            response.sendRedirect("login.html");
        }
    }
}
