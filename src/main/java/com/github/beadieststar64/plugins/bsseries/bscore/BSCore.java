package com.github.beadieststar64.plugins.bsseries.bscore;

import org.bukkit.plugin.java.JavaPlugin;

public final class BSCore extends JavaPlugin {

    public static BSCore getInstance;

    @Override
    public void onEnable() {
        getInstance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
