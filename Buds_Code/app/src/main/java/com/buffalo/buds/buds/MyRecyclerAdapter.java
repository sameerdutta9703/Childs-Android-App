package com.buffalo.buds.buds;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import java.util.ArrayList;

public class MyRecyclerAdapter
        extends RecyclerView.Adapter<MyRecyclerAdapter
        .MyViewHolder> {

    private Context context;
    private ArrayList<String> myItems;
    private ArrayList<Integer> myImages;
    private LayoutInflater inflater;


    MyRecyclerAdapter(Context context, ArrayList<String> myItems,ArrayList<Integer> myImages){
        this.context = context;
        this.myItems = myItems;
        this.myImages = myImages;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = inflater.inflate(R.layout.home_screen_layout,
                parent, false);
        return new MyViewHolder(item,inflater,parent);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.myText.setText(myItems.get(position));
        holder.myImage.setImageResource(myImages.get(position));

    }

    @Override
    public int getItemCount() {
        return myItems.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView myText;
        ImageView myImage;

        public MyViewHolder(View itemView, LayoutInflater inflater, ViewGroup parent) {
            super(itemView);
            myText = itemView.findViewById(R.id.Menu_text);
            myImage = itemView.findViewById(R.id.Menu_image);
            myImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    switch (getAdapterPosition())
                    {
                        case 0:
                           context.startActivity(new Intent(context,EnglishAlphabets.class));
                            break;
                        case 1:
                            context.startActivity(new Intent(context,HindiAlphabets.class));
                            break;
                        case 2:
                            context.startActivity(new Intent(context,Animal.class));
                            break;
                        case 3:
                            context.startActivity(new Intent(context,Numbers.class));
                            break;
                        case 4:
                            context.startActivity(new Intent(context,Shapes.class));
                            break;
                        case 5:
                           context.startActivity(new Intent(context,Colours.class));
                            break;
                    }
                }
            });
        }


    }//AppCompat.Light.DarkActionBar
}


