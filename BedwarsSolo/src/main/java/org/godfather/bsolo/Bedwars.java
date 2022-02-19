package org.godfather.bsolo;

import org.bukkit.plugin.java.JavaPlugin;
import org.godfather.bsolo.listeners.PlayerInWorldEvent;
import org.godfather.bsolo.listeners.PlayerLoginEvent;
import org.godfather.bsolo.manager.GameManager;
import org.godfather.bsolo.manager.GameScoreboard;
import org.godfather.bsolo.manager.runnables.Tablist;
import org.org.godfather.gboard.api.scoreboard.ScoreboardManager;
import org.org.godfather.gboard.api.scoreboard.adapter.ScoreboardAdapter;
import org.org.godfather.gboard.nms.ScoreboardUtilsNMS;

public class Bedwars extends JavaPlugin {

    private final GameManager gameManager = new GameManager(this);
    private final ScoreboardAdapter scoreboardAdapter = ScoreboardAdapter.builder(this, new ScoreboardUtilsNMS()).build();

    public void onEnable() {
        saveDefaultConfig();
        GameScoreboard gameScoreboard = new GameScoreboard(gameManager);
        new ScoreboardManager(this, gameScoreboard, 5).start();
        new Tablist(gameManager).runTaskTimer(this, 0L, 5L);

        getServer().getPluginManager().registerEvents(new PlayerLoginEvent(gameManager), this);
        getServer().getPluginManager().registerEvents(new PlayerInWorldEvent(gameManager), this);
    }

    public void onDisable() {
        gameManager.reset();
    }

    public ScoreboardAdapter getAdapter(){
        return scoreboardAdapter;
    }
}
