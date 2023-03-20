package com.snakeandladder.snakeandladder.model;

import com.snakeandladder.snakeandladder.util.Dice;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection =  "game")
public class Game {
    @Id
    private String id;
    private int gameResult;
    private int noOfTurns;
    private Player player1;
    private Player player2;
    private Snakes snakes;
    private Ladders ladders;

    public Game(String id, int gameResult, int noOfTurns, Player player1, Player player2, Snakes snakes, Ladders ladders){
        this.id = id;
        this.gameResult = gameResult;
        this.noOfTurns = noOfTurns;
        this.player1 = player1;
        this.player2 = player2;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public String rollDice() {
        if (gameResult == 0) {
            int roll = Dice.roll();
            setPosition(noOfTurns % 2 == 0 ? player1 : player2, roll);
            noOfTurns++;
            return "No. Generated is " + roll + "\nPlayer 1 position is " + player1.getPosition() +
                    "\nPlayer 2 position is " + player2.getPosition();
        } else {
            return "Game is Already Finished! Player " + gameResult + " Won";
        }
    }
    private void setPosition(Player player, int roll) {
        int pos = player.getPosition() + roll;
        if (pos < 100) {
            pos = ladders.checkForLadder(pos);
            pos = snakes.checkForSnake(pos);
            player.setPosition(pos);
        } else {
            player.setPosition(100);
            gameResult = player.equals(player1) ? 1 : 2;
        }
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

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
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
                ", noOfTurns=" + noOfTurns +
                ", player1=" + player1 +
                ", player2=" + player2 +
                ", snakes=" + snakes +
                ", ladders=" + ladders +
                '}';
    }
}
