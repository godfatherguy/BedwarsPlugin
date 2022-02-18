package org.godfather.bsolo.manager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.godfather.bsolo.manager.players.GamePlayer;
import org.godfather.bsolo.manager.players.teams.Teams;
import org.godfather.bsolo.manager.players.teams.TeamsManager;
import org.org.godfather.gboard.api.scoreboard.ScoreboardProvider;
import org.org.godfather.gboard.api.scoreboard.board.line.ScoreboardLine;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameScoreboard implements ScoreboardProvider {

    private final GameManager gameManager;

    public GameScoreboard(GameManager gameManager){
        super();
        this.gameManager = gameManager;
    }

    @Override
    public String getTitle(Player player) {
        return ChatColor.AQUA + "" + ChatColor.BOLD + "BLOCK SUMO";
    }

    @Override
    public List<ScoreboardLine> getLines(Player player) {
        List<String> lines = new ArrayList<>();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

        lines.add(ChatColor.GRAY + date.format(new Date()));
        lines.add("              ");

        switch (gameManager.getPhase()) {
            case WAITING:
            case STARTING:
                lines.add(ChatColor.WHITE + "Mappa: " + ChatColor.AQUA + "Canada");
                lines.add(ChatColor.WHITE + "Giocatori: " + ChatColor.AQUA + gameManager.getPlayerManager().getPlayersInGame().size() + "/" + gameManager.getPlayerManager().getMaxPlayers());
                lines.add("     ");
                if(gameManager.getPhase() == GamePhases.WAITING){
                    lines.add(ChatColor.AQUA + "In attesa...");
                } else {
                    lines.add(ChatColor.AQUA + "Inizio in " + ChatColor.WHITE + gameManager.getTimecountdown() + "s");
                }
                lines.add("   ");
                lines.add(ChatColor.WHITE + "Modalità: " + ChatColor.AQUA + "Solo");
                lines.add(ChatColor.WHITE + "Versione: " + ChatColor.AQUA + "1.0");
                break;
            case INGAME:
            case END:
                TeamsManager teamsManager = gameManager.getPlayerManager().getTeamsManager();
                //todo mettere i vari upgrade generatori
                lines.add("  ");
                lines.add(ChatColor.RED + "" + ChatColor.BOLD + "R " + ChatColor.WHITE + "Rossi: " + teamsManager.getTeamState(Teams.RED) + teamsManager.getInheritance(player, Teams.RED));
                lines.add(ChatColor.BLUE + "" + ChatColor.BOLD + "B " + ChatColor.WHITE + "Blu: " + teamsManager.getTeamState(Teams.BLUE) + teamsManager.getInheritance(player, Teams.BLUE));
                lines.add(ChatColor.GREEN + "" + ChatColor.BOLD + "V " + ChatColor.WHITE + "Verdi: " + teamsManager.getTeamState(Teams.GREEN) + teamsManager.getInheritance(player, Teams.GREEN));
                lines.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "G " + ChatColor.WHITE + "Gialli: " + teamsManager.getTeamState(Teams.YELLOW) + teamsManager.getInheritance(player, Teams.YELLOW));
                lines.add(ChatColor.AQUA + "" + ChatColor.BOLD + "A " + ChatColor.WHITE + "Azzurri: " + teamsManager.getTeamState(Teams.AQUA) + teamsManager.getInheritance(player, Teams.AQUA));
                lines.add(ChatColor.WHITE + "" + ChatColor.BOLD + "B " + ChatColor.WHITE + "Bianchi: " + teamsManager.getTeamState(Teams.WHITE) + teamsManager.getInheritance(player, Teams.WHITE));
                lines.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "R " + ChatColor.WHITE + "Rosa: " + teamsManager.getTeamState(Teams.PINK) + teamsManager.getInheritance(player, Teams.PINK));
                lines.add(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "G " + ChatColor.WHITE + "Grigi: " + teamsManager.getTeamState(Teams.GRAY) + teamsManager.getInheritance(player, Teams.GRAY));
                lines.add("        ");
                break;
        }

        lines.add(" ");
        lines.add(ChatColor.YELLOW + "play.coralmc.it     ");

        return build(player, lines);
    }

    @Override
    public JavaPlugin getPlugin() {
        return gameManager.getInstance();
    }

    @Override
    public org.org.godfather.gboard.api.scoreboard.adapter.ScoreboardAdapter getAdapter() {
        return gameManager.getInstance().getAdapter();
    }
}
