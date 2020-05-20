package com.example.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StringAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> stringArrayList;
    private LayoutInflater mLayoutInflater;

    public StringAdapter(Context mContext, ArrayList<String> stringArrayList) {
        this.mContext = mContext;
        this.stringArrayList = stringArrayList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return stringArrayList.size();
    }

    @Override
    public String getItem(int position) {
        return stringArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.items, null);

        TextView stringViewer = (TextView) view.findViewById(R.id.item_string);

        stringViewer.setText(stringArrayList.get(position));

        return view;
    }
}
