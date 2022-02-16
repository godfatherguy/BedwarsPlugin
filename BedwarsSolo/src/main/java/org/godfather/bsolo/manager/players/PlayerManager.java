package org.godfather.bsolo.manager.players;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.godfather.bsolo.manager.GameManager;
import org.godfather.bsolo.manager.GamePhases;
import org.godfather.bsolo.manager.players.teams.Teams;
import org.godfather.bsolo.manager.players.teams.TeamsManager;
import org.godfather.bsolo.manager.runnables.DeathCountdown;
import org.godfather.bsolo.utils.Helper;

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

    public TeamsManager getTeamsManager() {
        return teamsManager;
    }

    public final int getMaxPlayers() {
        return 8;
    }

    public final int getRequiredPlayers() {
        return 5;
    }

    public Set<UUID> getPlayersInGame() {
        return playersInGame;
    }

    public Set<UUID> getSpectators() {
        return spectators;
    }

    public void setGameProfile(Player player, Teams team) {
        playerMap.put(player, new GamePlayer(team));
    }

    public void removeGameProfile(Player player) {
        playerMap.remove(player);
    }

    public GamePlayer getGameProfile(Player player) {
        return playerMap.get(player);
    }

    public boolean hasGameProfile(Player player) {
        return playerMap.containsKey(player);
    }

    public void killPlayer(Player player) {
        player.getInventory().clear();
        playerMap.get(player).addDeath();
        player.setGameMode(GameMode.ADVENTURE);
        if (teamsManager.isTeamActive(getGameProfile(player).getTeam())) {
            new DeathCountdown(gameManager, player).runTaskTimer(gameManager.getInstance(), 0L, 20L);
        } else {
            playersInGame.remove(player.getUniqueId());
            spectators.add(player.getUniqueId());
            //todo aggiungere gli item dello spettatore
            player.getWorld().strikeLightningEffect(player.getLocation());
            Helper.sendTitle(player, ChatColor.RED + "" + ChatColor.BOLD + "SEI UNO SPETTATORE", ChatColor.GRAY + "Non puoi più respawnare!", 10, 40, 10);

            if (playersInGame.size() <= 1) {
                gameManager.setPhase(GamePhases.END);
            }
        }
        //todo teleportare il player al punto spettatore
    }

    public void respawnPlayer(Player player) {
        player.setGameMode(GameMode.SURVIVAL);
        Helper.sendTitle(player, ChatColor.GREEN + "SEI RESPAWNATO!", "", 5, 20, 5);
        player.setAllowFlight(false);
        player.setFlying(false);
        //todo teleportare il player allo spawn della sua isola
        //todo ridare gli item
    }

    public void reset(){
        playersInGame.clear();
        spectators.clear();
        playerMap.clear();
        teamsManager.reset();
    }
}
