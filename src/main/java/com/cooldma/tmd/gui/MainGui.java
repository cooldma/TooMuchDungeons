package com.cooldma.tmd.gui;

import com.cooldma.tmd.commands.ToggleCommand;
import com.cooldma.tmd.handlers.ConfigHandler;
import com.cooldma.tmd.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MainGui extends GuiScreen {

    //TODO: To add a new feature, add something here.
    private final int page;
    ResourceLocation texture = new ResourceLocation("tmd:tmdbackground.png");
    private GuiButton closeGUI;
    private GuiButton githubLink;
    private GuiButton discordLink;
    private GuiButton riddle;
    private GuiButton trivia;
    private GuiButton blaze;
    private GuiButton creeper;
    private GuiButton joinInformation;
    private GuiButton mobClear;
    private GuiButton amongUsSolver;
//    private GuiButton discordRpc;
    private GuiButton witherKey;
    private GuiButton hideImplosion;
    private GuiButton skeletonMaster;

    public MainGui(int page) {
        this.page = page;
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        zLevel = -5000;
        //Main Frame
        GlStateManager.pushMatrix();
        float x = (float) width / 1920;
        float y = (float) height / 1080;
        GlStateManager.scale(x * 7.5, y * 4, 0);
        mc.getTextureManager().bindTexture(texture);
        drawTexturedModalRect(0, 0, 0, 0, 1920, 1080);
        GlStateManager.popMatrix();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui() {
        zLevel = 5000;
        super.initGui();

        ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
        int height = sr.getScaledHeight();
        int width = sr.getScaledWidth();

        // Default button size is 200, 20
        closeGUI = new GuiButton(0, width / 2 - 100, (int) (height * 0.75), "Close");
        githubLink = new GuiButton(0, (int)(width / 2 - 300), (int) (height * 0.75), 100, 20, "Github");
        discordLink = new GuiButton(0, (int)(width / 2 + 200), (int) (height * 0.75), 100, 20, "Discord");


        // Page 1
        GlStateManager.pushMatrix();
        //TODO: To add a new feature, add something here.
        riddle = new GuiButton(0, width / 2 - 100, (int) (height * 0.15), "Riddle Solver: " + Utils.getColouredBoolean(ToggleCommand.threeManToggled));
        trivia = new GuiButton(0, width / 2 - 100, (int) (height * 0.20), "Trivia Solver: " + Utils.getColouredBoolean(ToggleCommand.oruoToggled));
        blaze = new GuiButton(0, width / 2 - 100, (int) (height * 0.25), "Blaze Solver: " + Utils.getColouredBoolean(ToggleCommand.blazeToggled));
        creeper = new GuiButton(0, width / 2 - 100, (int) (height * 0.30), "Creeper Solver : " + Utils.getColouredBoolean(ToggleCommand.creeperToggled));
        joinInformation = new GuiButton(0, width / 2 - 100, (int) (height * 0.35), "Party Finder Join Information : " + Utils.getColouredBoolean(ToggleCommand.joinInformationToggled));
        mobClear = new GuiButton(0, width / 2 - 100, (int) (height * 0.40), "Highlight Starred Mobs : " + Utils.getColouredBoolean(ToggleCommand.mobClearToggled));
        amongUsSolver = new GuiButton(0, width / 2 - 100, (int) (height * 0.45), "Among Us Tasks Solver : " + Utils.getColouredBoolean(ToggleCommand.amongUsSolverToggled));
//        discordRpc = new GuiButton(0, width / 2 - 100, (int) (height * 0.50), "Discord RPC (CAUSES FPS ISSUES) : " + Utils.getColouredBoolean(ToggleCommand.discordRpcToggled));
        witherKey = new GuiButton(0, width / 2 - 100, (int) (height * 0.50), "Keys/Blessings Highlighter : " + Utils.getColouredBoolean(ToggleCommand.witherKeyToggled));
        hideImplosion = new GuiButton(0, width / 2 - 100, (int) (height * 0.55), "Hide Implosion Messages : " + Utils.getColouredBoolean(ToggleCommand.hideImplosionToggled));
        skeletonMaster = new GuiButton(0, width / 2 - 100, (int) (height * 0.60), "Highlight Skeleton Masters : " + Utils.getColouredBoolean(ToggleCommand.hideImplosionToggled));
        GlStateManager.popMatrix();

        this.buttonList.add(riddle);
        this.buttonList.add(trivia);
        this.buttonList.add(blaze);
        this.buttonList.add(creeper);
        this.buttonList.add(joinInformation);
        this.buttonList.add(githubLink);
        this.buttonList.add(discordLink);
        this.buttonList.add(closeGUI);
        this.buttonList.add(mobClear);
        this.buttonList.add(amongUsSolver);
//        this.buttonList.add(discordRpc);
        this.buttonList.add(witherKey);
        this.buttonList.add(hideImplosion);
        this.buttonList.add(skeletonMaster);

    }


    @Override
    public void actionPerformed(GuiButton button) {
        if (button == closeGUI) {
            Minecraft.getMinecraft().thePlayer.closeScreen();
            //TODO: To add a new feature, add something here.
        } else if (button == riddle) {
            ToggleCommand.threeManToggled = !ToggleCommand.threeManToggled;
            ConfigHandler.writeBooleanConfig("toggles", "ThreeManPuzzle", ToggleCommand.threeManToggled);
            riddle.displayString = "Riddle Solver: " + Utils.getColouredBoolean(ToggleCommand.threeManToggled);
        } else if (button == trivia) {
            ToggleCommand.oruoToggled = !ToggleCommand.oruoToggled;
            ConfigHandler.writeBooleanConfig("toggles", "OruoPuzzle", ToggleCommand.oruoToggled);
            trivia.displayString = "Trivia Solver: " + Utils.getColouredBoolean(ToggleCommand.oruoToggled);
        } else if (button == blaze) {
            ToggleCommand.blazeToggled = !ToggleCommand.blazeToggled;
            ConfigHandler.writeBooleanConfig("toggles", "BlazePuzzle", ToggleCommand.blazeToggled);
            blaze.displayString = "Blaze Solver: " + Utils.getColouredBoolean(ToggleCommand.blazeToggled);
        } else if (button == creeper) {
            ToggleCommand.creeperToggled = !ToggleCommand.creeperToggled;
            ConfigHandler.writeBooleanConfig("toggles", "CreeperPuzzle", ToggleCommand.creeperToggled);
            creeper.displayString = "Creeper Solver: " + Utils.getColouredBoolean(ToggleCommand.creeperToggled);
        } else if (button == joinInformation) {
            ToggleCommand.joinInformationToggled = !ToggleCommand.joinInformationToggled;
            ConfigHandler.writeBooleanConfig("toggles", "joinInformation", ToggleCommand.joinInformationToggled);
            joinInformation.displayString = "Party Finder Join Information: " + Utils.getColouredBoolean(ToggleCommand.joinInformationToggled);
        } else if (button == mobClear) {
            ToggleCommand.mobClearToggled = !ToggleCommand.mobClearToggled;
            ConfigHandler.writeBooleanConfig("toggles", "mobClear", ToggleCommand.mobClearToggled);
            mobClear.displayString = "Highlight Starred Mobs : " + Utils.getColouredBoolean(ToggleCommand.mobClearToggled);
        } else if (button == amongUsSolver) {
            ToggleCommand.amongUsSolverToggled = !ToggleCommand.amongUsSolverToggled;
            ConfigHandler.writeBooleanConfig("toggles", "amongUsSolver", ToggleCommand.amongUsSolverToggled);
            amongUsSolver.displayString = "Among Us Tasks Solver : " + Utils.getColouredBoolean(ToggleCommand.amongUsSolverToggled);
//        } else if (button == discordRpc) {
//            ToggleCommand.discordRpcToggled = !ToggleCommand.discordRpcToggled;
//            ConfigHandler.writeBooleanConfig("toggles", "discordRpc", ToggleCommand.discordRpcToggled);
//            discordRpc.displayString = "Discord RPC (MAJOR FPS ISSUES) : " + Utils.getColouredBoolean(ToggleCommand.discordRpcToggled);
        } else if (button == witherKey) {
            ToggleCommand.witherKeyToggled = !ToggleCommand.witherKeyToggled;
            ConfigHandler.writeBooleanConfig("toggles", "witherKey", ToggleCommand.witherKeyToggled);
            witherKey.displayString = "Keys/Blessings Highlighter : " + Utils.getColouredBoolean(ToggleCommand.witherKeyToggled);
        } else if (button == hideImplosion) {
            ToggleCommand.hideImplosionToggled = !ToggleCommand.hideImplosionToggled;
            ConfigHandler.writeBooleanConfig("toggles", "hideImplosion", ToggleCommand.hideImplosionToggled);
            hideImplosion.displayString = "Hide Implosion Messages : " + Utils.getColouredBoolean(ToggleCommand.hideImplosionToggled);
        } else if (button == skeletonMaster) {
            ToggleCommand.skeletonMasterToggled = !ToggleCommand.skeletonMasterToggled;
            ConfigHandler.writeBooleanConfig("toggles", "skeletonMaster", ToggleCommand.skeletonMasterToggled);
            skeletonMaster.displayString = "Highlight Skeleton Masters : " + Utils.getColouredBoolean(ToggleCommand.skeletonMasterToggled);
        } else if (button == githubLink) {
            try {
                Desktop.getDesktop().browse(new URI("https://github.com/cooldma/TooMuchDungeons"));
            } catch (IOException | URISyntaxException ex) {
                System.err.println(ex);
            }
        } else if (button == discordLink) {
            try {
                Desktop.getDesktop().browse(new URI("https://discord.gg/vueabhnt5N"));
            } catch (IOException | URISyntaxException ex) {
                System.err.println(ex);
            }
        }

    }

}
