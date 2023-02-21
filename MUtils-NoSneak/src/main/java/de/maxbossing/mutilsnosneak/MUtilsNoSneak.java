package de.maxbossing.mutilsnosneak;

import de.maxbossing.mutilsnosneak.Listener.PlayerToggleSneakListener;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

public final class MUtilsNoSneak extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerToggleSneakListener(), this);
        Bukkit.getConsoleSender().sendMessage("[MUtils NoSneak] Plugin Loaded");
    }
}
