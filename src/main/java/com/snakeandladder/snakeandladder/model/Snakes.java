package com.snakeandladder.snakeandladder.model;

import java.util.HashMap;

public class Snakes {
    private HashMap<Integer,Integer> snakeCoordinates;
    public Snakes(){}
    public Snakes(HashMap<Integer, Integer> snakeCoordinates) {
        this.snakeCoordinates = snakeCoordinates;
    }

    public HashMap<Integer, Integer> getSnakeCoordinates() {
        return snakeCoordinates;
    }

    public void setSnakeCoordinates(HashMap<Integer, Integer> snakeCoordinates) {
        this.snakeCoordinates = snakeCoordinates;
    }
}
