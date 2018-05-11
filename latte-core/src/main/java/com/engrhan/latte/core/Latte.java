package com.engrhan.latte.core;

import android.content.Context;

import java.util.HashMap;


/**
 * @author engrh
 * @date 2018/5/9
 */

public final class Latte {
    static Configurator init(Context conText) {
        getConfigrations().put(ConfigType.APPLICATION_CONTENT.name(), conText.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static Context getApplicationContext() {
        return (Context) getConfigrations().get(ConfigType.APPLICATION_CONTENT.name());
    }

    public static HashMap<String, Object> getConfigrations() {
        return Configurator.getInstance().getLatteConfigs();
    }

    public static <T> T getConfigration(Object key) {
        return Configurator.getInstance().getConfigration(key);
    }
}
