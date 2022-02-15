package org.godfather.bsolo.manager.players;

import org.bukkit.entity.Player;
import org.godfather.bsolo.manager.GameManager;
import org.godfather.bsolo.manager.players.teams.Teams;
import org.godfather.bsolo.manager.players.teams.TeamsManager;

import java.util.*;

public class PlayerManager {

    private final GameManager gameManager;
    private final TeamsManager teamsManager;
    private final Set<UUID> playersInGame = new HashSet<>();
    private final Set<UUID> spectators = new HashSet<>();
    private final Map<Player, GamePlayer> playerMap = new HashMap<>();

    public PlayerManager(GameManager gameManager) {
        this.gameManager = gameManager;
        teamsManager = new TeamsManager(this);
    }

    public TeamsManager getTeamsManager(){
        return teamsManager;
    }

    public final int getMaxPlayers() {
        return 8;
    }

    public final int getRequiredPlayers() {
        return 5;
    }

    public Set<UUID> getPlayersInGame(){
        return playersInGame;
    }

    public Set<UUID> getSpectators(){
        return spectators;
    }

    public void setGameProfile(Player player, Teams team){
        playerMap.put(player, new GamePlayer(team));
    }

    public void removeGameProfile(Player player){
        playerMap.remove(player);
    }

    public GamePlayer getGameProfile(Player player){
        return playerMap.get(player);
    }
}
