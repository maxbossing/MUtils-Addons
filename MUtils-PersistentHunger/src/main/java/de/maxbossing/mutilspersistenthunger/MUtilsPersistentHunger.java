package de.maxbossing.mutilspersistenthunger;

import de.maxbossing.mutilspersistenthunger.Listeners.FoodLevelChangeListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MUtilsPersistentHunger extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new FoodLevelChangeListener(), this);
    }
}
