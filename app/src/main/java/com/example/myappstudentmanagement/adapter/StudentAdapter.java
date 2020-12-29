package com.example.myappstudentmanagement.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myappstudentmanagement.ActivityShowDetailStudentInfo;
import com.example.myappstudentmanagement.R;
import com.example.myappstudentmanagement.model.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.viewHolder> {
    Context context;
    List<Student> list;

    public StudentAdapter(Context context, List<Student> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater =LayoutInflater.from(context);
        View view =layoutInflater.inflate(R.layout.student_view, parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Student student = list.get(position);
        holder.mssv.setText("Mã số sinh viên: " + student.getMssv() );
        holder.fullname.setText("Họ tên: "+ student.getFullname());
        holder.email.setText("Email: " + student.getEmail());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityShowDetailStudentInfo.class);
                intent.putExtra("student",student);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView mssv, fullname,email;
        LinearLayout linearLayout;
        CheckBox check;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            mssv = itemView.findViewById(R.id.mssv);
            fullname = itemView.findViewById(R.id.fullName);
            email = itemView.findViewById(R.id.email);
            check = itemView.findViewById(R.id.check);
            linearLayout = itemView.findViewById(R.id.layout_student);
        }
    }
}
