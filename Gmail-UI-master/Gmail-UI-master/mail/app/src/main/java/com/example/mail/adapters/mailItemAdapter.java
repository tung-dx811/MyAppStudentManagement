package com.example.mail.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mail.R;
import com.example.mail.models.mailItem;

import java.util.List;

public class mailItemAdapter extends BaseAdapter {

    Context context;
    List<mailItem> items;

    public mailItemAdapter(Context context, List<mailItem> items) {
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
            view = LayoutInflater.from(context).inflate(R.layout.mail_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.avatar = view.findViewById(R.id.avatar);
            viewHolder.sender = view.findViewById(R.id.sender);
            viewHolder.text = view.findViewById(R.id.text);
            viewHolder.time = view.findViewById(R.id.time);
            viewHolder.star = view.findViewById(R.id.star);
            view.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder)view.getTag();

        final mailItem item = items.get(i);
        viewHolder.avatar.setText(""+item.getSender().charAt(0));
        viewHolder.sender.setText(item.getSender());
        viewHolder.text.setText(item.getText());
        viewHolder.time.setText(item.getTimeSended().toString().substring(0, 5));

        Drawable backgound = viewHolder.avatar.getBackground();
        backgound.setColorFilter(Color.parseColor(item.getAvatarColor()), PorterDuff.Mode.SRC_ATOP);

        if(item.isStar()){
            viewHolder.star.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_star_rate_32, 0, 0, 0);
        }else{
            viewHolder.star.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_star_outline_32, 0, 0, 0);
        }

        viewHolder.star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.setStar(!item.isStar());
                notifyDataSetChanged();
            }
        });

        return view;
    }

    private class ViewHolder {
        TextView avatar;
        TextView sender;
        TextView text;
        TextView time;
        TextView star;
    }
}
