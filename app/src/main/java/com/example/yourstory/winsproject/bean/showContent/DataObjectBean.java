package com.example.yourstory.winsproject.bean.showContent;

/**
 * Created by lenovo on 2018/9/19.
 */

public class DataObjectBean {
    private int id;
    private String name;
    private String img;
    private String originalprice;
    private String tPrice;
    private String price;
    private String description;

    public DataObjectBean(int id, String name, String img, String originalprice, String tPrice, String price, String description) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.originalprice = originalprice;
        this.tPrice = tPrice;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getOriginalprice() {
        return originalprice;
    }

    public void setOriginalprice(String originalprice) {
        this.originalprice = originalprice;
    }

    public String gettPrice() {
        return tPrice;
    }

    public void settPrice(String tPrice) {
        this.tPrice = tPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
