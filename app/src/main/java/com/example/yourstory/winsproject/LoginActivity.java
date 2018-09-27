package com.example.yourstory.winsproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.yourstory.winsproject.adapter.ViewPagerLoginAdapter;
import com.example.yourstory.winsproject.fragment.LoginFragment;
import com.example.yourstory.winsproject.fragment.RegisterFragment;
import com.example.yourstory.winsproject.view.BanSlidingViewPager;

public class LoginActivity extends AppCompatActivity {

    private BanSlidingViewPager viewPager;
    private Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initVP();
        fragmentAdapter();

    }

    private void initVP() {
        viewPager=findViewById(R.id.vp_login_main);
        fragments = new Fragment[]{
                LoginFragment.newInstance(viewPager),
                RegisterFragment.newInstance(viewPager),
        };
    }

    /**
     * 页面适配器
     */
    private void fragmentAdapter() {
        ViewPagerLoginAdapter adapter=new ViewPagerLoginAdapter(
                getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
    }


}
