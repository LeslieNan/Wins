package com.example.yourstory.winsproject.bean;

/**
 * Created by lenovo on 2018/9/4.
 * 实体类
 */

public class HeadRecyclerBean {
    private int imgResource;
    private String name;
    private String introduce;
    private String price;

    public HeadRecyclerBean(int imgResource, String name, String introduce, String price) {
        this.imgResource = imgResource;
        this.name = name;
        this.introduce = introduce;
        this.price = price;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
