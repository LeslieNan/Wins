package com.example.yourstory.winsproject.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yourstory.winsproject.MyInformationActivity;
import com.example.yourstory.winsproject.R;
import com.example.yourstory.winsproject.adapter.UserGridAdapter;
import com.example.yourstory.winsproject.bean.ImageTextButtonBean;
import com.example.yourstory.winsproject.util.UIUtil;
import com.example.yourstory.winsproject.view.UserGridView;

import java.util.ArrayList;
import java.util.List;

public class UserFragment extends Fragment implements View.OnClickListener {


    private Context mContext;

    //控件
    private Button btnCode;
    private Button btnSet;
    private ImageView ivHead;
    private TextView tvName;
    private TextView tvContent;
    private LinearLayout llCollection;
    private LinearLayout llEvaluation;
    private LinearLayout llRecent;
    private View topView;
    private UserGridView gvMenu;


    //gridView的list
    private List<ImageTextButtonBean> buttonList=new ArrayList<>();



    /**
     * 用于取得实例
     * @return
     */
    public static UserFragment newInstance() {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_user, container, false);
        initView(view);
        initGridView();
        return view;
    }

    private void initView(View view) {
        mContext=getActivity();
        btnCode=view.findViewById(R.id.btn_user_saomiao);
        btnSet=view.findViewById(R.id.btn_user_shezhi);
        ivHead=view.findViewById(R.id.iv_user_headimg);
        tvName=view.findViewById(R.id.tv_user_content);
        tvContent=view.findViewById(R.id.tv_user_content);
        llCollection=view.findViewById(R.id.ll_user_shoucang);
        llEvaluation=view.findViewById(R.id.ll_user_pinglun);
        llRecent=view.findViewById(R.id.ll_user_recent);
        gvMenu=view.findViewById(R.id.gv_user);
        topView=view.findViewById(R.id.user_topView);

        //绑定事件
        btnCode.setOnClickListener(this);
        btnSet.setOnClickListener(this);
        ivHead.setOnClickListener(this);
        tvName.setOnClickListener(this);
        tvContent.setOnClickListener(this);
        llCollection.setOnClickListener(this);
        llEvaluation.setOnClickListener(this);
        llRecent.setOnClickListener(this);

        //设置顶部view的高度
        UIUtil.setTopViewHeight(mContext,topView);
    }

    private void initGridView() {

        for (int i = 0; i < 5; i++) {
            Bitmap icon1= BitmapFactory.decodeResource(getResources(),R.drawable.user_star);
            ImageTextButtonBean btn1=new ImageTextButtonBean(icon1,"优惠券","1");
            buttonList.add(btn1);
            Bitmap icon2= BitmapFactory.decodeResource(getResources(),R.drawable.user_speak);
            ImageTextButtonBean btn2=new ImageTextButtonBean(icon2,"校园公告","1");
            buttonList.add(btn2);
            Bitmap icon3= BitmapFactory.decodeResource(getResources(),R.drawable.user_time);
            ImageTextButtonBean btn3=new ImageTextButtonBean(icon3,"失物招领","1");
            buttonList.add(btn3);
        }
        UserGridAdapter adapter=new UserGridAdapter(mContext,buttonList);
        gvMenu.setAdapter(adapter);
    }


    /**
     * 监听事件
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_user_saomiao:

                break;
            case R.id.btn_user_shezhi:

                break;
            case R.id.iv_user_headimg:
                Intent intent=new Intent(mContext, MyInformationActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_user_name:

                break;
            case R.id.tv_user_content:

                break;

        }
    }
}
