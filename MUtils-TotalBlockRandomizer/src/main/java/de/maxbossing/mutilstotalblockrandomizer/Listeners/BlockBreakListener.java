package de.maxbossing.mutilstotalblockrandomizer.Listeners;

import de.maxbossing.mutils.MUtils;
import de.maxbossing.mutils.UTils.Timer;
import org.apache.commons.lang3.RandomUtils;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class BlockBreakListener implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (!Timer.getTimer().isRunning())return;
        if (!MUtils.getInstance().getConfigValue("challenge.totalblockrandom"))return;
        if (event.getPlayer().hasPermission("mutils.bypass"))return;
        event.setDropItems(false);
        Material[] mats = Material.values();
        int i = RandomUtils.nextInt(0, mats.length - 1);
        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(mats[i]));
    }
}
