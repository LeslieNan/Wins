package com.example.yourstory.winsproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lenovo on 2018/8/27.
 * 以前的方法。主界面用viewpager做，因为容易卡顿,暂时没用
 */

public class ViewPagerFragmentAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments;

    public ViewPagerFragmentAdapter(FragmentManager fm,Fragment[] fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
