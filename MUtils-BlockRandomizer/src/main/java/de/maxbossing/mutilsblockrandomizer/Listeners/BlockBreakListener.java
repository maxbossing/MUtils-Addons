package de.maxbossing.mutilsblockrandomizer.Listeners;

import de.maxbossing.mutils.MUtils;
import de.maxbossing.mutils.UTils.Timer;
import de.maxbossing.mutilsblockrandomizer.UTils;
import org.bukkit.GameMode;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreakListener implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (!Timer.getTimer().isRunning())return;
        if (!MUtils.getInstance().getConfigValue("challenge.blockrandom"))return;
        if (event.getPlayer().hasPermission("mutils.bypass"))return;
        if (event.getPlayer().getGameMode() == GameMode.CREATIVE)return;
        event.setDropItems(false);
        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(UTils.getPartner(event.getBlock().getType())));
    }
}
