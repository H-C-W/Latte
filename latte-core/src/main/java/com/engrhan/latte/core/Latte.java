package com.engrhan.latte.core;

import android.content.Context;

import java.util.HashMap;


/**
 * Created by engrh on 2018/5/9.
 */

public final class Latte {
    static Configurator init(Context conText) {
        getConfigrations().put(ConfigType.APPLICATION_CONTENT.name(), conText.getApplicationContext());
        return Configurator.getInstance();
    }

    private static HashMap<String, Object> getConfigrations() {
        return Configurator.getInstance().getLatteConfigs();
    }

    public static <T> T getConfigration(Object key) {
        return Configurator.getInstance().getConfigration(key);
    }
}
