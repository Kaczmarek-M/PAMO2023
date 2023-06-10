package com.example.pamo2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Calories_per_der extends AppCompatActivity {

    Button back, btn;
    EditText height, weight, age;
    TextView result;
    LinearLayout malelayout, femalelayout;
    ImageView mimg, fimg;

    double h=0, w=0, a=0, bmr=0;
    String user = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories_per_der);

        btn = findViewById(R.id.btncal);
        height = findViewById(R.id.heighttxt);
        weight = findViewById(R.id.weighttxt);
        age = findViewById(R.id.agetxt);
        result = findViewById(R.id.result);
        malelayout = findViewById(R.id.male);
        femalelayout = findViewById(R.id.female);
        mimg = findViewById(R.id.maleimg);
        fimg = findViewById(R.id.femaleimg);

        malelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mimg.setColorFilter(getResources().getColor(R.color.white));
                fimg.setColorFilter(getResources().getColor(R.color.black));
                user = "Male";
            }
        });
        femalelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fimg.setColorFilter(getResources().getColor(R.color.white));
                mimg.setColorFilter(getResources().getColor(R.color.black));
                user = "Female";
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = height.getText().toString();
                String str2 = weight.getText().toString();
                String str3 = age.getText().toString();
                if (user.equals("0")){
                    Toast.makeText(Calories_per_der.this, "Select your gender", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(str1)){
                    height.setError("Select Height");
                    height.requestFocus();
                    return;
                }
                else if (TextUtils.isEmpty(str2)){
                    weight.setError("Select Weight");
                    weight.requestFocus();
                    return;
                }
                else if (TextUtils.isEmpty(str3)){
                    age.setError("Select Age");
                    age.requestFocus();
                    return;
                }
                else {
                    calculate();
                }

            }
        });

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calories_per_der.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    private void calculate(){
        h = Double.parseDouble(height.getText().toString());
        w = Double.parseDouble(weight.getText().toString());
        a = Double.parseDouble(age.getText().toString());
        if (user.equals("Male")){
            bmr=((10*w) + (6.25 * h) - (5*a) + 5);
            result.setText(Double.toString(bmr));
        }
        if (user.equals("Female")){
            bmr=((10*w) + (6.25 * h) - (5 * a) + 161);
            result.setText(Double.toString(bmr));
        }
    }
}
