package com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.layout.wrapper;

import android.annotation.SuppressLint;
import android.view.View;

import com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.layout.api.RefreshHeader;
import com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.layout.simple.SimpleComponent;

/**
 * 刷新头部包装
 * Created by scwang on 2017/5/26.
 */
@SuppressLint("ViewConstructor")
public class RefreshHeaderWrapper extends SimpleComponent implements RefreshHeader {

    public RefreshHeaderWrapper(View wrapper) {
        super(wrapper);
    }

}
