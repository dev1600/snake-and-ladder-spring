package com.snakeandladder.snakeandladder.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using=com.snakeandladder.snakeandladder.deserializer.LaddersDeserializer.class)
public class Ladders {
    private Map<Integer,Integer> ladderCoordinates;
    public Ladders(){}
    public Ladders(Map<Integer, Integer> ladderCoordinates) {
        this.ladderCoordinates = ladderCoordinates;
    }

    public Map<Integer, Integer> getLadderCoordinates() {
        return ladderCoordinates;
    }

    public void setLadderCoordinates(Map<Integer, Integer> ladderCoordinates) {
        this.ladderCoordinates = ladderCoordinates;
    }

    @Override
    public String toString() {
        return "Ladders{" +
                "ladderCoordinates=" + ladderCoordinates +
                '}';
    }
}
