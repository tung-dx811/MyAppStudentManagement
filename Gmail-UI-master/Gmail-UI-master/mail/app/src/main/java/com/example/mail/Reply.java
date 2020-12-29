package com.example.mail;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;

public class Reply extends AppCompatActivity {

    EditText to, subject, compose_mail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);

        to = findViewById(R.id.to);
        subject = findViewById(R.id.subject);
        compose_mail = findViewById(R.id.compose_mail);

        Intent caller = getIntent();
        Bundle myBundle = caller.getExtras();

        to.setText(myBundle.getString("sender"));
        subject.setText("RE:" + myBundle.getString("text"));

        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_OK, caller);
                finish();
            }
        });
    }
}