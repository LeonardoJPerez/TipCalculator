package edu.gatech.seclass.tipcalculator;

import java.text.DecimalFormat;

/**
 * Created by Leonardo on 9/14/2016.
 */
public class TipCalculator {

    public static int CalculateTip(double amount, double tipPercent) throws IllegalArgumentException {

        if (amount <= 0) {
            return 0;
        }

        if (tipPercent < 0 || tipPercent > 100) {
            throw new IllegalArgumentException("Percentage value must be a number greater than zero, and less or equal than 100 (0 > p <= 100).");
        }

        if (tipPercent == 0) {
            return (int)amount;
        }

        return (int)Math.round(amount * (tipPercent/100));
    }

    public static double CalculateTotal(double amount, double tipPercent, int split) throws IllegalArgumentException {

        if (tipPercent < 0 || tipPercent > 100) {
            throw new IllegalArgumentException("Percentage value must be a number greater than zero, and less or equal than 100 (0 > p <= 100).");
        }

        if (amount <= 0) {
            return 0f;
        }
        if (split < 0) {
            split = 1;
        }

        double subAmount = amount / split;

        // Get Tip amount after splitting Total amount.
        double tip = TipCalculator.CalculateTip(subAmount, tipPercent);

        // Add the tip to the subtotal.
        DecimalFormat df = new DecimalFormat("#.00");
        String formatted = df.format(subAmount + tip);

        return Double.parseDouble(formatted);
    }

    public static double CalculateTotalRounded(double amount, double tipPercent, int split) throws IllegalArgumentException {
        return Math.round(CalculateTotal(amount, tipPercent, split));
    }
}
