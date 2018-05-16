package com.engrhan.latte.net;

import com.engrhan.latte.callback.IError;
import com.engrhan.latte.callback.IFailure;
import com.engrhan.latte.callback.IRequest;
import com.engrhan.latte.callback.ISuccess;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by engrh on 2018/5/16.
 */

public class RequestBack implements Callback<String> {
    private IRequest IRequest;
    private ISuccess ISuccess;
    private IError IError;
    private IFailure IFailure;

    public RequestBack(IRequest request, ISuccess success, IError error, IFailure failure) {
        this.IRequest = request;
        this.ISuccess = success;
        this.IError = error;
        this.IFailure = failure;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response != null) {
            if (call.isExecuted()) {
                if (ISuccess != null) {
                    ISuccess.onSuccess(response.body());
                }
            }

        } else if (IError != null) {
            IError.onError(response.code(), response.message());
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (IFailure != null) {
            IFailure.onFailure();
        }
        if (IRequest != null) {
            IRequest.onRequestEnd();
        }
    }
}
