package com.example.myapplication.slot9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class Demo91Adapter extends BaseAdapter {
    private Context mContext;
    private List<Product91> mList;

    public Demo91Adapter(Context mContext, List<Product91> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder91 holder;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.demo91_itemview, parent, false);
            holder=new ViewHolder91();
            holder.imageView=convertView.findViewById(R.id.demo91_itemview_searchImage);
            holder.styleIDTV=convertView.findViewById(R.id.demo91_itemview_TvStyleID);
            holder.brandTv=convertView.findViewById(R.id.demo91_itemview_TvBrand);
        }
        return null;
    }

    static class ViewHolder91{
        ImageView imageView;
        TextView styleIDTV, brandTv, priceTv, infoTv;
    }
}
