package com.example.yourstory.winsproject.util;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yourstory.winsproject.bean.showContent.DataObjectBean;
import com.example.yourstory.winsproject.bean.showContent.ShowDataBean;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

/**
 * Created by lenovo on 2018/9/19.
 */

public class ShowWebDataTask extends AsyncTask {

    private String path;
    private String data;
    private Context mContext;

    //控件
    private ActionBar bar;
    private ImageView img;
    private TextView tvPrice;
    private TextView tvContent;

    public ShowWebDataTask(Context context, String path, ActionBar bar, ImageView img, TextView tvPrice, TextView tvContent) {
        this.mContext = context;
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
        DataObjectBean datalist = showData.getData();

        //更新UI
        bar.setTitle(datalist.getName()+"（服务器网络数据）");

        tvPrice.setText(datalist.getPrice());
        tvContent.setText(datalist.getDescription());

        //图片
        Picasso picasso = Picasso.with(mContext);
        picasso.load(datalist.getImg()).into(img);


    }
}
