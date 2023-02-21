package de.maxbossing.mutilstotalblockrandomizer.Listeners

import de.maxbossing.mutils.MUtils
import de.maxbossing.mutils.UTils.Timer
import org.apache.commons.lang3.RandomUtils
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import java.util.Arrays

class BlockBreakListener: Listener {
    @EventHandler
    public fun onBreak(event: BlockBreakEvent) {
        if (!Timer.getTimer().isRunning)return
        if (!MUtils.getInstance().getConfigValue("challenge.totalblockrandom"))return
        if (event.player.hasPermission("mutils.bypass"))return
        event.isDropItems = false
        val list: Array<Material> = Material.values()
        val i: Int = RandomUtils.nextInt(0, list.size - 1)
        event.player.inventory.all(Material.values()[i])
    }
}