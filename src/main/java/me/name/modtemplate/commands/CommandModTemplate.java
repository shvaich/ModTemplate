package me.name.modtemplate.commands;

import me.name.modtemplate.ModTemplate;
import me.name.modtemplate.config.ModTemplateConfig;
import me.name.modtemplate.utils.ChatUtil;
import me.name.modtemplate.utils.GuiUtil;
import me.name.modtemplate.utils.StringUtil;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

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
        if (args.length > 0 && isHelpSubcommand(StringUtil.toLowerCase(args[0]))) {
            final String slashCommand = '/' + getCommandName();
            final IChatComponent msg = new ChatComponentText(getHelpBar() + "\n" + getHelpHeader(ModTemplate.NAME + " Help"))
                    .appendSibling(getHelpLine(slashCommand, "Opens the configuration GUI", "md"))
                    .appendText("\n" + ChatUtil.centerLine(EnumChatFormatting.GRAY + "Some commands have a shortcut. Shortcuts are shown in parentheses after the description\n") + getHelpBar());

            ChatUtil.addChatMessage(msg);
            return;
        }
        GuiUtil.openScreen(ModTemplateConfig.instance().getConfigGuiScreen());
    }

    @Override
    protected List<String> onTabComplete(ICommandSender sender, String[] args) {
        if (args.length <= 1) {
            return getListOfStringsMatchingLastWord(args, "help");
        }
        return Collections.emptyList();
    }
}
