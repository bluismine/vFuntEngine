package net.vfunt.engine.lib.commands;

import org.bukkit.entity.Player;

public abstract class SubCommand {

    //name of the subcommand ex. /prank <subcommand> <-- that
    public abstract String getName();

    //ex. "This is a subcommand that lets a shark eat someone"
    public abstract String getDescription();

    //How to use command ex. /prank freeze <player>
    public abstract String getSyntax();

    public abstract void perform(Player player, String[] args);

}
