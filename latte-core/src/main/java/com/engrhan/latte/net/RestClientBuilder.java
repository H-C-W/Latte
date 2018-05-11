package com.engrhan.latte.net;

import com.engrhan.latte.callback.IError;
import com.engrhan.latte.callback.IFailure;
import com.engrhan.latte.callback.IRequest;
import com.engrhan.latte.callback.ISuccess;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @author engrh
 * @date 2018/5/10
 */

public class RestClientBuilder {

    private String mUrl;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private ISuccess mISuccess;
    private IError mIError;
    private IFailure mIFailure;
    private IRequest mIRequest;
    private RequestBody mRequestBody;

    public RestClientBuilder() {
    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(Map<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder success(ISuccess success) {
        this.mISuccess = success;
        return this;
    }

    public final RestClientBuilder error(IError error) {
        this.mIError = error;
        return this;
    }

    public final RestClientBuilder failure(IFailure failure) {
        this.mIFailure = failure;
        return this;
    }

    public final RestClientBuilder request(IRequest request) {
        this.mIRequest = request;
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mRequestBody = RequestBody.create(MediaType.parse("application/json;charaster=UTF-8"), raw);
        return this;
    }


    public final RestClient build() {
        return new RestClient(mUrl, PARAMS, mISuccess, mIError, mIFailure, mIRequest, mRequestBody);
    }
}
