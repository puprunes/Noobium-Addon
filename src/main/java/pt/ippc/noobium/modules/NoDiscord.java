package pt.ippc.noobium.modules;

import meteordevelopment.meteorclient.events.packets.PacketEvent;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import pt.ippc.noobium.AddonTemplate;
import meteordevelopment.meteorclient.settings.ColorSetting;
import meteordevelopment.meteorclient.settings.DoubleSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.render.color.Color;
import meteordevelopment.meteorclient.utils.render.color.SettingColor;
import meteordevelopment.orbit.EventHandler;

public class NoDiscord extends Module {
    public NoDiscord() {
        super(AddonTemplate.CATEGORY, "NoDiscord", "Gets rid of discordsrv. A block should be a block");
    }

    @EventHandler
    private void onReceivePacket(PacketEvent.Receive event) {
        if (event.packet instanceof GameMessageS2CPacket packet) {
            String message = packet.content().getString();

            if (message.contains("[Discord]")) {
                event.cancel();
            }
        }
    }
}
