<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<section>
    <h1>Future Value Calculator</h1>
    <p><i>${message}</i></p>
    <form action="calculate" method="post">
        <label>Investment Amount:</label>
        <c:if test="${investmentAmount != null}">
            <input type="text" name="investment"
                   value="${investmentAmount}"/><br>
        </c:if>
        <c:if test="${investmentAmount == null}">
            <input type="text" name="investment"
                   value="${calculation.monthlyInvestmentAmount}"/><br>
        </c:if>        
        <label>Yearly Interest Rate:</label>
        <c:if test="${interestRate != null}">
            <input type="text" name="interest_rate"
                   value="${interestRate}"/><br>
        </c:if>
        <c:if test="${interestRate == null}">
            <input type="text" name="interest_rate"
                   value="${calculation.yearlyInterestRate}"/><br>
        </c:if>
        <label>Number of Years:</label>
        <input type="text" name="years"
               value="${calculation.years}"/><br>

        <label>&nbsp;</label>
        <input type="submit" value="Calculate"/><br>
    </form>
</section>
<%@include file="footer.jsp" %>