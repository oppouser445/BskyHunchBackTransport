package com.tuofeng.bskyhunchbacktransport.utils;

import android.content.Context;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tuofeng.bskyhunchbacktransport.ui.activity.BaseApplication;
import com.tuofeng.bskyhunchbacktransport.R;

import org.json.JSONException;
import org.json.JSONObject;

public class ToastUtil {
    public static void showFixedJSONToast(String data) {
        try {
            JSONObject object = new JSONObject(data);
            JSONObject error1 = object.getJSONObject("error");
            String message = error1.getString("message");
            ToastUtil.shortToast(message);
        } catch (JSONException e) {
            ToastUtil.shortUniteErrorToast();
            e.printStackTrace();
        }
    }
    public static void shortUniteErrorToast() {
        showToast(BaseApplication.getInstance(), "网络异常请稍后再试", Toast.LENGTH_SHORT);
    }

    public static void shortToast(String msg) {
        showToast(BaseApplication.getInstance(), msg, Toast.LENGTH_SHORT);
    }
    public static void shortToast(Context context, String msg) {
        showToast(context, msg, Toast.LENGTH_SHORT);
    }

    public static void longToast(Context context, String msg) {
        showToast(context, msg, Toast.LENGTH_LONG);
    }

    public static void showToast(Context context, String massage, int duration) {
        // 判断是否是在主线程
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            Looper.prepare();
            Toast toast = new Toast(context);
            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 200);
            toast.setDuration(duration);

            View view = LayoutInflater.from(context).inflate(R.layout.toast_layout, null);
            TextView tvToast = view.findViewById(R.id.tv_toast);
            tvToast.setText(massage);//设置文本

            toast.setView(view);
            toast.show();
            Looper.loop();
        } else {
            Toast toast = new Toast(context);
            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 200);
            toast.setDuration(duration);

            View view = LayoutInflater.from(context).inflate(R.layout.toast_layout, null);
            TextView tvToast = view.findViewById(R.id.tv_toast);
            tvToast.setText(massage);//设置文本

            toast.setView(view);
            toast.show();
        }
    }

    public static void shortTopToast(Context context, String massage) {

        // 判断是否是在主线程
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            Looper.prepare();

            Toast toast = new Toast(context);
            TextView tvToast;

            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP, 0, 300);
            toast.setDuration(Toast.LENGTH_SHORT);

            View view = LayoutInflater.from(context).inflate(R.layout.toast_layout_download, null);
            tvToast = view.findViewById(R.id.tv_toast);
            tvToast.setText(massage);//设置文本

            toast.setView(view);
            toast.show();
            Looper.loop();
        } else {
            Toast toast = new Toast(context);
            TextView tvToast;

            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP, 0, 300);
            toast.setDuration(Toast.LENGTH_SHORT);

            View view = LayoutInflater.from(context).inflate(R.layout.toast_layout_download, null);
            tvToast = view.findViewById(R.id.tv_toast);
            tvToast.setText(massage);//设置文本

            toast.setView(view);
            toast.show();
        }
    }

    public static void showCenterToast(Context context, String massage) {
        // 判断是否是在主线程
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            Looper.prepare();
            Toast toast = new Toast(context);
            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER, 0, 0);
            toast.setDuration(Toast.LENGTH_SHORT);

            View view = LayoutInflater.from(context).inflate(R.layout.toast_layout, null);
            TextView tvToast = view.findViewById(R.id.tv_toast);
            tvToast.setText(massage);//设置文本

            toast.setView(view);
            toast.show();
            Looper.loop();
        } else {
            Toast toast = new Toast(context);
            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER, 0, 0);
            toast.setDuration(Toast.LENGTH_SHORT);

            View view = LayoutInflater.from(context).inflate(R.layout.toast_layout, null);
            TextView tvToast = view.findViewById(R.id.tv_toast);
            tvToast.setText(massage);//设置文本

            toast.setView(view);
            toast.show();
        }
    }

}
