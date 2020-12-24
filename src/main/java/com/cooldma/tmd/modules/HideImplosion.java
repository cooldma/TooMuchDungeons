package com.cooldma.tmd.modules;

import com.cooldma.tmd.commands.ToggleCommand;
import com.cooldma.tmd.utils.Utils;
import net.minecraft.util.StringUtils;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HideImplosion {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onChat(ClientChatReceivedEvent event) {
        String message = StringUtils.stripControlCodes(event.message.getUnformattedText());

        if (!Utils.inSkyblock) return;

        if (ToggleCommand.hideImplosionToggled) {
            if (message.contains("Your Implosion hit ") || message.contains("There are blocks in the way")) {
                event.setCanceled(true);
            }
        }
    }
}

