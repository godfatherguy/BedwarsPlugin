package org.godfather.bsolo.manager.map;

import org.bukkit.World;
import org.godfather.bsolo.manager.GameManager;

import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class MapManager {

    private final GameManager gameManager;
    private Maps map;
    private GameMap gameMap;

    public MapManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void setMap(Maps map) {
        this.map = map;

        gameManager.getInstance().getDataFolder().mkdirs();
        File gameMapsFolder = new File(gameManager.getInstance().getDataFolder(), "gameMaps");
        if (!gameMapsFolder.exists()) {
            gameMapsFolder.mkdirs();
        }

        gameMap = new LocalGameMap(gameMapsFolder, map.getName(), true);
    }

    public void setRandomMap() {
        int random = new Random().nextInt(Maps.values().length);
        setMap(Arrays.stream(Maps.values()).collect(Collectors.toList()).get(random));
    }

    public Maps getMap() {
        return map;
    }

    public void unload() {
        File[] files = new File(gameMap.getWorld().getWorldFolder().getAbsolutePath() + "/playerdata/").listFiles();
        if (files == null) return;
        for (File file : files) {
            file.delete();
        }
        File[] files2 = new File(gameMap.getWorld().getWorldFolder().getAbsolutePath() + "/stats/").listFiles();
        if (files2 == null) return;
        for (File file : files2) {
            file.delete();
        }
        gameMap.unload();
    }
}
