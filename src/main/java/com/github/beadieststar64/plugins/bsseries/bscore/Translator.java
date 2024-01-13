package com.github.beadieststar64.plugins.bsseries.bscore;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Properties;

public class Translator {

    private final Plugin plugin;
    private final YamlReader config;
    private final String language;
    private final String folder;

    public Translator(Plugin plugin, String languagePath, String folderPath) {
        this.plugin = plugin;
        this.config = new YamlReader(plugin);
        this.language = config.getString(languagePath);
        this.folder = config.getString(folderPath);
    }

    public String getTranslator(String key) {
        Properties prop = new Properties();
        File file = new File(plugin.getDataFolder() + File.separator + folder, language + ".properties");
        try(InputStream stream = Files.newInputStream(file.toPath());
            InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
            prop.load(reader);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(key);
    }
}