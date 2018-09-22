package com.example.yourstory.winsproject.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yourstory.winsproject.R;
import com.example.yourstory.winsproject.adapter.OrderRVMainAdapter;
import com.example.yourstory.winsproject.util.UIUtil;

public class OrderFragment extends Fragment {

    private Context mContext;
    private RecyclerView recycler;
    private View topView;
    private Toolbar toolbar;


    public static OrderFragment newInstance() {
        OrderFragment fragment = new OrderFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_order, container, false);
        initView(view);
        initRecycler();
        return view;

    }

    private void initView(View view) {
        mContext=getActivity();
        recycler=view.findViewById(R.id.rv_order);
        topView=view.findViewById(R.id.order_topView);
        toolbar=view.findViewById(R.id.toolbar);
        //设置顶部view的高度
        UIUtil.setTopViewHeight(mContext,topView);
        toolbar.setTitle("订单");
    }

    /**
     * 配置recyclerView
     */
    private void initRecycler() {
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        OrderRVMainAdapter adapter=new OrderRVMainAdapter(mContext);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);
    }

}
