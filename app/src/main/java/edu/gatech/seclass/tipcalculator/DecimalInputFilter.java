package edu.gatech.seclass.tipcalculator;

import android.text.InputFilter;
import android.text.Spanned;

import java.util.regex.Pattern;

/**
 * Created by Leonardo on 9/14/2016.
 */
public class DecimalInputFilter
        implements InputFilter {

    private Pattern regexPattern;

    public DecimalInputFilter(int decimalPlaces) {
        regexPattern = Pattern.compile("\\$[0-9]*+((\\.[0-9]{0," + (decimalPlaces-1) + "})?)||(\\.)?");
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        if(!regexPattern.matcher(dest).matches()) return "";
        return null;
    }
}