package com.example.yourstory.winsproject.util;

import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yourstory.winsproject.bean.showContent.DataObjectBean;
import com.example.yourstory.winsproject.bean.showContent.ShowDataBean;
import com.google.gson.Gson;

/**
 * Created by lenovo on 2018/9/19.
 */

public class ShowWebDataTask extends AsyncTask {

    private String path;
    private String data;

    //控件
    private ActionBar bar;
    private ImageView img;
    private TextView tvPrice;
    private TextView tvContent;

    public ShowWebDataTask(String path, ActionBar bar, ImageView img, TextView tvPrice, TextView tvContent) {
        this.path = path;
        this.bar = bar;
        this.img = img;
        this.tvPrice = tvPrice;
        this.tvContent = tvContent;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        //获取网络数据
        data = NetUtil.getWebData(path);
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        //解析数据
        Gson gson = new Gson();
        ShowDataBean showData = gson.fromJson(data, ShowDataBean.class);
        DataObjectBean dataLast = showData.getData();

        //更新UI
        bar.setTitle(dataLast.getName());
//        img
        tvPrice.setText(dataLast.getPrice());
        tvContent.setText(dataLast.getDescription());

    }
}
