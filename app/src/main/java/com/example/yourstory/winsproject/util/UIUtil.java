package com.example.yourstory.winsproject.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lenovo on 2018/9/19.
 * UI界面的工具类
 */

public class UIUtil {

    /**
     * 用于使toolbar顶端的View高度适应
     * @param context
     * @param topView
     */
    public static void setTopViewHeight(Context context, View topView){
        //取控件View当前的布局参数// 控件的高强制设成20
        ViewGroup.LayoutParams params = topView.getLayoutParams();
        params.height = getStatusBarHeight(context);// 控件的宽强制设成状态栏的高度
        topView.setLayoutParams(params); //使设置好的布局参数应用到控件
    }
    private static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
