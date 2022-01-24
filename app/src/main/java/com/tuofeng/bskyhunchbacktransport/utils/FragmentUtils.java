package com.tuofeng.bskyhunchbacktransport.utils;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

public class FragmentUtils {

    public static void initFragment(FragmentActivity context, int layoutID, Fragment targetFragment) {
        FragmentTransaction transaction = context.getSupportFragmentManager()
                .beginTransaction();
        transaction.replace(layoutID, targetFragment);
        transaction.commitAllowingStateLoss();
    }

    public static void switchFragment(FragmentActivity context, int layoutID, Fragment currentFragment, Fragment targetFragment) {
        FragmentTransaction transaction = context.getSupportFragmentManager()
                .beginTransaction();
        if (!targetFragment.isAdded()) {
            transaction.hide(currentFragment);
            transaction.add(layoutID, targetFragment);
        } else {
            transaction.hide(currentFragment);
            transaction.show(targetFragment);
        }
        transaction.commitAllowingStateLoss();
    }
}