package de.maxbossing.mutilsbedrockwalls.Listeners;

import de.maxbossing.mutils.MUtils;
import de.maxbossing.mutils.UTils.Timer;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerMovelistener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (!Timer.getTimer().isRunning())return;
        if (!MUtils.getInstance().getConfigValue("challenge.bedrockwalls"))return;
        if (event.getPlayer().hasPermission("mutils.bypass"))return;
        World world= event.getPlayer().getWorld();
        double x = event.getPlayer().getLocation().getX();
        double y = event.getPlayer().getLocation().getY();
        double z = event.getPlayer().getLocation().getZ();
        new BukkitRunnable() {
            @Override
            public void run() {
                for (double i = world.getMinHeight(); i <= world.getMaxHeight(); i++) {
                    Location loc = new Location(world, x, i, z);
                    loc.getBlock().setType(Material.BEDROCK);
                }
            }
        }.runTaskLater(MUtils.getInstance(), 10 * 20);
    }

}
