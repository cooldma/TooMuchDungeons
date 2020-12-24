package com.cooldma.tmd.commands;


import com.cooldma.tmd.Main;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class MainGuiCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "tmd";
    }

    @Override
    public String getCommandUsage(ICommandSender arg0) {
        return null;
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public void processCommand(ICommandSender arg0, String[] arg1) throws CommandException {
        Main.guiToOpen = "tmdGui";
    }

}
