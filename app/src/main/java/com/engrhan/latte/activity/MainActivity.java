package com.engrhan.latte.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.util.Log;

import com.engrhan.latte.core.Latte;
import com.engrhan.latte.delegate.MainDelegate;
import com.engrhan.latte.delegete.LatteDelegate;

import me.yokeyword.fragmentation.SupportActivityDelegate;

/**
 * @author engrh
 */
public class MainActivity extends ProxyActivity {




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        Latte.getConfigurator().withActivity(this);
    }

    @Override
    public LatteDelegate setRootDelegete() {
        Log.e("latte", "setRootDelegate");
        return new MainDelegate();
    }


    @Override
    public SupportActivityDelegate getSupportDelegate() {
        return null;
    }
}
