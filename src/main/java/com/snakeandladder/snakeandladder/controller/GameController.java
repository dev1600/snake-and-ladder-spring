package com.snakeandladder.snakeandladder.controller;

import com.snakeandladder.snakeandladder.model.Game;
import com.snakeandladder.snakeandladder.model.Ladders;
import com.snakeandladder.snakeandladder.model.Snakes;
import com.snakeandladder.snakeandladder.service.GameService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/game")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/gamedetails")
    public ResponseEntity<?> getGameDetailsByGameId(String id){
        Optional<Game> game=gameService.getGameDetailsByGameId(id);
        return game.isPresent() ? new ResponseEntity<>(game.get(),HttpStatus.OK) :
                new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/snakecoordinates")
    public ResponseEntity<?> getSnakeCoordinatesByGameId(String id){
        Optional<Snakes> snakes=gameService.getSnakeCoordinatesByGameId(id);
        return snakes.isPresent() ? new ResponseEntity<>(snakes.get(),HttpStatus.OK) :
                new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/laddercoordinates")
    public ResponseEntity<?> getLadderCoordinatesByGameId(String id){
        Optional<Ladders> ladder=gameService.getLadderCoordinatesByGameId(id);
        return ladder.isPresent() ? new ResponseEntity<>(ladder.get(),HttpStatus.OK) :
                new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

    }
    @PostMapping("/gamedetails")
    public ResponseEntity<?>  postGameDetails(@RequestBody Game game){
        try{
            gameService.saveGameDetails(game);
            return new ResponseEntity<>("Match Details Successfully Inserted",HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Match Details could not be Inserted",HttpStatus.OK);
        }
    }
}
