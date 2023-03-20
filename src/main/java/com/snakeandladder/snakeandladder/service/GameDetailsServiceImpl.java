package com.snakeandladder.snakeandladder.service;

import com.snakeandladder.snakeandladder.model.Game;
import com.snakeandladder.snakeandladder.model.Ladders;
import com.snakeandladder.snakeandladder.model.Snakes;
import com.snakeandladder.snakeandladder.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameDetailsServiceImpl implements GameDetailsService {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    GameService gameService;
    @Override
    public Optional<Game> getGameDetailsByGameId(String id) {
        return gameRepository.findById(id);
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
        gameRepository.save(game);;
        gameService.getGameCache().put(game.getId(),game);
    }
}
