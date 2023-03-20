package com.snakeandladder.snakeandladder.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection =  "game")
public class Game {
    @Id
    private String id;
    private int gameResult;
    private int noOfTurns;
    private int player1Position;
    private int player2Position;
    private Snakes snakes;
    private Ladders ladders;

    public Game(String id, int gameResult, int noOfTurns, int player1Position, int player2Position, Snakes snakes, Ladders ladders) {
        this.id = id;
        this.gameResult = gameResult;
        this.noOfTurns = noOfTurns;
        this.player1Position = player1Position;
        this.player2Position = player2Position;
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

    public int getNoOfTurns() {
        return noOfTurns;
    }

    public void setNoOfTurns(int noOfTurns) {
        this.noOfTurns = noOfTurns;
    }

    public int getPlayer1Position() {
        return player1Position;
    }

    public void setPlayer1Position(int player1Position) {
        this.player1Position = player1Position;
    }

    public int getPlayer2Position() {
        return player2Position;
    }

    public void setPlayer2Position(int player2Position) {
        this.player2Position = player2Position;
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


    @Override
    public String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                ", gameResult=" + gameResult +
                ", noOfTurnsToFinish=" + noOfTurns +
                ", player1Position=" + player1Position +
                ", player2Position=" + player2Position +
                ", snakes=" + snakes +
                ", ladders=" + ladders +
                '}';
    }

}
