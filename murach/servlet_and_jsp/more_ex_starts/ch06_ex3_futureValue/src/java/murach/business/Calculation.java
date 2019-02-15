package murach.business;

import java.io.Serializable;
import java.text.NumberFormat;

public class Calculation implements Serializable {

    private double monthlyInvestmentAmount;
    private double yearlyInterestRate;
    private int years;
    private double futureValue;

    public Calculation() {
    }

    public double getMonthlyInvestmentAmount() {
        return monthlyInvestmentAmount;
    }

    public void setMonthlyInvestmentAmount(double monthlyInvestmentAmount) {
        this.monthlyInvestmentAmount = monthlyInvestmentAmount;
    }

    public String getMonthlyInvestmentAmountCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(monthlyInvestmentAmount);
    }
    
    public double getYearlyInterestRate() {
        return yearlyInterestRate;
    }

    public void setYearlyInterestRate(double yearlyInterestRate) {
        this.yearlyInterestRate = yearlyInterestRate;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public double getFutureValue() {
        // convert yearly values to monthly values and initialize future value
        double monthlyInterestRate = yearlyInterestRate / 12 / 100;
        int months = years * 12;

        // use a for loop to calculate the future value
        futureValue = 0.0;
        for (int i = 1; i <= months; i++) {
            futureValue = (futureValue + monthlyInvestmentAmount)
                    * (1 + monthlyInterestRate);
        }
        return futureValue;
    }

    public String getFutureValueCurrencyFormat() {
        futureValue = getFutureValue();
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(futureValue);
    }
}