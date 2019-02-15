package goldenoaks.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LibraryController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String url = "";
        switch (action) {
            case "checkout":
                url = "/checkout.jsp";
                break;
            case "manage": 
                url = manage(request, response);
                break;
        }

        getServletContext().getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String url = "";
        switch (action) {
            case "doCheckout":
                url = doCheckout(request, response);
                break;
            case "doCheckin":
                url = doCheckin(request, response);
                break;
        }
        
        getServletContext().getRequestDispatcher(url)
                .forward(request, response);
    }
    
    private String manage(HttpServletRequest request,
            HttpServletResponse response) {
        
        //TODO: Implement code to display list of checked out books here.
        
        return "/checkedOutList.jsp";
    }
    
    private String doCheckout(HttpServletRequest request,
            HttpServletResponse response) {
        
        //TODO: Implement code to check out the book here.
        
        return "/thankyou.jsp";
    }
    
    private String doCheckin(HttpServletRequest request,
            HttpServletResponse response) {
        
        //TODO: Implement code to check in the book here.
        
        return manage(request, response);
    }
}