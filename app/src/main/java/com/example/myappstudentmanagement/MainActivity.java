package com.example.myappstudentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myappstudentmanagement.model.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static Button create, add, show,search;
    public static SQLiteDatabase db;
    static List<Student> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create = findViewById(R.id.btn_createTb);
        add = findViewById(R.id.btn_add);
        show = findViewById(R.id.btn_show);
        search = findViewById(R.id.btn_filter);

        String dataPath = getFilesDir() + "/dataStudent";
        db = SQLiteDatabase.openDatabase(dataPath,null,SQLiteDatabase.CREATE_IF_NECESSARY);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.beginTransaction();
                try {
                    db.execSQL("create table student ("
                            + " mssv integer(8) PRIMARY KEY, "
                            + " fullName text, "
                            + " dateOfBirth text, "
                            + " email text, "
                            + " address text ); " );
                    db.execSQL("insert into student(mssv,fullname,dateOfBirth,email,address) " +
                               "values (20183851, 'Đỗ Xuân Tùng','8/11/2000','tung.dx183851@hust.edu.vn','Hà Nội');");
                    db.execSQL("insert into student(mssv,fullname,dateOfBirth,email,address) " +
                            "values (20183852, 'Đỗ Xuân Tùng','8/11/2000','tung.dx183851@hust.edu.vn','Hà Nội');");
                    db.execSQL("insert into student(mssv,fullname,dateOfBirth,email,address) " +
                            "values (20183853, 'Đỗ Xuân Tùng','8/11/2000','tung.dx183851@hust.edu.vn','Hà Nội');");
                    db.execSQL("insert into student(mssv,fullname,dateOfBirth,email,address) " +
                            "values (20183854, 'Đỗ Xuân Tùng','8/11/2000','tung.dx183851@hust.edu.vn','Hà Nội');");
                    db.setTransactionSuccessful();
                    Toast.makeText(MainActivity.this,"OK",Toast.LENGTH_LONG).show();
                }catch (Exception ex){
                    ex.printStackTrace();
                }finally {
                    db.endTransaction();
                }
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ActivityAddStudent.class);
                startActivity(intent);
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list = getAllStudent();
                Intent intent = new Intent(MainActivity.this, ActivityShowListStudent.class);
                intent.putExtra("listStudent",(Serializable)list);
                startActivity(intent);
            }
        });


    }
    private static List<Student> getAllStudent(){
        List<Student> studentList = new ArrayList<>();
        String query = "SELECT * FROM student"  ;

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            Student student = new Student(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4));
            studentList.add(student);
            cursor.moveToNext();
        }
        return  studentList;
    }
}