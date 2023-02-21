package de.maxbossing.mutilsultraultrahardcore.Listeners;

import de.maxbossing.mutils.MUtils;
import de.maxbossing.mutils.UTils.Timer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class EntityRegainHealthListener implements Listener {

    public void onRegainHealth(EntityRegainHealthEvent event) {
        if (!Timer.getTimer().isRunning())return;
        if (!MUtils.getInstance().getSettingsConf().getBoolean("gamerule.ultraultrahardcore"))return;
        if (event.getEntity().hasPermission("mutils.bypass"))return;
        if (!(event.getEntity() instanceof Player))return;
        event.setCancelled(true);return;
    }
}
