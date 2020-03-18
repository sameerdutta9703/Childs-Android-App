package com.buffalo.buds.buds;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.buffalo.buds.buds.engine.GameEngine;
import com.buffalo.buds.buds.enums.Direction;
import com.buffalo.buds.buds.enums.GameState;
import com.buffalo.buds.buds.views.SnakeView;


public class SnakeActivity extends AppCompatActivity implements View.OnTouchListener {

    MediaPlayer mp=null;
    private GameEngine gameEngine;
    private SnakeView snakeView;
    private final Handler handler = new Handler();
    public static long delay = 500;
    private float prevX , prevY ;
    private AlertDialog.Builder alert;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snake);

//        SnakeActivity.delay = 500;
        Toast.makeText(SnakeActivity.this,"Swipe in any direction to move the snake",Toast.LENGTH_LONG).show();

        gameEngine = new GameEngine();
        gameEngine.initGame();

        snakeView = (SnakeView)findViewById(R.id.snakeView);
        //snakeView.setSnakeViewMap(gameEngine.getMap());
        //snakeView.invalidate();
        snakeView.setOnTouchListener(this);
        mp=MediaPlayer.create(SnakeActivity.this,R.raw.snake_music);
        startUpdateHandler();


    }

    private void startUpdateHandler(){
        runnable = new Runnable() {
            @Override
            public void run() {

                if (!mp.isPlaying()) {
                    mp.start();
                }
                gameEngine.Update();

                if (gameEngine.getCurrentGameState() == GameState.Running) {
                    handler.postDelayed(this, SnakeActivity.delay);
                }
                if (gameEngine.getCurrentGameState() == GameState.lost) {
                    OnGamelost();
                }
                snakeView.setSnakeViewMap(gameEngine.getMap());
                snakeView.invalidate();
            }
        };
        handler.postDelayed(runnable, delay);
    }

    public static void updateDelay() {
        if(SnakeActivity.delay>75)
            SnakeActivity.delay=SnakeActivity.delay-8;
    }


    public void OnGamelost(){
        if(mp.isPlaying()){
            mp.stop();
            mp=MediaPlayer.create(SnakeActivity.this,R.raw.lost);
            mp.start();
        }
        Toast.makeText(this, "You Lost.", Toast.LENGTH_SHORT).show();
        alert = new AlertDialog.Builder(SnakeActivity.this);
        alert.setTitle("You Scored");
        alert.setMessage(gameEngine.updateScore()-1+"");
        alert.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(SnakeActivity.this, SnakeMain.class);
                startActivity(intent);
            }
        });

        alert.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(SnakeActivity.this, StartingScreenActivity.class);
                startActivity(intent);
            }
        });
        alert.setCancelable(false);
        alert.show();
        SnakeActivity.delay = 500;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()){

            case MotionEvent.ACTION_DOWN:
                prevX = motionEvent.getX();
                prevY = motionEvent.getY();
                break;

            case MotionEvent.ACTION_UP:
                float newX = motionEvent.getX();
                float newY = motionEvent.getY();

                //Calculate where we Swiped

                if(Math.abs((newX - prevX)) > (Math.abs(newY - prevY))){
                    if(newX > prevX){
                        gameEngine.UpdateDirection(Direction.East);
                    }
                    else
                    {
                        gameEngine.UpdateDirection(Direction.West);
                    }
                }
                else{
                    if(newY > prevY){
                        gameEngine.UpdateDirection(Direction.North);
                    }
                    else
                    {
                        gameEngine.UpdateDirection(Direction.South);
                    }
                }


                break;
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mp.stop();
        this.finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(handler!=null && runnable!=null){
            handler.removeCallbacks(runnable);
        }
        this.finish();
    }
}
