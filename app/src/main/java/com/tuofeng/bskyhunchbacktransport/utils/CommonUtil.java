package com.tuofeng.bskyhunchbacktransport.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.IDCardParams;
import com.baidu.ocr.sdk.model.IDCardResult;
import com.tuofeng.bskyhunchbacktransport.ui.activity.BaseApplication;

import java.io.File;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(float dpValue) {
        final float scale = BaseApplication.getInstance().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (spValue * scale + 0.5f);
    }

    public static int px2sp(Context context, float spValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (spValue / scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 拨打电话（跳转到拨号界面，用户手动点击拨打）
     *
     * @param phoneNum 电话号码
     */
    public static void callPhone(Context context, String phoneNum) {
        /*int version = android.os.Build.VERSION.SDK_INT;
        if (version > Build.VERSION_CODES.M) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            Uri data = Uri.parse("tel:" + phoneNum);
            intent.setData(data);
            context.startActivity(intent);
        } else {

        }*/
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        context.startActivity(intent);
    }

    /**
     * 正则匹配手机号码:
     */
    public static boolean telePhone(String tel){
        Pattern p = Pattern.compile("^[1][3,4,5,7,8,9][0-9]{9}$");
        //Pattern p = Pattern.compile("0?(13|14|15|17|18)[0-9]{9}");
        Matcher matcher = p.matcher(tel);
        return matcher.matches();
    }

    /**
     * MD5码获取
     */
    public static void getMD5Values(Context context){
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);

            Signature signatures = pi.signatures[0];

            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(signatures.toByteArray());

            byte[] digest = md.digest();

            String res = toHexString(digest);

            Log.e("1111111111111","apk md5 = "+res);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static String toHexString(byte[] block) {
        StringBuffer buf = new StringBuffer();
        int len = block.length;
        for (int i = 0; i < len; i++) {
            byte2hex(block[i], buf);
            if (i < len - 1) {
                buf.append(":");
            }
        }
        return buf.toString();
    }

    private static void byte2hex(byte b, StringBuffer buf) {
        char[] hexChars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F' };
        int high = ((b & 0xf0) >> 4);//CA:1E:BA:C9:6E:C0:6D:3F:8C:96:5B:66:C3:EF:F3:3C
        int low = (b & 0x0f);
        buf.append(hexChars[high]);
        buf.append(hexChars[low]);
    }

    /**
     * 跳转到设置界面
     */
    public static void startSetting(Activity mActivity, int requestCode) {
        String settingsFlage = Settings.ACTION_APPLICATION_DETAILS_SETTINGS;
        if (requestCode == PermissionUtil.REQUEST_INSTALL_PACKAGES_COD) {//跳转到安装位置应用程序页面中
            settingsFlage = Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES;
        }
        Intent aPackage = new Intent(settingsFlage);
        aPackage.setData(Uri.fromParts("package", mActivity.getPackageName(), null));
        mActivity.startActivityForResult(aPackage, requestCode);
    }

    public static void recIDCard(Activity mActivity,String idCardSide, String filePath) {
        IDCardParams param = new IDCardParams();
        param.setImageFile(new File(filePath));
        // 设置身份证正反面
        param.setIdCardSide(idCardSide);
        // 设置方向检测
        param.setDetectDirection(true);
        // 设置图像参数压缩质量0-100, 越大图像质量越好但是请求时间越长。 不设置则默认值为20
        param.setImageQuality(20);

        OCR.getInstance(mActivity).recognizeIDCard(param, new OnResultListener<IDCardResult>() {
            @Override
            public void onResult(IDCardResult result) {
                if (result != null) {
                    ToastUtil.shortToast(result.toString());
                }
            }

            @Override
            public void onError(OCRError error) {
                ToastUtil.shortToast(error.getMessage());
            }
        });
    }
    public static File getSaveFile(Context context) {
        File file = new File(context.getFilesDir(), "pic.jpg");
        return file;
    }
}