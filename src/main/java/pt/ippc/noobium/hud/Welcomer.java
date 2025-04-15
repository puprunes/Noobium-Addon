package pt.ippc.noobium.hud;

import net.minecraft.client.MinecraftClient;
import pt.ippc.noobium.AddonTemplate;
import meteordevelopment.meteorclient.systems.hud.HudElement;
import meteordevelopment.meteorclient.systems.hud.HudElementInfo;
import meteordevelopment.meteorclient.systems.hud.HudRenderer;
import meteordevelopment.meteorclient.utils.render.color.Color;

public class Welcomer extends HudElement {
    /**
     * The {@code name} parameter should be in kebab-case.
     */
    public static final HudElementInfo<Welcomer> INFO = new HudElementInfo<>(AddonTemplate.HUD_GROUP, "Welcomer", "Welcomes the player", Welcomer::new);

    public Welcomer() {
        super(INFO);
    }

    @Override
    public void render(HudRenderer renderer) {
        setSize(renderer.textWidth("Welcomer for the player", true), renderer.textHeight(true));

        // Render background
        renderer.quad(x, y, getWidth(), getHeight(), Color.YELLOW);

        // Render text
        assert MinecraftClient.getInstance().player != null;
        renderer.text("Welcome," + MinecraftClient.getInstance().player.getName() + " are u ouppy?", x, y, Color.PINK, true);
    }
}
