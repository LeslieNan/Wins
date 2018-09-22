package com.example.yourstory.winsproject.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.yourstory.winsproject.R;

import java.util.List;

/**
 * Created by lenovo on 2018/8/28.
 * 子viewpager的适配器
 */

public class HeadViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<Integer> imgList;

    public HeadViewPagerAdapter(Context context, List<Integer> imgList) {
        this.mContext=context;
        this.imgList=imgList;
    }

    @Override
    public int getCount() {
        return imgList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View child= LayoutInflater.from(mContext).inflate(R.layout.viewpager_head,null);
        ImageView ivHead=child.findViewById(R.id.iv_viewpager);
        ivHead.setImageResource(imgList.get(position));
        container.addView(child);
        return child;
    }

    /**
     * 销毁方法
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }


}
