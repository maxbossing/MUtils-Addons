package de.maxbossing.mutilsbedrockwalls;

import de.maxbossing.mutilsbedrockwalls.Listeners.PlayerMovelistener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MUtilsBedrockWalls extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerMovelistener(), this);
    }
}
