package com.engrhan.latte.delegate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.engrhan.latte.R;
import com.engrhan.latte.callback.IError;
import com.engrhan.latte.callback.IFailure;
import com.engrhan.latte.callback.ISuccess;
import com.engrhan.latte.delegete.LatteDelegate;
import com.engrhan.latte.net.RestClient;

import java.util.WeakHashMap;

/**
 * @author engrh
 * @date 2018/5/10
 */

public class MainDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_main;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    public void testRequest() {
        RestClient.builder()
                .url("http://www.baidu.com")
                .params(new WeakHashMap<String, Object>())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {

                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .raw("haha")
                .build();
    }

}
