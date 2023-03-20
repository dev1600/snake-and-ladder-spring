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
    private static final ConcurrentHashMap<String, Game> gameCache=new ConcurrentHashMap<>();
    @Override
    public ConcurrentHashMap<String, Game> getGameCache() {
        return gameCache;
    }
    @Override
    public String rollDice(String id) {
        if (gameCache.containsKey(id)) {
            Game game = gameCache.get(id);
            String resp=game.rollDice();
            if(game.getPlayer1().getPosition()==100 || game.getPlayer2().getPosition()==100){
                gameRepository.save(game);
                gameCache.remove(id);
            }
            else gameCache.put(id,game);
            return resp;
        } else {
            if(gameRepository.findById(id).isPresent()) return "Game already Finished!!! Player "+
                    gameRepository.findById(id).get().getGameResult()+" Won !!!";
            return "Game Id not found!!!";
        }
    }
}
