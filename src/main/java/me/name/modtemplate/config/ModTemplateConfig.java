package me.name.modtemplate.config;

import me.name.modtemplate.config.data.AbstractConfig;
import me.name.modtemplate.config.data.ConfigCategory;
import me.name.modtemplate.config.data.ConfigProperty;
import me.name.modtemplate.config.data.PropertyType;
import me.name.modtemplate.gui.data.HUDPosition;

import java.io.File;
import java.util.Arrays;

public class ModTemplateConfig extends AbstractConfig {

    @ConfigCategory(comment = "This is an example")
    public static final String EXAMPLE = "Example";

    @ConfigProperty(
        type = PropertyType.SWITCH,
        name = "Boolean Example",
        category = EXAMPLE,
        comment = "Boolean Example"
    )
    public static boolean exampleBoolean = true;

    @ConfigProperty(
        type = PropertyType.COLOR,
        name = "Color Example",
        category = EXAMPLE,
        comment = "Color Example"
    )
    public static int exampleColor = 0xFFFF0000;

    @ConfigProperty(
        type = PropertyType.COLOR,
        name = "Opaque Color Example",
        category = EXAMPLE,
        comment = "Opaque Color Example",
        allowsTransparency = false
    )
    public static int exampleColorOpaque = 0xFFFF0000;

    @ConfigProperty(
        type = PropertyType.SLIDER,
        name = "Slider Example",
        category = EXAMPLE,
        comment = "Slider Example",
        min = 0,
        max = 100
    )
    public static int exampleSlider = 50;

    @ConfigProperty(
        type = PropertyType.HUD_POSITION,
        name = "HUD Example",
        category = EXAMPLE,
        comment = "HUD Example"
    )
    public static final HUDPosition exampleHUD = new HUDPosition(true, 0.5f, 0.5f);

    @ConfigProperty(
        type = PropertyType.NUMBER,
        name = "Number Example",
        category = EXAMPLE,
        comment = "Number of HUD Example Lines",
        min = 1,
        max = 10
    )
    public static int exampleNumber = 5;

    @ConfigProperty(
        type = PropertyType.SELECTOR,
        name = "Selector Example",
        category = EXAMPLE,
        comment = "Selector Example",
        options = {
            "Example1",
            "Example2",
            "Example3"
        }
    )
    public static int exampleSelector = 0;

    @ConfigProperty(
        type = PropertyType.SWITCH,
        name = "Example Hidden Boolean",
        category = EXAMPLE,
        comment = "If you see me and wish not to, flip 'config.showHidden' in build.gradle"
    )
    public static boolean exampleHiddenBoolean = true;


    private static ModTemplateConfig instance;

    public static void loadConfig(File file) {
        if (instance != null)
            throw new IllegalStateException("Config already created");

        instance = new ModTemplateConfig(file);
    }

    public static ModTemplateConfig instance() { return instance; }

    private ModTemplateConfig(File file) {
        super(file);

        Arrays.asList(
                "exampleColor",
                "exampleColorOpaque",
                "exampleSlider",
                "exampleHUD",
                "exampleSelector",
                "exampleHiddenBoolean"
        ).forEach(property -> addDependency(property, "exampleBoolean"));

        addDependency("exampleNumber", "exampleHUD");
    }
}