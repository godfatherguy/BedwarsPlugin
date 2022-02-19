package org.godfather.bsolo.manager.runnables;

import net.minecraft.server.v1_8_R3.ChatComponentText;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.godfather.bsolo.manager.GameManager;

import java.lang.reflect.Field;

public class Tablist extends BukkitRunnable {

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(player -> sendTablist(player, gameManager));
    }

    private final GameManager gameManager;

    public Tablist(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public static void sendTablist(Player player, GameManager gameManager) {
        PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();
        Object header;
        Object footer;
        switch (gameManager.getPhase()) {
            case WAITING:
            case STARTING:
                header = new ChatComponentText(" \n" + ChatColor.AQUA + "" + ChatColor.BOLD + "CORAL" + ChatColor.WHITE + "" + ChatColor.BOLD + "MC" + "\n");
                footer = new ChatComponentText(ChatColor.AQUA + "\nSito: " + ChatColor.GRAY + "www.coralmc.it\n"
                        + ChatColor.AQUA + "Teamspeak: " + ChatColor.GRAY + "ts.coralmc.it\n"
                        + ChatColor.AQUA + "Store: " + ChatColor.GRAY + "ts.coralmc.it\n");
                break;
            case INGAME:
            case END:
                header = new ChatComponentText(" \n" + ChatColor.AQUA + "" + ChatColor.BOLD + "CORAL" + ChatColor.WHITE + "" + ChatColor.BOLD + "MC" + "\n");
                footer = new ChatComponentText(ChatColor.WHITE + "\nUccisioni: " + ChatColor.GRAY + gameManager.getPlayerManager().getGameProfile(player).getKills()
                        + ChatColor.WHITE + " Uccisioni Finali: " + ChatColor.GRAY + gameManager.getPlayerManager().getGameProfile(player).getFinalKills()
                        + ChatColor.WHITE + " Letti distrutti: " + ChatColor.GRAY + gameManager.getPlayerManager().getGameProfile(player).getBedsDestroyed()
                        + ChatColor.AQUA + "\n\nSito: " + ChatColor.GRAY + "www.coralmc.it\n"
                        + ChatColor.AQUA + "Teamspeak: " + ChatColor.GRAY + "ts.coralmc.it\n"
                        + ChatColor.AQUA + "Store: " + ChatColor.GRAY + "ts.coralmc.it\n");
                break;
            default:
                header = null;
                footer = null;
        }

        try {
            Field a = packet.getClass().getDeclaredField("a");
            a.setAccessible(true);
            Field b = packet.getClass().getDeclaredField("b");
            b.setAccessible(true);

            a.set(packet, header);
            b.set(packet, footer);

            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
        } catch (IllegalAccessError | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
