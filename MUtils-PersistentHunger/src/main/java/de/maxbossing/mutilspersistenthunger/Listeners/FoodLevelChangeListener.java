package de.maxbossing.mutilspersistenthunger.Listeners;

import de.maxbossing.mutils.UTils.Timer;
import de.maxbossing.mutils.MUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChangeListener implements Listener {
    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        if (!Timer.getTimer().isRunning())return;
        if (!MUtils.getInstance().getConfigValue("gamerule.persistenthunger"))return;
        if (event.getEntity().hasPermission("mutils.bypass"))return;
        if (event.getEntity().getFoodLevel() <= event.getFoodLevel())event.setCancelled(true);
    }
}
