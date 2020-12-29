package com.example.listviewexamples.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listviewexamples.R;
import com.example.listviewexamples.models.CustomItemModel;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context context;
    List<CustomItemModel> items;

    public CustomAdapter(Context context, List<CustomItemModel> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_custom_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.imageAvatar = view.findViewById(R.id.image_avatar);
            viewHolder.textTitle = view.findViewById(R.id.text_title);
            viewHolder.textSubtitle = view.findViewById(R.id.text_sub_title);
            viewHolder.checkSelected = view.findViewById(R.id.check_selected);
            view.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder)view.getTag();

        CustomItemModel item = items.get(i);
        viewHolder.imageAvatar.setImageResource(item.getAvatarResource());
        viewHolder.textTitle.setText(item.getTitle());
        viewHolder.textSubtitle.setText(item.getSubtitle());
        viewHolder.checkSelected.setChecked(item.isSelected());

        viewHolder.checkSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.setSelected(viewHolder.checkSelected.isChecked());
                notifyDataSetChanged();
            }
        });

        return view;
    }

    private class ViewHolder {
        ImageView imageAvatar;
        TextView textTitle;
        TextView textSubtitle;
        CheckBox checkSelected;
    }
}
