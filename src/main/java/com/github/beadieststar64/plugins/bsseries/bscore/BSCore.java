package com.github.beadieststar64.plugins.bsseries.bscore;

import com.github.beadieststar64.plugins.bsseries.bscore.API.FileManager;
import com.github.beadieststar64.plugins.bsseries.bscore.API.Translator;
import com.github.beadieststar64.plugins.bsseries.bscore.API.YamlReader;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public final class BSCore extends JavaPlugin {

    @Override
    public void onEnable() {
        /*
        AbstractFileManager afm = new AbstractFileManager(this);
        getServer().getServicesManager().register(FileManager.class, afm, this, ServicePriority.Normal);

        AbstractYamlReader ayr = new AbstractYamlReader(this);
        getServer().getServicesManager().register(YamlReader.class, ayr, this, ServicePriority.Normal);

        AbstractTranslator at = new AbstractTranslator(this, "" ,"");
        getServer().getServicesManager().register(Translator.class, at, this, ServicePriority.Normal);
         */
        registerCommands(new String[]{"core-info"});
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands(String[] strings) {
        for(String command : strings) {
            final PluginCommand pc = getCommand(command);
            if(pc != null) {
                pc.setExecutor(new Commands(this));
            }
        }
    }
}
