package org.godfather.bsolo.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.godfather.bsolo.manager.GameManager;
import org.godfather.bsolo.manager.GamePhases;
import org.godfather.bsolo.manager.runnables.Tablist;
import org.godfather.bsolo.utils.Helper;

public class PlayerLoginEvent implements Listener {

    private final GameManager gameManager;

    public PlayerLoginEvent(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Tablist.sendTablist(player, gameManager);

        switch (gameManager.getPhase()) {
            case LOADING:
            case END:
                player.kickPlayer(ChatColor.RED + "Gioco in riavvio... Attendi!");
                break;
            case WAITING:
                player.teleport(gameManager.getMapManager().getMap().getLobbyLocation());
                gameManager.getPlayerManager().getPlayersInGame().add(player.getUniqueId());
                Bukkit.getOnlinePlayers().forEach(p -> p.sendMessage(ChatColor.GRAY
                        + p.getName() + ChatColor.YELLOW + " è entrato (" + ChatColor.AQUA + gameManager.getPlayerManager().getPlayersInGame().size()
                        + ChatColor.YELLOW + "/" + ChatColor.AQUA + gameManager.getPlayerManager().getMaxPlayers() + ChatColor.YELLOW + ")!"));
                if (gameManager.getPlayerManager().getPlayersInGame().size() >= gameManager.getPlayerManager().getRequiredPlayers())
                    gameManager.setPhase(GamePhases.STARTING);
                break;
            case STARTING:
                player.teleport(gameManager.getMapManager().getMap().getLobbyLocation());
                if (gameManager.getPlayerManager().getPlayersInGame().size() == gameManager.getPlayerManager().getMaxPlayers()) {
                    player.kickPlayer(ChatColor.RED + "Il gioco è pieno. Attendi!");
                    return;
                }
                gameManager.getPlayerManager().getPlayersInGame().add(player.getUniqueId());
                Bukkit.getOnlinePlayers().forEach(p -> p.sendMessage(ChatColor.GRAY
                        + p.getName() + ChatColor.YELLOW + " è entrato (" + ChatColor.AQUA + gameManager.getPlayerManager().getPlayersInGame().size()
                        + ChatColor.YELLOW + "/" + ChatColor.AQUA + gameManager.getPlayerManager().getMaxPlayers() + ChatColor.YELLOW + ")!"));
                break;
            case INGAME:
                player.teleport(gameManager.getMapManager().getMap().getSpectatorLocation());
                gameManager.getPlayerManager().getSpectators().add(player.getUniqueId());
                player.sendMessage(ChatColor.GRAY + "Sei entrato come spettatore!");
                break;
        }

        event.setJoinMessage(null);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        switch (gameManager.getPhase()) {
            case LOADING:
            case END:
                gameManager.getPlayerManager().getPlayersInGame().remove(player.getUniqueId());
                gameManager.getPlayerManager().getSpectators().remove(player.getUniqueId());
                break;
            case WAITING:
                gameManager.getPlayerManager().getPlayersInGame().remove(player.getUniqueId());
                Bukkit.getOnlinePlayers().forEach(p -> p.sendMessage(ChatColor.GRAY + p.getName() + ChatColor.YELLOW + " è uscito!"));
                break;
            case STARTING:
                gameManager.getPlayerManager().getPlayersInGame().remove(player.getUniqueId());
                Bukkit.getOnlinePlayers().forEach(p -> p.sendMessage(ChatColor.GRAY + p.getName() + ChatColor.YELLOW + " è uscito!"));
                if (gameManager.getPlayerManager().getPlayersInGame().size() < gameManager.getPlayerManager().getRequiredPlayers()) {
                    gameManager.setPhase(GamePhases.WAITING);
                    Bukkit.getOnlinePlayers().forEach(p -> {
                        p.sendMessage(ChatColor.RED + "Aspettando altri giocatori...");
                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, 1);
                        Helper.sendTitle(p, ChatColor.RED + "Aspettando altri giocatori...", "", 5, 20, 5);
                    });
                }
                break;
            case INGAME:
                if (gameManager.getPlayerManager().getPlayersInGame().contains(player.getUniqueId())) {
                    Bukkit.getOnlinePlayers().forEach(p -> {
                        p.sendMessage(gameManager.getPlayerManager().getGameProfile(player).getTeam().getColor() + player.getName() + ChatColor.GRAY + " è uscito dalla partita.");
                    });
                    gameManager.getPlayerManager().getPlayersInGame().remove(player.getUniqueId());
                    gameManager.getPlayerManager().removeGameProfile(player);
                } else {
                    gameManager.getPlayerManager().getSpectators().remove(player.getUniqueId());
                }
                break;
        }
        if (gameManager.getPlayerManager().hasGameProfile(player))
            gameManager.getPlayerManager().removeGameProfile(player);

        event.setQuitMessage(null);
    }
}
