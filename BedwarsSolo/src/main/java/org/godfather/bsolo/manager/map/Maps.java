package org.godfather.bsolo.manager.map;

import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.godfather.bsolo.manager.players.teams.Teams;

public enum Maps {

    AIRSHOW(
            new Location(MapManager.getWorld(), 0.5, 118, 0.5, (float) 0.0, (float) 0.0),
            new Location[]{
                    new Location(MapManager.getWorld(), -11.5, 65, 12.5),
                    new Location(MapManager.getWorld(), 12.5, 61, 12.5),
                    new Location(MapManager.getWorld(), 12.5, 65, -11.5),
                    new Location(MapManager.getWorld(), -11.5, 61, -11.5)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), -39.5, 65, 40.5),
                    new Location(MapManager.getWorld(), 40.5, 61, 40.5),
                    new Location(MapManager.getWorld(), 40.5, 65, -39.5),
                    new Location(MapManager.getWorld(), -39.5, 61, -39.5)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), -39.5, 63, -83.5, (float) 0.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 40.5, 67, -83.5, (float) 0.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 84.5, 67, -39.5, (float) 90.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 84.5, 63, 40.5, (float) 90.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 40.5, 63, 84.5, (float) 180.0, (float) 0.0),
                    new Location(MapManager.getWorld(), -39.5, 67, 84.5, (float) 180.0, (float) 0.0),
                    new Location(MapManager.getWorld(), -83.5, 67, 40.5, (float) -90.0, (float) 0.0),
                    new Location(MapManager.getWorld(), -83.5, 63, -39.5, (float) -90.0, (float) 0.0)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), -39.5, 63, -86.5),
                    new Location(MapManager.getWorld(), 40.5, 67, -86.5),
                    new Location(MapManager.getWorld(), 81.5, 67, -39.5),
                    new Location(MapManager.getWorld(), 81.5, 63, 40.5),
                    new Location(MapManager.getWorld(), 40.5, 63, 81.5),
                    new Location(MapManager.getWorld(), -39.5, 67, 81.5),
                    new Location(MapManager.getWorld(), -86.5, 67, 40.5),
                    new Location(MapManager.getWorld(), -86.5, 63, -39.5)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), -39.5, 63, -75.5),
                    new Location(MapManager.getWorld(), 40.5, 67, -75.5),
                    new Location(MapManager.getWorld(), 92.5, 67, -39.5),
                    new Location(MapManager.getWorld(), 92.5, 63, 40.5),
                    new Location(MapManager.getWorld(), 40.5, 63, 92.5),
                    new Location(MapManager.getWorld(), -39.5, 67, 92.5),
                    new Location(MapManager.getWorld(), -75.5, 67, 40.5),
                    new Location(MapManager.getWorld(), -75.5, 63, -39.5)
            }
    ),
    GLACIER(
            new Location(MapManager.getWorld(), 0.5, 118, 0.5, (float) 0.0, (float) 0.0),
            new Location[]{
                    new Location(MapManager.getWorld(), -19.5, 79, 20.5),
                    new Location(MapManager.getWorld(), 20.5, 79, 20.5),
                    new Location(MapManager.getWorld(), 20.5, 79, -19.5),
                    new Location(MapManager.getWorld(), -19.5, 79, -19.5)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), 0.5, 80, -49.5),
                    new Location(MapManager.getWorld(), -49.5, 80, 0.5),
                    new Location(MapManager.getWorld(), 0.5, 80, 50.5),
                    new Location(MapManager.getWorld(), 50.5, 80, 0.5)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), -31.5, 81, -82.5, (float) 0.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 32.5, 81, -82.5, (float) 0.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 83.5, 81, -31.5, (float) 90.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 83.5, 81, 32.5, (float) 90.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 32.5, 81, 83.5, (float) 180.0, (float) 0.0),
                    new Location(MapManager.getWorld(), -31.5, 81, 83.5, (float) 180.0, (float) 0.0),
                    new Location(MapManager.getWorld(), -82.5, 81, 32.5, (float) -90.0, (float) 0.0),
                    new Location(MapManager.getWorld(), -82.5, 81, -31.5, (float) -90.0, (float) 0.0)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), -31.5, 81, -85.5),
                    new Location(MapManager.getWorld(), 32.5, 81, -85.5),
                    new Location(MapManager.getWorld(), 80.5, 81, -31.5),
                    new Location(MapManager.getWorld(), 80.5, 81, 32.5),
                    new Location(MapManager.getWorld(), 32.5, 81, 80.5),
                    new Location(MapManager.getWorld(), -31.5, 81, 80.5),
                    new Location(MapManager.getWorld(), -85.5, 81, 32.5),
                    new Location(MapManager.getWorld(), -85.5, 81, -31.5)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), -31.5, 81, -64.5),
                    new Location(MapManager.getWorld(), 32.5, 81, -64.5),
                    new Location(MapManager.getWorld(), 101.5, 81, -31.5),
                    new Location(MapManager.getWorld(), 101.5, 81, 32.5),
                    new Location(MapManager.getWorld(), 32.5, 81, 101.5),
                    new Location(MapManager.getWorld(), -31.5, 81, 101.5),
                    new Location(MapManager.getWorld(), -64.5, 81, 32.5),
                    new Location(MapManager.getWorld(), -64.5, 81, -31.5)
            }
    ),
    LIGHTHOUSE(
            new Location(MapManager.getWorld(), 0.5, 118, 0.5, (float) 0.0, (float) 0.0),
            new Location[]{
                    new Location(MapManager.getWorld(), 3.5, 87, 7.5),
                    new Location(MapManager.getWorld(), 3.5, 87, -6.5),
                    new Location(MapManager.getWorld(), 13.5, 65, -13.5),
                    new Location(MapManager.getWorld(), -6.5, 65, 14.5)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), -48.5, 67, 52.5),
                    new Location(MapManager.getWorld(), 55.5, 67, 52.5),
                    new Location(MapManager.getWorld(), 55.5, 67, -51.5),
                    new Location(MapManager.getWorld(), -48.5, 67, -51.5)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), -22.5, 65, -87.5, (float) 0.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 29.5, 65, -87.5, (float) 0.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 91.5, 65, -25.5, (float) 90.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 91.5, 65, 26.5, (float) 90.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 29.5, 65, 88.5, (float) 180.0, (float) 0.0),
                    new Location(MapManager.getWorld(), -22.5, 65, 88.5, (float) 180.0, (float) 0.0),
                    new Location(MapManager.getWorld(), -84.5, 65, 26.5, (float) -90.0, (float) 0.0),
                    new Location(MapManager.getWorld(), -84.5, 65, -25.5, (float) -90.0, (float) 0.0)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), -22.5, 65, -90.5),
                    new Location(MapManager.getWorld(), 29.5, 65, -90.5),
                    new Location(MapManager.getWorld(), 94.5, 65, -25.5),
                    new Location(MapManager.getWorld(), 94.5, 65, 26.5),
                    new Location(MapManager.getWorld(), 29.5, 65, 85.5),
                    new Location(MapManager.getWorld(), -22.5, 65, 85.5),
                    new Location(MapManager.getWorld(), -81.5, 65, 26.5),
                    new Location(MapManager.getWorld(), -81.5, 65, -25.5)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), -22.5, 65, -74.5),
                    new Location(MapManager.getWorld(), 29.5, 65, -74.5),
                    new Location(MapManager.getWorld(), 104.5, 65, -25.5),
                    new Location(MapManager.getWorld(), 104.5, 65, 26.5),
                    new Location(MapManager.getWorld(), 29.5, 65, 101.5),
                    new Location(MapManager.getWorld(), -22.5, 65, 101.5),
                    new Location(MapManager.getWorld(), -71.5, 65, 26.5),
                    new Location(MapManager.getWorld(), -71.5, 65, -25.5)
            }
    ),
    ORCHESTRA(
            new Location(MapManager.getWorld(), 0.5, 118, 0.5, (float) 0.0, (float) 0.0),
            new Location[]{
                    new Location(MapManager.getWorld(), 29.5, 79, 0.5),
                    new Location(MapManager.getWorld(), 0.5, 79, -28.5),
                    new Location(MapManager.getWorld(), -28.5, 79, 0.5),
                    new Location(MapManager.getWorld(), 0.5, 79, 29.5)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), -57.5, 79, 58.5),
                    new Location(MapManager.getWorld(), 58.5, 79, 58.5),
                    new Location(MapManager.getWorld(), 58.5, 79, -57.5),
                    new Location(MapManager.getWorld(), -57.5, 0, -57.5)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), -29.5, 81, -93.5, (float) 0.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 30.5, 81, -93.5, (float) 0.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 94.5, 81, -29.5, (float) 90.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 94.5, 81, 30.5, (float) 90.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 30.5, 81, 94.5, (float) 180.0, (float) 0.0),
                    new Location(MapManager.getWorld(), -29.5, 81, 94.5, (float) 180.0, (float) 0.0),
                    new Location(MapManager.getWorld(), -93.5, 81, 30.5, (float) -90.0, (float) 0.0),
                    new Location(MapManager.getWorld(), -93.5, 81, -29.5, (float) -90.0, (float) 0.0)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), -29.5, 81, -96.5),
                    new Location(MapManager.getWorld(), 30.5, 81, -96.5),
                    new Location(MapManager.getWorld(), 91.5, 81, -29.5),
                    new Location(MapManager.getWorld(), 91.5, 81, 30.5),
                    new Location(MapManager.getWorld(), 30.5, 81, 91.5),
                    new Location(MapManager.getWorld(), -29.5, 81, 91.5),
                    new Location(MapManager.getWorld(), -96.5, 81, 30.5),
                    new Location(MapManager.getWorld(), -96.5, 81, -29.5)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), -29.5, 81, -80.5),
                    new Location(MapManager.getWorld(), 30.5, 81, -80.5),
                    new Location(MapManager.getWorld(), 107.5, 81, -29.5),
                    new Location(MapManager.getWorld(), 107.5, 81, 30.5),
                    new Location(MapManager.getWorld(), 30.5, 81, 107.5),
                    new Location(MapManager.getWorld(), -29.5, 81, 107.5),
                    new Location(MapManager.getWorld(), -80.5, 81, 30.5),
                    new Location(MapManager.getWorld(), -80.5, 81, -29.5)
            }
    ),
    PERNICIOUS(
            new Location(MapManager.getWorld(), 0.5, 118, 0.5, (float) -90.0, (float) 0.0),
            new Location[]{
                    new Location(MapManager.getWorld(), 0.5, 69, -28.5),
                    new Location(MapManager.getWorld(), -28.5, 69, 0.5),
                    new Location(MapManager.getWorld(), 0.5, 69, 29.5),
                    new Location(MapManager.getWorld(), 29.5, 69, 0.5)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), 39.5, 68, 39.5),
                    new Location(MapManager.getWorld(), 39.5, 68, -38.5),
                    new Location(MapManager.getWorld(), -38.5, 68, -38.5),
                    new Location(MapManager.getWorld(), -38.5, 68, 39.5)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), 33.5, 67, 92.5, (float) -180.0, (float) 0.0),
                    new Location(MapManager.getWorld(), -34.5, 67, 92.5, (float) -180.0, (float) 0.0),
                    new Location(MapManager.getWorld(), -91.5, 67, 33.5, (float) -90.0, (float) 0.0),
                    new Location(MapManager.getWorld(), -91.5, 67, -34.5, (float) -90.0, (float) 0.0),
                    new Location(MapManager.getWorld(), -32.5, 67, -91.5, (float) 0.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 35.5, 67, -91.5, (float) 0.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 92.5, 67, -32.5, (float) 90.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 92.5, 67, 35.5, (float) 90.0, (float) 0.0)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), 33.5, 66.5, 95.5),
                    new Location(MapManager.getWorld(), -34.5, 66.5, 95.5),
                    new Location(MapManager.getWorld(), -94.5, 66.5, 33.5),
                    new Location(MapManager.getWorld(), -94.5, 66.5, -34.5),
                    new Location(MapManager.getWorld(), -32.5, 66.5, -94.5),
                    new Location(MapManager.getWorld(), 35.5, 66.5, -94.5),
                    new Location(MapManager.getWorld(), 95.5, 66.5, -32.5),
                    new Location(MapManager.getWorld(), 95.5, 66.5, 35.5)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), 34.5, 68, 78.5),
                    new Location(MapManager.getWorld(), -33.5, 68, 78.5),
                    new Location(MapManager.getWorld(), -77.5, 68, 34.5),
                    new Location(MapManager.getWorld(), -77.5, 68, -33.5),
                    new Location(MapManager.getWorld(), -33.5, 68, -77.5),
                    new Location(MapManager.getWorld(), 34.5, 68, -77.5),
                    new Location(MapManager.getWorld(), 78.5, 68, -33.5),
                    new Location(MapManager.getWorld(), 78.5, 68, 34.5)
            }
    ),
    SOLACE(
            new Location(MapManager.getWorld(), 0.5, 126, 0.5, (float) 0.0, (float) 0.0),
            new Location[]{
                    new Location(MapManager.getWorld(), -17.5, 84, 18.5),
                    new Location(MapManager.getWorld(), 18.5, 84, 18.5),
                    new Location(MapManager.getWorld(), 18.5, 84, -17.5),
                    new Location(MapManager.getWorld(), -17.5, 84, -17.5)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), -43.5, 82, -43.5),
                    new Location(MapManager.getWorld(), -43.5, 82, 44.5),
                    new Location(MapManager.getWorld(), 44.5, 82, 44.5),
                    new Location(MapManager.getWorld(), 44.5, 82, -43.5)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), -23.5, 75, -81.5, (float) 0.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 24.5, 75, -81.5, (float) 0.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 82.5, 75, -23.5, (float) 90.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 82.5, 75, 24.5, (float) 90.0, (float) 0.0),
                    new Location(MapManager.getWorld(), 24.5, 75, 82.5, (float) 180.0, (float) 0.0),
                    new Location(MapManager.getWorld(), -23.5, 75, 82.5, (float) 180.0, (float) 0.0),
                    new Location(MapManager.getWorld(), -81.5, 75, 24.5, (float) -90.0, (float) 0.0),
                    new Location(MapManager.getWorld(), -81.5, 75, -23.5, (float) -90.0, (float) 0.0)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), -23.5, 75, -84.5),
                    new Location(MapManager.getWorld(), 24.5, 75, -84.5),
                    new Location(MapManager.getWorld(), 79.5, 75, -23.5),
                    new Location(MapManager.getWorld(), 79.5, 75, 24.5),
                    new Location(MapManager.getWorld(), 24.5, 75, 79.5),
                    new Location(MapManager.getWorld(), -23.5, 75, 79.5),
                    new Location(MapManager.getWorld(), -84.5, 75, 24.5),
                    new Location(MapManager.getWorld(), -84.5, 75, -23.5)
            },
            new Location[]{
                    new Location(MapManager.getWorld(), -23.5, 75, -69.5),
                    new Location(MapManager.getWorld(), 24.5, 75, -69.5),
                    new Location(MapManager.getWorld(), 94.5, 75, -23.5),
                    new Location(MapManager.getWorld(), 94.5, 75, 24.5),
                    new Location(MapManager.getWorld(), 24.5, 75, 94.5),
                    new Location(MapManager.getWorld(), -23.5, 75, 94.5),
                    new Location(MapManager.getWorld(), -69.5, 75, 24.5),
                    new Location(MapManager.getWorld(), -69.5, 75, -23.5)
            }
    );

    private final Location lobbyloc;
    private final Location[] emeraldgen;
    private final Location[] diamondgen;
    private final Location[] teamspawn;
    private final Location[] teamgenerator;
    private final Location[] teambed;

    Maps(Location lobbyloc, Location[] emeraldgen, Location[] diamondgen, Location[] teamspawn, Location[] teamgenerator, Location[] teambed) {
        this.lobbyloc = lobbyloc;
        this.emeraldgen = emeraldgen;
        this.diamondgen = diamondgen;
        this.teamspawn = teamspawn;
        this.teamgenerator = teamgenerator;
        this.teambed = teambed;
    }

    public String getName() {
        return WordUtils.capitalizeFully(this.toString().toLowerCase());
    }

    public Location getLobbyLocation() {
        return lobbyloc;
    }

    public Location getSpectatorLocation() {
        return new Location(lobbyloc.getWorld(), lobbyloc.getX(), lobbyloc.getY() - 10, lobbyloc.getZ(), lobbyloc.getYaw(), lobbyloc.getPitch());
    }

    public Location[] getEmeraldGenerators() {
        return emeraldgen;
    }

    public Location[] getDiamondGenerators() {
        return diamondgen;
    }

    public Location getSpawnLocation(Teams team) {
        return teamspawn[team.getPosition()];
    }

    public Location getIslandGenLocation(Teams team) {
        return teamgenerator[team.getPosition()];
    }

    public Location getBedLocation(Teams team) {
        return teambed[team.getPosition()];
    }
}
