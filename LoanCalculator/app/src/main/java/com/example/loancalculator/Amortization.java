package com.example.loancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Amortization extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView amountHeader, numPayments, tableHeader;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amoritization);
        TableLayout table = findViewById(R.id.table);
        amountHeader = findViewById(R.id.amount_label);
        numPayments = findViewById(R.id.num_payments);
        table = findViewById(R.id.table);
        tableHeader = findViewById(R.id.title_label);
        table = findViewById(R.id.table);
        Intent intent = getIntent();
        String la_amountString = intent.getStringExtra("la_AMT");
        String lp_amountString = intent.getStringExtra("lp_AMT");
        String monthsString = intent.getStringExtra("MON");
        String apr_string = intent.getStringExtra("APR");
        double initial_amount = Double.parseDouble(la_amountString);
        double lp_amount = Double.parseDouble(lp_amountString);
        int numMonths = Integer.parseInt(monthsString);
        double interest = 0;
        double principle = 0;
        double balance = initial_amount;
        double apr = Double.parseDouble(apr_string);
        TableRow row = new TableRow(this);
        TableRow.LayoutParams lp =new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(lp);
        row.setLayoutParams(lp);
        TextView t1, t2, t3, t4, t5;
        t1 = new TextView(this);
        t1.setText("#");
        t1.setTypeface(null, Typeface.BOLD);
        t2 = new TextView(this);
        t2.setText("Monthly");
        t2.setTypeface(null, Typeface.BOLD);
        t3 = new TextView(this);
        t3.setText("Interest");
        t3.setTypeface(null, Typeface.BOLD);
        t4 = new TextView(this);
        t4.setText("Principle");
        t4.setTypeface(null, Typeface.BOLD);
        t5 = new TextView(this);
        t5.setText("Balance");
        t5.setTypeface(null, Typeface.BOLD);
        t1.setPadding(20,0,10,0);
        t2.setPadding(0,0,20,0);
        t3.setPadding(0,0,20,0);
        t4.setPadding(0,0,20,0);
        t5.setPadding(0,0,20,0);
        row.addView(t1);
        row.addView(t2);
        row.addView(t3);
        row.addView(t4);
        row.addView(t5);
        table.addView(row);
        for(int i = 0; i < numMonths; i++){
            t1 = new TextView(this);
            t1.setText((i+1)+". ");

            t2 = new TextView(this);
            t2.setText(String.format("%,.2f", lp_amount));

            interest = balance * apr/12;
            t3 = new TextView(this);
            t3.setText(String.format("%,.2f", interest));

            principle = lp_amount - interest;
            t4 = new TextView(this);
            t4.setText(String.format("%,.2f", principle));

            balance -= principle;
            t5 = new TextView(this);
            t5.setText(String.format("%,.2f", balance));

            t1.setPadding(20,0,10,0);
            t2.setPadding(0,0,20,0);
            t3.setPadding(0,0,20,0);
            t4.setPadding(0,0,20,0);
            t5.setPadding(0,0,20,0);

            row = new TableRow(this);
            lp =new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            row.addView(t1);
            row.addView(t2);
            row.addView(t3);
            row.addView(t4);
            row.addView(t5);
            if ( i % 2 == 1 ) {
                t1.setTextColor(Color.GREEN);
                t2.setTextColor(Color.GREEN);
                t3.setTextColor(Color.GREEN);
                t4.setTextColor(Color.GREEN);
                t5.setTextColor(Color.GREEN);
            }
            else {
                t1.setTextColor(Color.BLUE);
                t2.setTextColor(Color.BLUE);
                t3.setTextColor(Color.BLUE);
                t4.setTextColor(Color.BLUE);
                t5.setTextColor(Color.BLUE);

            }
            table.addView(row);
        }


    }
}
