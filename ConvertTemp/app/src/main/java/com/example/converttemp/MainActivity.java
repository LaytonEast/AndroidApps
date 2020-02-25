package com.example.converttemp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button getButton;
    EditText fahrenheitIn;
    TextView f_c_label;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fahrenheitIn = findViewById(R.id.temperature);
        f_c_label = findViewById(R.id.f_c);
        getButton = findViewById(R.id.get_button);
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeTemperature();

            }
        });
    }
    private void computeTemperature(){
          String fahrenheitText;
          double fahrenheit = 0;
          boolean flag = false;
          if(fahrenheitIn.getText().toString().length() == 0){
              flag = true;
          }
          else {
              fahrenheitText = fahrenheitIn.getText().toString();
              fahrenheit = Double.parseDouble(fahrenheitText);
          }

          if(!flag){
              double celcius = 0;
              celcius = (fahrenheit - 32.0) * 5.0/9.0;
              fahrenheitIn.setText(String.format("%.2f F", fahrenheit));
              f_c_label.setText(String.format("%.2f C", celcius));
          }
          else{
              Toast.makeText(this,"Missing field value", Toast.LENGTH_SHORT).show();
          }
      }
  }
