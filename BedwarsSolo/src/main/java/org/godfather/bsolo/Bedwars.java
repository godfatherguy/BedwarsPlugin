package org.godfather.bsolo;

import org.bukkit.plugin.java.JavaPlugin;
import org.godfather.bsolo.listeners.PlayerInWorldEvent;
import org.godfather.bsolo.listeners.PlayerLoginEvent;
import org.godfather.bsolo.manager.GameManager;

public class Bedwars extends JavaPlugin {

    public void onEnable() {
        saveDefaultConfig();
        GameManager gameManager = new GameManager(this);

        getServer().getPluginManager().registerEvents(new PlayerLoginEvent(gameManager), this);
        getServer().getPluginManager().registerEvents(new PlayerInWorldEvent(gameManager), this);
    }

    public void onDisable() {

    }
}
