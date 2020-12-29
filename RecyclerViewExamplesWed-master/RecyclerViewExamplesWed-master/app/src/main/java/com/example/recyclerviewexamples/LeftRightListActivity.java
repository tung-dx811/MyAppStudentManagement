package com.example.recyclerviewexamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class LeftRightListActivity extends AppCompatActivity {

    List<ItemModel> items;
    LRItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_right_list);

        items = new ArrayList<>();
        items.add(new ItemModel(R.drawable.thumb1, "me"));
        items.add(new ItemModel(R.drawable.thumb2, "Image 2"));
        items.add(new ItemModel(R.drawable.thumb3, "Image 3"));
        items.add(new ItemModel(R.drawable.thumb4, "Image 4"));
        items.add(new ItemModel(R.drawable.thumb5, "me"));
        items.add(new ItemModel(R.drawable.thumb6, "Image 6"));
        items.add(new ItemModel(R.drawable.thumb7, "me"));
        items.add(new ItemModel(R.drawable.thumb8, "Image 8"));

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, true);
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
        //RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new LRItemAdapter(items);
        recyclerView.setAdapter(adapter);
    }
}