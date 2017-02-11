package com.m1m2.geoquiz;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.m1m2.geoquiz.qa_manager.Repository;

public class QuizActivity extends AppCompatActivity {

    private TextView question;
    private Button trueButton;
    private Button falseButton;
    private Typeface sportify;
    private Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        repository = new Repository();
        sportify = Typeface.createFromAsset(getAssets(), getResources().getString(R.string.sportify));
        question = (TextView) findViewById(R.id.tv_question);
        question.setTypeface(sportify);
        Log.d("random question",repository.getRandomQuestion());
        question.setText(repository.getRandomQuestion());
        trueButton = (Button) findViewById(R.id.button_true);
        trueButton.setTypeface(sportify);
        /* Handle button click event */
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   displayResponseToast(true);
            }
        });

        falseButton = (Button) findViewById(R.id.button_false);
        falseButton.setTypeface(sportify);
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayResponseToast(false);
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    private void displayResponseToast(boolean response){/* response lets us know user answer */
        Toast toast = Toast.makeText(this,"",Toast.LENGTH_LONG);
        TextView tv_toastmsg = (TextView)toast.getView().findViewById(android.R.id.message);
        tv_toastmsg.setTypeface(sportify);
        String message = new String(" your answer is");

        // Log.d("question",question.getText().toString());
        if(repository.isCorrectAnswer(question.getText().toString(),response)) {
            message += " correct";
            toast.getView().setBackgroundColor(Color.GRAY);
        }else{
            message += " incorrect";
            toast.getView().setBackgroundColor(Color.RED);
        }
        tv_toastmsg.setTextColor(Color.WHITE);
        toast.setText(message);
        toast.show();
    }

}
