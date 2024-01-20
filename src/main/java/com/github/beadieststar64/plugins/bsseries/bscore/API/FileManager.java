package com.github.beadieststar64.plugins.bsseries.bscore.API;

import java.io.File;

public interface FileManager {

    String getCustomerPlugin();

    void managerInitialize(File folder, String fileName);
    void createFile(File folder, String fileName);
}
