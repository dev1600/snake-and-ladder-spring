package com.snakeandladder.snakeandladder.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import java.util.Map;
@JsonDeserialize(using= com.snakeandladder.snakeandladder.deserializer.SnakesDeserializer.class)
public class Snakes {
    private Map<Integer,Integer> snakeCoordinates;
    public Snakes(){};
    public Snakes(Map<Integer, Integer> snakeCoordinates) {
        this.snakeCoordinates = snakeCoordinates;
    }

    public Map<Integer, Integer> getSnakeCoordinates() {
        return snakeCoordinates;
    }

    public void setSnakeCoordinates(Map<Integer, Integer> snakeCoordinates) {
        this.snakeCoordinates = snakeCoordinates;
    }
    public int checkForSnake(int pos){
        if(snakeCoordinates.containsKey(pos)) return snakeCoordinates.get(pos);
        return pos;
    }
    @Override
    public String toString() {
        return "Snakes{" +
                "snakeCoordinates=" + snakeCoordinates +
                '}';
    }
}
