package com.engrhan.latte.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by engrh on 2018/5/9.
 */

public enum IconFonts implements Icon {

    icon_ali_pay('\ue626'),
    icon_wallet('\ue6b8');
    private char character;


    IconFonts(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace("_", "-");
    }

    @Override
    public char character() {
        return character;
    }
}
