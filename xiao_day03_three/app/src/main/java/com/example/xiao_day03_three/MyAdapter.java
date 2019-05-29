package com.example.xiao_day03_three;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by 只想暴富 on 2019/5/29.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.HolderView> {
    private Context context;
    private  List<User.ResultsBean> list;
    private  OnClick onClick;

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    public MyAdapter(Context context, List<User.ResultsBean>  list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapter.HolderView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        return new HolderView(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.HolderView holderView, final int i) {
       User.ResultsBean user = list.get(i);
        holderView.tv.setText(user.getDesc());
        Glide.with(context).load(user.getUrl()).into(holderView.iv);
        holderView.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClick!=null){
                    onClick.OnClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HolderView extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        public HolderView(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            tv=itemView.findViewById(R.id.tv);
        }
    }
    public  interface  OnClick{
        void OnClick(int psoition);
    }
}
