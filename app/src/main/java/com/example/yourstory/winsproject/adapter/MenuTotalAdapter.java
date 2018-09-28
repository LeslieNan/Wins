package com.example.yourstory.winsproject.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.yourstory.winsproject.MenuListActivity;
import com.example.yourstory.winsproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/9/27.
 * 根据传来的菜单的页面类型，设置列表项的样式
 */

public class MenuTotalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> list=new ArrayList<>();

    private MenuListActivity activity;

    private String TOTAL = "total";
    private String MYINFO = "mInfo";
    private String COMMON = "common";

    public MenuTotalAdapter(MenuListActivity activity, String menuType) {
        this.activity=activity;
        if (menuType.equals(MYINFO)){

        }else if (menuType.equals(COMMON)){

        }else {
            list.add("退出登录");
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_menulist, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder mHolder= (MyViewHolder) holder;
        mHolder.tvTitle.setText(list.get(position));
        mHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击退出登录的事件
                if (position==0){
                    SharedPreferences.Editor editor = activity
                            .getSharedPreferences("login", Context.MODE_PRIVATE)
                            .edit();
                    editor.putString("id","未登录");
                    editor.apply();
                    activity.finish();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        View itemView;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvTitle=itemView.findViewById(R.id.tv_menuList_title);
            this.itemView=itemView;
        }
    }
}
