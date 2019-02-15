<%@include file="header.jsp" %>
<%@ taglib prefix="mma" uri="/WEB-INF/murach.tld" %>
<section>
    <h1>Future Value Calculator</h1>

    <label>Investment Amount:</label>
    <span>${calculation.monthlyInvestmentAmountCurrencyFormat}</span><br />

    <label>Yearly Interest Rate:</label>
    <span>${calculation.yearlyInterestRate}</span><br />

    <label>Number of Years:</label>
    <span>${calculation.years}</span><br />

    <label>Future Value:</label>
    <span><mma:currencyFormat value="${calculation.futureValue}"/></span><br />
</section>
<%@include file="footer.jsp" %>
