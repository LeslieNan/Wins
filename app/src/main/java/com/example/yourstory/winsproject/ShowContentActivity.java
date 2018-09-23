package com.example.yourstory.winsproject;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yourstory.winsproject.util.ShowWebDataTask;

import org.w3c.dom.Text;

public class ShowContentActivity extends AppCompatActivity {


    private int contentID;
    private String contentName;
    private Toolbar toolbar;
    private ImageView img;
    private TextView tvPrice;
    private TextView tvContent;

    private ActionBar actionBar;

    private static String PATH="http://www.imooc.com/api/shopping?type=12";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_content);
        initIntent();
        initView();
        initData();

    }

    /**
     * 初始化intent
     */
    private void initIntent() {
        Intent getid = getIntent();
        contentName = getid.getStringExtra("name");
    }

    /**
     * 初始化控件
     */
    private void initView() {
        toolbar = findViewById(R.id.toolbar_show);
        img=findViewById(R.id.iv_show);
        tvPrice=findViewById(R.id.tv_show_price);
        tvContent=findViewById(R.id.tv_show_content);
        setSupportActionBar(toolbar);
        actionBar=getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(contentName);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    /**
     * 获取网络数据
     */
    private void initData() {
        new ShowWebDataTask(this,PATH,actionBar,img,tvPrice,tvContent).execute();
    }
}
