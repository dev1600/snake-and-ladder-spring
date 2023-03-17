package com.snakeandladder.snakeandladder.service;

import com.snakeandladder.snakeandladder.model.Game;
import com.snakeandladder.snakeandladder.model.Ladders;
import com.snakeandladder.snakeandladder.model.Snakes;
import com.snakeandladder.snakeandladder.repository.GameDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameServiceImpl implements GameService{
    @Autowired
    GameDataRepository gameDataRepository;
    @Override
    public Optional<Game> getGameDetailsByGameId(String id) {
        return gameDataRepository.findById(id);
    }

    @Override
    public Optional<Snakes> getSnakeCoordinatesByGameId(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<Ladders> getLadderCoordinatesByGameId(String id) {
        return Optional.empty();
    }

    @Override
    public void saveGameDetails(Game game) {
        gameDataRepository.save(game);
    }
}
