package com.example.yourstory.winsproject.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yourstory.winsproject.R;
import com.example.yourstory.winsproject.bean.ImageTextButtonBean;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by lenovo on 2018/9/17.
 */

public class UserGridAdapter extends BaseAdapter {

    private List<ImageTextButtonBean> list;
    private Context mContext;

    public UserGridAdapter(Context context, List<ImageTextButtonBean> list) {
        this.list = list;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=new ViewHolder();
        if (view==null){
            view = LayoutInflater.from(mContext).inflate(R.layout.item_user_gridview,viewGroup,false);
            holder.icon=view.findViewById(R.id.iv_user_grid);
            holder.name=view.findViewById(R.id.tv_user_grid);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        holder.icon.setImageBitmap(list.get(i).getIcon());
        holder.name.setText(list.get(i).getName());
        return view;
    }

    class ViewHolder {
        ImageView icon;
        TextView name;
        TextView hint;

        public ViewHolder() {
        }
    }
}
