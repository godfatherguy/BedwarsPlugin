package org.godfather.bsolo.manager.players;

import org.godfather.bsolo.manager.players.teams.Teams;

public class GamePlayer {

    private int kills = 0;
    private int finalkills = 0;
    private int bedsdestroyed = 0;
    private int deaths = 0;
    private final Teams team;

    public GamePlayer(Teams team){
        this.team = team;
    }

    public Teams getTeam(){
        return team;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void addKill() {
        kills++;
    }

    public void removeKill() {
        kills--;
    }

    public int getFinalKills() {
        return finalkills;
    }

    public void setFinalKills(int finalkills) {
        this.finalkills = finalkills;
    }

    public void addFinalKill() {
        finalkills++;
    }

    public void removeFinalKill() {
        finalkills--;
    }

    public int getBedsDestroyed() {
        return bedsdestroyed;
    }

    public void setBedsDestroyed(int bedsdestroyed) {
        this.bedsdestroyed = bedsdestroyed;
    }

    public void addBedDestroyed() {
        bedsdestroyed++;
    }

    public void removeBedDestroyed() {
        bedsdestroyed--;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void addDeath() {
        deaths++;
    }

    public void removeDeath() {
        deaths--;
    }
}
