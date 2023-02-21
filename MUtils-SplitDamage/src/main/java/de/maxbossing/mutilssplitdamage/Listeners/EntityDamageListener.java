package de.maxbossing.mutilssplitdamage.Listeners;

import de.maxbossing.mutils.MUtils;
import de.maxbossing.mutils.UTils.Timer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener {
    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (!Timer.getTimer().isRunning())return;
        if (!(event.getEntity() instanceof Player))return;
        if (!MUtils.getInstance().getConfigValue("gamerule.splitdamage"))return;

        Player player = (Player) event.getEntity();

        if (player.getInventory().getItemInOffHand().equals(Material.SHIELD) || player.getInventory().getItemInMainHand().equals(Material.SHIELD)) {
            switch (event.getCause()) {
                case ENTITY_ATTACK:
                case ENTITY_SWEEP_ATTACK:
                case PROJECTILE:
                case BLOCK_EXPLOSION:
                case ENTITY_EXPLOSION:
                    return;
                default:
                    Bukkit.getOnlinePlayers().forEach((p) -> {p.setHealth(p.getHealth() - event.getDamage());});
            }
        }
    }
}
