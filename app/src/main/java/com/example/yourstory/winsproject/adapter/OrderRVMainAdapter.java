package com.example.yourstory.winsproject.adapter;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yourstory.winsproject.R;

/**
 * Created by lenovo on 2018/9/12.
 * 订单页面适配器
 */

public class OrderRVMainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;


    public OrderRVMainAdapter(Context context) {
        mContext=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==0){
            View view= LayoutInflater.from(mContext).inflate(R.layout.item_order_ivgroup,parent,false);
            return new IVGroupHolder(view);
        }else {
            View view=LayoutInflater.from(mContext).inflate(R.layout.item_order_listview,parent,false);
            return new MyViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof IVGroupHolder){
            ((IVGroupHolder)holder).linearLayout1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext,"你点击了按钮组",Toast.LENGTH_SHORT).show();
                }
            });
        }else if (holder instanceof MyViewHolder){
            MyViewHolder mHolder=(MyViewHolder)holder;
            mHolder.toEvaluation.setVisibility(View.GONE);
            mHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext,"你点击了cardView",Toast.LENGTH_SHORT).show();

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    class IVGroupHolder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout1;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        public IVGroupHolder(View itemView) {
            super(itemView);
            linearLayout1=itemView.findViewById(R.id.ll_order_group1);
            linearLayout2=itemView.findViewById(R.id.ll_order_group2);
            linearLayout3=itemView.findViewById(R.id.ll_order_group3);
            linearLayout4=itemView.findViewById(R.id.ll_order_group4);
        }
    }


    /**
     * 普通列表项的viewHolder
     */
    class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView evaluation;
        TextView toEvaluation;
        ImageView ivHead;
        TextView title;
        TextView content;
        TextView time;
        TextView price;
        public MyViewHolder(View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.cv_order);
            evaluation=itemView.findViewById(R.id.tv_card_evaluation);
            toEvaluation=itemView.findViewById(R.id.tv_toEvaluation);
            ivHead=itemView.findViewById(R.id.iv_card_head);
            title=itemView.findViewById(R.id.tv_card_title);
            content=itemView.findViewById(R.id.tv_card_content);
            time=itemView.findViewById(R.id.tv_card_time);
            price=itemView.findViewById(R.id.tv_card_price);
        }
    }

}
