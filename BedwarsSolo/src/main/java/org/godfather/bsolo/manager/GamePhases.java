package org.godfather.bsolo.manager;

import org.godfather.bsolo.manager.runnables.StartCountdown;

import java.util.function.Consumer;

public enum GamePhases {

    LOADING(gameManager -> {

    }),

    WAITING(gameManager -> {

    }),

    STARTING(gameManager -> {
        new StartCountdown(gameManager).runTaskTimer(gameManager.getInstance(), 0L, 5L);
    }),

    INGAME(gameManager -> {
        gameManager.getPlayerManager().getTeamsManager().setupRandomTeams();
    }),

    END(gameManager -> {

    });

    private final Consumer<GameManager> consumer;

    GamePhases(Consumer<GameManager> consumer) {
        this.consumer = consumer;
    }

    public Consumer<GameManager> getConsumer() {
        return consumer;
    }
}
