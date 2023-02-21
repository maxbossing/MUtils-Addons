package de.maxbossing.mutilsnotrade;

import de.maxbossing.mutilsnotrade.Listeners.EntityInteractListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MUtilsNoTrade extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new EntityInteractListener(), this);
    }
}
