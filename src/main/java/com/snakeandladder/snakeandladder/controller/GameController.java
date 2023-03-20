package com.snakeandladder.snakeandladder.controller;

import com.snakeandladder.snakeandladder.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/game")
public class GameController {
    @Autowired
    GameService gameService;

    @PostMapping("/{id}/rolldice")
    public ResponseEntity<?> rollDice(@PathVariable String id){
        return new ResponseEntity<>(gameService.rollDice(id), HttpStatus.OK);
    }


}
