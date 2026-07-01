package me.name.modtemplate.gui.huds;

import me.name.modtemplate.config.ModTemplateConfig;
import me.name.modtemplate.gui.data.AbstractRenderer;
import me.name.modtemplate.gui.data.ModResources;
import net.minecraft.client.Minecraft;

public class ExampleHUD extends AbstractRenderer {

    private final Minecraft mc = Minecraft.getMinecraft();

    public ExampleHUD() {
        super(ModTemplateConfig.exampleHUD);
    }

    @Override
    public boolean isEnabled(long currentTimeMillis) {
        return hudPosition.isEnabled();
    }

    @Override
    public void render(int screenWidth, int screenHeight, int thisWidth, int thisHeight) {
        final int x = hudPosition.getDrawX();
        int y = hudPosition.getDrawY();
        for (int i = 0; i < ModTemplateConfig.exampleNumber; i++) {
            mc.fontRendererObj.drawStringWithShadow("Example!", x, y, ModResources.WHITE);
            y += mc.fontRendererObj.FONT_HEIGHT;
        }
    }

    @Override
    public int getWidth() {
        return mc.fontRendererObj.getStringWidth("Example!");
    }

    @Override
    public int getHeight() {
        return mc.fontRendererObj.FONT_HEIGHT * ModTemplateConfig.exampleNumber;
    }

    @Override
    public void renderDummy(int screenWidth, int screenHeight, int thisWidth, int thisHeight) {
        render(screenWidth, screenHeight, thisWidth, thisHeight);
    }
}
