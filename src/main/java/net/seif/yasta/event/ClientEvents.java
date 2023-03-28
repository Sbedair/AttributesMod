package net.seif.yasta.event;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.seif.yasta.Yasta;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.fml.common.Mod;
import net.seif.yasta.networking.ModMessages;
import net.seif.yasta.networking.packet.AttributesC2SPacket;
import net.seif.yasta.util.KeyBindings;


public class ClientEvents {
    @Mod.EventBusSubscriber(modid = Yasta.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents{

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event){
        if(KeyBindings.Show_Attributes.consumeClick())
        {
            ModMessages.sendToServer(new AttributesC2SPacket());
        }

        }

        @Mod.EventBusSubscriber(modid = Yasta.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
        public static class ClientModBusEvents{
            @SubscribeEvent
            public static void onKeyRegister(RegisterKeyMappingsEvent event){
                event.register(KeyBindings.Show_Attributes);

            }
        }
    }
}
