package org.godfather.bsolo.manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.godfather.bsolo.manager.runnables.StartCountdown;
import org.godfather.bsolo.utils.Helper;

import java.util.UUID;
import java.util.function.Consumer;

public enum GamePhases {

    LOADING(gameManager -> {

    }),

    WAITING(gameManager -> {

    }),

    STARTING(gameManager -> {
        new StartCountdown(gameManager).runTaskTimer(gameManager.getInstance(), 0L, 5L);
    }),

    INGAME(gameManager -> {
        gameManager.getPlayerManager().getTeamsManager().setupRandomTeams();
        for (UUID uuid : gameManager.getPlayerManager().getPlayersInGame()) {
            Player player = Bukkit.getPlayer(uuid);
            player.sendMessage(ChatColor.GREEN + "Partita iniziata!");
            Helper.sendTitle(player, ChatColor.RED + "" + ChatColor.BOLD + "BEDWARS", ChatColor.YELLOW + "Partita iniziata!", 5, 40, 5);
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
            //todo teletrasportare
        }
    }),

    END(gameManager -> {

    });

    private final Consumer<GameManager> consumer;

    GamePhases(Consumer<GameManager> consumer) {
        this.consumer = consumer;
    }

    public Consumer<GameManager> getConsumer() {
        return consumer;
    }
}
