package net.seif.yasta.networking;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.seif.yasta.Yasta;
import net.seif.yasta.networking.packet.AttributesC2SPacket;

public class ModMessages{
    private static SimpleChannel INSTANCE;

    private static int packetID = 0;

    private static int id() {
        return packetID++;
    }

    public static void register(){
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(Yasta.MOD_ID,"messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s->true)
                .serverAcceptedVersions(s->true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(AttributesC2SPacket.class ,id(), NetworkDirection.PLAY_TO_SERVER).decoder(AttributesC2SPacket::new)
                .encoder(AttributesC2SPacket::toBytes).consumerMainThread(AttributesC2SPacket::handle).add();
    }

    public static <MSG> void sendToServer(MSG message){
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void SendToPlayer(MSG message, ServerPlayer player){
        INSTANCE.send(PacketDistributor.PLAYER.with(()->player),message);
    }
}