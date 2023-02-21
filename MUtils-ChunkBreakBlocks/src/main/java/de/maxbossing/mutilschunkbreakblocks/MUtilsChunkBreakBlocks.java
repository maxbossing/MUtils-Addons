package de.maxbossing.mutilschunkbreakblocks;

import de.maxbossing.mutilschunkbreakblocks.Listeners.BlockBreakListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MUtilsChunkBreakBlocks extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(), this);
    }
}
