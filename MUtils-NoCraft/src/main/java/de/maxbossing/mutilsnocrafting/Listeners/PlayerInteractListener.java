package de.maxbossing.mutilsnocrafting.Listeners;

import de.maxbossing.mutils.UTils.Timer;
import de.maxbossing.mutils.MUtils;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (!Timer.getTimer().isRunning())return;
        if (!MUtils.getInstance().getConfigValue("challenge.nocraft"))return;
        if (event.getPlayer().hasPermission("mutils.bypass"))return;
        if (!event.getClickedBlock().equals(Material.CRAFTING_TABLE))return;
        event.getPlayer().setHealth(0);
    }
}
