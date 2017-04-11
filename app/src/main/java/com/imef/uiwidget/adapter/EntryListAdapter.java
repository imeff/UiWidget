package com.imef.uiwidget.adapter;

import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.imef.uiwidget.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2017/4/11.
 */

public class EntryListAdapter extends RecyclerView.Adapter<EntryListAdapter.ViewHolder> {

    private ArrayList<Pair<String, Class>> mData;
    private OnEntryClick mListener;

    public EntryListAdapter(ArrayList<Pair<String, Class>> data, OnEntryClick listener) {
        mData = data;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_entry, parent, false));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = (TextView) itemView.findViewById(R.id.textview);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pair<String, Class> pair = mData.get(position);
        holder.view.setText(pair.first);
        holder.view.setTag(pair.second);
        holder.view.setOnClickListener(mOnclickListener);
    }

    private View.OnClickListener mOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mListener.onClick((Class) v.getTag());
        }
    };

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface OnEntryClick {
        void onClick(Class activityName);
    }
}
