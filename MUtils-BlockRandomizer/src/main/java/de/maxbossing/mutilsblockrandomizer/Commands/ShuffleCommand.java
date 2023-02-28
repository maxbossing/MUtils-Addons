package de.maxbossing.mutilsblockrandomizer.Commands;

import de.maxbossing.mutilsblockrandomizer.UTils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ShuffleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) UTils.shuffleBlocks();
        return false;
    }
}
