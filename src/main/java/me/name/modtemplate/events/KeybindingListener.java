package me.name.modtemplate.events;

import me.name.modtemplate.ModTemplate;
import me.name.modtemplate.utils.ChatUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import org.lwjgl.input.Keyboard;

import java.util.Arrays;

public class KeybindingListener {

    private static final KeyBinding exampleKey = create("Print Example");

    public KeybindingListener() {
        Arrays.asList(
                exampleKey
        ).forEach(ClientRegistry::registerKeyBinding);
    }

    @SubscribeEvent
    public void onKeyInput(KeyInputEvent e) {
        final Minecraft mc = Minecraft.getMinecraft();

        if (mc.theWorld == null || mc.thePlayer == null) return;

        if (exampleKey.isPressed()) {
            ChatUtil.addChatMessage(ChatUtil.getModTag() + EnumChatFormatting.GRAY + "Hello There!");
        }
    }


    private static KeyBinding create(String desc, int defaultKeyCode, String category) {
        return new KeyBinding(desc, defaultKeyCode, category);
    }

    private static KeyBinding create(String desc, int defaultKeyCode) {
        return create(desc, defaultKeyCode, ModTemplate.NAME);
    }

    private static KeyBinding create(String desc) {
        return create(desc, Keyboard.KEY_NONE, ModTemplate.NAME);
    }
}
