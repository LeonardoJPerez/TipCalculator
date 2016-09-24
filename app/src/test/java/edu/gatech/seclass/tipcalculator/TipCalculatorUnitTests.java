package edu.gatech.seclass.tipcalculator;

import org.junit.Test;

import edu.gatech.seclass.tipcalculator.TipCalculator;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class TipCalculatorUnitTests {

    @Test
    public void CalculateTip_For_15Percent1() {
        double tip = TipCalculator.CalculateTip(120/4, 15);
        assertEquals(tip, 5, 0);
    }

    @Test
    public void CalculateTip_For_15Percent2() {
        double tip = TipCalculator.CalculateTip(257.63/2, 15);
        assertEquals(tip, 19, 0);
    }

    @Test
    public void CalculateTip_For_20Percent1() {
        double tip = TipCalculator.CalculateTip(120/4, 20);
        assertEquals(tip, 6, 0);
    }

    @Test
    public void CalculateTip_For_20Percent2() {
        double tip = TipCalculator.CalculateTip(257.63/2, 20);
        assertEquals(tip, 26, 0);
    }

    @Test
    public void CalculateTip_For_25Percent1() {
        double tip = TipCalculator.CalculateTip(120/4, 25);
        assertEquals(tip, 8, 0);
    }

    @Test
    public void CalculateTip_For_25Percent2() {
        double tip = TipCalculator.CalculateTip(257.63/2, 25);
        assertEquals(tip, 32, 0);
    }

    @Test
    public void CalculateTotal_With_15PercentTip() {
        double total = TipCalculator.CalculateTotal(257.63, 25, 2);
        assertEquals(total, 160.81, 0);
    }

    @Test
    public void CalculateTotal_With_20PercentTip() {
        double total = TipCalculator.CalculateTotal(257.63, 20, 3);
        assertEquals(total, 102.88, 0);
    }

    @Test
    public void CalculateTotal_With_25PercentTip() throws Exception {
        double total = TipCalculator.CalculateTotal(257.63, 25, 4);
        assertEquals(total, 80.41, 0);
    }


    @Test(expected = IllegalArgumentException.class)
    public void CalculateTotal_With_25PercentTip_Throw_Error() throws Exception {
        TipCalculator.CalculateTotal(257.63, 25, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void CalculateTip_For_25Percent_Throw_Error() throws Exception {
        TipCalculator.CalculateTip(257.63, -15);
    }

    @Test
    public void CalculateTotal_For_25Percent_When_Total_Is_Zero() throws Exception {
        double total =TipCalculator.CalculateTotal(0, 25, 0);
        assertEquals(total, 0, 0);
    }

    @Test
    public void CalculateTip_For_25Percent_When_Total_Is_Zero() throws Exception {
        double total = TipCalculator.CalculateTip(0, 25);
        assertEquals(total, 0, 0);
    }
}