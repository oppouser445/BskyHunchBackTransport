package com.tuofeng.bskyhunchbacktransport.utils;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

public class FragmentUtils {

          //错误的做法
        //每次切换的时候，Fragment都会重新实例化，重新加载一边数据，这样非常消耗性能和用户的数据流量
    /*public void switchFragment(Fragment targetFragment) {
        if (targetFragment == null)
            return;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //目标Fragment替换原来的Fragment
        transaction.replace(R.id.content, targetFragment);
        transaction.commit();
    }*/

    //正确的做法
    public static void switchFragment(FragmentActivity context, int layoutID, Fragment currentFragment, Fragment targetFragment) {
        FragmentTransaction transaction = context.getSupportFragmentManager()
                .beginTransaction();
        if (!targetFragment.isAdded()) {
            transaction.hide(currentFragment);
            transaction.add(/*R.id.main_fragment*/layoutID, targetFragment);
            System.out.println("还没添加呢");
        } else {
            transaction.hide(currentFragment);
            transaction.show(targetFragment);
            System.out.println("添加了( ⊙o⊙ )哇");
        }
        transaction.commit();
    }
}
