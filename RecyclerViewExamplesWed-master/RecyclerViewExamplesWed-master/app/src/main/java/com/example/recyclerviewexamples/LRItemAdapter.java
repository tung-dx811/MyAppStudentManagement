package com.example.recyclerviewexamples;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LRItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    List<ItemModel> items;

    public LRItemAdapter(List<ItemModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_left, parent, false);
            return new LeftViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_right, parent, false);
            return new RightViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 0) {
            LeftViewHolder viewHolder = (LeftViewHolder)holder;
            viewHolder.textMessage.setText(items.get(position).getTitle());
            viewHolder.imageAvatar.setImageResource(items.get(position).getThumbnailResource());
        } else {
            RightViewHolder viewHolder = (RightViewHolder)holder;
            viewHolder.textMessage.setText(items.get(position).getTitle());
            viewHolder.imageAvatar.setImageResource(items.get(position).getThumbnailResource());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position).getTitle().equals("me"))
            return 1;
        else
            return 0;
    }

    class LeftViewHolder extends RecyclerView.ViewHolder {

        TextView textMessage;
        ImageView imageAvatar;

        public LeftViewHolder(@NonNull View itemView) {
            super(itemView);

            textMessage = itemView.findViewById(R.id.text_message);
            imageAvatar = itemView.findViewById(R.id.image_avatar);
        }
    }

    class RightViewHolder extends RecyclerView.ViewHolder {

        TextView textMessage;
        ImageView imageAvatar;

        public RightViewHolder(@NonNull View itemView) {
            super(itemView);

            textMessage = itemView.findViewById(R.id.text_message);
            imageAvatar = itemView.findViewById(R.id.image_avatar);
        }
    }
}
