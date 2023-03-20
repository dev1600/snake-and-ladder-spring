package com.snakeandladder.snakeandladder.service;

import com.snakeandladder.snakeandladder.model.Game;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public interface GameService {
    ConcurrentHashMap<String,Game> getGameCache();
    String rollDice(String id);
}
