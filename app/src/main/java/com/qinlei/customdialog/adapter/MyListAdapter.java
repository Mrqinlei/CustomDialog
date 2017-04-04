package com.qinlei.customdialog.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qinlei.customdialog.R;
import com.qinlei.customdialog.model.MyListBean;

import java.util.List;

/**
 * Created by ql on 2017/4/1.
 */

public class MyListAdapter extends BaseAdapter {
    private List<MyListBean> myListBeanList;
    private LayoutInflater mInflater;

    public MyListAdapter(Context context, List<MyListBean> myListBeanList) {
        mInflater = LayoutInflater.from(context);
        this.myListBeanList = myListBeanList;
    }

    @Override
    public int getCount() {
        return myListBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return myListBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.content = (TextView) convertView.findViewById(R.id.content);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.title.setText(myListBeanList.get(position).title);
        holder.content.setText(myListBeanList.get(position).content);
        return convertView;
    }

    public class ViewHolder {
        public TextView title;
        public TextView content;
    }
}
