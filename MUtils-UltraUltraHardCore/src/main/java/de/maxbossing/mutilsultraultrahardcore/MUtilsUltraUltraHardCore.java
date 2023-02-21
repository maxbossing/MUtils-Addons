package de.maxbossing.mutilsultraultrahardcore;

import de.maxbossing.mutilsultraultrahardcore.Listeners.EntityRegainHealthListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MUtilsUltraUltraHardCore extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new EntityRegainHealthListener(), this);
    }
}
