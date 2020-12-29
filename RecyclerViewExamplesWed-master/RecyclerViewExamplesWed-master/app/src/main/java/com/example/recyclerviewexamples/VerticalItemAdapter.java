package com.example.recyclerviewexamples;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VerticalItemAdapter extends RecyclerView.Adapter<VerticalItemAdapter.VerticalViewHolder> {

    List<List<ItemModel>> items;

    public VerticalItemAdapter(List<List<ItemModel>> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_vertical_item, parent, false);
        return new VerticalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder holder, int position) {
        List<ItemModel> subItems = items.get(position);
        ItemAdapter adapter = new ItemAdapter(subItems, null);
        holder.recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VerticalViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;

        public VerticalViewHolder(@NonNull View itemView) {
            super(itemView);

            recyclerView = itemView.findViewById(R.id.horizontal_recycler_view);
            recyclerView.setHasFixedSize(true);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(itemView.getContext(), RecyclerView.HORIZONTAL, false);
            recyclerView.setLayoutManager(layoutManager);


        }
    }
}
