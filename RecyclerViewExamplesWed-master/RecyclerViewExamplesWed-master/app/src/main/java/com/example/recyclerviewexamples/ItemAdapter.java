package com.example.recyclerviewexamples;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    List<ItemModel> items;
    ItemClickListener listener;

    public ItemAdapter(List<ItemModel> items, ItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemModel item = items.get(position);
        holder.textTitle.setText(item.getTitle());
        holder.imageThumbnail.setImageResource(item.getThumbnailResource());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageThumbnail;
        TextView textTitle;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            imageThumbnail = itemView.findViewById(R.id.image_thumbnail);
            textTitle = itemView.findViewById(R.id.text_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null)
                        listener.ProcessItemClick(getAdapterPosition());
                }
            });

            imageThumbnail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.v("TAG", "Image click: " + getAdapterPosition());
                }
            });
        }
    }

    public interface ItemClickListener {
        void ProcessItemClick(int position);
    }
}
