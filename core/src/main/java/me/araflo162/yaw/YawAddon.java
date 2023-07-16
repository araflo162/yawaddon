package me.araflo162.yaw;

import me.araflo162.yaw.config.YawConfig;
import me.araflo162.yaw.gui.YawWidget;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;

@AddonMain
public class YawAddon extends LabyAddon<YawConfig> {

    @Override
    protected void enable() {
        registerSettingCategory();

        labyAPI().hudWidgetRegistry().register(new YawWidget(this));
    } 

    @Override
    protected Class<? extends YawConfig> configurationClass() {
        return YawConfig.class;
    }
}
