package org.godfather.bsolo.manager;

import org.bukkit.scheduler.BukkitRunnable;
import org.godfather.bsolo.Bedwars;
import org.godfather.bsolo.manager.map.BlockManager;
import org.godfather.bsolo.manager.map.MapManager;
import org.godfather.bsolo.manager.players.PlayerManager;

public class GameManager {

    private final Bedwars plugin;
    private final PlayerManager playerManager;
    private final BlockManager blockManager;
    private final MapManager mapManager;
    private GamePhases gamePhase;
    private int timecountdown = 30;

    public GameManager(Bedwars plugin) {
        this.plugin = plugin;
        playerManager = new PlayerManager(this);
        blockManager = new BlockManager();
        mapManager = new MapManager(this);
        setPhase(GamePhases.LOADING);
    }

    public Bedwars getInstance() {
        return plugin;
    }

    public int getTimecountdown() {
        return timecountdown;
    }

    public void setTimecountdown(int timecountdown) {
        this.timecountdown = timecountdown;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public BlockManager getBlockManager() {
        return blockManager;
    }

    public MapManager getMapManager() {
        return mapManager;
    }

    public GamePhases getPhase() {
        return gamePhase;
    }

    public void setPhase(GamePhases gamePhase) {
        this.gamePhase = gamePhase;
        gamePhase.getConsumer().accept(this);
        if (gamePhase == GamePhases.LOADING)
            setPhase(GamePhases.WAITING);
        else if (gamePhase == GamePhases.END) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    setPhase(GamePhases.LOADING);
                }
            }.runTaskLater(plugin, 120L);
        }
    }

    public void reset() {
        playerManager.reset();
        blockManager.reset();
        mapManager.unload();
    }
}
