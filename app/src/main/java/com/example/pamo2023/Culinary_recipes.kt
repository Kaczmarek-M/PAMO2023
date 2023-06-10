package com.example.pamo2023;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Culinary_recipes extends AppCompatActivity {

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culinary_recipes);

        findViewById(R.id.firstRec).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstRecipe("https://recipes.net/main-dish/vegetables/asparagus-with-sherry-and-bacon-vinaigrette-recipe/#wprm-recipe-container-261");
            }
        });

        findViewById(R.id.secondRec).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondRecipe("https://recipes.net/main-dish/pasta/ravioli-alfredo-with-herbes-de-provence-recipe");
            }
        });

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Culinary_recipes.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    public void firstRecipe (String url){

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
    public void secondRecipe (String url){

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
