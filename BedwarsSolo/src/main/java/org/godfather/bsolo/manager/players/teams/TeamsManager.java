package org.godfather.bsolo.manager.players.teams;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.godfather.bsolo.manager.players.PlayerManager;

import java.util.*;
import java.util.stream.Collectors;

public class TeamsManager {

    private final PlayerManager playerManager;
    private final Map<Teams, UUID> teamsMap = new HashMap<>();

    public TeamsManager(PlayerManager playerManager) {
        this.playerManager = playerManager;
    }

    public boolean isInTeam(Player player) {
        return teamsMap.containsValue(player.getUniqueId());
    }

    public boolean teamContainsPlayer(Teams team) {
        return teamsMap.containsKey(team);
    }

    public boolean isTeamActive(Teams team) {
        //todo sistemare con i letti
        return true;
    }

    public boolean isTeamAlive(Teams team) {
        return Bukkit.getPlayer(getPlayerInTeam(team)).getGameMode() == GameMode.SURVIVAL;
    }

    public String getTeamState(Teams team) {
        if (isTeamActive(team)) return ChatColor.GREEN + "✔";
        else if (isTeamAlive(team)) return ChatColor.GREEN + "1";
        else return ChatColor.RED + "✘";
    }

    public String getInheritance(Player player, Teams team) {
        if (teamsMap.get(team) == player.getUniqueId()) return ChatColor.GRAY + "TU";
        else return "";
    }

    public UUID getPlayerInTeam(Teams team) {
        return teamsMap.get(team);
    }

    public void setupRandomTeams() {
        for (UUID uuid : playerManager.getPlayersInGame()) {
            Player player = Bukkit.getPlayer(uuid);
            do {
                for (Teams team : Arrays.stream(Teams.values()).filter(team -> !teamContainsPlayer(team)).collect(Collectors.toList())) {
                    int rand = new Random().nextInt(3);
                    if (rand == 1) {
                        teamsMap.put(team, player.getUniqueId());
                        playerManager.setGameProfile(player, team);
                        break;
                    }
                }
            } while (!isInTeam(player));
        }
    }

    public void reset() {
        teamsMap.clear();
    }
}
