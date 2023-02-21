package de.maxbossing.mutilschunkbreakblocks.Listeners;

import de.maxbossing.mutils.MUtils;
import de.maxbossing.mutils.UTils.Timer;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.concurrent.atomic.AtomicInteger;

public class BlockBreakListener implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (!Timer.getTimer().isRunning())return;
        if (!MUtils.getInstance().getConfigValue("challenge.chunkbreakblocks"))return;
        if (event.getPlayer().hasPermission("MUtils.bypass"))return;
        this.breakBlocks(event.getBlock(), event.getBlock().getChunk());
        event.setDropItems(true);
    }
    private void breakBlocks(Block block, Chunk chunk) {
        AtomicInteger blocks = new AtomicInteger();
        AtomicInteger upperY = new AtomicInteger(block.getLocation().getBlockY() + 1);
        AtomicInteger lowerY = new AtomicInteger(block.getLocation().getBlockY());
        Material material = block.getType();
        MUtils.getInstance().getServer().getScheduler().runTaskTimer(MUtils.getInstance(), (bukkitTask) -> {
            if (upperY.get() <= chunk.getWorld().getMaxHeight()) {
                blocks.addAndGet(this.breakBlocksOnY(material, chunk, upperY.getAndIncrement()));
            }

            if (lowerY.get() >= chunk.getWorld().getMinHeight()) {
                blocks.addAndGet(this.breakBlocksOnY(material, chunk, lowerY.getAndDecrement()));
            }

            if (lowerY.get() < chunk.getWorld().getMinHeight() && upperY.get() > chunk.getWorld().getMaxHeight()) {
                bukkitTask.cancel();
            }

        }, 0L, 1L);
    }

    private int breakBlocksOnY(Material material, Chunk chunk, int y) {
        int blocks = 0;

        for(int x = 0; x < 16; ++x) {
            for(int z = 0; z < 16; ++z) {
                Block chunkBlock = chunk.getBlock(x, y, z);
                if (chunkBlock.getType().equals(material)) {
                    chunkBlock.setType(Material.AIR);
                    ++blocks;
                }
            }
        }

        return blocks;
    }
}
