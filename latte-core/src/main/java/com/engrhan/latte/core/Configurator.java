package com.engrhan.latte.core;

import android.app.Activity;
import android.text.TextUtils;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @author engrh
 * @date 2018/5/9
 */

public final class Configurator {

    private static final HashMap<String, Object> LATTE_CONFIGS = new HashMap<>();
    private static final List<IconFontDescriptor> ICONS = new ArrayList<>();

    static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    private Configurator() {

        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    final HashMap<String, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    private void initIcon() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    final Configurator withApiHost(String value) {
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(), value);
        return this;
    }

    final Configurator withIcons(IconFontDescriptor icons) {
        ICONS.add(icons);
        return this;
    }

    public final void withActivity(Activity activity) {
        LATTE_CONFIGS.put(ConfigType.ACTIVITY.name(), activity);
    }


    final void getConfigs() {
        initIcon();
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }


    private void checkConfigration() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY);
        if (!isReady) {
            throw new RuntimeException("初始化失败");
        }

    }

    @SuppressWarnings("unchecked")
    final <T> T getConfigration(Object key) {
        checkConfigration();
        final Object value = LATTE_CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException((String) TextUtils.concat(key.toString(), "不存在"));

        }
        return (T) LATTE_CONFIGS.get(key);
    }
}
