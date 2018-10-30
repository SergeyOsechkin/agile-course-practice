package ru.unn.agile.depositconverter.model;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;


public class DepositCalculatorTest {
    private final double delta = 0.001;

    @Test(expected = NumberFormatException.class)
    public void cannotSetDepositAmount() {
        // Arrange
        DepositCalculator depositCalculator = new DepositCalculator();

        // Act & Assert
        depositCalculator.setDepositAmount(-500);
    }

    @Test
    public void canGetDepositAmount() {
        // Arrange
        DepositCalculator depositCalculator = new DepositCalculator();

        // Act
        depositCalculator.setDepositAmount(500);

        //Assert
        assertEquals(500, depositCalculator.getDepositAmount(), delta);
    }

    @Test
    public void canGetTermPlacement() {
        // Arrange
        DepositCalculator depositCalculator = new DepositCalculator();

        // Act
        depositCalculator.setTermPlacementInMonths(10);

        //Assert
        assertEquals(10, depositCalculator.getTermPlacementInMonths());
    }

    @Test(expected = NumberFormatException.class)
    public void cannotSetTermPlacement() {
        // Arrange
        DepositCalculator depositCalculator = new DepositCalculator();

        // Act & Assert
        depositCalculator.setTermPlacementInMonths(-5);
    }

    @Test
    public void canCreateDateTime() throws ParseException {
        // Arrange & Act & Assert
        DateTime dTime = new DateTime("02.02.2018");
    }

    @Test(expected = ParseException.class)
    public void cannotCreateDateTime() throws ParseException {
        // Arrange & Act & Assert
        DateTime dTime = new DateTime("36.02.2018");
    }

    @Test
    public void canDateTimeConvertToString() throws ParseException {
        // Arrange
        DateTime dTime = new DateTime("06.02.2018");

        // Act
        String strTime = dTime.convertToString();

        // Assert
        assertEquals("06.02.2018", strTime);
    }

    @Test
    public void canSetStartDate() throws ParseException {
        // Arrange
        DepositCalculator depositCalculator = new DepositCalculator();

        // Act & Assert
        depositCalculator.setStartDate("06.02.2018");
    }

    @Test
    public void canGetStartDate() throws ParseException {
        // Arrange
        DepositCalculator depositCalculator = new DepositCalculator();

        // Act
        depositCalculator.setStartDate("06.02.2018");

        //Assert
        assertEquals("06.02.2018", depositCalculator.getStartDate());
    }

    @Test(expected = NumberFormatException.class)
    public void cannotSetInterestRate() {
        // Arrange
        DepositCalculator depositCalculator = new DepositCalculator();

        // Act & Assert
        depositCalculator.setInterestRate(-5);
    }

    @Test
    public void canGetInterestRate() {
        // Arrange
        DepositCalculator depositCalculator = new DepositCalculator();

        // Act
        depositCalculator.setInterestRate(13);

        // Assert
        assertEquals(13, depositCalculator.getInterestRate(), delta);
    }

    @Test
    public void canCalculateRevenueWhenAddToDeposit() {
        // Arrange
        DepositCalculator depositCalculator = new DepositCalculator();

        // Act
        double revenue = depositCalculator.calculateRevenue();

        // Assert
        assertEquals(758099.654, revenue, delta);
    }

    @Test
    public void canCalculateRevenueWhenPayOutDeposit() {
        // Arrange
        DepositCalculator depositCalculator = new DepositCalculator();

        // Act
        depositCalculator.setAccruedInterest(AccruedInterest.payOut);
        double revenue = depositCalculator.calculateRevenue();

        // Assert
        assertEquals(756000, revenue, delta);
    }

    @Test
    public void canGetAccruedInterest() {
        // Arrange
        DepositCalculator depositCalculator = new DepositCalculator();

        // Assert
        assertEquals(AccruedInterest.addToDeposit, depositCalculator.getAccruedInterest());
    }

    @Test
    public void canCalcRevenueWithCapitalizationTwoMonth() {
        // Arrange
        DepositCalculator depositCalculator = new DepositCalculator();

        // Act
        depositCalculator.setAccruedInterest(AccruedInterest.payOut);
        depositCalculator.setFrequencyOfCapitalization(FrequencyOfCapitalization.onceTwoMonth);
        double revenue = depositCalculator.calculateRevenue();

        // Assert
        assertEquals(756000, revenue, delta);
    }

    @Test
    public void canGetFrequencyOfCapitalization() {
        // Arrange & Act
        DepositCalculator depositCalculator = new DepositCalculator();

        // Assert
        assertEquals(FrequencyOfCapitalization.onceMonth,
                depositCalculator.getFrequencyOfCapitalization());
    }

    @Test
    public void canCalcRevenueWithCapitalizationQuarterly() {
        // Arrange
        DepositCalculator depositCalculator = new DepositCalculator();

        // Act
        depositCalculator.setAccruedInterest(AccruedInterest.payOut);
        depositCalculator.setFrequencyOfCapitalization(FrequencyOfCapitalization.quarterly);
        double revenue = depositCalculator.calculateRevenue();

        // Assert
        assertEquals(756000, revenue, delta);
    }

    @Test
    public void canCalcRevenueWithCapitalizationHalfYear() {
        // Arrange
        DepositCalculator depositCalculator = new DepositCalculator();

        // Act
        depositCalculator.setAccruedInterest(AccruedInterest.payOut);
        depositCalculator.setFrequencyOfCapitalization(FrequencyOfCapitalization.halfYear);
        double revenue = depositCalculator.calculateRevenue();

        // Assert
        assertEquals(756000, revenue, delta);
    }

    @Test
    public void canCalcRevenueWithCapitalizationHalfYearAndAddToDeposit() {
        // Arrange
        DepositCalculator depositCalculator = new DepositCalculator();

        // Act
        depositCalculator.setAccruedInterest(AccruedInterest.addToDeposit);
        depositCalculator.setFrequencyOfCapitalization(FrequencyOfCapitalization.halfYear);
        double revenue = depositCalculator.calculateRevenue();

        // Assert
        assertEquals(757120, revenue, delta);
    }

    @Test
    public void canCalcRevenueWithCapitalizationTwoMonthAndAddToDeposit() {
        // Arrange
        DepositCalculator depositCalculator = new DepositCalculator();

        // Act
        depositCalculator.setAccruedInterest(AccruedInterest.addToDeposit);
        depositCalculator.setFrequencyOfCapitalization(FrequencyOfCapitalization.onceTwoMonth);
        double revenue = depositCalculator.calculateRevenue();

        // Assert
        assertEquals(757900.185, revenue, delta);
    }

    @Test
    public void canCalcRevenueWithCapitalizationQuarterlyAndAddToDeposit() {
        // Arrange
        DepositCalculator depositCalculator = new DepositCalculator();

        // Act
        depositCalculator.setAccruedInterest(AccruedInterest.addToDeposit);
        depositCalculator.setFrequencyOfCapitalization(FrequencyOfCapitalization.quarterly);
        double revenue = depositCalculator.calculateRevenue();

        // Assert
        assertEquals(757702.512, revenue, delta);
    }

    @Test
    public void canGetIncome() {
        // Arrange
        DepositCalculator depositCalculator = new DepositCalculator();

        // Act
        depositCalculator.setAccruedInterest(AccruedInterest.addToDeposit);
        depositCalculator.setFrequencyOfCapitalization(FrequencyOfCapitalization.quarterly);
        depositCalculator.calculateRevenue();

        // Assert
        assertEquals(57702.512, depositCalculator.getIncome(), delta);
    }

    @Test
    public void canUseChargesWhenOneMonth() {
        FrequencyOfCapitalization freqCapital = FrequencyOfCapitalization.onceMonth;

        boolean charges = FrequencyOfCapitalization.useCharges(freqCapital, 1);

        assertEquals(true, charges);
    }

    @Test
    public void canUseChargesWhenTwoMonth() {
        FrequencyOfCapitalization freqCapital = FrequencyOfCapitalization.onceTwoMonth;

        boolean charges = FrequencyOfCapitalization.useCharges(freqCapital, 2);

        assertEquals(true, charges);
    }

    @Test
    public void cannotUseCharges() {
        FrequencyOfCapitalization freqCapital = FrequencyOfCapitalization.quarterly;

        boolean charges = FrequencyOfCapitalization.useCharges(freqCapital, 2);

        assertEquals(false, charges);
    }

}
