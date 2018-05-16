package com.engrhan.latte.net;

import com.engrhan.latte.callback.IError;
import com.engrhan.latte.callback.IFailure;
import com.engrhan.latte.callback.IRequest;
import com.engrhan.latte.callback.ISuccess;

import java.util.WeakHashMap;

import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * @author engrh
 * @date 2018/5/10
 */

public class RestClient {

    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final ISuccess ISuccess;
    private final IError IError;
    private final IFailure IFailure;
    private final IRequest IRequest;
    private final RequestBody Requestbody;

    public RestClient(String url, WeakHashMap<String, Object> params,
                      ISuccess ISuccess, IError IError,
                      IFailure IFailure, IRequest IRequest,
                      RequestBody Requestody) {
        this.URL = url;
        PARAMS.putAll(params);
        this.ISuccess = ISuccess;
        this.IError = IError;
        this.IFailure = IFailure;
        this.IRequest = IRequest;
        this.Requestbody = Requestody;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }


    private void request(HttpMethod httpMethod) {
        final RestService restService = RestCreator.getRestService();
        Call<String> call = null;
        if (IRequest != null) {
            IRequest.onRequestStart();
        }

        switch (httpMethod) {
            case GET:
                call = restService.get(URL, PARAMS);
                break;
            case PUT:
                call = restService.put(URL, PARAMS);
                break;
            case POST:
                call = restService.post(URL, PARAMS);
                break;
            case DELETE:
                call = restService.delete(URL, PARAMS);

                break;

//                break; case UPLOAD:
//                restService.upload(URL,);
//                break;
//            case DOWNLOAD:
//                restService.download(URL);
            default:
                break;
        }

        if (call != null) {
            call.enqueue(getRequestBack());
        }

    }


    private RequestBack getRequestBack() {
        return new RequestBack(IRequest, ISuccess, IError, IFailure);
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void put() {
        request(HttpMethod.PUT);
    }

    public final void post() {
        request(HttpMethod.POST);
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }


}
