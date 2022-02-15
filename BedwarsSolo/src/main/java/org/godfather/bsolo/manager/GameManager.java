package org.godfather.bsolo.manager;

import org.godfather.bsolo.Bedwars;
import org.godfather.bsolo.manager.players.PlayerManager;

public class GameManager {

    private final Bedwars plugin;
    private final PlayerManager playerManager;
    private GamePhases gamePhase;

    public GameManager(Bedwars plugin) {
        this.plugin = plugin;
        playerManager = new PlayerManager(this);
        gamePhase = GamePhases.LOADING;
    }

    public Bedwars getInstance() {
        return plugin;
    }

    public PlayerManager getPlayerManager(){
        return playerManager;
    }

    public GamePhases getPhase() {
        return gamePhase;
    }

    public void setPhase(GamePhases gamePhase) {
        this.gamePhase = gamePhase;
        gamePhase.getConsumer().accept(this);
    }

    public void startGame() {
        setPhase(GamePhases.INGAME);
    }
}
