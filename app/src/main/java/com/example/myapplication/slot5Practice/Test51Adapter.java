package com.example.myapplication.slot5Practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class Test51Adapter extends BaseAdapter {
    private List<Test51Product> mlist;
    private Context mContext;

    public Test51Adapter(List<Test51Product> mlist, Context mContext) {
        this.mlist = mlist;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Test51ViewHolder holder;
        if(convertView==null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.test51_item_view, parent, false);
            holder = new Test51ViewHolder();
            holder.img = convertView.findViewById(R.id.test51_itemview_img);
            holder.tvId = convertView.findViewById(R.id.test51_itemview_tvID);
            holder.tvName = convertView.findViewById(R.id.test51_itemview_tvName);
            holder.tvPrice = convertView.findViewById(R.id.test51_itemview_tvPrice);
            convertView.setTag(holder);
        }
        else{
            holder=(Test51ViewHolder) convertView.getTag();
        }
        Test51Product product = mlist.get(position);
        if(product!=null){
            holder.img.setImageResource(R.drawable.android);
            holder.tvId.setText(product.getId());
            holder.tvName.setText(product.getName());
            holder.tvPrice.setText(String.valueOf(product.getPrice()));
        }
        return convertView;
    }

    static class Test51ViewHolder{
        ImageView img;
        TextView tvId, tvName, tvPrice;
    }
}
