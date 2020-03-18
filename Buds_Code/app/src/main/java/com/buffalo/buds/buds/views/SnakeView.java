package com.buffalo.buds.buds.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.buffalo.buds.buds.enums.TileType;

public class SnakeView extends View {
    private Paint mpaint = new Paint();
    private TileType snakeViewMap [][];

    public SnakeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setSnakeViewMap (TileType[][] map){ this.snakeViewMap = map; }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(snakeViewMap !=null){
            float tileSizeX = canvas.getWidth()/snakeViewMap.length;
            float tileSizeY = canvas.getHeight()/snakeViewMap[0].length;

            float circleSize = Math.min(tileSizeX,tileSizeY)/2;

            for(int x=0;x<snakeViewMap.length;x++){
                for(int y=0;y<snakeViewMap[0].length;y++) {
                    switch (snakeViewMap[x][y]) {

                        case Nothing:
                            mpaint.setColor(Color.WHITE);
                            break;
                        case Wall:
                            mpaint.setColor(Color.GREEN);
                            break;
                        case SnakeHead:
                            mpaint.setColor(Color.BLUE);
                            break;
                        case SnakeTail:
                            mpaint.setColor(Color.GREEN);
                            break;
                        case Apple:
                            mpaint.setColor(Color.RED);
                            break;
                    }
                    canvas.drawCircle(x*tileSizeX+tileSizeX/2f+circleSize/2 , y*tileSizeY+tileSizeY/2f+circleSize/2 , circleSize , mpaint);
                }
            }

        }
    }
}