package com.example.intentexamples;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PickAndViewActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textContactUri;
    TextView textImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_and_view);

        textContactUri = findViewById(R.id.text_contact_uri);
        textImageUri = findViewById(R.id.text_image_uri);

        findViewById(R.id.btn_pick_contact).setOnClickListener(this);
        findViewById(R.id.btn_view_contact).setOnClickListener(this);
        findViewById(R.id.btn_pick_image).setOnClickListener(this);
        findViewById(R.id.btn_view_image).setOnClickListener(this);
        findViewById(R.id.btn_open_target_activity).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_pick_contact) {
            Intent intent = new Intent(Intent.ACTION_PICK,
                    android.provider.ContactsContract.Contacts.CONTENT_URI);
            startActivityForResult(intent, 111);
        } else if (id == R.id.btn_view_contact) {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(textContactUri.getText().toString()));
            startActivity(intent);
        } else if (id == R.id.btn_pick_image) {
            Intent intent = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, 222);
        } else if (id == R.id.btn_view_image) {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(textImageUri.getText().toString()));
            startActivity(intent);
        } else if (id == R.id.btn_open_target_activity) {
            Intent intent = new Intent(PickAndViewActivity.this, TargetActivity.class);
            intent.putExtra("param1", "value1");
            intent.putExtra("param2", 3.14);
            intent.putExtra("param3", 123);
            Bundle bundle = new Bundle();
            bundle.putString("p1", "value 1");
            bundle.putDouble("p2", 3.14);
            intent.putExtras(bundle);

            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 111) {
            if (resultCode == Activity.RESULT_OK) {
                String contactUri = data.getDataString();
                textContactUri.setText(contactUri);
            }
        } else if (requestCode == 222) {
            if (resultCode == RESULT_OK) {
                String imageUri = data.getDataString();
                textImageUri.setText(imageUri);
            }
        }
    }
}