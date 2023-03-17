package com.snakeandladder.snakeandladder.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public class Ladders {
    private HashMap<Integer,Integer> ladderCoordinates;
    public Ladders(){}
    public Ladders(HashMap<Integer, Integer> ladderCoordinates) {
        this.ladderCoordinates = ladderCoordinates;
    }

    public HashMap<Integer, Integer> getLadderCoordinates() {
        return ladderCoordinates;
    }

    public void setLadderCoordinates(HashMap<Integer, Integer> ladderCoordinates) {
        this.ladderCoordinates = ladderCoordinates;
    }
}
