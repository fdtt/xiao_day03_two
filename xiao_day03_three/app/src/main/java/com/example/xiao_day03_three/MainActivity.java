package com.example.xiao_day03_three;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.xiao_day03_three.presenter.presenter;
import com.example.xiao_day03_three.view.Iview;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Iview {

    private XRecyclerView mXrv;
    private   List<User.ResultsBean>  list;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mvp();
    }

    private void mvp() {
        presenter presenter = new presenter(this);
        presenter.fuli();
    }

    private void initView() {
        mXrv = (XRecyclerView) findViewById(R.id.xrv);
        mXrv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        mXrv.setAdapter(myAdapter);
        mXrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mXrv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                mXrv.loadMoreComplete();
            }
        });
    }

    @Override
    public void fuli(User user) {
        List<User.ResultsBean> results = user.getResults();
        list.addAll(results);
        myAdapter.notifyDataSetChanged();
    }
}
