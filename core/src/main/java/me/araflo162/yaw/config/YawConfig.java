package me.araflo162.yaw.config;

import net.labymod.api.addon.AddonConfig;
import net.labymod.api.client.gui.screen.widget.widgets.input.SliderWidget.SliderSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.annotation.ConfigName;
import net.labymod.api.configuration.loader.property.ConfigProperty;

@ConfigName("settings")
public class YawConfig extends AddonConfig {

    @SwitchSetting
    private final ConfigProperty<Boolean> enabled = new ConfigProperty<>(true);
    @SliderSetting(min = 1, max = 5)
    private final ConfigProperty<Integer> max = new ConfigProperty<>(1);

    public ConfigProperty<Boolean> enabled() {
        return enabled;
    }

    public ConfigProperty<Integer> max() {
        return max;
    }
}