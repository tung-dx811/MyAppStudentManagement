package com.example.sqliteexamples;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class StudentAdapter extends BaseAdapter {

    Cursor cs;

    public StudentAdapter(SQLiteDatabase db) {
        cs = db.rawQuery("select * from sinhvien", null);
    }

    @Override
    public int getCount() {
        return cs.getCount();
    }

    @Override
    public Object getItem(int i) {
        cs.moveToPosition(i);
        return cs;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item, viewGroup, false);
        }

        TextView textMSSV = view.findViewById(R.id.text_mssv);
        TextView textHoten = view.findViewById(R.id.text_hoten);
        TextView textEmail = view.findViewById(R.id.text_email);

        cs.moveToPosition(i);

        textMSSV.setText(cs.getString(cs.getColumnIndex("mssv")));
        textHoten.setText(cs.getString(cs.getColumnIndex("hoten")));
        textEmail.setText(cs.getString(cs.getColumnIndex("email")));

        return view;
    }


}
