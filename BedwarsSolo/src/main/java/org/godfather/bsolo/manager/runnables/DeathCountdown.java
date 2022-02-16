package org.godfather.bsolo.manager.runnables;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.godfather.bsolo.manager.GameManager;
import org.godfather.bsolo.manager.GamePhases;
import org.godfather.bsolo.utils.Helper;

public class DeathCountdown extends BukkitRunnable {

    @Override
    public void run() {
        if (gameManager.getPhase() != GamePhases.INGAME) {
            cancel();
            return;
        }
        if (time == 0) {
            cancel();
            gameManager.getPlayerManager().respawnPlayer(player);
            return;
        }
        Helper.sendTitle(player, ChatColor.RED + "SEI MORTO", ChatColor.YELLOW + "Rientrerai in " + ChatColor.RED + time + ChatColor.YELLOW + " secondi.", 1, 20, 1);
        player.playSound(player.getLocation(), Sound.WOOD_CLICK, 1, 1);
        time--;
    }

    private final GameManager gameManager;
    private final Player player;
    private int time = 5;

    public DeathCountdown(GameManager gameManager, Player player) {
        this.gameManager = gameManager;
        this.player = player;
    }
}
