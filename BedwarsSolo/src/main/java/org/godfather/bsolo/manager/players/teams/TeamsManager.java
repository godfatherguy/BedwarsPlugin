package org.godfather.bsolo.manager.players.teams;

import org.bukkit.Bukkit;
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

    public UUID getPlayerInTeam(Teams team) {
        return teamsMap.get(team);
    }

    public void setupRandomTeams() {
        for (UUID uuid : playerManager.getPlayersInGame()) {
            Player player = Bukkit.getPlayer(uuid);
            do {
                for (Teams team : Arrays.stream(Teams.values()).filter(team -> !teamContainsPlayer(team)).collect(Collectors.toList())) {
                    int rand = new Random().nextInt(3);
                    if(rand == 1) {
                        teamsMap.put(team, player.getUniqueId());
                        playerManager.setGameProfile(player, team);
                        break;
                    }
                }
            } while (!isInTeam(player));
        }
    }
}
