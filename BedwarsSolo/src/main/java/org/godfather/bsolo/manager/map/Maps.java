package org.godfather.bsolo.manager.map;

import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.godfather.bsolo.manager.players.teams.Teams;

public enum Maps {

    AIRSHOW(
            new Location(Bukkit.getWorld("world"), 0, 0, 0),
            new Location(Bukkit.getWorld("world"), 0, 0, 0)
    ),
    GLACIER(
            new Location(Bukkit.getWorld("world"), 0, 0, 0),
            new Location(Bukkit.getWorld("world"), 0, 0, 0)
    ),
    LIGHTHOUSE(
            new Location(Bukkit.getWorld("world"), 0, 0, 0),
            new Location(Bukkit.getWorld("world"), 0, 0, 0)
    ),
    ORCHESTRA(
            new Location(Bukkit.getWorld("world"), 0, 0, 0),
            new Location(Bukkit.getWorld("world"), 0, 0, 0)
    ),
    PERNICIOUS(
            new Location(Bukkit.getWorld("world"), 0, 0, 0),
            new Location(Bukkit.getWorld("world"), 0, 0, 0)
    ),
    SOLACE(
            new Location(Bukkit.getWorld("world"), 0, 0, 0),
            new Location(Bukkit.getWorld("world"), 0, 0, 0)
    );

    private final Location lobbyloc;
    private final Location spectatorloc;

    Maps(Location lobbyloc, Location spectatorloc){
        this.lobbyloc = lobbyloc;
        this.spectatorloc = spectatorloc;
    }

    public String getName(){
        return WordUtils.capitalizeFully(this.toString().toLowerCase());
    }

    public Location getLobbyLocation(){
        return lobbyloc;
    }

    public Location getSpectatorLocation(){
        return spectatorloc;
    }

    public Location getTeamSpawnLocation(Teams team){ //todo sistemare
        return null;
    }
}
