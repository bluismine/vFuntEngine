package net.vfunt.engine;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Engine extends JavaPlugin {

    public static File folder;
    public static YamlConfiguration config;
    public static YamlConfiguration commandCfg;
    public static YamlConfiguration permissionCfg;
    public static YamlConfiguration soundCfg;

    private static Engine instance;

    @Override
    public void onEnable() {
        final long cur = System.currentTimeMillis();

        instance = this;
        //-------------------------//
        folder = new File(getDataFolder(), this.getDescription().getName());
        if (!folder.exists()) folder.mkdir();

        String ping;
        final long pings = System.currentTimeMillis() - cur;
        if (pings < 200) ping = "&a" + pings + "&r";
        else if (pings > 200 && pings < 500) ping = "&e" + pings + "&r";
        else ping = "&c" + pings + "&r";
        // Finish log
        this.getLogger().info("Successfully load the engine in " + ping + " ms.");
    }

    @Override
    public void onDisable() {
        // Unregister service
        this.getServer().getServicesManager().unregisterAll(this);
        this.getLogger().info("Unregistered all services!");
        // Unregister tasks
        Bukkit.getScheduler().cancelTasks(this);
        this.getLogger().info("Cancelled all tasks!");
    }

    public void registerHooker() {

    }

    public void registerCommand() {

    }

    public void registerEvents() {

    }

    public static Engine getInstance() {
        return instance;
    }

    public static void info(String messages) {
        Engine.getInstance().getLogger().info(messages);
    }

    public static void warn(String messages) {
        Engine.getInstance().getLogger().warning(messages);
    }

    public static void error(String messages) {
        Engine.getInstance().getLogger().severe(messages);
    }
}
