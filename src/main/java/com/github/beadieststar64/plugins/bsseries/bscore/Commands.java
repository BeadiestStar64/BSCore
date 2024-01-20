package com.github.beadieststar64.plugins.bsseries.bscore;

import com.github.beadieststar64.plugins.bsseries.bscore.API.FileManager;
import com.github.beadieststar64.plugins.bsseries.bscore.API.Translator;
import com.github.beadieststar64.plugins.bsseries.bscore.API.YamlReader;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class Commands implements CommandExecutor {

    private final BSCore plugin;

    public Commands(BSCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String str, @NotNull String[] args) {
        if(!sender.hasPermission("bs-core.admin")) {
            if(!(sender instanceof ConsoleCommandSender)) {
                sender.sendMessage(ChatColor.RED + "No permission!");
                return true;
            }
        }

        if(command.getName().equals("core-info")) {
            displayInfo(sender);
        }
        return true;
    }

    private void displayInfo(CommandSender sender) {
        StringBuilder fileManagerConsumer = null;
        StringBuilder translatorConsumer = null;
        StringBuilder yamlReaderConsumer = null;

        Collection<RegisteredServiceProvider<FileManager>> FM_RSP = plugin.getServer().getServicesManager().getRegistrations(FileManager.class);
        Collection<RegisteredServiceProvider<Translator>> T_RSP = plugin.getServer().getServicesManager().getRegistrations(Translator.class);
        Collection<RegisteredServiceProvider<YamlReader>> YR_RSP = plugin.getServer().getServicesManager().getRegistrations(YamlReader.class);

        for(RegisteredServiceProvider<FileManager> rsp : FM_RSP) {
            FileManager fm = rsp.getProvider();
            if(fileManagerConsumer == null) {
                fileManagerConsumer = new StringBuilder(fm.getCustomerPlugin());
            }else{
                fileManagerConsumer.append(", ").append(fm.getCustomerPlugin());
            }
        }
        for(RegisteredServiceProvider<Translator> rsp : T_RSP) {
            Translator ts = rsp.getProvider();
            if(translatorConsumer == null) {
                translatorConsumer = new StringBuilder(ts.getCustomerPlugin());
            }else{
                translatorConsumer.append(", ").append(ts.getCustomerPlugin());
            }
        }
        for(RegisteredServiceProvider<YamlReader> rsp : YR_RSP) {
            YamlReader yr = rsp.getProvider();
            if(yamlReaderConsumer == null) {
                yamlReaderConsumer = new StringBuilder(yr.getCustomerPlugin());
            }else{
                yamlReaderConsumer.append(", ").append(yr.getCustomerPlugin());
            }
        }

        RegisteredServiceProvider<FileManager> fmRSP = plugin.getServer().getServicesManager().getRegistration(FileManager.class);
        FileManager manager = null;
        if(fmRSP != null) {
            manager = fmRSP.getProvider();
        }
        RegisteredServiceProvider<Translator> tsRSP = plugin.getServer().getServicesManager().getRegistration(Translator.class);
        Translator translator = null;
        if(tsRSP != null) {
            translator = tsRSP.getProvider();
        }
        RegisteredServiceProvider<YamlReader> yrRSP = plugin.getServer().getServicesManager().getRegistration(YamlReader.class);
        YamlReader reader = null;
        if(yrRSP != null) {
            reader = yrRSP.getProvider();
        }

        sender.sendMessage(String.format("[%s] BSCore Information", plugin.getName()));
        sender.sendMessage(String.format("[%s] BSCore version: v.[%s]", plugin.getName(), plugin.getDescription().getVersion()));
        sender.sendMessage(String.format("[%s] File Manager Consumer Plugins: [%s]", plugin.getName(), manager == null ? "None" : fileManagerConsumer));
        sender.sendMessage(String.format("[%s] Translator Consumer Plugins: [%s]", plugin.getName(), translator == null ? "None" : translatorConsumer));
        sender.sendMessage(String.format("[%s] Yaml Reader Consumer Plugins: [%s]", plugin.getName(), reader == null ? "None" : yamlReaderConsumer));
    }
}
