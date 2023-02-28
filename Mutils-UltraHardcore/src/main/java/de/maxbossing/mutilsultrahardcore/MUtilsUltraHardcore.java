package de.maxbossing.mutilsultrahardcore;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.plugin.java.JavaPlugin;

public final class MUtilsUltraHardcore extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getWorlds().forEach(w -> w.setGameRule(GameRule.NATURAL_REGENERATION, false));

    }

    @Override
    public void onDisable() {
        Bukkit.getWorlds().forEach(w -> w.setGameRule(GameRule.NATURAL_REGENERATION, true));
    }
}
