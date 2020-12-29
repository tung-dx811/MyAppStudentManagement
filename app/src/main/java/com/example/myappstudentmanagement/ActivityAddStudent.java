package com.example.myappstudentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.FileUriExposedException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myappstudentmanagement.model.Student;

public class ActivityAddStudent extends AppCompatActivity {
    EditText mssv, fullname, dob, email, address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        mssv = findViewById(R.id.et_addMssv);
        fullname = findViewById(R.id.et_addFullname);
        dob = findViewById(R.id.et_addDob);
        email = findViewById(R.id.et_addEmail);
        address = findViewById(R.id.et_addAddress);

        findViewById(R.id.btn_addStudent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(
                        Integer.parseInt(mssv.getText().toString()),
                        fullname.getText().toString(),
                        dob.getText().toString(),
                        email.getText().toString(),
                        address.getText().toString());
                addStudent(student);

                Intent intent = new Intent(ActivityAddStudent.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    public void addStudent(Student student) {
        String dataPath = "/data/user/0/com.example.studentmanager/files/mydata";
        SQLiteDatabase db = SQLiteDatabase.openDatabase(dataPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        ContentValues values = new ContentValues();
        values.put("mssv", student.getMssv());
        values.put("fullname", student.getFullname());
        values.put("dateOfBirth", student.getDob());
        values.put("email", student.getEmail());
        values.put("address",student.getAddress());

        db.insert("student", null, values);
        db.close();
    }
}