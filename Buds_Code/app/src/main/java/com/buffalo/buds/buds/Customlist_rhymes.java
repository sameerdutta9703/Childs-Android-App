package com.buffalo.buds.buds;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Customlist_rhymes extends AppCompatActivity {
    private ListView myCustomList;
    MediaPlayer mp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customlist_rhymes);
        myCustomList = findViewById(R.id.mycustomlist);

        ArrayList<String> myArray = new ArrayList<>();

        String[] list = getResources().getStringArray(R.array.rhymes);
        for (int i = 0; i < list.length; i++) {
            myArray.add(list[i]);
        }

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.shapes2);
        images.add(R.drawable.london1);
        images.add(R.drawable.baa);
        images.add(R.drawable.twinkle);
        images.add(R.drawable.clap);

        MyCustomAdapter myCustomAdapter = new MyCustomAdapter(Customlist_rhymes.this,
                myArray, images);
        myCustomList.setAdapter(myCustomAdapter);

        mp = MediaPlayer.create(Customlist_rhymes.this, R.raw.baa);

        myCustomList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //String myvalue = adapterView.getItemAtPosition(i).toString();

                if (mp.isPlaying()) {

                    switch (i) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            mp.stop();
                            break;

                    }
                }

                // else if(!mp.isPlaying()) {
                switch (i) {
                    case 0:
                        mp = MediaPlayer.create(Customlist_rhymes.this, R.raw.alpha);
                        mp.start();
                        break;
                    case 1:
                        mp = MediaPlayer.create(Customlist_rhymes.this, R.raw.london);
                        mp.start();
                        break;
                    case 2:
                        mp = MediaPlayer.create(Customlist_rhymes.this, R.raw.baa);
                        mp.start();
                        break;
                    case 3:
                        mp = MediaPlayer.create(Customlist_rhymes.this, R.raw.twinkle);
                        mp.start();
                        break;
                    case 4:
                        //view.setBackgroundColor(Color.GREEN);
                        mp = MediaPlayer.create(Customlist_rhymes.this, R.raw.clap);
                        mp.start();
                        break;
                }

            }

        });


    }
    @Override
    public void onBackPressed(){

        if(mp.isPlaying())
            mp.stop();
        this.finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.finish();
    }
}