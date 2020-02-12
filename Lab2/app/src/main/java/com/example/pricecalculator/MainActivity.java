package com.example.pricecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button getButton;
    EditText priceIn, quantityIn;
    TextView tax, subtotal, total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getButton = findViewById(R.id.compute);
        priceIn = findViewById(R.id.price);
        quantityIn = findViewById(R.id.quantity);
        subtotal = findViewById(R.id.subtotal_label);
        tax = findViewById(R.id.tax_label);
        total = findViewById(R.id.total_label);
        subtotal.setVisibility(View.INVISIBLE);
        tax.setVisibility(View.INVISIBLE);
        total.setVisibility(View.INVISIBLE);
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeDisplay();

            }
        });
    }
    private void computeDisplay(){
        String priceText, quantityText;
        double amount = 0, theAmount = 0, subAmount = 0, taxAmount = 0, totAmount = 0;
        int points = 0;
        boolean flag = false;
        if(priceIn.getText().toString().length() == 0){
            flag = true;
        }
        else {
            priceText = (priceIn.getText().toString());
            priceText = priceText.replace("$", "");
            amount = Double.parseDouble(priceText);
        }
        if(quantityIn.getText().toString().length() == 0){
            flag = true;
        }
        else {
            quantityText = quantityIn.getText().toString();
            points = Integer.parseInt(quantityText);
        }
        if(!flag){
            subAmount = amount * points;
            taxAmount = subAmount * .075;
            totAmount += subAmount + taxAmount;

            subtotal.setText(String.format("$%,.2f", subAmount));
            tax.setText(String.format("$%,.2f", taxAmount));
            total.setText(String.format("$%,.2f", totAmount));
            priceIn.setText(String.format("$%,.2f", amount));
            quantityIn.setText(String.format("%,d", points));
            subtotal.setVisibility(View.VISIBLE);
            tax.setVisibility(View.VISIBLE);
            total.setVisibility(View.VISIBLE);
        }
        else{
            Toast.makeText(this,"Missing field value", Toast.LENGTH_SHORT).show();
        }
    }
}
