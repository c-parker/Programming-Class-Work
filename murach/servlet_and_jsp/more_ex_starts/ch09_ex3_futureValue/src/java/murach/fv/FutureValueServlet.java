package murach.fv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import murach.business.Calculation;

@WebServlet("/calculate")
public class FutureValueServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // get parameters from the request
        String investmentString = request.getParameter("investment");
        String interestRateString = request.getParameter("interest_rate");
        String yearsString = request.getParameter("years");

        // validate the parameters
        String url;
        String message;
        double investment = 0;
        double interestRate = 0;
        int years = 0;
        try {
            investment = Double.parseDouble(investmentString);
            interestRate = Double.parseDouble(interestRateString);
            years = Integer.parseInt(yearsString);
            message = "";
            url = "/result.jsp";
        } catch (NumberFormatException e) {
            message = "Please enter a valid number in all three text boxes.";
            url = "/index.jsp";
        }
        request.setAttribute("message", message);

        // Create a calculation object for each year
        List<Calculation> calculations = new ArrayList<Calculation>();
        for (int i = 1; i <= years; i++) {
            Calculation calculation = new Calculation();
            calculation.setMonthlyInvestmentAmount(investment);
            calculation.setYearlyInterestRate(interestRate);
            calculation.setYears(i);
            calculations.add(calculation);
        }

        // Store calculations list in calculations object
        request.setAttribute("calculations", calculations);
        request.setAttribute("years", years);
        request.setAttribute("message", message);

        request.getSession().setAttribute("investment", investment);
        request.getSession().setAttribute("interestRate", interestRate);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}