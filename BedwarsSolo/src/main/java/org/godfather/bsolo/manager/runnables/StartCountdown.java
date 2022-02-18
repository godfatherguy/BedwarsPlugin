package org.godfather.bsolo.manager.runnables;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;
import org.godfather.bsolo.manager.GameManager;
import org.godfather.bsolo.manager.GamePhases;
import org.godfather.bsolo.utils.Helper;

public class StartCountdown extends BukkitRunnable {

    @Override
    public void run() {
        gameManager.setTimecountdown(time);
        if (gameManager.getPhase() != GamePhases.STARTING) {
            cancel();
            return;
        }
        if (time == 0) {
            cancel();
            gameManager.setPhase(GamePhases.INGAME);
            return;

        } else if (time % 10 == 0 || time == 10 || time <= 5) {
            Bukkit.getOnlinePlayers().forEach(player -> {
                player.playSound(player.getLocation(), Sound.WOOD_CLICK, 1, 1);
                Helper.sendTitle(player, getTimeColor(time) + String.valueOf(time), "", 0, 21, 0);
                player.sendMessage(ChatColor.YELLOW + "La partita inizia in " + getTimeColor(time) + time + ChatColor.YELLOW + " secondi!");
            });
        }
        time--;
    }

    private int time = 30;
    private final GameManager gameManager;

    public StartCountdown(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    private ChatColor getTimeColor(int time) {
        if (time <= 5) return ChatColor.RED;
        else if (time == 10) return ChatColor.GOLD;
        else return ChatColor.YELLOW;
    }
}
