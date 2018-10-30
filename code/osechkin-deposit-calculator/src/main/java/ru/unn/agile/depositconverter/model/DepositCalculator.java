package ru.unn.agile.depositconverter.model;

import java.text.ParseException;

public class DepositCalculator {
    private double depositAmount = 700000;
    private int termPlacementInMonths = 12;
    private double income = 0;
    private DateTime startDate = new DateTime();
    private double interestRate = 8;
    private AccruedInterest accruedInterest = AccruedInterest.addToDeposit;
    private FrequencyOfCapitalization frequencyOfCapitalization = FrequencyOfCapitalization.onceMonth;

    public double getDepositAmount() {
        return this.depositAmount;
    }

    public void setDepositAmount(double deposit) {
        if (deposit < 0) {
            throw new NumberFormatException("Отрицательное значение суммы вклада");
        }
        this.depositAmount = deposit;
    }

    public void setTermPlacementInMonths(int term) throws NumberFormatException {
        if (term < 1) {
            throw new NumberFormatException("Отрицательное значение срока размещения");
        }
        this.termPlacementInMonths = term;
    }

    public int getTermPlacementInMonths() {
        return this.termPlacementInMonths;
    }

    public void setStartDate(String date) throws ParseException {
        this.startDate = new DateTime(date);
    }

    public String getStartDate() {
        return this.startDate.convertToString();
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double rate) {
        if (rate < 0) {
            throw new NumberFormatException("Отрицательное значение процента");
        }
        this.interestRate = rate;
    }

    public double calculateRevenue() {
        double incomeInMonth = 0;
        double gain = 0;
        int monthInYear = 12;
        double valuePercentPerMonth = this.interestRate / (monthInYear * 100);
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

    private void calculationCapitalization(double gain, int term) {
        if (this.frequencyOfCapitalization == FrequencyOfCapitalization.onceMonth)
            this.income = gain;
        else if (this.frequencyOfCapitalization == FrequencyOfCapitalization.onceTwoMonth && term % 2 == 0)
            this.income = gain;
        else if (this.frequencyOfCapitalization == FrequencyOfCapitalization.quarterly && term % 3 == 0)
            this.income = gain;
        else if (this.frequencyOfCapitalization == FrequencyOfCapitalization.halfYear && term % 6 == 0)
            this.income = gain;
        else if (term == this.termPlacementInMonths)
            this.income = gain;
    }

    public AccruedInterest getAccruedInterest() {
        return this.accruedInterest;
    }

    public void setAccruedInterest(AccruedInterest accrued) {
        this.accruedInterest = accrued;
    }

    public FrequencyOfCapitalization getFrequencyOfCapitalization() {
        return this.frequencyOfCapitalization;
    }

    public void setFrequencyOfCapitalization(FrequencyOfCapitalization frequencyOfCapitalization) {
        this.frequencyOfCapitalization = frequencyOfCapitalization;
    }

    public double getIncome() {
        return this.income;
    }
}