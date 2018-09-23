package com.example.yourstory.winsproject;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.yourstory.winsproject.adapter.ViewPagerFragmentAdapter;
import com.example.yourstory.winsproject.fragment.HeadFragment;
import com.example.yourstory.winsproject.fragment.OrderFragment;
import com.example.yourstory.winsproject.fragment.UserFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private BottomNavigationView navigation;
    private Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addFragment();
        link();
        //适配器
        fragmentAdapter();
        //设置底部导航栏不为透明
        setBottomNavigation();
    }

    /**
     * 页面适配器
     */
    private void fragmentAdapter() {
        ViewPagerFragmentAdapter adapter=new ViewPagerFragmentAdapter(
                getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
        //设置初始的页面项
        navigation.setSelectedItemId(R.id.navigation_home);
    }

    /**
     * 初始化控件
     */
    private void initView() {
        viewPager = findViewById(R.id.vp_main);
        navigation = findViewById(R.id.bnv_main);
        //设置navigation的默认图标为空,即显示自定义图标
        navigation.setItemIconTintList(null);
    }

    /**
     * 往数组中添加fragment
     */
    private void addFragment() {
        fragments = new Fragment[]{
                HeadFragment.newInstance(),
                OrderFragment.newInstance(),
                UserFragment.newInstance(),
        };
    }

    /**
     * 将bottomNavigation和viewPager事件链接起来
     */
    private void link() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //根据viePager的position选择navigaiton的选中项
                switch (position) {
                    case 0:
                        navigation.setSelectedItemId(R.id.navigation_home);
                        break;
                    case 1:
                        navigation.setSelectedItemId(R.id.navigation_order);
                        break;
                    case 2:
                        navigation.setSelectedItemId(R.id.navigation_user);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        navigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                viewPager.setCurrentItem(0);
                                return true;
                            case R.id.navigation_order:
                                viewPager.setCurrentItem(1);
                                return true;
                            case R.id.navigation_user:
                                viewPager.setCurrentItem(2);
                                return true;
                        }
                        return false;
                    }
                });
    }

    /**
     * 设置底部导航栏不为透明
     */
    private void setBottomNavigation() {
        Resources resource=(Resources)getBaseContext().getResources();
        ColorStateList csl=(ColorStateList)resource.getColorStateList(R.color.bottom_text);
        navigation.setItemTextColor(csl);
    }
}
