package com.buffalo.buds.buds;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Colours extends AppCompatActivity {
    ListView colours;
    MediaPlayer mp=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colours);

        colours = findViewById(R.id.colors_listView);

        ArrayAdapter <CharSequence> myAdapter = ArrayAdapter.createFromResource(Colours.this,R.array.Colours_List,
                android.R.layout.simple_list_item_1);
        colours.setAdapter(myAdapter);
        mp=MediaPlayer.create(Colours.this,R.raw.black);

        colours.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(mp.isPlaying()){
                    switch (i){
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                            mp.stop();
                            break;
                    }
                }
                switch (i){
                    case 0 :
                        //adapterView.getChildAt(i).setBackgroundColor(Color.BLACK);
                        view.setBackgroundColor(Color.BLACK);
                        mp=MediaPlayer.create(Colours.this,R.raw.black);
                        mp.start();
                        break;
                    case 1:
                        view.setBackgroundColor(Color.GRAY);
                        mp=MediaPlayer.create(Colours.this,R.raw.grey);
                        mp.start();
                        break;
                    case 2:
                        view.setBackgroundColor(Color.rgb(72,33,134));
                        mp=MediaPlayer.create(Colours.this,R.raw.purple);
                        mp.start();
                        break;
                    case 3:
                        view.setBackgroundColor(Color.BLUE);
                        mp=MediaPlayer.create(Colours.this,R.raw.blue);
                        mp.start();
                        break;
                    case 4:
                        view.setBackgroundColor(Color.GREEN);
                        mp=MediaPlayer.create(Colours.this,R.raw.green);
                        mp.start();
                        break;
                    case 5:
                        view.setBackgroundColor(Color.YELLOW);
                        mp=MediaPlayer.create(Colours.this,R.raw.yellow);
                        mp.start();
                        break;
                    case 6:
                        view.setBackgroundColor(Color.rgb(255,106,0));
                        mp=MediaPlayer.create(Colours.this,R.raw.orange);
                        mp.start();
                        break;
                    case 7:
                        view.setBackgroundColor(Color.RED);
                        mp=MediaPlayer.create(Colours.this,R.raw.red);
                        mp.start();
                        break;
                    case 8:
                        view.setBackgroundColor(Color.GRAY);
                        view.setBackgroundColor(Color.WHITE);
                        mp=MediaPlayer.create(Colours.this,R.raw.white);
                        mp.start();
                        break;
                    case 9:
                        view.setBackgroundColor(Color.parseColor("#FFFF40E9"));
                        mp=MediaPlayer.create(Colours.this,R.raw.pink);
                        mp.start();
                        break;
                    case 10:
                        view.setBackgroundColor(Color.parseColor("#FF9A3502"));
                        mp=MediaPlayer.create(Colours.this,R.raw.brown);
                        mp.start();
                        break;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mp.stop();
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.finish();
    }
}
