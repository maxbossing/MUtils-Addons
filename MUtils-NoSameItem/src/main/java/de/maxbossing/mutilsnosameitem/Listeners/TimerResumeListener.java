package de.maxbossing.mutilsnosameitem.Listeners;

import de.maxbossing.mutils.Events.TimerResumeEvent;
import de.maxbossing.mutils.MUtils;
import de.maxbossing.mutilsnosameitem.UTils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class TimerResumeListener implements Listener {
    @EventHandler
    public void onTimerResume(TimerResumeEvent event) {
        if (!MUtils.getInstance().getConfigValue("challenge.nosameitem"))return;
        Bukkit.getOnlinePlayers().forEach(p -> {
            if (p.hasPermission("mutils.bypass"))return;
            p.getInventory().forEach( i -> {
                if (!UTils.isRegistered(i.getType()))UTils.registerItem(p, i.getType());
                if (!p.equals(UTils.getRegister(i.getType()))){
                    p.setHealthScale(p.getHealthScale() - 2);
                    UTils.getRegister(i.getType()).setHealthScale(UTils.getRegister(i.getType()).getHealthScale() - 2);
                }
            });
        });
    }
}
