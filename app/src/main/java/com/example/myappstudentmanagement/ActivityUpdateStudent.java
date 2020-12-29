package com.example.myappstudentmanagement;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myappstudentmanagement.model.Student;

public class ActivityUpdateStudent extends AppCompatActivity {
    EditText mssv, fullname, dob, email, address;
    Button Ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);

        mssv = findViewById(R.id.update_Mssv);
        fullname = findViewById(R.id.update_Fullname);
        dob = findViewById(R.id.update_Dob);
        email = findViewById(R.id.update_Email);
        address = findViewById(R.id.update_Address);
        Ok = findViewById(R.id.btn_confirm);

        Intent intent  = getIntent();
        Student student  =(Student) intent.getSerializableExtra("student");

        mssv.setText("Mã số sinh viên: " +student.getMssv());
        fullname.setText("Họ tên: " +student.getFullname());
        dob.setText("Ngày sinh: " +student.getDob());
        email.setText("Email: " +student.getEmail());
        address.setText("Địa chỉ: " +student.getAddress());

        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(ActivityUpdateStudent.this)
                        .setTitle("")
                        .setMessage("Bạn muốn thay đổi chi tiết thông tin sinh viên này?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Student student1 = new Student(Integer.parseInt(mssv.getText().toString()),
                                        fullname.getText().toString(),
                                        dob.getText().toString(),
                                        email.getText().toString(),
                                        address.getText().toString());

                            }
                        }).setNegativeButton("No", null).show();
            }
        });
    }
    public void updateStudent(Student student){
        String dataPath  = "/data/data/com.example.myappstudentmanagement/files/dataStudent";

        SQLiteDatabase db = SQLiteDatabase.openDatabase(dataPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        ContentValues values = new ContentValues();

        values.put("mssv", student.getMssv());
        values.put("fullname", student.getFullname());
        values.put("dateOfBirth", student.getDob());
        values.put("email", student.getEmail());
        values.put("address",student.getAddress());

        db.update("student", values, "mssv = ?", new String[] { String.valueOf(student.getMssv()) });
        db.close();
    }
}