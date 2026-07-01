package me.name.modtemplate.commands;

import me.name.modtemplate.config.ModTemplateConfig;
import me.name.modtemplate.utils.GuiUtil;
import net.minecraft.command.ICommandSender;

import java.util.Collections;
import java.util.List;

public class CommandModTemplate extends MyAbstractCommand {
    @Override
    public String getCommandName() {
        return "modtemplate";
    }

    @Override
    public List<String> getCommandAliases() {
        return Collections.singletonList("md");
    }

    @Override
    protected void onCommand(ICommandSender sender, String[] args) {
        GuiUtil.openScreen(ModTemplateConfig.instance().getConfigGuiScreen());
    }

    @Override
    protected List<String> onTabComplete(ICommandSender sender, String[] args) {
        return Collections.emptyList();
    }
}
