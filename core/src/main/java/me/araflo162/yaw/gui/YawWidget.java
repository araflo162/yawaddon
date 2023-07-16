package me.araflo162.yaw.gui;

import me.araflo162.yaw.YawAddon;
import net.labymod.api.Laby;
import net.labymod.api.client.gui.hud.hudwidget.text.TextHudWidget;
import net.labymod.api.client.gui.hud.hudwidget.text.TextHudWidgetConfig;
import net.labymod.api.client.gui.hud.hudwidget.text.TextLine;
import net.labymod.api.client.world.MinecraftCamera;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class YawWidget extends TextHudWidget<TextHudWidgetConfig> {

    private YawAddon addon;
    private TextLine line;

    public YawWidget(YawAddon addon) {
        super("yaw_widget");

        this.addon = addon;
    }

    @Override
    public void load(TextHudWidgetConfig config) {
        super.load(config);

        line = super.createLine("Head Rotation", "0 | 0");
    }

    @Override
    public void onTick(boolean isEditorContext) {
        if(line == null || isEditorContext) return;

        MinecraftCamera camera = Laby.labyAPI().minecraft().getCamera();
        if (camera == null) return;

        line.updateAndFlush(String.format(
            "%s | %s",
            format(camera.getYaw()),
            format(camera.getPitch())
        ));
    }

    private String format(float number) {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        formatter.setDecimalFormatSymbols(symbols);
        formatter.setMinimumFractionDigits(1);
        formatter.setMaximumFractionDigits(addon.configuration().max().get());

        return formatter.format(number);
    }
}