package com.example.pamo2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    private Button yesBtn;
    private Button noBtn;
    private TextView question;
    private ImageView image;

    Button back;

    private int currentIndex = 0;
    private Integer images[] = {R.mipmap.coffee, R.mipmap.sugar, R.mipmap.cucumber, R.mipmap.potatoes,
            R.mipmap.honey, R.mipmap.gluten};
    private Question[] questionBank = new Question[]{
            new Question(R.string.my_question1, true),
            new Question(R.string.my_question2, true),
            new Question(R.string.my_question3, true),
            new Question(R.string.my_question4, false),
            new Question(R.string.my_question5, false),
            new Question(R.string.my_question6, false),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        yesBtn = findViewById(R.id.yesBtn);
        noBtn = findViewById(R.id.noBtn);
        question = findViewById(R.id.txtQue);
        image = findViewById(R.id.questionImage);

        image.setImageResource(images[currentIndex]);
        yesBtn.setOnClickListener(this::onClick);
        noBtn.setOnClickListener(this::onClick);

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizActivity.this, MainActivity.class);
                startActivity(intent);
                correctCount = 0;
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.noBtn:
                checkAnswers(false);
                currentIndex++;
                updateQuestion();
                break;
            case R.id.yesBtn:
                checkAnswers(true);
                currentIndex++;
                updateQuestion();
                break;
        }
    }

    private void updateQuestion(){
        if(currentIndex<questionBank.length){
            question.setText(questionBank[currentIndex].getAnsID());
            image.setImageResource(images[currentIndex]);
        }else {
            question.setText("Total correct answer: "+correctCount);
            yesBtn.setVisibility(View.GONE);
            noBtn.setVisibility(View.GONE);
            image.setVisibility(View.GONE);
        }
    }

    private static int correctCount=0;
    private void checkAnswers(boolean userAnswers){
        boolean isTrue = questionBank[currentIndex].isAns();
        if(userAnswers==isTrue){
            correctCount++;
        }
    }
}