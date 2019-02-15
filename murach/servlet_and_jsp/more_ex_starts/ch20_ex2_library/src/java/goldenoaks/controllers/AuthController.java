package goldenoaks.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthController extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        // Hardcoded for simplicity. A real world application would get these from a database.
        String username = "librarian";
        String password =  "sesame";
        
        String suppliedUsername = request.getParameter("username");
        String suppliedPassword = request.getParameter("password");
        
        boolean authorized = false;
        if (suppliedUsername != null
                && suppliedUsername.equals(username)
                && suppliedPassword != null
                && suppliedPassword.equals(password)) {
            authorized = true;
        }
        
        if (authorized == true) {
            request.getSession().setAttribute("authorized", "true");
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("loginfailed.html");
        }
    }
}