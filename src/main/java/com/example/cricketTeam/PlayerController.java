package com.example.cricketTeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public ArrayList<Player> getPlayers() {
        return playerService.getPlayers();
    }
    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player){
        return playerService.addPlayer(player);
    }

    @GetMapping("/players/{playerId}")
    public Player getPlayerById(@PathVariable("playerId") int playerId){
        return playerService.getPlayerById(playerId);
    }
    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable("playerId") int playerId,@RequestBody Player player){
        return playerService.updatePlayer(playerId,player);
    }
    @DeleteMapping("/players/{playerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId){
        playerService.deletePlayer(playerId);
    }
}
