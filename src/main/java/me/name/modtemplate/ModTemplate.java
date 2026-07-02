package me.name.modtemplate;

import me.name.modtemplate.commands.CommandModTemplate;
import me.name.modtemplate.config.ModTemplateConfig;
import me.name.modtemplate.events.KeybindingListener;
import me.name.modtemplate.events.ModAnnouncement;
import me.name.modtemplate.gui.data.HUDManager;
import net.minecraft.command.ICommand;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;


@Mod(
    modid = ModTemplate.MOD_ID,
    name = ModTemplate.NAME,
    version = ModTemplate.VERSION,
    acceptedMinecraftVersions = ModTemplate.ACCEPTED_MC_VERSIONS,
    clientSideOnly = ModTemplate.CLIENT_SIDE_ONLY
)
public class ModTemplate {
    public static final String MOD_ID = "@MOD_ID@";
    public static final String NAME = "@MOD_NAME@";
    public static final String VERSION = "@MOD_VERSION@";
    public static final String ACCEPTED_MC_VERSIONS = "@ACCEPTED_MINECRAFT_VERSIONS@";
    public static final boolean CLIENT_SIDE_ONLY = true;

    public static final Logger LOGGER = LogManager.getLogger(NAME);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        ModTemplateConfig.loadConfig(new File(e.getModConfigurationDirectory(), MOD_ID + ".cfg"));
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        registerCommands(
                new CommandModTemplate()
        );

        registerEvents(
                new ModAnnouncement(),
                new KeybindingListener()
        );

        HUDManager.register();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {}

    private void registerCommands(ICommand... commands) {
        for (final ICommand command : commands) {
            ClientCommandHandler.instance.registerCommand(command);
        }
    }

    private void registerEvents(Object... events) {
        for (final Object event : events) {
            MinecraftForge.EVENT_BUS.register(event);
        }
    }
}