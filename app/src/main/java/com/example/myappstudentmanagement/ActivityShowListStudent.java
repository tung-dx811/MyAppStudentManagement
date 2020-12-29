package com.example.myappstudentmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.myappstudentmanagement.adapter.StudentAdapter;
import com.example.myappstudentmanagement.model.Student;

import java.util.List;

public class ActivityShowListStudent extends AppCompatActivity {
    StudentAdapter studentAdapter;
    RecyclerView recyclerView;
    List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list_student);
        Intent intent = getIntent();
        studentList =(List<Student>) intent.getSerializableExtra("listStudent");
        recyclerView = findViewById(R.id.RecyclerView);
        studentAdapter = new StudentAdapter(this, studentList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(studentAdapter);
    }
}