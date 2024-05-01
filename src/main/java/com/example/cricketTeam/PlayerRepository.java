package com.example.cricketTeam;
import java.util.ArrayList;
import com.example.cricketTeam.Player;
public interface PlayerRepository {
    ArrayList<Player> getPlayers();
    Player addPlayer(Player player);

    Player getPlayerById(int playerId);
    Player updatePlayer(int playerId,Player player);
    void deletePlayer(int playerId);
}
