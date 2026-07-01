package me.name.modtemplate.config.gui.elements;

import me.name.modtemplate.config.data.ConfigFieldContainer;
import me.name.modtemplate.config.gui.elements.base.ConfigGuiButton;
import me.name.modtemplate.config.gui.screens.ConfigScreen;
import me.name.modtemplate.utils.GuiUtil;
import net.minecraft.client.gui.GuiButton;

public class ConfigBooleanButton extends ConfigGuiButton {
    private final GuiButton button;
    private boolean isOn;

    public ConfigBooleanButton(ConfigScreen screen, ConfigFieldContainer fieldData) throws IllegalAccessException {
        super(screen, fieldData);
        this.isOn = getBoolean();
        this.button = getMcGuiButton(getMcButtonText(isOn));
    }

    @Override
    protected int getRightSideContentWidth() {
        return button.width + BUTTON_RIGHT_MARGIN;
    }

    @Override
    protected int getRightSideContentHeight() {
        return button.height;
    }

    @Override
    public void onResize(int elementRectWidth) {
        //this.button = getMcGuiButton(getMcButtonText(isOn));
        super.onResize(elementRectWidth);
    }

    @Override
    public void draw(int x, int y, int mouseX, int mouseY) {
        super.draw(x, y, mouseX, mouseY);
        button.xPosition = contentLeft;
        button.yPosition = y + (drawHeight - button.height) / 2;
        button.drawButton(mc, mouseX, mouseY);
    }

    @Override
    public boolean mouseClicked(int mouseX, int mouseY, int mouseButton) throws IllegalAccessException {
        if (mouseButton == GuiUtil.MOUSE_LEFT && button.mousePressed(mc, mouseX, mouseY)) {
            toggleBoolean();
            this.isOn = getBoolean();
            this.button.displayString = getMcButtonText(isOn);
            if (fieldData.hasDependants())
                screen.updateDependantsDisplay(fieldData);
            button.playPressSound(mc.getSoundHandler());
            return true;
        }
        return false;
    }

    @Override
    public void updateDisplayFromDependency() {
        button.displayString = getMcButtonText(isOn);
    }

    private boolean getBoolean() throws IllegalAccessException {
        return fieldData.getBoolean();
    }

    private void toggleBoolean() throws IllegalAccessException {
        fieldData.setValue(!getBoolean());
    }

    @Override
    protected boolean showDependencyIndicatorFromMouse(int mouseX, int mouseY) {
        return button.isMouseOver();
    }
}
