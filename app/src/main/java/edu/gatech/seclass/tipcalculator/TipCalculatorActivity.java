package edu.gatech.seclass.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.NumberFormat;

import edu.gatech.seclass.R;

/**
 * Created by Leonardo on 9/13/2016.
 */
public class TipCalculatorActivity
        extends AppCompatActivity {

    private EditText txtCheckAmountValue;
    private EditText txtPartySize;

    private EditText txt15PercentTip;
    private EditText txt20PercentTip;
    private EditText txt25PercentTip;
    private EditText txt15PercentTotal;
    private EditText txt20PercentTotal;
    private EditText txt25PercentTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        initialize();
    }

    private void initialize() {
        txtCheckAmountValue = (EditText) findViewById(R.id.checkAmountValue);
        txtCheckAmountValue.setFilters(new InputFilter[]{new DecimalInputFilter(25)});
        txtCheckAmountValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String t = s.toString();
                txtCheckAmountValue.removeTextChangedListener(this);
                String newString = t.startsWith("$") ? t : "$" + t;
                txtCheckAmountValue.setText(newString);
                txtCheckAmountValue.setSelection(newString.length());
                txtCheckAmountValue.addTextChangedListener(this);
            }
        });

        txtPartySize = (EditText) findViewById(R.id.partySizeValue);
        txt15PercentTip = (EditText) findViewById(R.id.fifteenPercentTipValue);
        txt20PercentTip = (EditText) findViewById(R.id.twentyPercentTipValue);
        txt25PercentTip = (EditText) findViewById(R.id.twentyfivePercentTipValue);

        txt15PercentTotal = (EditText) findViewById(R.id.fifteenPercentTotalValue);
        txt20PercentTotal = (EditText) findViewById(R.id.twentyPercentTotalValue);
        txt25PercentTotal = (EditText) findViewById(R.id.twentyfivePercentTotalValue);

        txt15PercentTip.setFocusable(false);
        txt20PercentTip.setFocusable(false);
        txt25PercentTip.setFocusable(false);

        txt15PercentTotal.setFocusable(false);
        txt20PercentTotal.setFocusable(false);
        txt25PercentTotal.setFocusable(false);
    }

    public void OnCompute_Click(View view) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        String amountString = txtCheckAmountValue.getText().toString().replace("$", "");
        String splitString = txtPartySize.getText().toString();
        if ((amountString == null || amountString.length() < 1) ||
                (splitString == null || splitString.length() < 1)) {
            displayToast("Invalid or incorrect value(s)!", Toast.LENGTH_SHORT);
            return;
        }

        try {

            double amount = Double.parseDouble(amountString.toString());
            int split = Integer.parseInt(splitString.toString());

            int tip = TipCalculator.CalculateTip(amount / split, 15);
            txt15PercentTip.setText(Integer.toString(tip));

            tip = TipCalculator.CalculateTip(amount / split, 20);
            txt20PercentTip.setText(Integer.toString(tip));

            tip = TipCalculator.CalculateTip(amount / split, 25);
            txt25PercentTip.setText(Integer.toString(tip));

            int total = (int) TipCalculator.CalculateTotalRounded(amount, 15, split);
            txt15PercentTotal.setText(Integer.toString(total));

            total = (int) TipCalculator.CalculateTotalRounded(amount, 20, split);
            txt20PercentTotal.setText(Integer.toString(total));

            total = (int) TipCalculator.CalculateTotalRounded(amount, 25, split);
            txt25PercentTotal.setText(Integer.toString(total));

        } catch (Exception e) {
            displayToast(e.getMessage(), Toast.LENGTH_LONG);
        }
    }

    public void displayToast(String message, int duration) {
        Toast toast = Toast.makeText(getApplicationContext(), message, duration);
        toast.show();
    }
}
