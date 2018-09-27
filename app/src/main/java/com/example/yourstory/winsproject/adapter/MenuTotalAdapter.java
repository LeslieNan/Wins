package com.example.yourstory.winsproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/9/27.
 * 根据传来的菜单的页面类型，设置列表项的样式
 */

public class MenuTotalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> list=new ArrayList<>();

    private String menuType;

    private String TOTAL = "total";
    private String MYINFO = "mInfo";
    private String COMMON = "common";

    public MenuTotalAdapter(String menuType) {
        this.menuType = menuType;
        if (menuType.equals(TOTAL)){

        }
    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
