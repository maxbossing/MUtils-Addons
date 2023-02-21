package de.maxbossing.mutilsairfloor.Listeners;

import de.maxbossing.mutils.MUtils;
import de.maxbossing.mutils.UTils.Timer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (!Timer.getTimer().isRunning())return;
        if (!MUtils.getInstance().getConfigValue("challenge.airfloor"))return;
        if (event.getPlayer().hasPermission("MUtils.bypass"))return;
        delBlock(event.getPlayer().getLocation().subtract(0,1,0), 5*20);
    }

    private void delBlock(Location location, int delay) {
        Bukkit.getScheduler().runTaskLater(MUtils.getInstance(), w -> {
            location.getBlock().setType(Material.AIR);
        }, delay);
    }
}
