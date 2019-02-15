<%@include file="header.jsp" %>
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
    <label>&nbsp;</label>
    <br>
    <span><a href="index.jsp">Return to Calculator</a></span>
</section>
<%@include file="footer.jsp" %>
