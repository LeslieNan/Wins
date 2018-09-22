package com.example.yourstory.winsproject.bean.showContent;

/**
 * Created by lenovo on 2018/9/19.
 */

public class ShowDataBean {

    private int status;
    private DataObjectBean data;
    private String msg;

    public ShowDataBean(int status, DataObjectBean data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataObjectBean getData() {
        return data;
    }

    public void setData(DataObjectBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
