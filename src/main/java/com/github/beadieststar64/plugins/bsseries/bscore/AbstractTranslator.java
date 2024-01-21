package com.github.beadieststar64.plugins.bsseries.bscore;

import com.github.beadieststar64.plugins.bsseries.bscore.API.Translator;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Properties;

public class AbstractTranslator implements Translator {

    private final Plugin plugin;
    private String language;
    private String folder;

    public AbstractTranslator(Plugin plugin, String languagePath, String folderPath) {
        this.plugin = plugin;
        if(plugin instanceof BSCore) {
            return;
        }
        AbstractYamlReader config = new AbstractYamlReader(plugin);
        this.language = config.getString(languagePath);
        this.folder = config.getString(folderPath);
    }

    @Override
    public String getCustomerPlugin() {
        return plugin.getName();
    }

    @Override
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

    @Override
    public String getTranslator(String key, String[] varPath, Object[] var) {
        Properties prop = new Properties();
        File file = new File(plugin.getDataFolder() + File.separator + folder, language + ".properties");
        try(InputStream stream = Files.newInputStream(file.toPath());
            InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
            prop.load(reader);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        String str = prop.getProperty(key);
        for(int i = 0, l = varPath.length; i < l; i++) {
            str = str.replaceAll(varPath[i], var[i].toString());
        }

        return str;
    }
}