package com.example.yourstory.winsproject;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class SchoolListActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_list);
        initVIew();
    }

    /**
     * 控件初始化
     */
    private void initVIew() {
        toolbar=findViewById(R.id.toolbar);
        recycler=findViewById(R.id.rv_school);
        //配置toolbar
        toolbar.setTitle("选择学校");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    /**
     * item点击事件
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            //toolbar返回键点击事件
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
