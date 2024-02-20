package com.pakhi.newcashingapp;

public interface AsyncTaskReceiver<T> {
    void onSuccess(T result);
    void onFailure(Throwable throwable);

}
