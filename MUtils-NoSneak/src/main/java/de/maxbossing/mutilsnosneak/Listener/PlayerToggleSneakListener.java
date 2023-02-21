package de.maxbossing.mutilsnosneak.Listener;

import de.maxbossing.mutils.MUtils;
import de.maxbossing.mutils.UTils.Timer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class PlayerToggleSneakListener implements Listener {
    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event) {
        if (!Timer.getTimer().isRunning())return;
        if (!MUtils.getInstance().getConfigValue("challenge.nosneak"))return;
        if (event.getPlayer().hasPermission("MUtils.bypass"))return;
        if (!event.getPlayer().isSneaking())event.getPlayer().setHealth(0);
    }
}
