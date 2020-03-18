package com.buffalo.buds.buds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyCustomAdapter extends BaseAdapter{
    private ArrayList<String> itemsList;
    private LayoutInflater layoutInflater;
    private ArrayList<Integer> images;
    private Context context;

    MyCustomAdapter(Context context, ArrayList<String> listitems, ArrayList<Integer> images){
        this.itemsList=listitems;
        this.layoutInflater=LayoutInflater.from(context);
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return itemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemsList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int pos, View view, ViewGroup parent) {
        if(view==null){
            view=layoutInflater.inflate(R.layout.custom_rhymes_items,null);
            ImageView myImage=view.findViewById(R.id.imageView);
            TextView textView=view.findViewById(R.id.textView);

            if(images.get(pos)!=null)
                myImage.setImageResource(images.get(pos));
            textView.setText(itemsList.get(pos));
        }
        return view;
    }
}

