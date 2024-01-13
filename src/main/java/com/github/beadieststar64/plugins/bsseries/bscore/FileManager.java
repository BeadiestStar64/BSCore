package com.github.beadieststar64.plugins.bsseries.bscore;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileManager {

    private final Plugin plugin;

    public FileManager(Plugin plugin) {
        this.plugin = plugin;
    }

    public void init(File folder, String fileName) {
        if(new File(folder, fileName).exists()) {
            return;
        }
        createFile(folder, fileName);
        try(InputStream stream = Files.newInputStream(new File(folder, fileName).toPath());
            InputStreamReader input = new InputStreamReader(stream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(input)) {
            String line;
            while((line = reader.readLine()) != null) {
                if(line.charAt(0) == '#') {
                    continue;
                }
                String[] split = line.split(", ");
                if(split.length < 1 || split.length > 2) {
                    plugin.getLogger().warning("Error");
                    return;
                }
                if(split.length == 1) {
                    createFile(plugin.getDataFolder(), split[0]);
                    continue;
                }
                createFile(new File(plugin.getDataFolder(), split[0]), split[1]);
            }
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createFile(File folder, String fileName) {
        String filePath = folder + File.separator + fileName;
        File file = new File(fileName);
        if(!folder.exists()) {
            if(folder.mkdir()) {
                plugin.getLogger().info("Folder created: " + folder);
            }else{
                plugin.getLogger().warning(ChatColor.RED + "Folder creation failed: " + folder);
            }
        }
        if(!file.exists()) {
            String resource = File.separator + fileName;
            copyResource(resource, filePath);
        }
    }

    private void copyResource(String resourcePath, String targetPath) {
        try {
            File temp = copyTemp(resourcePath);
            copyFile(temp, new File(targetPath));
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    private File copyTemp(String resourcePath) throws IOException {
        try(InputStream input = plugin.getClass().getResourceAsStream(resourcePath)) {
            File temp = File.createTempFile("temp", null);
            temp.deleteOnExit();

            try(FileOutputStream output = new FileOutputStream(temp)) {
                byte[] buffer = new byte[1024];
                int byteRead;
                while((byteRead = input.read(buffer)) != -1) {
                    output.write(buffer, 0, byteRead);
                }
            }

            input.close();
            return temp;
        }
    }

    private void copyFile(File sourceFile, File targetFile) {
        try {
            Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
