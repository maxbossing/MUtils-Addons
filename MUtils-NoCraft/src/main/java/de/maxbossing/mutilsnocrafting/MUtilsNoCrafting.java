package de.maxbossing.mutilsnocrafting;

import de.maxbossing.mutilsnocrafting.Listeners.PlayerInteractListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MUtilsNoCrafting extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
    }
}
