package com.engrhan.latte.core;

import android.app.Application;

import com.engrhan.latte.icon.IconFontModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * @author engrh
 * @date 2018/5/9
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcons(new IconFontModule())
                .withIcons(new FontAwesomeModule())
                .withApiHost("http://127.0.0.1")
                .getConfigs();
    }
}
