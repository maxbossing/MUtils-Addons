package de.maxbossing.mutilsnosameitem;

import de.maxbossing.mutilsnosameitem.Commands.ResetRegistersCommand;
import de.maxbossing.mutilsnosameitem.Listeners.ItemPickupListener;
import de.maxbossing.mutilsnosameitem.Listeners.TimerResumeListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

import static de.maxbossing.mutils.MUtils.*;

public final class MUtilsNoSameItem extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("resetregisters").setExecutor(new ResetRegistersCommand());
        try {
            config();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Bukkit.getPluginManager().registerEvents(new ItemPickupListener(), this);
        Bukkit.getPluginManager().registerEvents(new TimerResumeListener(), this);
    }
    public static void config() throws IOException {
        if (! new File(getInstance().getDataFolder().getPath(), "items.yml").exists()) {
            new File(getInstance().getDataFolder().getPath(), "items.yml").createNewFile();
            UTils.log(DEBUG + "items.yml does not exist, creating");
        }
    }
}
