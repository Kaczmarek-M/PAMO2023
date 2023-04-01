package com.example.pamo2023;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BmiActivity extends AppCompatActivity {

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        EditText edWeg,edHei;
        TextView txtRes,txtInter;
        Button btnRes,btnReset;

        edWeg = (EditText) findViewById(R.id.edweg);
        edHei = (EditText) findViewById(R.id.edhei);

        txtInter = (TextView) findViewById(R.id.txtinter);
        txtRes = (TextView) findViewById(R.id.txtres);

        btnRes = (Button) findViewById(R.id.btnres);
        btnReset = (Button) findViewById(R.id.btnreset);

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BmiActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strweg = edWeg.getText().toString();
                String strhei = edHei.getText().toString();

                if (strweg.equals("")){
                    edWeg.setError("Please Enter Your Weight");
                    edWeg.requestFocus();
                    return;
                }
                if (strhei.equals("")){
                    edHei.setError("Please Enter Your Height");
                    edHei.requestFocus();
                    return;
                }

                float weight = Float.parseFloat(strweg);
                float height = Float.parseFloat(strhei)/100;
                float bmiValue = BMICalculate(weight,height);

                txtInter.setText(interpreteBMI(bmiValue));
                txtRes.setText("BMI= " + bmiValue);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edHei.setText("");
                edWeg.setText("");
                txtInter.setText("");
                txtRes.setText("");

            }
        });

    }
    public float BMICalculate(float weight, float height){
        return weight / (height * height);
    }
    public String interpreteBMI(float bmiValue){
        if (bmiValue < 16){
            return "Servely Underweight";
        }
        else if (bmiValue < 18.5){
            return "Underweight";
        }
        else if (bmiValue < 21){
            return "Normal";
        }
        else if (bmiValue < 30){
            return "OverWeight";
        }
        else
            return "Obese";
    }
}
