package com.example.cricketTeam;

import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import  com.example.cricketTeam.Player;
import org.springframework.web.server.ResponseStatusException;

@Component
public class PlayerService implements PlayerRepository{
    private static HashMap<Integer, Player> team = new HashMap<>();
    int playerId = 13;

    public PlayerService() {
        team.put(1, new Player(1, "Alexander", 5, "All-rounder"));
        team.put(2, new Player(2, "Benjamin", 3, "All-rounder"));
        team.put(3, new Player(3, "Michael", 18, "Batsman"));
        team.put(4, new Player(4, "William", 45, "Batsman"));
        team.put(5, new Player(5, "Joshua", 19, "Batsman"));
        team.put(6, new Player(6, "Daniel", 10, "Bowler"));
        team.put(7, new Player(7, "Matthew", 34, "Bowler"));
        team.put(8, new Player(8, "Samuel", 17, "Batsman"));
        team.put(9, new Player(9, "John", 1, "Bowler"));
        team.put(10, new Player(10, "Earnest", 2, "All-rounder"));
        team.put(11, new Player(11, "Bob", 25, "Batsman"));
        team.put(12,new Player(12,"suresh",23,"bowler"));

    }

    @Override
    public ArrayList<Player> getPlayers(){
        Collection<Player> playersCollection = team.values();
        ArrayList<Player> players = new ArrayList<>(playersCollection);
        return players;
    }
    @Override
    public Player addPlayer(Player player){
        Player newPlayer = new Player(playerId,player.getPlayerName(),player.getJerseyNumber(),player.getRole());
        team.put(playerId,newPlayer);
        playerId++;
        return newPlayer;
    }

    @Override
    public Player getPlayerById(int playerId){
        Player player = team.get(playerId);
        if(player != null){
            return player;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public Player updatePlayer(int playerId,Player player){
        Player oldPlayer = team.get(playerId);
        if(oldPlayer == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            oldPlayer.setPlayerName(player.getPlayerName());
            oldPlayer.setRole(player.getRole());
            oldPlayer.setJerseyNumber(player.getJerseyNumber());
            return oldPlayer;
        }
    }
    @Override
    public void deletePlayer(int playerId){
        Player player = team.get(playerId);
        if(player == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            team.remove(playerId);
        }   
    }
}
