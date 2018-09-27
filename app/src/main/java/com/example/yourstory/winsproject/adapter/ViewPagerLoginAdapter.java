package com.example.yourstory.winsproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by lenovo on 2018/9/25.
 */

public class ViewPagerLoginAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments;
    public ViewPagerLoginAdapter(FragmentManager fm,Fragment[] fragments) {
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
}
