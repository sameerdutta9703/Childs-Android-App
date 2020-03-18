package com.buffalo.buds.buds;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private QuizBook mQuizBook = new QuizBook();

    private TextView mScoreView, mQuestionView;
    private ImageView mImageView;
    private Button mButtonChoice1, mButtonChoice2, mButtonChoice3, mButtonChoice4;

    private int mScore = 0;
    private int mQuestionNumber = 0;
    private String mAnswer=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quiz);


        mScoreView = (TextView)findViewById(R.id.points);
        mImageView = (ImageView)findViewById(R.id.imageView);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.option1);
        mButtonChoice2 = (Button)findViewById(R.id.option2);
        mButtonChoice3 = (Button)findViewById(R.id.option3);
        mButtonChoice4 = (Button)findViewById(R.id.option4);
        updateQuestion();

        //Start of Button Listner for Button 1
        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(mButtonChoice1.getText() == mAnswer){
                    mScore = mScore+1;
                    updateScore(mScore);
                    Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
                else{
                    Toast.makeText(QuizActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();

                }
            }
        });
        //End of Button Listner for Button 1


        //Start of Button Listner for Button 2
        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(mButtonChoice2.getText() == mAnswer){
                    mScore = mScore+1;
                    updateScore(mScore);
                    Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
                else{
                    Toast.makeText(QuizActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();

                }
            }
        });
        //End of Button Listner for Button 2


        //Start of Button Listner for Button 3
        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(mButtonChoice3.getText() == mAnswer){
                    mScore = mScore+1;
                    updateScore(mScore);
                    Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
                else{
                    Toast.makeText(QuizActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();

                }
            }
        });
        //End of Button Listner for Button 3


        //Start of Button Listner for Button 4
        mButtonChoice4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(mButtonChoice4.getText() == mAnswer){
                    mScore = mScore+1;
                    updateScore(mScore);
                    Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
                else{
                    Toast.makeText(QuizActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();

                }
            }
        });
        //End of Button Listner for Button 4

    }

    private void updateQuestion() {

        if (mQuestionNumber == 10) {
            AlertDialog.Builder alert = new AlertDialog.Builder(QuizActivity.this);
            alert.setTitle("You Scored");
            alert.setMessage(mScore + "");
            alert.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });

            alert.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(QuizActivity.this, StartingScreenActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            alert.setCancelable(false);
            alert.show();
            return;
        }

        mImageView.setImageResource(mQuizBook.getImages(mQuestionNumber));
        mQuestionView.setText((mQuizBook.getQuestion(mQuestionNumber)));
        mButtonChoice1.setText(mQuizBook.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuizBook.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuizBook.getChoice3(mQuestionNumber));
        mButtonChoice4.setText(mQuizBook.getChoice4(mQuestionNumber));

        mAnswer = mQuizBook.getAnswer(mQuestionNumber);



//        if (mQuestionNumber != 9)


        mQuestionNumber++;


    }
    private void updateScore(int points) {
        mScoreView.setText("" + mScore);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.finish();
    }
}


