package com.example.loancalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    EditText loanAmount, apr, loanYears, loanPayment;
    Button calculateButton, resetButton, tableButton;
    String la_amountString, apr_amountString, ly_amountString, lp_amountString;
    static double la_amount = 0;
    static double apr_amount = 0;
    static int ly_amount = 0;
    static double lp_amount = 0;
    final static int RESULT_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loanAmount = findViewById(R.id.loan_amount);
        apr = findViewById(R.id.apr_in);
        loanYears = findViewById(R.id.loan_years);
        loanPayment = findViewById(R.id.loan_payment);
        loanPayment.setEnabled(false);
        calculateButton = findViewById(R.id.calculate_button);
        resetButton = findViewById(R.id.reset_button);
        tableButton = findViewById(R.id.table_button);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                la_amountString = loanAmount.getText().toString();
                la_amount = Double.parseDouble(la_amountString);
                apr_amountString = apr.getText().toString();
                apr_amount = Double.parseDouble(apr_amountString);
                ly_amountString = loanYears.getText().toString();
                ly_amount = Integer.parseInt(ly_amountString);
                double apr_percent = apr_amount / 100;
                int months = ly_amount * 12;
                lp_amount = la_amount * ( apr_percent/12 + (apr_percent/12)/(Math.pow((1+apr_percent/12), months)-1));
                lp_amountString = Double.toString(lp_amount);
                display();
            }
        });

        tableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Amortization.class);
                intent.putExtra("la_AMT", la_amountString );
                intent.putExtra("lp_AMT", lp_amountString );
                startActivityForResult(intent,RESULT_1);
            }
        });

    }

    private void display(){
        loanAmount.setText(String.format("$%,.2f", la_amount));
        apr.setText(String.format("%,.2f", apr_amount) + "%");
        loanYears.setText(String.format("%,d", ly_amount));
        loanPayment.setEnabled(true);
        loanPayment.setText(String.format("$%,.2f", lp_amount));
    }
}
