package ru.unn.agile.depositconverter.model;

import java.text.ParseException;

public class DepositCalculator {
    static final double DEFAULT_DEPOSIT = 700000;
    static final int DEFAULT_TERM_PLACMENT = 12;
    static final double DEFAULT_INCOME = 0;
    static final double DEFAULT_INTEREST_RATE = 8;
    static final int MONTH_IN_YEAR = 12;
    static final int PERCENT = 100;

    private double depositAmount;
    private int termPlacementInMonths;
    private double income;
    private DateTime startDate;
    private double interestRate;
    private AccruedInterest accruedInterest;
    private FrequencyOfCapitalization frequencyOfCapitalization;

    public DepositCalculator() {
        this.depositAmount = DEFAULT_DEPOSIT;
        this.termPlacementInMonths = DEFAULT_TERM_PLACMENT;
        this.income = DEFAULT_INCOME;
        this.startDate = new DateTime();
        this.interestRate = DEFAULT_INTEREST_RATE;
        this.accruedInterest = AccruedInterest.addToDeposit;
        this.frequencyOfCapitalization = FrequencyOfCapitalization.onceMonth;
    }

    public double getDepositAmount() {
        return this.depositAmount;
    }

    public void setDepositAmount(final double deposit) {
        if (deposit < 0) {
            throw new NumberFormatException("Отрицательное значение суммы вклада");
        }
        this.depositAmount = deposit;
    }

    public void setTermPlacementInMonths(final int term) throws NumberFormatException {
        if (term < 1) {
            throw new NumberFormatException("Отрицательное значение срока размещения");
        }
        this.termPlacementInMonths = term;
    }

    public int getTermPlacementInMonths() {
        return this.termPlacementInMonths;
    }

    public void setStartDate(final String date) throws ParseException {
        this.startDate = new DateTime(date);
    }

    public String getStartDate() {
        return this.startDate.convertToString();
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(final double rate) {
        if (rate < 0) {
            throw new NumberFormatException("Отрицательное значение процента");
        }
        this.interestRate = rate;
    }

    public double calculateRevenue() {
        double incomeInMonth = 0;
        double gain = 0;
        double valuePercentPerMonth = this.interestRate / (MONTH_IN_YEAR * PERCENT);
        for (int i = 1; i < this.termPlacementInMonths + 1; ++i) {
            if (this.accruedInterest == AccruedInterest.addToDeposit) {
                incomeInMonth = valuePercentPerMonth * (this.depositAmount + this.income);
            } else if (this.accruedInterest == AccruedInterest.payOut) {
                incomeInMonth = valuePercentPerMonth * this.depositAmount;
            }
            gain += incomeInMonth;
            this.calculationCapitalization(gain, i);
        }
        return this.depositAmount + this.income;
    }

    private void calculationCapitalization(final double gain, final int term) {
        if (FrequencyOfCapitalization.useCharges(this.frequencyOfCapitalization, term)) {
            this.income = gain;
        } else if (term == this.termPlacementInMonths) {
            this.income = gain;
        }
    }

    public AccruedInterest getAccruedInterest() {
        return this.accruedInterest;
    }

    public void setAccruedInterest(final AccruedInterest accrued) {
        this.accruedInterest = accrued;
    }

    public FrequencyOfCapitalization getFrequencyOfCapitalization() {
        return this.frequencyOfCapitalization;
    }

    public void setFrequencyOfCapitalization(
            final FrequencyOfCapitalization frequencyOfCapitalization) {
        this.frequencyOfCapitalization = frequencyOfCapitalization;
    }

    public double getIncome() {
        return this.income;
    }
}
