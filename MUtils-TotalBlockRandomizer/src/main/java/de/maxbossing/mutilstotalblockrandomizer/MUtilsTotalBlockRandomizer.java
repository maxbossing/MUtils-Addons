package de.maxbossing.mutilstotalblockrandomizer;

import de.maxbossing.mutilstotalblockrandomizer.Listeners.BlockBreakListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MUtilsTotalBlockRandomizer extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(), this);
    }
}
