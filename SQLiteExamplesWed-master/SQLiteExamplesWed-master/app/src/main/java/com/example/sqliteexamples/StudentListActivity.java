package com.example.sqliteexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import io.bloco.faker.Faker;

public class StudentListActivity extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        String dataPath = getFilesDir() + "/student_data";
        db = SQLiteDatabase.openDatabase(dataPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);

        // createRandomData();

        ListView listView = findViewById(R.id.list_students);
        StudentAdapter adapter = new StudentAdapter(db);
        listView.setAdapter(adapter);

    }

    private void createRandomData() {
        db.beginTransaction();
        try {
            db.execSQL("create table sinhvien(" +
                    "mssv char(8) primary key," +
                    "hoten text," +
                    "ngaysinh date," +
                    "email text," +
                    "diachi text);");

            Faker faker = new Faker();
            for (int i = 0; i < 50; i++) {
                String mssv = "2017" + faker.number.number(4);
                String hoten = faker.name.name();
                String ngaysinh = faker.date.birthday(18, 22).toString();
                String email = faker.internet.email();
                String diachi = faker.address.city() + ", " + faker.address.country();

                String sql = String.format("insert into sinhvien(mssv, hoten, ngaysinh, email, diachi) " +
                        "values('%s', '%s', '%s', '%s', '%s')", mssv, hoten, ngaysinh, email, diachi);

                db.execSQL(sql);
            }

            db.setTransactionSuccessful();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.endTransaction();
        }

    }

    @Override
    protected void onStop() {
        db.close();
        super.onStop();
    }

}