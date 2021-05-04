package com.example.studentdb.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentdb.R;
import com.example.studentdb.model.Student;

import java.util.ArrayList;

public class StudentAapter extends RecyclerView.Adapter<StudentAapter.StudentViewHolder>{

    ArrayList<Student> students;
    Context context;

    public StudentAapter(ArrayList<Student> students, Context context) {
        this.students = students;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_student, parent, false);
        StudentViewHolder studentViewHolder =new StudentViewHolder(view);


        return studentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
Student s = students.get(position);
holder.tvName.setText(s.getName());
        holder.tvCourse.setText(s.getCourse());
        holder.tvMobile.setText(s.getMobile());
        holder.tvTotal.setText(String.valueOf(s.getTotalfee()));
        holder.tvPaid.setText(String.valueOf(s.getFeepaid()));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvCourse, tvMobile, tvTotal, tvPaid;
        CardView cardUpdate, cardDelete;

        public StudentViewHolder(@NonNull View v) {
            super(v);
            tvName = v.findViewById(R.id.tv_name);
            tvCourse = v.findViewById(R.id.tv_course);
            tvMobile = v.findViewById(R.id.tv_Mobile);
            tvTotal = v.findViewById(R.id.tv_Total);
            tvPaid = v.findViewById(R.id.tv_Paid);

            cardDelete = v.findViewById(R.id.card_delete);
            cardUpdate = v.findViewById(R.id.card_update);
        }
    }
}
