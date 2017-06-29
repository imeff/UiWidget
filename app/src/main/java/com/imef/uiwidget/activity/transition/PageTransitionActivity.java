package com.imef.uiwidget.activity.transition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.imef.uiwidget.R;
import com.imef.uiwidget.activity.BaseActivity;
import com.imef.uiwidget.activity.custom.SearchViewActivity;
import com.imef.uiwidget.adapter.EntryListAdapter;

import java.util.ArrayList;

/**
 * Created by yqzheng on 2017/4/27.
 */

public class PageTransitionActivity extends BaseActivity implements EntryListAdapter.OnEntryClick{

    private ArrayList<Pair<String, Class>> mEntryList;
    private RecyclerView mRecyclerView;
    private EntryListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_list);
        initEntryList();
        initView();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new EntryListAdapter(mEntryList, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initEntryList() {
        mEntryList = new ArrayList<>();
        mEntryList.add(new Pair<String, Class>("Explode ", Explode1Activity.class));
    }

    @Override
    public void onClick(Class activityClass) {
        Intent intent = new Intent();
        intent.setClass(this , activityClass);
        startActivity(intent);
    }

}
