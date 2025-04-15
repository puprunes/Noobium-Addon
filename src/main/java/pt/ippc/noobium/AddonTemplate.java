package pt.ippc.noobium;

import pt.ippc.noobium.commands.CommandExample;
import pt.ippc.noobium.hud.Welcomer;
import pt.ippc.noobium.modules.NoDiscord;
import com.mojang.logging.LogUtils;
import meteordevelopment.meteorclient.addons.GithubRepo;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.commands.Commands;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.slf4j.Logger;

public class AddonTemplate extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();
    public static final Category CATEGORY = new Category("Noobium");
    public static final HudGroup HUD_GROUP = new HudGroup("Noobium");

    @Override
    public void onInitialize() {
        LOG.info("Initializing the Noobium addon :3");

        // Modules
        Modules.get().add(new NoDiscord());

        // Commands
        Commands.add(new CommandExample());

        // HUD
        Hud.get().register(Welcomer.INFO);
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "pt.ippc.noobium";
    }

    @Override
    public GithubRepo getRepo() {
        return new GithubRepo("Noobium", "hai");
    }
}
