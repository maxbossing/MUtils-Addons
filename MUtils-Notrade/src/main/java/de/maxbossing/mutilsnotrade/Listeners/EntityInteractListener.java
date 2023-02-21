package de.maxbossing.mutilsnotrade.Listeners;

import de.maxbossing.mutils.UTils.Timer;
import de.maxbossing.mutils.MUtils;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class EntityInteractListener implements Listener {
    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        if (!Timer.getTimer().isRunning())return;
        if (!MUtils.getInstance().getConfigValue("challenge.notrade"))return;
        if (event.getPlayer().hasPermission("mutils.bypass"))return;
        if (event.getRightClicked().getType() != EntityType.VILLAGER)return;
        event.getPlayer().setHealth(0);
    }
}
