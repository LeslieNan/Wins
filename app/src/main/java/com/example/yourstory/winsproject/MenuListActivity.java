package com.example.yourstory.winsproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.yourstory.winsproject.adapter.MenuTotalAdapter;

public class MenuListActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);
        initIntent();
        initView();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.rv_menuList);
    }

    private void initIntent() {
        Intent intent = getIntent();
        String menuType = intent.getStringExtra("menuPage");
        MenuTotalAdapter adapter=new MenuTotalAdapter(menuType);
        recyclerView.setAdapter(adapter);
    }




}
