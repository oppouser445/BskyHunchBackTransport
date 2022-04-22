package com.tuofeng.bskyhunchbacktransport.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.tuofeng.bskyhunchbacktransport.ui.activity.BaseApplication;

public class UserSPUtil {

    private static final String USERDAT = "user_data";
    private static final String TOKEN = "user_token";
    private static final String DRIVERDATA = "user_driver";
    private static final String DRIVERID = "driver_id";
    private static final String TENANT = "_tenant";
    private static final String CACHEFILE = "userInfo.txt";

    private static SharedPreferences getPreferences() {
        return BaseApplication.getInstance().getSharedPreferences(CACHEFILE, Context.MODE_PRIVATE);
    }

    public static void setUserData(String value) {
        getPreferences().edit().putString(USERDAT, value).apply();
    }

    public static String getUserData() {
        return getPreferences().getString(USERDAT, "");
    }

    public static void setUserToken(String value) {
        getPreferences().edit().putString(TOKEN, value).apply();
    }

    public static String getUserToken() {
        return getPreferences().getString(TOKEN, "");
    }

    public static void setDriverData(String value) {
        getPreferences().edit().putString(DRIVERDATA, value).apply();
    }

    public static String getDriverData() {
        return getPreferences().getString(DRIVERDATA, "");
    }

    public static void setDriverID(String value) {
        getPreferences().edit().putString(DRIVERID, value).apply();
    }

    public static String getDriverID() {
        return getPreferences().getString(DRIVERID, "");
    }

    public static void initUserData() {
        UserSPUtil.setDriverID("");
        UserSPUtil.setUserToken("");
        UserSPUtil.setDriverData("");
        UserSPUtil.setUserData("");
    }

    public static void setUserTenant(int type) {
        String data = null;
        if (type == 1) {
            data = "FA54BC53-FF20-1E15-EBBC-3A023C84ACB7";
        } else if (type == 2) {
            data = "62614DA1-B904-1A13-CE72-3A023C84F6F9";
        }
        getPreferences().edit().putString(TENANT, data).apply();
    }

    public static String getTenant() {
        return getPreferences().getString(TENANT, "");
    }
}
