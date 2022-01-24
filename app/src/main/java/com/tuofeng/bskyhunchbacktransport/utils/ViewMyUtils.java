package com.tuofeng.bskyhunchbacktransport.utils;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.base.IView;
import com.tuofeng.bskyhunchbacktransport.in.IPublicCallback;

public class ViewMyUtils {

    private final String TAG = "ViewMyUtils";

    public static void setTtoggleEffect(View view, boolean b) {
        ObjectAnimator alphaAnimator;
        if (b) {
            alphaAnimator = ObjectAnimator.ofFloat(view, "alpha", 0.5f, 1f);
        } else {
            alphaAnimator = ObjectAnimator.ofFloat(view, "alpha", 1f, 0.5f);
        }
        alphaAnimator.setDuration(500);
        alphaAnimator.start();
    }

    public static SpannableStringBuilder setInstructionText(Context context, IPublicCallback callback) {
        String TAG = "setInstructionText";
        /*String str = "请您务必审慎阅读、充分理解“用户协议”和“隐私政策”各条款，包括但不限于：" +
                "为了向您提供交易相关基本功能，我们会收集、使用必要的信息。你可阅读" +
                "《用户协议》" + "和" +
                "《隐私政策》" +
                "了解详细信息。如您同意，请点击“同意”接受我们的服务。";*/

        String str = "首次登录自动注册网络货运平台账号，并默认您已\n阅读同意《用户服务协议》 《隐私协议》";
        SpannableStringBuilder ssb = new SpannableStringBuilder();
        ssb.append(str);
        //第一个出现的位置
        final int start = str.indexOf("《");
        ssb.setSpan(new ClickableSpan() {

            @Override
            public void onClick(View widget) {
                //用户服务协议点击事件
                //ToastUtil.shortToast("用户服务协议点击事件");
                callback.showLoginView(1);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                //设置文件颜色
                ds.setColor(context.getResources().getColor(R.color.color_main_orange));
                // 去掉下划线
                ds.setUnderlineText(false);
            }
        }, start, start + 8, 0);

        //最后一个出现的位置
        final int end = str.lastIndexOf("《");
        ssb.setSpan(new ClickableSpan() {

            @Override
            public void onClick(View widget) {
                //隐私协议点击事件
                callback.showLoginView(2);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                //设置文件颜色
                ds.setColor(context.getResources().getColor(R.color.color_main_orange));
                // 去掉下划线
                ds.setUnderlineText(false);
            }
        }, end, end + 6, 0);
        return ssb;
    }

    public static void initDotsLayoutStyle(Context context,LinearLayout homeLlyaout){
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(context);
            int i1 = CommonUtil.px2dp(context, 10);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(i1, i1);
            params.setMargins(i1, i1, i1, i1);
            imageView.setImageResource(R.drawable.shape_main_fragment_dots_default);
            imageView.setLayoutParams(params);
            homeLlyaout.addView(imageView);
        }
    }

    public static void setDotsLayoutStyle(Context context,int position,LinearLayout homeLlyaout){
        for (int i = 0; i < 3; i++) {
            boolean b = position == i;
            ImageView imageView = (ImageView) homeLlyaout.getChildAt(i);
            int spacing = CommonUtil.px2dp(context, 10);
            int width = CommonUtil.px2dp(context, b ? 20 : 10);
            int spacingRight = CommonUtil.px2dp(context, b ? 5 : 10);
            LinearLayout.LayoutParams layoutParams = /*new LinearLayout.LayoutParams(width, high)*/(LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = width;
            layoutParams.setMargins(spacing, spacing, spacingRight, spacing);
            imageView.setImageResource(b ? R.drawable.shape_main_fragment_dots : R.drawable.shape_main_fragment_dots_default);
            imageView.setLayoutParams(layoutParams);
        }
    }


    /**/

}