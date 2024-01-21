package com.github.beadieststar64.plugins.bsseries.bscore.API;

public interface Translator {

    String getCustomerPlugin();
    String getTranslator(String key);
    String getTranslator(String key, String[] varPath, Object[] objects);
}
