package com.snakeandladder.snakeandladder.service;

import com.snakeandladder.snakeandladder.model.Game;
import com.snakeandladder.snakeandladder.model.Ladders;
import com.snakeandladder.snakeandladder.model.Snakes;

import java.util.Optional;

public interface GameService {
    Optional<Game> getGameDetailsByGameId(String id);
    Optional<Snakes> getSnakeCoordinatesByGameId(String id);
    Optional<Ladders> getLadderCoordinatesByGameId(String id);
    void saveGameDetails(Game game);
}
