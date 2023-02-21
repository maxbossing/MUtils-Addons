package de.maxbossing.mutilsnoxp.Listener;

import com.destroystokyo.paper.event.player.PlayerPickupExperienceEvent;
import de.maxbossing.mutils.UTils.Timer;
import de.maxbossing.mutils.MUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerPickupXPListener implements Listener {
    @EventHandler
    public void onXP(PlayerPickupExperienceEvent event) {
        if (!Timer.getTimer().isRunning())return;
        if (!MUtils.getInstance().getConfigValue("challenge.noxp"))return;
        if (event.getPlayer().hasPermission("MUtils.bypass"))return;
        event.getPlayer().setHealth(0);
    }
}
