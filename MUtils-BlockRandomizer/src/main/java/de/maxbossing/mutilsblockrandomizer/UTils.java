package de.maxbossing.mutilsblockrandomizer;

import de.maxbossing.maxapi.UTils.ConfigManager;
import de.maxbossing.mutils.MUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;


import java.util.ArrayList;
import java.util.Random;

public class UTils {

    private static ArrayList<Material> remaining = new ArrayList<>();
    private static ConfigManager config = new ConfigManager(MUtils.getInstance(), "blocks.yml");

    public static void shuffleBlocks() {
        for (Material mat : Material.values()) {
            if (mat.isItem()) {
                remaining.add(mat);
            }
        }
        for (Material mat : Material.values()) {
            if (!remaining.isEmpty()) {
                if (mat.isBlock()) {
                    Random r = new Random();
                    int rand;
                    if (remaining.size() != 1) {
                        rand = r.nextInt(remaining.size() - 1);
                    } else {
                        rand = 0;
                    }
                    config.set("partners." + mat, remaining.get(rand).toString(), true);
                    remaining.remove(rand);
                }

            }

        }
    }
    public static Material getPartner(Material mat) {
        Material randpart;
        try {
            randpart = Material.valueOf(config.getString("partners." + mat.toString()));
        } catch (Exception e) {
            randpart = mat;
        }
        return randpart;
    }
    public static void log(String msg) {
        Bukkit.getServer().getConsoleSender().sendMessage(msg);
    }


}
