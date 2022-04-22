package com.tuofeng.bskyhunchbacktransport.utils;


import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;

import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.PermissionRequest;

public class PermissionUtil {

    public static final int ACCESS_FINE_LOCATION_CODE = 500;
    public static final int CALL_PHONE_CODE = 501;
    public static final int READ_EXTERNAL_STORAGE_COD = 502;
    public static final int REQUEST_INSTALL_PACKAGES_COD = 503;

    public static final String CAMERA_PERMISSION = "CAMERA_PERMISSION";

    public static final String CALL_PHONE = Manifest.permission.CAMERA;//相册

    public static final String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;//读文件
    public static final String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;//写文件

    public static final String ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;//定位权限
    public static final String ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;//定位权限

    public static final String REQUEST_INSTALL_PACKAGES = Manifest.permission.REQUEST_INSTALL_PACKAGES;//安装APP权限

    private static String[] getPermissionType(String permissionsType) {
        String[] params = null;
        if (ACCESS_FINE_LOCATION.equals(permissionsType)) {//定位权限
            params = new String[]{ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION};
        } else if (CALL_PHONE.equals(permissionsType)) {//相机权限
            params = new String[]{CALL_PHONE};
        } else if (READ_EXTERNAL_STORAGE.equals(permissionsType)) {
            params = new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE};
        }
        return params;
    }

    public static String getPermissionsHint(String permissionsType) {
        String permissionsHint = "";
        if (PermissionUtil.ACCESS_FINE_LOCATION.equals(permissionsType)) {
            permissionsHint = "当前已禁止获取定位权限，请前往设置页开启权限";
        } else if (PermissionUtil.CALL_PHONE.equals(permissionsType)) {
            permissionsHint = "当前已禁止获取相机权限，请前往设置页开启权限";
        } else if (PermissionUtil.READ_EXTERNAL_STORAGE.equals(permissionsType)) {
            permissionsHint = "当前已禁止获取存储权限，请前往设置页开启权限";
        }
        return permissionsHint;
    }

    public static int getPermissionCode(String permissionsType) {
        int code = 0;
        if (ACCESS_FINE_LOCATION.equals(permissionsType)) {//定位权限
            code = ACCESS_FINE_LOCATION_CODE;
        } else if (CALL_PHONE.equals(permissionsType)) {//相机权限
            code = CALL_PHONE_CODE;
        } else if (READ_EXTERNAL_STORAGE.equals(permissionsType)) {
            code = READ_EXTERNAL_STORAGE_COD;
        }
        return code;
    }

    public interface PermissionsCall {
        void responseCall(int type);
    }

    @SuppressLint("RestrictedApi")
    public static void getPermissionList(Activity activity, String permissionsType, PermissionsCall call) {
        String[] permissionType = getPermissionType(permissionsType);
        if (EasyPermissions.hasPermissions(activity, permissionType)) {
            call.responseCall(1);
        } else {
            PermissionRequest request = new PermissionRequest.Builder(activity, getPermissionCode(permissionsType), permissionType).build();
            request.getHelper().directRequestPermissions(getPermissionCode(permissionsType), permissionType);
        }
    }

   /* public static final String CAMERA_PERMISSION = "CAMERA_PERMISSION";

    public static final String CALL_PHONE = "CALL_PHONE";

    public static final String ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;//定位权限

    *//**
     *
     *//*
    public static void getPermissionList(Activity activity, final PermissionListener listener, String... permissions) {
        AndPermission.with(activity)
                .runtime()
                .permission(permissions)
                .rationale(new RuntimeRationale())
                .onGranted(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        if (listener != null) {
                            listener.onSuccess(data);
                        }
                    }
                })
                .onDenied(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        if (listener != null) {
                            listener.onFail(data);
                        }
                    }
                })
                .start();
    }

    *//**
     * 获取指定某一个权限
     * 第一次参数写法：Permission.READ_CONTACTS，一般为permission+Android权限的最后一个单词
     *
     * @param whichPermission
     * @param activity
     * @param listener
     *//*
    public static void checkOneOfPermission(Activity activity, final PermissionListener listener, String... whichPermission) {
        getPermissionList(activity, listener, whichPermission);
    }

    *//**
     * 请求相机权限
     *//*
    public static void checkCameraPermission(Activity context, PermissionListener listener) {
        checkOneOfPermission(context, listener, Permission.CAMERA);
    }

    *//**
     * 判断是否具有相机运行时权限
     *
     * @return
     *//*
    public static boolean hasCameraPermission(Context context) {
        return AndPermission.hasPermissions(context, Permission.CAMERA);
    }

    *//**
     * 判断是否具有录音运行时权限
     *
     * @return
     *//*
    public static boolean hasVoicePermission(Context context) {
        return AndPermission.hasPermissions(context, Permission.RECORD_AUDIO);
    }

    *//**
     * 判断是否具有相机运行时权限
     *
     * @return
     *//*
    public static boolean hasStoragePermission(Context context) {
        return AndPermission.hasPermissions(context, Permission.WRITE_EXTERNAL_STORAGE, Permission.READ_EXTERNAL_STORAGE);
    }

    *//**
     * Set permissions.
     * 在Activity中的onActivityResult中判断
     *//*
    public static void setPermission(Activity activity, int requestC0de) {
        AndPermission.with(activity).runtime().setting().start(requestC0de);
    }

    *//**
     * 权限请求结果回调
     *//*
    public interface PermissionListener {
        void onSuccess(List<String> permissions);

        void onFail(List<String> permissions);
    }*/
}