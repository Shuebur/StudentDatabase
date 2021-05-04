package com.example.studentdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.studentdb.Adapter.StudentAapter;
import com.example.studentdb.db.MyDatabaseHelper;
import com.example.studentdb.model.Student;

import java.util.ArrayList;


public class StudentList extends AppCompatActivity {
    TextView tvTotal;
RecyclerView recyclerView;
StudentAapter studentAapter;

ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        tvTotal = findViewById(R.id.tvTotal);
        recyclerView = findViewById(R.id.recyclerView);


        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);

        students = myDatabaseHelper.getAllStudents();
     tvTotal.setText("Total Students :"  + students.size());
     studentAapter = new StudentAapter(students,this);
recyclerView.setAdapter(studentAapter);


        LinearLayoutManager llm = new LinearLayoutManager(this);
       llm.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(llm);

        }



    }
