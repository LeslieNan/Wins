package com.example.yourstory.winsproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yourstory.winsproject.R;
import com.example.yourstory.winsproject.ShowContentActivity;
import com.example.yourstory.winsproject.bean.HeadRecyclerBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/9/4.
 * recycler的适配器
 */

public class HeadRVMainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<HeadRecyclerBean> mList;
    private Context mContext;
    private List<Integer> imgList = new ArrayList<>();


    /**
     * 枚举类型
     */
    private enum ITEM_TYPE {

    }

    private static final int ITEM_HEADER = 0;
    private static final int ITEM_GRiD = 1;


    public HeadRVMainAdapter(List<HeadRecyclerBean> mList, Context mContext,
                             List<Integer> imgList) {
        this.mList = mList;
        this.mContext = mContext;
        this.imgList = imgList;
    }

    /**
     * 创建viewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_HEADER) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_head_header, parent,false);
            return new HeaderViewHolder(view);
        } else if (viewType == ITEM_GRiD) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_head_buttongroup, parent,false);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                view.setBackground(mContext.getDrawable(R.drawable.background_listview_prase));
            }
            return new ButtonGroupHolder(view);
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_head, parent,false);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                view.setBackground(mContext.getDrawable(R.drawable.background_listview_prase));
            }
            return new MyViewHolder(view);
        }
    }

    /**
     * 绑定ViewHolder的内容
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,  int position) {
        if (holder instanceof HeaderViewHolder) {
            HeadViewPagerAdapter adapter = new HeadViewPagerAdapter(mContext, imgList);
            ((HeaderViewHolder) holder).vpHeader.setAdapter(adapter);
            ((HeaderViewHolder) holder).vpHeader.setOffscreenPageLimit(imgList.size());
        } else if (holder instanceof ButtonGroupHolder) {
            ((ButtonGroupHolder)holder).iv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext,"你点击了按钮组",Toast.LENGTH_SHORT).show();
                }
            });

        } else if (holder instanceof MyViewHolder) {
            final MyViewHolder mHolder = (MyViewHolder) holder;
            //item的项数加上前两个
            final int truePosition=position-2;
            mHolder.ivHead.setImageResource(mList.get(truePosition).getImgResource());
            mHolder.tvName.setText(mList.get(truePosition).getName());
            mHolder.tvIntroduce.setText(mList.get(truePosition).getIntroduce());
            mHolder.tvPrice.setText("¥" + mList.get(truePosition).getPrice());

            //列表项点击事件
            mHolder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(mContext, ShowContentActivity.class);
                    intent.putExtra("id",truePosition);
                    intent.putExtra("name",mList.get(truePosition).getName());
                    mContext.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size()+2;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    /**
     * 内部header的viewHolder
     */
    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivHead;
        TextView tvName;
        TextView tvIntroduce;
        TextView tvPrice;
        View view;

        MyViewHolder(View itemView) {
            super(itemView);
            ivHead = itemView.findViewById(R.id.iv_head);
            tvName = itemView.findViewById(R.id.text_name);
            tvIntroduce = itemView.findViewById(R.id.text_introduce);
            tvPrice = itemView.findViewById(R.id.text_price);
            view=itemView;
        }
    }

    /**
     * 按钮组的viewHolder
     */
    class ButtonGroupHolder extends RecyclerView.ViewHolder {

        ImageView iv1;
        ImageView iv2;
        ImageView iv3;
        ImageView iv4;
        ImageView iv5;
        public ButtonGroupHolder(View itemView) {
            super(itemView);
            iv1=itemView.findViewById(R.id.btn_head_group1);
            iv2=itemView.findViewById(R.id.btn_head_group2);
            iv3=itemView.findViewById(R.id.btn_head_group3);
            iv4=itemView.findViewById(R.id.btn_head_group4);
            iv5=itemView.findViewById(R.id.btn_head_group5);
        }
    }


    /**
     * header的viewHolder
     */
    class HeaderViewHolder extends RecyclerView.ViewHolder {

        private ViewPager vpHeader;

        HeaderViewHolder(View itemView) {
            super(itemView);
            vpHeader = itemView.findViewById(R.id.vp_head);
        }
    }

}
