package com.example.yourstory.winsproject.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yourstory.winsproject.LoginActivity;
import com.example.yourstory.winsproject.R;
import com.example.yourstory.winsproject.view.BanSlidingViewPager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 */
public class LoginFragment extends Fragment implements View.OnClickListener {


    private LoginActivity activity;

    private EditText etID;
    private EditText etPsw;
    private Button btnLogin;
    private TextView tvForget;
    private TextView tvRegister;

    private static BanSlidingViewPager mViewPager;

    /**
     * 获取实例
     */
    public static LoginFragment newInstance(BanSlidingViewPager viewPager) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        mViewPager=viewPager;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_login, container, false);
        initView(view);

        return view;
    }

    /**
     * 初始化控件
     * @param view
     */
    private void initView(View view) {
        activity=(LoginActivity) getActivity();
        etID=view.findViewById(R.id.ev_login_id);
        etPsw=view.findViewById(R.id.ev_login_psw);
        btnLogin=view.findViewById(R.id.btn_login_login);
        tvForget=view.findViewById(R.id.tv_login_forget);
        tvRegister=view.findViewById(R.id.tv_login_register);

        //点击事件
        btnLogin.setOnClickListener(this);
        tvForget.setOnClickListener(this);
        tvRegister.setOnClickListener(this);

    }

    /**
     * 点击事件
      * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login_login:
                if (etID.getText().toString().equals("") || etPsw.getText().toString().equals("")){
                    Toast.makeText(activity,"账号和密码不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    login();
                }
                break;
            case R.id.tv_login_forget:

                break;
            case R.id.tv_login_register:
                //viewPager滑动,1代表注册界面
                mViewPager.setCurrentItem(1);
                break;

        }
    }

    /**
     * 从服务器检查账号密码
     */
    private void login() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //创建requestBody的post请求对象,这是向服务器传一般数据
                    RequestBody requestBody = new FormBody.Builder()
                            .add("id",etID.getText().toString())
                            .add("psw",etPsw.getText().toString())
                            .build();
                    //或者传入一般固定格式的
//                    RequestBody requestBody1=RequestBody.create();

                    //以下为获取数据步骤
                    OkHttpClient client=new OkHttpClient();
                    Request.Builder builder=new Request.Builder();
                    builder.url("http://39.105.144.55:8080/login");
                    builder.post(requestBody);
                    Request request=builder.build();
                    Call call=client.newCall(request);
                    //response是服务器返回的数据
                    Response response=call.execute();

                    Log.d("我的",response+"");

                    final String str=response.body().string();
                    final int code=response.code();
                    Log.d("我的", str);
                    Log.d("我的", String.valueOf(response.code()));
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (str.equals("0")){
                                Toast.makeText(activity,"密码错误",Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(activity,"登录成功",Toast.LENGTH_SHORT).show();
                                @SuppressLint("CommitPrefEdits")
                                SharedPreferences.Editor editor=activity
                                        .getSharedPreferences("login",Context.MODE_PRIVATE)
                                        .edit();
                                editor.putString("id",etID.getText().toString());
                                editor.apply();
                                activity.finish();
                            }
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }



}
