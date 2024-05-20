package com.example.myapplication.slot5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class Demo51Adapter extends BaseAdapter {
    private List<Demo51Product> mList;
    private Context context;

    public Demo51Adapter() {
    }

    public Demo51Adapter(List<Demo51Product> mList, Context context) {
        this.mList = mList;
        this.context = context;
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
        Demo51ViewHolder holder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.demo51_item_view,parent,false);
            holder = new Demo51ViewHolder();
            holder.img=convertView.findViewById(R.id.demo51_itemview_img);
            holder.tvId=convertView.findViewById(R.id.demo51_itemview_tvID);
            holder.tvName=convertView.findViewById(R.id.demo51_itemview_tvName);
            holder.tvPrice=convertView.findViewById(R.id.demo51_itemview_tvPrice);
            convertView.setTag(holder);
        }else{
            holder=(Demo51ViewHolder) convertView.getTag();
        }
        Demo51Product product = mList.get(position);
        if(product!=null){
            holder.img.setImageResource(R.drawable.android);
            holder.tvId.setText(product.getId());
            holder.tvName.setText(product.getName());
            holder.tvPrice.setText(String.valueOf(product.getPrice()));
        }
        return convertView;
    }

    static class Demo51ViewHolder{
        ImageView img;
        TextView tvName, tvPrice, tvId;

    }
}
