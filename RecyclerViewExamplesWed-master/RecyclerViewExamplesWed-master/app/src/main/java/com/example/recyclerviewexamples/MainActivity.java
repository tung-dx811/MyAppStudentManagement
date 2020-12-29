package com.example.recyclerviewexamples;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.bloco.faker.Faker;

public class MainActivity extends AppCompatActivity implements ItemAdapter.ItemClickListener {

    List<ItemModel> items;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        items.add(new ItemModel(R.drawable.thumb1, "Image 1"));
        items.add(new ItemModel(R.drawable.thumb2, "Image 2  Image 2 Image 2"));
        items.add(new ItemModel(R.drawable.thumb3, "Image 3"));
        items.add(new ItemModel(R.drawable.thumb4, "Image 4"));
        items.add(new ItemModel(R.drawable.thumb5, "Image 5 Image 5"));
        items.add(new ItemModel(R.drawable.thumb6, "Image 6"));
        items.add(new ItemModel(R.drawable.thumb7, "Image 7 Image 7 Image 7"));
        items.add(new ItemModel(R.drawable.thumb8, "Image 8"));

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, true);
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
        //RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ItemAdapter(items, this);
        recyclerView.setAdapter(adapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        findViewById(R.id.btn_insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(0, new ItemModel(R.drawable.thumb1, "New Item"));
                adapter.notifyItemInserted(0);
            }
        });

        findViewById(R.id.btn_remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.remove(0);
                adapter.notifyItemRemoved(0);
            }
        });

        findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.get(0).setTitle("Updated title");
                adapter.notifyItemChanged(0);
            }
        });

        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                items.remove(position);
                adapter.notifyItemRemoved(position);
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }


    @Override
    public void ProcessItemClick(int position) {
        Log.v("TAG", "Selected: " + items.get(position).getTitle());
    }
}