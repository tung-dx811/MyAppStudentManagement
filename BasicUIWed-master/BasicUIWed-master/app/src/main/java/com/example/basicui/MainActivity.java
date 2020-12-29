package com.example.basicui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox chkCream, chkSugar;
    RadioButton radDecaf, radExpresso, radColombian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkCream = findViewById(R.id.chk_cream);
        chkSugar = findViewById(R.id.chk_sugar);

        radDecaf = findViewById(R.id.rad_decaf);
        radExpresso = findViewById(R.id.rad_expresso);
        radColombian = findViewById(R.id.rad_colombian);

        findViewById(R.id.btn_pay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = "Coffee ";

                if (radDecaf.isChecked())
                    msg += "decaf ";
                else if (radExpresso.isChecked())
                    msg += "expresso ";
                else
                    msg += "colombian ";



                if (chkCream.isChecked())
                    msg += " & cream";
                if (chkSugar.isChecked())
                    msg += " & sugar";
                Log.v("TAG", msg);

            }
        });

    }

}