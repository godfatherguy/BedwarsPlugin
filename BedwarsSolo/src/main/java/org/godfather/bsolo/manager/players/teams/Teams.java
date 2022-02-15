package org.godfather.bsolo.manager.players.teams;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;

public enum Teams {

    RED(ChatColor.RED, DyeColor.RED),
    BLUE(ChatColor.BLUE, DyeColor.BLUE),
    GREEN(ChatColor.GREEN, DyeColor.LIME),
    YELLOW(ChatColor.YELLOW, DyeColor.YELLOW),
    AQUA(ChatColor.AQUA, DyeColor.CYAN),
    WHITE(ChatColor.WHITE, DyeColor.WHITE),
    PINK(ChatColor.LIGHT_PURPLE, DyeColor.PINK),
    GRAY(ChatColor.DARK_GRAY, DyeColor.GRAY);

    private final ChatColor color;
    private final DyeColor woolcolor;

    Teams(ChatColor color, DyeColor woolcolor) {
        this.color = color;
        this.woolcolor = woolcolor;
    }

    public ChatColor getColor() {
        return color;
    }

    public DyeColor getWoolColor() {
        return woolcolor;
    }
}
