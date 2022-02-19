package org.godfather.bsolo.manager.players.teams;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import java.util.function.Consumer;
import java.util.function.Function;

public enum Teams {

    RED(0, ChatColor.RED, DyeColor.RED, player -> scoreboard -> scoreboard.getTeam("aRed").addEntry(player.getName())),
    BLUE(1, ChatColor.BLUE, DyeColor.BLUE, player -> scoreboard -> scoreboard.getTeam("bBlue").addEntry(player.getName())),
    GREEN(2, ChatColor.GREEN, DyeColor.LIME, player -> scoreboard -> scoreboard.getTeam("cGreen").addEntry(player.getName())),
    YELLOW(3, ChatColor.YELLOW, DyeColor.YELLOW, player -> scoreboard -> scoreboard.getTeam("dYellow").addEntry(player.getName())),
    AQUA(4, ChatColor.AQUA, DyeColor.CYAN, player -> scoreboard -> scoreboard.getTeam("eAqua").addEntry(player.getName())),
    WHITE(5, ChatColor.WHITE, DyeColor.WHITE, player -> scoreboard -> scoreboard.getTeam("fWhite").addEntry(player.getName())),
    PINK(6, ChatColor.LIGHT_PURPLE, DyeColor.PINK, player -> scoreboard -> scoreboard.getTeam("gPink").addEntry(player.getName())),
    GRAY(7, ChatColor.DARK_GRAY, DyeColor.GRAY, player -> scoreboard -> scoreboard.getTeam("hGray").addEntry(player.getName()));

    private final int position;
    private final ChatColor color;
    private final DyeColor woolcolor;
    private final Function<Player, Consumer<Scoreboard>> function;

    Teams(int position, ChatColor color, DyeColor woolcolor, Function<Player, Consumer<Scoreboard>> function) {
        this.position = position;
        this.color = color;
        this.woolcolor = woolcolor;
        this.function = function;
    }

    public int getPosition() {
        return position;
    }

    public ChatColor getColor() {
        return color;
    }

    public DyeColor getWoolColor() {
        return woolcolor;
    }

    public Function<Player, Consumer<Scoreboard>> getFunction() {
        return function;
    }
}
