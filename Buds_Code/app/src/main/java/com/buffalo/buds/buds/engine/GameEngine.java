package com.buffalo.buds.buds.engine;

import com.buffalo.buds.buds.SnakeActivity;
import com.buffalo.buds.buds.classes.Coordinate;
import com.buffalo.buds.buds.enums.Direction;
import com.buffalo.buds.buds.enums.GameState;
import com.buffalo.buds.buds.enums.TileType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameEngine {
    SnakeActivity snakeactivity;
    public static final int GameWidth = 28;
    public static final int GameHeight = 42;

    private List<Coordinate> walls = new ArrayList<>();
    private List<Coordinate> snake = new ArrayList<>();
    private List<Coordinate> apples = new ArrayList<>();

    private Random  random = new Random();
    private boolean increaseTail = false;
    public int score = 0;

    private Direction currentDirection = Direction.East;
    private GameState currentGameState = GameState.Running;

    private Coordinate getSnakeHead(){
        return snake.get(0);
    }

    public GameEngine(){

    }

    public void initGame(){
        AddSnake();    
        AddWalls();
        AddApples();
}

      public void UpdateDirection(Direction newDirection){
        if(Math.abs(newDirection.ordinal() - currentDirection.ordinal())%2 ==1){
            currentDirection = newDirection;
        }
    }
int a=0;
    public void Update(){
        //Update The State
        switch (currentDirection){
            case North:
                UpdateSnake(0,1);
                break;
            case East:
                UpdateSnake(1,0);
                break;
            case South:
                UpdateSnake(0,-1);
                break;
            case West:
                UpdateSnake(-1,0);
                break;
        }
        //Check Wall Collision
        for (Coordinate w : walls){
            if(snake.get(0).equals(w)){
                currentGameState = GameState.lost;
            }
        }

        //Check self collision
        for (int i = 1; i <snake.size() ; i++) {
            
                if(getSnakeHead().equals(snake.get(i))){
                currentGameState = GameState.lost;
                return;
            }
        }
        //Check for the Apple
        Coordinate appleToRemove = null ;
        for (Coordinate apple : apples) {
            if(getSnakeHead().equals(apple)){
                appleToRemove = apple;
                updateScore();
                increaseTail = true;
            }
        }

            if(appleToRemove != null){
            apples.remove(appleToRemove);
            AddApples();
            }
   }


    public int updateScore() {
       score++;
        SnakeActivity.updateDelay();
       return score;
    }

    public TileType[][] getMap(){
        TileType[][] map = new TileType[GameWidth][GameHeight];

        for (int x=0;x<GameWidth;x++){
            for (int y=0;y<GameHeight;y++){
                map[x][y] = TileType.Nothing;
            }
        }

        for(Coordinate wall:walls) {
            map[wall.getX()][wall.getY()] = TileType.Wall;
        }

        for (Coordinate s:snake){
            map[s.getX()][s.getY()] = TileType.SnakeTail;
        }

        for (Coordinate a:apples){
            map[a.getX()][a.getY()] = TileType.Apple;
        }

        map[snake.get(0).getX()][snake.get(0).getY()] = TileType.SnakeHead;

        return map;
    }

    private void UpdateSnake(int x , int y){
        int newX = snake.get(snake.size()-1).getX();
        int newY = snake.get(snake.size()-1).getY();

        for (int i = snake.size()-1; i >0; i--) {
            snake.get(i).setX(snake.get(i-1).getX());
            snake.get(i).setY(snake.get(i-1).getY());
        }

        if(increaseTail){
            snake.add(new Coordinate(newX,newY));
            increaseTail = false;
        }

            snake.get(0).setX(snake.get(0).getX() + x);
            snake.get(0).setY(snake.get(0).getY() + y);
    }

    private void AddSnake() {
        snake.clear();

        snake.add(new Coordinate(7,7));
        snake.add(new Coordinate(6,7));
        snake.add(new Coordinate(5,7));
        snake.add(new Coordinate(4,7));
        snake.add(new Coordinate(3,7));
        snake.add(new Coordinate(2,7));
    }


    private void AddWalls() {
        //Top and Bottom Walls
        for(int x=0;x<GameWidth;x++){
            walls.add(new Coordinate(x,0));
            walls.add(new Coordinate(x,GameHeight-1));
        }
        //Left and Right Walls
        for(int y=1;y<GameHeight;y++){
            walls.add(new Coordinate(0,y));
            walls.add(new Coordinate(GameWidth-1,y));
        }
    }

    private void AddApples() {
        Coordinate coordinate = null ;
        boolean added = false;

        while (!added){
            int x = 1 +random.nextInt(GameWidth - 2);
            int y = 1 +random.nextInt(GameHeight - 2);

            coordinate = new Coordinate(x,y);
            boolean collision = false;
            for (Coordinate s : snake){
                if(s.equals(coordinate)){
                    collision = true;
                //    break;
                }
            }
            for(Coordinate a : apples){
                if(a.equals(coordinate)){
                    collision = true;
                //    break;
                }
            }

            added = !collision;
        }
        apples.add(coordinate);
    }


    public GameState getCurrentGameState()
    {
        return currentGameState;
    }


}
