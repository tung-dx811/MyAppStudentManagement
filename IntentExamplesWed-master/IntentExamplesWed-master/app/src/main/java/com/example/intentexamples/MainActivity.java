package com.example.intentexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_open_dial).setOnClickListener(this);
        findViewById(R.id.btn_open_call).setOnClickListener(this);
        findViewById(R.id.btn_web_search).setOnClickListener(this);
        findViewById(R.id.btn_send_sms).setOnClickListener(this);
        findViewById(R.id.btn_get_images).setOnClickListener(this);
        findViewById(R.id.btn_view_contacts).setOnClickListener(this);
        findViewById(R.id.btn_edit_contact).setOnClickListener(this);
        findViewById(R.id.btn_open_web).setOnClickListener(this);
        findViewById(R.id.btn_search_map).setOnClickListener(this);
        findViewById(R.id.btn_view_map).setOnClickListener(this);
        findViewById(R.id.btn_view_route).setOnClickListener(this);
        findViewById(R.id.btn_send_email).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_open_dial) {
            String myPhoneNumberUri = "tel:555-1234";
            Intent myActivity2 = new Intent(Intent.ACTION_DIAL, Uri.parse(myPhoneNumberUri));
            startActivity(myActivity2);
        } else if (id == R.id.btn_open_call) {
            String myData = "tel:555-1234";
            Intent myActivity2 = new Intent(Intent.ACTION_CALL, Uri.parse(myData));
            startActivity(myActivity2);
        }  else if (id == R.id.btn_web_search) {
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, "straight hitting golf clubs");
            startActivity(intent);
        }  else if (id == R.id.btn_send_sms) {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:555-4321"));
            intent.putExtra("sms_body", "are we playing golf next Sunday?");
            startActivity(intent);
        }  else if (id == R.id.btn_get_images) {
            Intent intent = new Intent();
            intent.setType("image/pictures/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivity(intent);
        }  else if (id == R.id.btn_view_contacts) {
            String myData = "content://contacts/people/";
            Intent myActivity2 = new Intent(Intent.ACTION_VIEW, Uri.parse(myData));
            startActivity(myActivity2);
        }  else if (id == R.id.btn_edit_contact) {
            String myData = ContactsContract.Contacts.CONTENT_URI + "/2" ;
            Intent myActivity2 = new Intent(Intent.ACTION_EDIT, Uri.parse(myData));
            startActivity(myActivity2);
        }  else if (id == R.id.btn_open_web) {
            String myUriString = "https://www.hust.edu.vn";
            Intent myActivity2 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUriString));
            startActivity(myActivity2);
        }  else if (id == R.id.btn_search_map) {
            String thePlace = "Cleveland State University, Ohio";
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=(" + thePlace + ")"));
            startActivity(intent);
        }  else if (id == R.id.btn_view_map) {
            String geoCode = "geo:41.5020952,-81.6789717&z=16";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoCode));
            startActivity(intent);
        }  else if (id == R.id.btn_view_route) {
            Intent intent = new Intent(
                    android.content.Intent.ACTION_VIEW,
                    Uri.parse("http://maps.google.com/maps?"
                                    + "saddr=9.938083,-84.054430&"
                                    + "daddr=9.926392,-84.055964"));
            startActivity(intent);
        }  else if (id == R.id.btn_send_email) {
            String emailSubject = "Department Meeting";
            String emailText = "We’ll discuss the new project "
                    + "on Tue. at 9:00am @ room BU344";
            String[] emailReceiverList = {"v.matos@csuohio.edu"};

            Intent intent = new Intent(Intent.ACTION_SEND);

            intent.setType("vnd.android.cursor.dir/email");
            intent.putExtra(Intent.EXTRA_EMAIL, emailReceiverList);
            intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
            intent.putExtra(Intent.EXTRA_TEXT, emailText);

            startActivity(Intent.createChooser(intent, "To complete action choose:"));
        }
    }
}