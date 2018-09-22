package com.example.yourstory.winsproject.bean;

import android.graphics.Bitmap;

/**
 * Created by lenovo on 2018/9/17.
 * 一个图标，一个标题，一个提示标的
 * 按钮的实体类
 */

public class ImageTextButtonBean {

    private Bitmap icon;
    private String name;
    private String hint;

    public ImageTextButtonBean(Bitmap icon, String name, String hint) {
        this.icon = icon;
        this.name = name;
        this.hint = hint;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
