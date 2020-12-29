package com.example.mail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.mail.adapters.mailItemAdapter;
import com.example.mail.models.mailItem;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.bloco.faker.Faker;

public class MainActivity extends AppCompatActivity {

    List<mailItem> items;
    List<mailItem> itemsCopy;
    String[] colors;
    Random generator;
    ListView listView;
    mailItemAdapter adapter;
    boolean favOnly = false;
    SearchView txtSearchValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = new ArrayList<>();
        colors = new String[]{
                "#fff44336", "#ffe91e63", "#ff9c27b0", "#ff673ab7",
                "#ff3f51b5", "#ff2196f3", "#ff03a9f4", "#ff00bcd4",
                "#ff009688", "#ff4caf50", "#ff8bc34a", "#ffcddc39",
                "#ffffeb3b", "#ffffc107", "#ffff9800", "#ffff5722",
                "#ff795548", "#ff9e9e9e", "#ff607d8b", "#ff333333"
        };

        generator = new Random(1);
        Time time;
        Faker faker = new Faker();
        for (int i = 0; i < 100; i++) {
            time = new Time(generator.nextInt(24), generator.nextInt(60), 4);
            items.add(new mailItem(faker.name.name(), faker.lorem.sentence(), time, false, colors[generator.nextInt(colors.length - 1)]));
        }
        itemsCopy = new ArrayList<>(items);

        adapter = new mailItemAdapter(this, itemsCopy);
        listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);
        listView.setLongClickable(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);

        txtSearchValue = (SearchView) menu.findItem(R.id.search)
                .getActionView();
        // set searchView listener (look for text changes, and submit event)
        txtSearchValue.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                itemsCopy = new ArrayList<>();

                for(int i = 0; i < items.size(); i++){
                    if(items.get(i).getSender().toLowerCase().contains(query.toLowerCase())){
                        itemsCopy.add(items.get(i));
                    }
                }

                adapter = new mailItemAdapter(getApplicationContext(), itemsCopy);
                listView.setAdapter(adapter);
                // recreate the 'original' ActionBar (collapse the SearchBox)
                invalidateOptionsMenu();
                // clear searchView text
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                itemsCopy = new ArrayList<>();
                mailItem tmp;
                for(int i = 0; i < items.size(); i++){
                    tmp = items.get(i);
                    if(tmp.getSender().toLowerCase().contains(newText.toLowerCase())||
                            tmp.getText().toLowerCase().contains(newText.toLowerCase())){
                        itemsCopy.add(tmp);
                    }
                }

                adapter = new mailItemAdapter(getApplicationContext(), itemsCopy);
                listView.setAdapter(adapter);
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search) {
            Toast.makeText(getApplicationContext(),"Search", Toast.LENGTH_SHORT).show();
            // perform SEARCH operations...
            return true;
        }else if (id == R.id.favourite) {

            if(!favOnly){
                favOnly = !favOnly;
                for(int i = 0; i < itemsCopy.size(); i++){
                    if(!itemsCopy.get(i).isStar()){
                        itemsCopy.remove(i);
                        i -= 1;
                    }
                }
                Toast.makeText(getApplicationContext(),"Favourite", Toast.LENGTH_SHORT).show();
                listView.setAdapter(adapter);
            }else {
                favOnly = !favOnly;
                itemsCopy = new ArrayList<>(items);
                adapter = new mailItemAdapter(this, itemsCopy);
                Toast.makeText(getApplicationContext(),"All", Toast.LENGTH_SHORT).show();
                listView.setAdapter(adapter);
            }
            return true;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
//        getMenuInflater().inflate(R.menu.context_menu, menu);
        menu.add(0, 101, 0, "Delete");
        menu.add(0, 102, 0, "Reply");
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        mailItem selectedItem = itemsCopy.get(info.position);

        int id = item.getItemId();
        if (id == 101) {
            items.remove(selectedItem);
            itemsCopy.remove(selectedItem);
            adapter.notifyDataSetChanged();
        } else if (id == 102) {
            Intent myIntent = new Intent(MainActivity.this, Reply.class);
            Bundle myBundle = new Bundle();

            myBundle.putString("sender", selectedItem.getSender());
            myBundle.putString("text", selectedItem.getText());

            myIntent.putExtras(myBundle);
            startActivityForResult(myIntent, 1122);
        }

        return super.onContextItemSelected(item);
    }
}