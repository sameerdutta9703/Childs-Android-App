package com.buffalo.buds.buds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.buffalo.buds.buds.engine.GameEngine;

public class SnakeMain extends AppCompatActivity {
ImageButton start,quit;
//TextView score;
//int prevScore,highscore=0;


    GameEngine gameEngine;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snake_main);

        start=findViewById(R.id.imageButton);
        quit=findViewById(R.id.imageButton2);
       // score=findViewById(R.id.textView5);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(SnakeMain.this,SnakeActivity.class);
                startActivity(intent);
            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(SnakeMain.this,StartingScreenActivity.class);
                startActivity(intent);
            }
        });
//        score.setText(0+"");
//        if(highscore!=0)
//        prevScore=gameEngine.updateScore()-1;
//        if(highscore>prevScore)
//        score.setText(highscore + "");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(SnakeMain.this,StartingScreenActivity.class);
        startActivity(intent);
    }
}

