package com.example.challengeday2_project2_quizapp_mvcarchitecture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.challengeday2_project2_quizapp_mvcarchitecture.Model.Question;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "MainActivity";
    private TextView answerRes;
    private Button trueButton;
    private Button falseButton;
    private ImageButton nextButton;
    private ImageButton previousButton;

    private Question[] question = new Question[]{
            new Question(R.string.question_1,false),
            new Question(R.string.question_2,true),
            new Question(R.string.question_3,false),
            new Question(R.string.question_4,false),
            new Question(R.string.question_5,false),
            new Question(R.string.question_6,true),
            new Question(R.string.question_7,true),
    };


    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        answerRes = findViewById(R.id.answersResourceText);
        trueButton = findViewById(R.id.trueBtn);
        falseButton = findViewById(R.id.falseBtn);
        nextButton = findViewById(R.id.nextBtn);
        previousButton = findViewById(R.id.previousBtn);

        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        previousButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.trueBtn:
                checkAnswer(true);
                break;

            case R.id.falseBtn:
                checkAnswer(false);
                break;

            case R.id.nextBtn:
                currentQuestionIndex = (currentQuestionIndex + 1) % question.length;
                updateQuestion();
                Log.d(TAG, "next: "+currentQuestionIndex);
                break;

            case R.id.previousBtn:

                if(currentQuestionIndex>0){
                    currentQuestionIndex = (currentQuestionIndex -1) % question.length;
                    updateQuestion();
                    Log.d(TAG, "previous: "+currentQuestionIndex);

                }

                break;

        }
    }

    private void updateQuestion(){
        answerRes.setText(question[currentQuestionIndex].getAnswerResId());
    }
    private void checkAnswer(boolean checkAnswerIsTrue){

        boolean isAnswerTrue = question[currentQuestionIndex].isAnswerTrue();

        if (checkAnswerIsTrue == isAnswerTrue){
            Toast.makeText(getApplicationContext(), R.string.correct_answer,Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), R.string.wrong_answer,Toast.LENGTH_SHORT).show();
        }
    }
}
