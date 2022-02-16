package org.godfather.bsolo.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.godfather.bsolo.manager.GameManager;
import org.godfather.bsolo.manager.GamePhases;

public class PlayerInWorldEvent implements Listener {

    private final GameManager gameManager;

    public PlayerInWorldEvent(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onBuild(BlockPlaceEvent event) {
        if (gameManager.getPhase() != GamePhases.INGAME) {
            event.setCancelled(true);
            return;
        }

        //todo cosa delle region

        gameManager.getBlockManager().addBlock(event.getBlock());
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (gameManager.getPhase() != GamePhases.INGAME) {
            event.setCancelled(true);
            return;
        }

        if(!gameManager.getBlockManager().isBlockBreakable(event.getBlock())){
            event.setCancelled(true);
        }
    }
}
