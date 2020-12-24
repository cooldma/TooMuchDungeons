package com.cooldma.tmd.commands;

import com.cooldma.tmd.utils.RepartyUtils;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;


public class RepartyCommand extends CommandBase implements ICommand {

    @Override
    public String getCommandName() {
        return "tmdreparty";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + getCommandName();
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        final Thread runCmd = new RepartyUtils();
        runCmd.start();
    }
}