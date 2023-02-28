package de.maxbossing.mutilsblockrandomizer;

import de.maxbossing.mutils.MUtils;
import de.maxbossing.mutilsblockrandomizer.Listeners.BlockBreakListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class MutilsBlockRandomizer extends JavaPlugin {
    @Override
    public void onEnable() {
        try {
            config();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        UTils.shuffleBlocks();
        Bukkit.getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
    }

    private void config() throws IOException {
        if (! new File(MUtils.getInstance().getDataFolder().getPath(), "blocks.yml").exists()) {
            new File(MUtils.getInstance().getDataFolder().getPath(), "blocks.yml").createNewFile();
            UTils.log(MUtils.DEBUG + "blocks.yml does not exist, creating");
        }
    }
}
