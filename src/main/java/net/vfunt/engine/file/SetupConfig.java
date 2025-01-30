package net.vfunt.engine.file;

import net.vfunt.engine.Engine;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;

public class SetupConfig {

    public File databaseFolder;

    public SetupConfig() {
        Engine.info("Loading system files...");

        final ArrayList<String> files = new ArrayList<>();
        files.add("config.yml");
        files.add("command.yml");
        files.add("permission.yml");
        files.add("sound.yml");

        for (String file : files) {
            if (!new File(Engine.getInstance().getDataFolder(), file).exists()) {
                Engine.getInstance().saveResource(file, false);
                Engine.info("Created " + file);
            }
        }

        Engine.config = YamlConfiguration.loadConfiguration(new File(Engine.getInstance().getDataFolder(), "config.yml"));
        Engine.commandCfg = YamlConfiguration.loadConfiguration(new File(Engine.getInstance().getDataFolder(), "command.yml"));
        Engine.permissionCfg = YamlConfiguration.loadConfiguration(new File(Engine.getInstance().getDataFolder(), "permission.yml"));
        Engine.soundCfg = YamlConfiguration.loadConfiguration(new File(Engine.getInstance().getDataFolder(), "sound.yml"));

        loadOthers();
    }

    private void loadOthers() {
        databaseFolder = new File(Engine.getInstance().getDataFolder(), "\\database");
        if (!databaseFolder.exists()) databaseFolder.mkdir();
    }
}
