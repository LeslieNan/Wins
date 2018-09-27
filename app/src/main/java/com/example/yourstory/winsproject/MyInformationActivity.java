package com.example.yourstory.winsproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MyInformationActivity extends AppCompatActivity {

    private View viewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_information);
        initView();
    }

    private void initView() {
        viewBack=findViewById(R.id.view_back);
        viewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
