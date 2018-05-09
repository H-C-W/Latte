package com.engrhan.latte;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.engrhan.latte.activity.BaseActivity;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;
import com.joanzapata.iconify.widget.IconTextView;

import butterknife.BindView;

/**
 * @author engrh
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.txt)
    TextView txt;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.iconText)
    IconTextView iconText;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IconDrawable iconDrawable = new IconDrawable(this, FontAwesomeIcons.fa_key)
                .colorRes(R.color.colorAccent)
                .actionBarSize();
        img.setImageDrawable(iconDrawable);
    }
}
