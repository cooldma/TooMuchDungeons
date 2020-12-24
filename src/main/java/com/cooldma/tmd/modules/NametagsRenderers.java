package com.cooldma.tmd.modules;

import com.cooldma.tmd.commands.ToggleCommand;
import com.cooldma.tmd.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

import java.util.List;

public class NametagsRenderers {
    @SubscribeEvent
    public void onWorldRender(RenderWorldLastEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        if (ToggleCommand.mobClearToggled && Utils.inDungeons) {
            Entity renderViewEntity = Minecraft.getMinecraft().getRenderViewEntity();
            List<Entity> entities = Minecraft.getMinecraft().theWorld.getLoadedEntityList();
            for (Entity entity : entities) {
                if (entity.getName().contains("✯") || entity.getName().contains("Skeleton Master") || entity.getName().contains("Shadow Assassin")) {
                    double viewX = renderViewEntity.prevPosX + (renderViewEntity.posX - renderViewEntity.prevPosX) * (double) event.partialTicks;
                    double viewY = renderViewEntity.prevPosY + (renderViewEntity.posY - renderViewEntity.prevPosY) * (double) event.partialTicks;
                    double viewZ = renderViewEntity.prevPosZ + (renderViewEntity.posZ - renderViewEntity.prevPosZ) * (double) event.partialTicks;

                    int iconSize = 25;

                    if (renderViewEntity == entity) {
                        continue;
                    }

                    double x = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double) event.partialTicks;
                    double y = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double) event.partialTicks;
                    double z = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double) event.partialTicks;

                    x -= viewX;
                    y -= viewY;
                    z -= viewZ;

                    double distanceScale = Math.max(1, renderViewEntity.getPositionVector().distanceTo(entity.getPositionVector()) / 10F);

                    if (ToggleCommand.mobClearToggled && Utils.inDungeons) {
                        y += entity.height + 0.75F + (iconSize * distanceScale) / 40F;
                    } else {
                        y += entity.height / 2F + 0.25F;
                    }

                    float f = 1.6F;
                    float f1 = 0.016666668F * f;
                    GlStateManager.pushMatrix();
                    GlStateManager.translate(x, y, z);
                    GL11.glNormal3f(0.0F, 1.0F, 0.0F);
                    GlStateManager.rotate(-Minecraft.getMinecraft().getRenderManager().playerViewY, 0.0F, 1.0F, 0.0F);
                    GlStateManager.rotate(Minecraft.getMinecraft().getRenderManager().playerViewX, 1.0F, 0.0F, 0.0F);
                    GlStateManager.scale(-f1, -f1, f1);

                    GlStateManager.scale(distanceScale, distanceScale, distanceScale);

                    GlStateManager.disableLighting();
                    GlStateManager.depthMask(false);
                    GlStateManager.disableDepth();
                    GlStateManager.enableBlend();
                    GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                    GlStateManager.enableTexture2D();
                    GlStateManager.color(1, 1, 1, 1);
                    GlStateManager.enableAlpha();

                    if (entity.getName().contains("Shadow Assassin") || entity.getName().contains("Lost Adventurer") || entity.getName().contains("Frozen Adventurer") || entity.getName().contains("Angry Archeologist")) {
                        final String nameOverlay = EnumChatFormatting.BOLD + "" + EnumChatFormatting.GREEN + entity.getName() + "  /  " + EnumChatFormatting.LIGHT_PURPLE + Math.round((entity.posX + entity.posY + entity.posZ) - (Minecraft.getMinecraft().thePlayer.posX + Minecraft.getMinecraft().thePlayer.posY + Minecraft.getMinecraft().thePlayer.posZ)) + " Meters";
                        if (Math.sqrt(entity.getPosition().distanceSq(mc.thePlayer.getPosition())) < 30) {
                            Minecraft.getMinecraft().fontRendererObj.drawString(nameOverlay, -Minecraft.getMinecraft().fontRendererObj.getStringWidth(nameOverlay) / 2F, 25 / 2F + 15, -1, true);
                        }
                    } else if (entity.getName().contains("✯") && !entity.getName().contains("Skeleton Master") && !entity.getName().contains("Shadow Assassin")) {
                        final String nameOverlay = EnumChatFormatting.GREEN + "   ✯   " + EnumChatFormatting.LIGHT_PURPLE + Math.round((entity.posX + entity.posY + entity.posZ) - (Minecraft.getMinecraft().thePlayer.posX + Minecraft.getMinecraft().thePlayer.posY + Minecraft.getMinecraft().thePlayer.posZ)) + " Meters";
                        if (Math.sqrt(entity.getPosition().distanceSq(mc.thePlayer.getPosition())) < 30) {
                            Minecraft.getMinecraft().fontRendererObj.drawString(nameOverlay, -Minecraft.getMinecraft().fontRendererObj.getStringWidth(nameOverlay) / 2F, 25 / 2F + 15, -1, true);
                        }
                    }
                    GlStateManager.enableDepth();
                    GlStateManager.depthMask(true);
                    GlStateManager.enableLighting();
                    GlStateManager.disableBlend();
                    GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                    GlStateManager.popMatrix();
                }
                if (ToggleCommand.witherKeyToggled) {
                    if (entity.getName().contains("Wither Key") || entity.getName().contains("Blood Key") || entity.getName().contains("Superboom TNT") || entity.getName().contains("Blessing") || entity.getName().contains("Revive Stone")) {
                        double viewX = renderViewEntity.prevPosX + (renderViewEntity.posX - renderViewEntity.prevPosX) * (double) event.partialTicks;
                        double viewY = renderViewEntity.prevPosY + (renderViewEntity.posY - renderViewEntity.prevPosY) * (double) event.partialTicks;
                        double viewZ = renderViewEntity.prevPosZ + (renderViewEntity.posZ - renderViewEntity.prevPosZ) * (double) event.partialTicks;

                        int iconSize = 25;

                        if (renderViewEntity == entity) {
                            continue;
                        }

                        double x = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double) event.partialTicks;
                        double y = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double) event.partialTicks;
                        double z = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double) event.partialTicks;

                        x -= viewX;
                        y -= viewY;
                        z -= viewZ;

                        double distanceScale = Math.max(1, renderViewEntity.getPositionVector().distanceTo(entity.getPositionVector()) / 10F);

                        if (ToggleCommand.mobClearToggled && Utils.inDungeons) {
                            y += entity.height + 0.75F + (iconSize * distanceScale) / 40F;
                        } else {
                            y += entity.height / 2F + 0.25F;
                        }

                        float f = 1.6F;
                        float f1 = 0.016666668F * f;
                        GlStateManager.pushMatrix();
                        GlStateManager.translate(x, y, z);
                        GL11.glNormal3f(0.0F, 1.0F, 0.0F);
                        GlStateManager.rotate(-Minecraft.getMinecraft().getRenderManager().playerViewY, 0.0F, 1.0F, 0.0F);
                        GlStateManager.rotate(Minecraft.getMinecraft().getRenderManager().playerViewX, 1.0F, 0.0F, 0.0F);
                        GlStateManager.scale(-f1, -f1, f1);

                        GlStateManager.scale(distanceScale, distanceScale, distanceScale);

                        GlStateManager.disableLighting();
                        GlStateManager.depthMask(false);
                        GlStateManager.disableDepth();
                        GlStateManager.enableBlend();
                        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                        GlStateManager.enableTexture2D();
                        GlStateManager.color(1, 1, 1, 1);
                        GlStateManager.enableAlpha();

                        final String nameOverlay = EnumChatFormatting.GREEN + entity.getName() + "  /  " + EnumChatFormatting.LIGHT_PURPLE + Math.round((entity.posX + entity.posY + entity.posZ) - (Minecraft.getMinecraft().thePlayer.posX + Minecraft.getMinecraft().thePlayer.posY + Minecraft.getMinecraft().thePlayer.posZ)) + " Meters";
                        if (Math.sqrt(entity.getPosition().distanceSq(mc.thePlayer.getPosition())) < 50) {
                            Minecraft.getMinecraft().fontRendererObj.drawString(nameOverlay, -Minecraft.getMinecraft().fontRendererObj.getStringWidth(nameOverlay) / 2F, 25 / 2F + 10, -1, true);
                        }
                        GlStateManager.enableDepth();
                        GlStateManager.depthMask(true);
                        GlStateManager.enableLighting();
                        GlStateManager.disableBlend();
                        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                        GlStateManager.popMatrix();
                    }
                }
                if (ToggleCommand.skeletonMasterToggled) {
                    if (entity.getName().contains("Skeleton Master")) {
                        double viewX = renderViewEntity.prevPosX + (renderViewEntity.posX - renderViewEntity.prevPosX) * (double) event.partialTicks;
                        double viewY = renderViewEntity.prevPosY + (renderViewEntity.posY - renderViewEntity.prevPosY) * (double) event.partialTicks;
                        double viewZ = renderViewEntity.prevPosZ + (renderViewEntity.posZ - renderViewEntity.prevPosZ) * (double) event.partialTicks;

                        int iconSize = 25;

                        if (renderViewEntity == entity) {
                            continue;
                        }

                        double x = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double) event.partialTicks;
                        double y = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double) event.partialTicks;
                        double z = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double) event.partialTicks;

                        x -= viewX;
                        y -= viewY;
                        z -= viewZ;

                        double distanceScale = Math.max(1, renderViewEntity.getPositionVector().distanceTo(entity.getPositionVector()) / 10F);

                        if (ToggleCommand.mobClearToggled && Utils.inDungeons) {
                            y += entity.height + 0.75F + (iconSize * distanceScale) / 40F;
                        } else {
                            y += entity.height / 2F + 0.25F;
                        }

                        float f = 1.6F;
                        float f1 = 0.016666668F * f;
                        GlStateManager.pushMatrix();
                        GlStateManager.translate(x, y, z);
                        GL11.glNormal3f(0.0F, 1.0F, 0.0F);
                        GlStateManager.rotate(-Minecraft.getMinecraft().getRenderManager().playerViewY, 0.0F, 1.0F, 0.0F);
                        GlStateManager.rotate(Minecraft.getMinecraft().getRenderManager().playerViewX, 1.0F, 0.0F, 0.0F);
                        GlStateManager.scale(-f1, -f1, f1);

                        GlStateManager.scale(distanceScale, distanceScale, distanceScale);

                        GlStateManager.disableLighting();
                        GlStateManager.depthMask(false);
                        GlStateManager.disableDepth();
                        GlStateManager.enableBlend();
                        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                        GlStateManager.enableTexture2D();
                        GlStateManager.color(1, 1, 1, 1);
                        GlStateManager.enableAlpha();

                        final String nameOverlay = EnumChatFormatting.RED + "▲ " + entity.getName() + "  /  " + EnumChatFormatting.LIGHT_PURPLE + Math.round((entity.posX + entity.posY + entity.posZ) - (Minecraft.getMinecraft().thePlayer.posX + Minecraft.getMinecraft().thePlayer.posY + Minecraft.getMinecraft().thePlayer.posZ)) + " Meters";
                        if (Math.sqrt(entity.getPosition().distanceSq(mc.thePlayer.getPosition())) < 25) {
                            Minecraft.getMinecraft().fontRendererObj.drawString(nameOverlay, -Minecraft.getMinecraft().fontRendererObj.getStringWidth(nameOverlay) / 2F, 25 / 2F + 10, -1, true);
                        }
                        GlStateManager.enableDepth();
                        GlStateManager.depthMask(true);
                        GlStateManager.enableLighting();
                        GlStateManager.disableBlend();
                        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                        GlStateManager.popMatrix();
                    }
                }
            }
        }
    }
}
