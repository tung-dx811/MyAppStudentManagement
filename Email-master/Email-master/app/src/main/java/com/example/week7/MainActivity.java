package com.example.week7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Email> listEmail=getList();
        final ListView listView=(ListView) findViewById(R.id.list);
        listView.setAdapter(new CustomListAdapter(this,listEmail));

    }
    private List<Email> getList(){
        List<Email> list=new ArrayList<Email>();
        Email one=new Email("google.com","12:34 AM","Your password: 12345678");
        Email two=new Email("youtube.com","9:01 AM","Thanks");
        Email three=new Email("support","1:04 PM","What can I help for you?");
        Email four=new Email("facebook.com","9:45 PM","Your account is 12344");
        Email five=new Email("GitHub.com","6:45 PM","Source code...");
        Email six=new Email("youtube.com","8:56 AM","Your video is saved");

        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        list.add(six);
        return list;
    }
}