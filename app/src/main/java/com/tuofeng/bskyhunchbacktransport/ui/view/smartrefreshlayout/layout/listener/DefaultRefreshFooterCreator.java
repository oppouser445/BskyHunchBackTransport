package com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.layout.listener;

import android.content.Context;

import androidx.annotation.NonNull;

import com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.layout.api.RefreshFooter;
import com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.layout.api.RefreshLayout;


/**
 * 默认Footer创建器
 * Created by scwang on 2018/1/26.
 */
public interface DefaultRefreshFooterCreator {
    @NonNull
    RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout);
}
