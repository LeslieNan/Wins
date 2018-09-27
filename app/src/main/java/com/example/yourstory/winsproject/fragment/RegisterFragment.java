package com.example.yourstory.winsproject.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 */
public class RegisterFragment extends Fragment {


    private LoginActivity activity;


    private TextView tvBack;
    private EditText etID;
    private EditText etPsw;
    private EditText etAgain;
    private Button btnRegister;

    private static BanSlidingViewPager mViewPager;


    private String jsonCode;
    private String jsonText;

    /**
     *
     */
    public static RegisterFragment newInstance(BanSlidingViewPager viewPager) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        mViewPager = viewPager;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        setKeyListener(view);
        initView(view);
        return view;
    }

    /**
     * 设置返回键监听事件
     *
     * @param view:
     */
    private void setKeyListener(View view) {
        //设置物理按键的监听事件,这个和下面的这个命令必须要设置了，才能监听back事件。
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.setOnKeyListener(backlistener);
    }


    private void initView(View view) {
        tvBack = view.findViewById(R.id.tv_register_back);
        etID = view.findViewById(R.id.et_register_id);
        etPsw = view.findViewById(R.id.et_register_psw);
        etAgain = view.findViewById(R.id.et_register_again);
        btnRegister = view.findViewById(R.id.btn_register);

        activity = (LoginActivity) getActivity();

        //点击事件
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(0);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = etID.getText().toString();
                String psw = etPsw.getText().toString();
                String again = etAgain.getText().toString();
                if (id.equals("") || psw.equals("") || again.equals("")) {
                    Toast.makeText(activity, "账号和密码不能为空", Toast.LENGTH_SHORT).show();
                } else if (!psw.equals(again)) {
                    Toast.makeText(activity, "两次密码不一致", Toast.LENGTH_SHORT).show();
                } else {
                    register();
                }
            }
        });

    }

    /**
     * 设置注册界面时，返回键的监听事件
     */
    private View.OnKeyListener backlistener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                if (i == KeyEvent.KEYCODE_BACK) {  //表示按返回键 时的操作
                    mViewPager.setCurrentItem(0);
                    return true;
                } //后退
                return false;    //已处理
            }

            return false;
        }
    };


    /**
     * 连接到服务器账号注册
     */
    private void register() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String jsonData="{\"id\":\""+etID.getText().toString()+"\",\"psw\":\""+etPsw.getText().toString()+"\",\"name\":\"\",\"school\":\"\",\"studentId\":\"\",\"headImg\":\"\",\"intro\":\"\"}";
                    //创建requestBody的post请求对象,这是向服务器传一般数据
                    RequestBody requestBody = new FormBody.Builder()
                            .add("message",jsonData)
                            .build();
                    Log.d("我的",jsonData);
                    //以下为获取数据步骤
                    OkHttpClient client = new OkHttpClient();
                    Request.Builder builder = new Request.Builder();
                    builder.url("http://39.105.144.55:8080/register");
                    builder.post(requestBody);
                    Request request = builder.build();
                    Call call = client.newCall(request);
                    //response是服务器返回的数据
                    Response response = call.execute();
                    String str = response.body().string();
                    //解析json数据
                    try {
                        JSONObject object=new JSONObject(str);
                        jsonCode=object.getString("code");
                        jsonText=object.getString("text");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Log.d("我的", String.valueOf(response.body()));
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (jsonCode.equals("0")) {
                                Toast.makeText(activity, jsonText, Toast.LENGTH_SHORT).show();
                            } else if (jsonCode.equals("1")){
                                Toast.makeText(activity, "注册成功", Toast.LENGTH_SHORT).show();
                                //返回到登录界面
                                mViewPager.setCurrentItem(0);
                            }
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private void parseJson(String data) {

    }


}
