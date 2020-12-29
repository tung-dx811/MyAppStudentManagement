package com.example.week7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private List<Email> listEmail;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context context, List<Email> listEmail){
        this.context=context;
        this.listEmail=listEmail;
        layoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return listEmail.size();
    }

    @Override
    public Object getItem(int position) {
        return listEmail.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.list_item,null);
            holder=new ViewHolder();
            holder.wordView=(TextView) convertView.findViewById(R.id.word);
            holder.nameView=(TextView) convertView.findViewById(R.id.name);
            holder.timeView=(TextView) convertView.findViewById(R.id.time);
            holder.contentView=(TextView) convertView.findViewById(R.id.content);
            holder.imageView= (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        }
        else{
            holder=(ViewHolder) convertView.getTag();
        }
        Email email= this.listEmail.get(position);
        holder.wordView.setText(email.getWord());
        holder.nameView.setText(email.getName());
        holder.timeView.setText(email.getTime());
        holder.contentView.setText(email.getContent());
        holder.imageView.setImageResource(R.mipmap.star);
        return convertView;
    }


    public class ViewHolder{
        TextView wordView;
        TextView nameView;
        TextView timeView;
        TextView contentView;
        ImageView imageView;
    }
}
