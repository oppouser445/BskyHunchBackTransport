package com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.layout.listener;

import android.content.Context;

import androidx.annotation.NonNull;

import com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.layout.api.RefreshHeader;
import com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.layout.api.RefreshLayout;

/**
 * 默认Header创建器
 * Created by scwang on 2018/1/26.
 */
public interface DefaultRefreshHeaderCreator {
    @NonNull
    RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout);
}
