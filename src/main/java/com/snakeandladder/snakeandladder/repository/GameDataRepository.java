package com.snakeandladder.snakeandladder.repository;

import com.snakeandladder.snakeandladder.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameDataRepository extends MongoRepository<Game,String> {
    Optional<Game> findById(String id);
}
