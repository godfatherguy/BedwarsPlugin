package org.godfather.bsolo;

import org.bukkit.plugin.java.JavaPlugin;
import org.godfather.bsolo.manager.GameManager;

public class Bedwars extends JavaPlugin {

    public void onEnable() {
        saveDefaultConfig();
        GameManager gameManager = new GameManager(this);
    }

    public void onDisable() {

    }
}
