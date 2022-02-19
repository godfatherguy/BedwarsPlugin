package org.godfather.bsolo.manager.players.teams;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import java.util.function.Consumer;
import java.util.function.Function;

public enum Teams {

    RED(ChatColor.RED, DyeColor.RED, player -> scoreboard -> scoreboard.getTeam("aRed").addEntry(player.getName())),
    BLUE(ChatColor.BLUE, DyeColor.BLUE, player -> scoreboard -> scoreboard.getTeam("bBlue").addEntry(player.getName())),
    GREEN(ChatColor.GREEN, DyeColor.LIME, player -> scoreboard -> scoreboard.getTeam("cGreen").addEntry(player.getName())),
    YELLOW(ChatColor.YELLOW, DyeColor.YELLOW, player -> scoreboard -> scoreboard.getTeam("dYellow").addEntry(player.getName())),
    AQUA(ChatColor.AQUA, DyeColor.CYAN, player -> scoreboard -> scoreboard.getTeam("eAqua").addEntry(player.getName())),
    WHITE(ChatColor.WHITE, DyeColor.WHITE, player -> scoreboard -> scoreboard.getTeam("fWhite").addEntry(player.getName())),
    PINK(ChatColor.LIGHT_PURPLE, DyeColor.PINK, player -> scoreboard -> scoreboard.getTeam("gPink").addEntry(player.getName())),
    GRAY(ChatColor.DARK_GRAY, DyeColor.GRAY, player -> scoreboard -> scoreboard.getTeam("hGray").addEntry(player.getName()));

    private final ChatColor color;
    private final DyeColor woolcolor;
    private final Function<Player, Consumer<Scoreboard>> function;

    Teams(ChatColor color, DyeColor woolcolor, Function<Player, Consumer<Scoreboard>> function) {
        this.color = color;
        this.woolcolor = woolcolor;
        this.function = function;
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
