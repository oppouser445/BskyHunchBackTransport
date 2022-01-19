package com.tuofeng.bskyhunchbacktransport.mode.bean;

import androidx.databinding.BaseObservable;

import java.io.Serializable;

public class BaseBean<T> extends BaseObservable implements Serializable {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}