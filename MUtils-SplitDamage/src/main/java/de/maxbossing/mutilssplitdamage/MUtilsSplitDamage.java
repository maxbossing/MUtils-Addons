package de.maxbossing.mutilssplitdamage;

import de.maxbossing.mutils.Listeners.EntityDeathListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MUtilsSplitDamage extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new EntityDeathListener(), this);
    }
}
