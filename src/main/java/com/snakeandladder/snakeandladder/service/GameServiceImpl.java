package com.snakeandladder.snakeandladder.service;

import com.snakeandladder.snakeandladder.model.Game;
import com.snakeandladder.snakeandladder.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GameServiceImpl implements GameService{
    @Autowired
    GameRepository gameRepository;
    private static ConcurrentHashMap<String, Game> gameCache=new ConcurrentHashMap<>();
    @Override
    public ConcurrentHashMap<String, Game> getGameCache() {
        return gameCache;
    }
    @Override
    public String rollDice(String id) {
        int no;
        String resultOfDiceRoll;
        if(gameCache.containsKey(id)){
            Game game=gameCache.get(id);
            if(game.getGameResult()==0){
                no=generator();
                if(game.getNoOfTurns()%2==0) setPositionPlayer1(game,no); //if even no. of turns even then its Player 1 turn else Player 2
                else setPositionPlayer2(game,no);
                game.setNoOfTurns(game.getNoOfTurns()+1);
                resultOfDiceRoll="No. Generated is "+no+"\nPlayer 1 position is "+game.getPlayer1Position()+
                                 "\nPlayer 2 position is "+game.getPlayer2Position();
                gameCache.put(id,game);
            }
            else{
                return "Game is Already Finished ! Player "+game.getGameResult()+" Won";
            }
        }
        else return "Game Id not found!!!";
        return resultOfDiceRoll;
    }
    private void  setPositionPlayer1(Game game,int no){
        int pos=game.getPlayer1Position()+no;
        if(game.getPlayer1Position()+no<100){
            pos=checkForLadders(game,pos);
            pos=checkForSnakes(game,pos);
            game.setPlayer1Position(pos);
        }
        else{
            game.setPlayer1Position(100);
            game.setGameResult(1);
            gameRepository.save(game);
        }
    }
    private void setPositionPlayer2(Game game,int no){
        int pos=game.getPlayer2Position()+no;
        if(game.getPlayer2Position()+no<100){
            pos=checkForLadders(game,pos);
            pos=checkForLadders(game,pos);
            game.setPlayer2Position(pos);
        }
        else{
            game.setPlayer2Position(100);
            game.setGameResult(2);
            gameRepository.save(game);
        }
    }
    private int checkForLadders(Game game,int pos){
        Map<Integer,Integer> ladder=game.getLadders().getLadderCoordinates();
        if(ladder.containsKey(pos)) return ladder.get(pos);
        return pos;
    }
    private int checkForSnakes(Game game,int pos){
        Map<Integer,Integer> snake=game.getSnakes().getSnakeCoordinates();
        if(snake.containsKey(pos)) return snake.get(pos);
        return pos;
    }
    private synchronized int generator(){
        Random rand = new Random();
        int min = 1;
        int max = 6;
        return rand.nextInt((max - min) + 1) + min;
    }
}
