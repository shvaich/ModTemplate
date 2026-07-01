package me.name.modtemplate.config.data;

import me.name.modtemplate.config.gui.elements.base.ConfigGuiElement;
import me.name.modtemplate.config.gui.screens.ConfigScreen;

public abstract class CustomPropertyInfo {
    public abstract ConfigGuiElement[] getConfigGuiButtons(ConfigScreen screen, ConfigFieldContainer fieldData);
}
