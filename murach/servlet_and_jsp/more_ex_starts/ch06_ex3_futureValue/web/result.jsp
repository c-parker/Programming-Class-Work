<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Murach's Java Servlets and JSP</title>
        <link rel="stylesheet" href="styles/main.css">
    </head>
    <body>
        <section>
            <h1>Future Value Calculator</h1>

            <label>Investment Amount:</label>
            <span>${calculation.monthlyInvestmentAmountCurrencyFormat}</span><br />

            <label>Yearly Interest Rate:</label>
            <span>${calculation.yearlyInterestRate}</span><br />

            <label>Number of Years:</label>
            <span>${calculation.years}</span><br />

            <label>Future Value:</label>
            <span>${calculation.futureValueCurrencyFormat}</span><br />
        </section>
    </body>
</html>