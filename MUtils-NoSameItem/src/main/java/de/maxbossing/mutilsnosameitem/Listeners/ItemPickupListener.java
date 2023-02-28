package de.maxbossing.mutilsnosameitem.Listeners;

import de.maxbossing.mutils.MUtils;
import de.maxbossing.mutils.UTils.Timer;
import de.maxbossing.mutilsnosameitem.UTils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import java.sql.Time;
import java.util.UUID;

public class ItemPickupListener implements Listener {

    private static String

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent event) {
        if (!Timer.getTimer().isRunning())return;
        if (!MUtils.getInstance().getConfigValue("challenge.nosameitem"))return;
        if (event.getPlayer().hasPermission("mutils.bypass"))return;

        Material material = event.getItem().getItemStack().getType();

        // register if item is unregistered
        if (!UTils.isRegistered(material)){UTils.registerItem(event.getPlayer(), material);
        event.getPlayer().sendMessage("§6Du hast §5" + material.toString() + " §6registriert!");}

        //Cast Players
        Player player = event.getPlayer();
        Player register = UTils.getRegister(material);

        // Check if Player is register
        if (player.equals(UTils.getRegister(material)))return;

        //remove 1 Heart from both Healthscales
        if (player.getHealthScale() == 2)player.setHealth(0);
        else player.setHealthScale(player.getHealthScale() -2);

        if (register.getHealthScale() == 2)register.setHealth(0);
        else register.setHealthScale(register.getHealthScale() -2);

        //Send Messages to them
        player.sendMessage("§4Dieses Item ist bereits registriert!\n§e" + register.getDisplayName() + " §6 hat das Item registriert!");
        register.sendMessage("§e" + player.getDisplayName() + " §4 Hat eines deiner Items aufgesammelt!");

    }
}
