package de.maxbossing.mutilsnosameitem.Commands;

import de.maxbossing.mutilsnosameitem.UTils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ResetRegistersCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) UTils.resetRegisters();
        return false;
    }
}
