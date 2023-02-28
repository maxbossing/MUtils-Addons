package de.maxbossing.mutilsnosameitem;

import de.maxbossing.maxapi.UTils.ConfigManager;
import de.maxbossing.mutils.MUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.UUID;

public class UTils {
    private static ConfigManager config = new ConfigManager(MUtils.getInstance(), "items.yml");

    public static void log(String msg) {
        Bukkit.getServer().getConsoleSender().sendMessage(msg);
    }

    public static void registerItem(Player player, Material material) {
        if (!isRegistered(material)) {
            config.set(material.toString(), player.getUniqueId().toString(), true);
        }
    }

    public static void unregisterItem(Material material) {
        if (isRegistered(material)) {
            config.set(material.toString(), null, true);
        }
    }
    public static boolean isRegistered(Material material) {
        return config.exists(material.toString());
    }

    public static Player getRegister(Material material) {
        return Bukkit.getServer().getPlayer(UUID.fromString(config.getString(material.toString())));
    }
    public static boolean resetRegisters(){
        try {
            if (new File(MUtils.getInstance().getDataFolder(), "items.yml").delete())MUtilsNoSameItem.config();
        }catch (Exception e) {
            return false;
        }

        return true;
    }
}
