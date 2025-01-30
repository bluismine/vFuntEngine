package net.vfunt.engine.lib.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public interface CommandManager {

    ArrayList<SubCommand> subcommands = new ArrayList<>();

    boolean onCommand(CommandSender sender, Command command, String label, String[] args);

    ArrayList<SubCommand> getSubcommands();

}
