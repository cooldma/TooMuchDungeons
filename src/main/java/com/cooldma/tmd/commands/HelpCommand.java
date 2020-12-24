package com.cooldma.tmd.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class HelpCommand extends CommandBase implements ICommand {

    @Override
    public String getCommandName() {
        return "tmdhelp";
    }

    @Override
    public String getCommandUsage(ICommandSender arg0) {
        return "/" + getCommandName();
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public void processCommand(ICommandSender arg0, String[] arg1) throws CommandException {
        final EntityPlayer player = (EntityPlayer) arg0;

        player.addChatMessage(new ChatComponentText(EnumChatFormatting.AQUA + "" + EnumChatFormatting.BOLD + "" + EnumChatFormatting.STRIKETHROUGH + "--------------------------------------\n" +
                EnumChatFormatting.AQUA + "" + EnumChatFormatting.BOLD + "LIST OF AVAILBLE COMMANDS:\n" +
                EnumChatFormatting.WHITE + " /tmdhelp: Provides a list of availble commands" + "\n" +
                EnumChatFormatting.WHITE + " /tmd: Opens the main GUI" + "\n" +
                EnumChatFormatting.WHITE + " /tmdsetkey: Set your API key" + "\n" +
                EnumChatFormatting.WHITE + " /tmddungeons: Allows you to check someone's dungeon stats." + "\n" +
                EnumChatFormatting.WHITE + " /reloadconfig: Reloads the configuration." + "\n" +
                EnumChatFormatting.AQUA + "" + EnumChatFormatting.BOLD + "" + EnumChatFormatting.STRIKETHROUGH + "--------------------------------------\n"));
    }

}
