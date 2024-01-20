package com.github.beadieststar64.plugins.bsseries.bscore.API;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public interface YamlReader {

    String getCustomerPlugin();

    void saveDefault(String fileName);
    void saveDefault(File folder, String fileName);
    void reloadYaml();
    FileConfiguration getYaml();
    void saveConfig();
    void setAutoReloadPath(String path);
    boolean checkAutoReload();
    void updateAutoReload(boolean bool);

    String getString(String key);
    void setString(String key, String var);

    int getInt(String key);
    void setInt(String key, int var);

    boolean getBoolean(String key);

    void setBoolean(String key, boolean var);
}
