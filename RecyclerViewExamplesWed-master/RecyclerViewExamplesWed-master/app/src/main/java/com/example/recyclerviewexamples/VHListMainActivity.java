package com.example.recyclerviewexamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class VHListMainActivity extends AppCompatActivity {

    List<List<ItemModel>> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_h_list_main);

        items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<ItemModel> subItems = new ArrayList<>();
            for (int j = 0; j < 10; j++)
                subItems.add(new ItemModel(R.drawable.thumb1, "Item " + i + j));
            items.add(subItems);
        }

        RecyclerView recyclerView = findViewById(R.id.vh_recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        VerticalItemAdapter adapter = new VerticalItemAdapter(items);
        recyclerView.setAdapter(adapter);
    }
}