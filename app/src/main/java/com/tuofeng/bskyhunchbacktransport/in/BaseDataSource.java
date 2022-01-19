package com.tuofeng.bskyhunchbacktransport.in;

public interface BaseDataSource {

    interface LoadTasksCallback {
        void onDataNotAvailable();
    }

    interface GetTaskCallback {
        void onDataNotAvailable();
    }
}
