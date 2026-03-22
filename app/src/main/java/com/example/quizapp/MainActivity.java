package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvQuestion;
    private Button btnOption1, btnOption2, btnOption3, btnOption4;
    
    private ArrayList<Question> questionList;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvQuestion = findViewById(R.id.tv_question);
        btnOption1 = findViewById(R.id.btn_option1);
        btnOption2 = findViewById(R.id.btn_option2);
        btnOption3 = findViewById(R.id.btn_option3);
        btnOption4 = findViewById(R.id.btn_option4);

        btnOption1.setOnClickListener(this);
        btnOption2.setOnClickListener(this);
        btnOption3.setOnClickListener(this);
        btnOption4.setOnClickListener(this);

        loadQuestions();
        setQuestion();
    }

    private void loadQuestions() {
        questionList = new ArrayList<>();
        questionList.add(new Question("What is the capital of France?", "Berlin", "Madrid", "Paris", "Rome", 3));
        questionList.add(new Question("Which programming language is used for Android native apps?", "Python", "Java/Kotlin", "Swift", "C#", 2));
        questionList.add(new Question("What does XML stand for?", "Extensible Markup Language", "Executable Multiple Language", "Extra Multi-Program Language", "Examine Multiple Language", 1));
    }

    private void setQuestion() {
        if (currentQuestionIndex < questionList.size()) {
            Question currentQuestion = questionList.get(currentQuestionIndex);
            tvQuestion.setText(currentQuestion.getQuestion());
            btnOption1.setText(currentQuestion.getOption1());
            btnOption2.setText(currentQuestion.getOption2());
            btnOption3.setText(currentQuestion.getOption3());
            btnOption4.setText(currentQuestion.getOption4());
        } else {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("SCORE", score);
            intent.putExtra("TOTAL", questionList.size());
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        Question currentQuestion = questionList.get(currentQuestionIndex);
        
        int clickedButtonIndex = 0;
        if (v.getId() == R.id.btn_option1) clickedButtonIndex = 1;
        else if (v.getId() == R.id.btn_option2) clickedButtonIndex = 2;
        else if (v.getId() == R.id.btn_option3) clickedButtonIndex = 3;
        else if (v.getId() == R.id.btn_option4) clickedButtonIndex = 4;

        if (clickedButtonIndex == currentQuestion.getAnswerIndex()) {
            score++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong! The correct answer was option " + currentQuestion.getAnswerIndex(), Toast.LENGTH_SHORT).show();
        }

        currentQuestionIndex++;
        setQuestion();
    }
}
