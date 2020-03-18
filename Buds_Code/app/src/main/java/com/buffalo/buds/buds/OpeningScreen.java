package com.buffalo.buds.buds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class OpeningScreen extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_opening_screen);

        recyclerView = (RecyclerView) findViewById(R.id.opening_screen_recycler_view);

        ArrayList<String> myArray = new ArrayList<>();

        String[] list = getResources().getStringArray(R.array.Home_Menu_Options);

        ArrayList<Integer> images = new ArrayList<>();
        Integer[] imageList = new Integer[]{R.drawable.alpha,R.drawable.hindi,R.drawable.animals,
                R.drawable.numbers,R.drawable.shapes,R.drawable.colors};

        for(int i = 0; i<list.length; i++) {
            myArray.add(list[i]);
            images.add(imageList[i]);
        }


        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(OpeningScreen.this,
                myArray, images);

        //MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(OpeningScreen.this, myArray);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(myRecyclerAdapter);
    }
}

