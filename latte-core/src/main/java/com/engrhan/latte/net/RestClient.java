package com.engrhan.latte.net;

import com.engrhan.latte.callback.IError;
import com.engrhan.latte.callback.IFailure;
import com.engrhan.latte.callback.IRequest;
import com.engrhan.latte.callback.ISuccess;

import java.util.WeakHashMap;

import okhttp3.RequestBody;

/**
 * @author engrh
 * @date 2018/5/10
 */

public class RestClient {

    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final ISuccess ISuccess;
    private final IError IERROR;
    private final IFailure IFAILURE;
    private final IRequest IREQUEST;
    private final RequestBody REQUESTBODY;

    public RestClient(String url, WeakHashMap<String, Object> params,
                      ISuccess ISuccess, IError IError,
                      IFailure IFailure, IRequest IRequest,
                      RequestBody Requestody) {
        this.URL = url;
        PARAMS.putAll(params);
        this.ISuccess = ISuccess;
        this.IERROR = IError;
        this.IFAILURE = IFailure;
        this.IREQUEST = IRequest;
        this.REQUESTBODY = Requestody;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }
}
