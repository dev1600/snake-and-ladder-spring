package com.snakeandladder.snakeandladder.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;

@Document(collection =  "game")
public class Game {
    @Id
    private String id;
    private int gameResult;
    private int noOfTurnsToFinish;
    private Snakes snakes;
    private Ladders ladders;

    public Game(String id, int gameResult, int noOfTurnsToFinish, Snakes snakes, Ladders ladders) {
        this.id = id;
        this.gameResult = gameResult;
        this.noOfTurnsToFinish = noOfTurnsToFinish;
        this.snakes = snakes;
        this.ladders = ladders;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getGameResult() {
        return gameResult;
    }

    public void setGameResult(int gameResult) {
        this.gameResult = gameResult;
    }

    public int getNoOfTurnsToFinish() {
        return noOfTurnsToFinish;
    }

    public void setNoOfTurnsToFinish(int noOfTurnsToFinish) {
        this.noOfTurnsToFinish = noOfTurnsToFinish;
    }

    public Snakes getSnakes() {
        return snakes;
    }

    public void setSnakes(Snakes snakes) {
        this.snakes = snakes;
    }

    public Ladders getLadders() {
        return ladders;
    }

    public void setLadders(Ladders ladders) {
        this.ladders = ladders;
    }

}
