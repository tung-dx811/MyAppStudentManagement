package com.example.intentexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TargetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        String param1 = getIntent().getStringExtra("param1");
        double param2 = getIntent().getDoubleExtra("param2", 0.0);
        int param3 = getIntent().getIntExtra("param3", 0);

        Bundle bundle = getIntent().getExtras();
        String p1 = bundle.getString("p1");
        double p2 = bundle.getDouble("p2", 0.0);

    }
}