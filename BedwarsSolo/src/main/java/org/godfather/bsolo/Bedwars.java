package org.godfather.bsolo;

import org.bukkit.plugin.java.JavaPlugin;
import org.godfather.bsolo.listeners.PlayerInWorldEvent;
import org.godfather.bsolo.listeners.PlayerLoginEvent;
import org.godfather.bsolo.manager.GameManager;
import org.godfather.bsolo.manager.GameScoreboard;
import org.org.godfather.gboard.api.scoreboard.ScoreboardManager;
import org.org.godfather.gboard.api.scoreboard.ScoreboardProvider;
import org.org.godfather.gboard.api.scoreboard.adapter.ScoreboardAdapter;
import org.org.godfather.gboard.nms.ScoreboardUtils;

public class Bedwars extends JavaPlugin {

    private final ScoreboardAdapter scoreboardAdapter = ScoreboardAdapter.builder(this, new ScoreboardUtils()).build();

    public void onEnable() {
        saveDefaultConfig();
        GameManager gameManager = new GameManager(this);
        GameScoreboard gameScoreboard = new GameScoreboard(gameManager);
        new ScoreboardManager(this, (ScoreboardProvider) scoreboardAdapter, 5).start();

        getServer().getPluginManager().registerEvents(new PlayerLoginEvent(gameManager), this);
        getServer().getPluginManager().registerEvents(new PlayerInWorldEvent(gameManager), this);
    }

    public void onDisable() {

    }

    public ScoreboardAdapter getAdapter(){
        return scoreboardAdapter;
    }
}
