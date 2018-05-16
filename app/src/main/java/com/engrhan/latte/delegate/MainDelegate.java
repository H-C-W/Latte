package com.engrhan.latte.delegate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.engrhan.latte.R;
import com.engrhan.latte.callback.IError;
import com.engrhan.latte.callback.IFailure;
import com.engrhan.latte.callback.ISuccess;
import com.engrhan.latte.delegete.LatteDelegate;
import com.engrhan.latte.net.RestClient;

import java.util.Map;
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
        Log.e("bind", "bindSuccess");
        testRequest();
    }

    public void testRequest() {
        Map<String, Object> testMap = new WeakHashMap<>();
//        testMap.put("methodName", "hotelRest/listAdvertisement");
//        testMap.put("hotelInfoCode", "a333a11b17804324b05e0b4e8635c1e5");
        RestClient.builder()
                .url("http://www.baidu.com")
                .params(testMap)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Toast.makeText(getContext(), "请求失败", Toast.LENGTH_LONG).show();
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {
                        Toast.makeText(getContext(), "errorCode=" + code + "errorMessage=" + msg, Toast.LENGTH_LONG).show();
                    }
                })
                .raw("haha")
                .build().get();
    }

}
