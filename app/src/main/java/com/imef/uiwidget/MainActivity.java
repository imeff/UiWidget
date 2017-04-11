package com.imef.uiwidget;

import android.content.Intent;
import android.support.v4.util.Pair;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.imef.uiwidget.adapter.EntryListAdapter;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements EntryListAdapter.OnEntryClick {


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
        mEntryList.add(new Pair<String, Class>("Ui控件", UiEntryActivity.class));
    }

    @Override
    public void onClick(Class activityClass) {
        Intent intent = new Intent();
        intent.setClass(this, activityClass);
        startActivity(intent);
    }
}
