package com.buffalo.buds.buds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartingScreenActivity extends AppCompatActivity {
Button lrn,qz,gm,rhym;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_screen);

        lrn= findViewById(R.id.learn);
        qz= findViewById(R.id.quiz);
        gm= findViewById(R.id.games);
        rhym= findViewById(R.id.rhymes);

      lrn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StartingScreenActivity.this,OpeningScreen.class);
                startActivity(intent);
            }
        });
        qz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StartingScreenActivity.this,QMainActivity.class);
                startActivity(intent);
            }
        });

        gm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StartingScreenActivity.this,SnakeMain.class);
                startActivity(intent);
            }
        });

        rhym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StartingScreenActivity.this,Customlist_rhymes.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}