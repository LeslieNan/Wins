package com.example.yourstory.winsproject.bean;

/**
 * Created by lenovo on 2018/9/27.
 * 设置菜单的按钮实体类
 */

public class MenuBean {

    private String menu;
    private String description;
    private boolean isOpen;

    public MenuBean(String menu) {
        this.menu = menu;
    }

    public MenuBean(String menu, String description) {
        this.menu = menu;
        this.description = description;
    }

    public MenuBean(String menu, boolean isOpen) {
        this.menu = menu;
        this.isOpen = isOpen;
    }

    public MenuBean(String menu, String description, boolean isOpen) {
        this.menu = menu;
        this.description = description;
        this.isOpen = isOpen;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
