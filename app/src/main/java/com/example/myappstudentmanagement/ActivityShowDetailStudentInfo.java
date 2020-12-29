package com.example.myappstudentmanagement;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myappstudentmanagement.model.Student;

public class ActivityShowDetailStudentInfo extends AppCompatActivity {
    TextView mssv, fullname, dob, email, address;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail_student_info);

        Intent intent = getIntent();
        Student student =(Student) intent.getSerializableExtra("student");

        mssv = findViewById(R.id.detail_mssv);
        mssv.setText("Mã số sinh viên: " + student.getMssv());

        fullname = findViewById(R.id.detail_fullname);
        fullname.setText("Họ tên: " + student.getFullname());

        dob = findViewById(R.id.detail_dob);
        dob.setText("Ngày sinh: " + student.getDob());

        email = findViewById(R.id.detail_email);
        email.setText("Mã số sinh viên: " + student.getEmail());

        address = findViewById(R.id.detail_address);
        address.setText("Mã số sinh viên: " + student.getAddress());

        findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(ActivityShowDetailStudentInfo.this)
                        .setTitle("")
                        .setMessage("Bạn muốn xóa sinh viên này?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int mssv = student.getMssv();
                                deleteStudent(mssv);
                                Intent intent = new Intent(ActivityShowDetailStudentInfo.this, ActivityShowListStudent.class);
                                startActivity(intent);
                            }
                        }).setNegativeButton("No", null).show();
            }
        });

        findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityShowDetailStudentInfo.this,ActivityUpdateStudent.class);
                intent.putExtra("student", student);
                startActivity(intent);
            }
        });
    }
    public void deleteStudent(int mssv){
        String dataPath  = "/data/data/com.example.myappstudentmanagement/files/dataStudent";
        SQLiteDatabase db = SQLiteDatabase.openDatabase(dataPath,null, SQLiteDatabase.CREATE_IF_NECESSARY);
        db.delete("student","mssv = ?", new String[]{String.valueOf(mssv)});
        db.close();
    }

}