package com.example.yourstory.winsproject.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.yourstory.winsproject.MainActivity;
import com.example.yourstory.winsproject.R;
import com.example.yourstory.winsproject.SchoolListActivity;
import com.example.yourstory.winsproject.SearchActivity;
import com.example.yourstory.winsproject.adapter.HeadRVMainAdapter;
import com.example.yourstory.winsproject.bean.HeadRecyclerBean;
import com.example.yourstory.winsproject.util.UIUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页碎片
 */
public class HeadFragment extends Fragment implements View.OnClickListener {

    private Context mContext;
    private View topView;
    private RecyclerView rvMain;
    private Toolbar mToolbar;
    private LinearLayout topViewGroup;
    private Button btnFound;
    private Button btnMessage;
    private LinearLayout btnSchool;
    private List<Integer> imgList = new ArrayList<>();

    //用于计算页面滑动的距离来实现toolbar的渐变
    private int mDistanceY = 0;

    public static HeadFragment newInstance() {
        HeadFragment fragment = new HeadFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_head, container, false);
        initView(view);
        initViewpager();
        initRecycler();
        return view;
    }

    /**
     * 初始化控件
     *
     * @param view：
     */
    private void initView(View view) {
        mContext=getContext();
        topView=view.findViewById(R.id.head_topView);
        rvMain = view.findViewById(R.id.rv_main);
        mToolbar=view.findViewById(R.id.toolbar_head);
        //根据状态栏高度设置topView的高度
        UIUtil.setTopViewHeight(mContext,topView);
        topViewGroup=view.findViewById(R.id.topViewGroup);

        btnFound=view.findViewById(R.id.btn_head_toolbar_found);
        btnMessage=view.findViewById(R.id.btn_head_toolbar_message);
        btnSchool=view.findViewById(R.id.ll_head_toolbar_school);


        //绑定点击事件
        btnFound.setOnClickListener(this);
        btnMessage.setOnClickListener(this);
        btnSchool.setOnClickListener(this);

    }

    /**
     * 初始化幻灯片数据，到时需改为网络数据
     */
    private void initViewpager() {
        int img1 = R.drawable.head1;
        int img2 = R.drawable.head2;
        int img3 = R.drawable.head3;
        int img4 = R.drawable.head4;
        imgList.add(img1);
        imgList.add(img2);
        imgList.add(img3);
        imgList.add(img4);
    }


    /**
     * 初始化recycler数据,到时改为网络数据
     */
    private void initRecycler() {
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        List<HeadRecyclerBean> mList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            mList.add(new HeadRecyclerBean(R.drawable.listimg1, "李浩男", "帮助过同学完成java,asp.net等课程大设计", "30"));
            mList.add(new HeadRecyclerBean(R.drawable.listimg2, "啦啦啦", "幸福的失眠", "30"));
            mList.add(new HeadRecyclerBean(R.drawable.listimg3, "恩恩额", "如何想你想到六点", "30"));
            mList.add(new HeadRecyclerBean(R.drawable.listimg4, "她她她", "如何爱你爱到终点", "30"));
        }
        HeadRVMainAdapter adapter = new HeadRVMainAdapter(mList, mContext, imgList);
        rvMain.setLayoutManager(manager);
        rvMain.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL));
        rvMain.setAdapter(adapter);

        //设置toolbar根据recycler滑动而变色
        rvMain.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //滑动的距离
                mDistanceY += dy;
                //toolbar的高度
//                int toolbarHeight = mToolbar.getBottom();
                //滑动变色的距离,单位px
                int scrollHeight=350;

                //当滑动的距离 <= toolbar高度的时候，改变Toolbar背景色的透明度，达到渐变的效果
                if (mDistanceY <= scrollHeight) {
                    float scale = (float) mDistanceY / scrollHeight;
                    float alpha = scale * 255;
                    topViewGroup.setBackgroundColor(Color.argb((int) alpha, 41, 184, 141));
                } else {
                    //上述虽然判断了滑动距离与toolbar高度相等的情况，但是实际测试时发现，标题栏的背景色
                    //很少能达到完全不透明的情况，所以这里又判断了滑动距离大于toolbar高度的情况，
                    //将标题栏的颜色设置为完全不透明状态
                    topViewGroup.setBackgroundResource(R.color.primary);
                }
            }
        });
    }


    /**
     * 处理点击事件
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_head_toolbar_found:
                Intent intent=new Intent(mContext, SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_head_toolbar_message:

                break;
            case R.id.ll_head_toolbar_school:
                Intent intentToSchool=new Intent(mContext, SchoolListActivity.class);
                startActivity(intentToSchool);
                break;
        }
    }
}
