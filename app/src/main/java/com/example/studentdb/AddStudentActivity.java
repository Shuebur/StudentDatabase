package com.example.studentdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentdb.db.MyDatabaseHelper;
import com.example.studentdb.model.Student;

public class AddStudentActivity extends AppCompatActivity {
EditText edname,edmobile,edtotal,edcourse,edpaid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        edname = findViewById(R.id.edName);
        edmobile = findViewById(R.id.edMobile);
        edtotal = findViewById(R.id.edTotalFee);
        edcourse = findViewById(R.id.edCourse);
        edpaid = findViewById(R.id.edFeePaid);
    }


    public void save(View view) {

String name =edname.getText().toString().trim();
        String course =edcourse.getText().toString().trim();
        String mobile =edmobile.getText().toString().trim();
        String total =edtotal.getText().toString().trim();

        String paid=edpaid.getText().toString().trim();

        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(AddStudentActivity.this);

        int id = 0;
        Student student= new Student(id, name,course,mobile,Integer.parseInt(total), Integer.parseInt(paid));

long result = myDatabaseHelper.addstudent(student);
if (result >0){
    Toast.makeText(this,"SAved," + result,Toast.LENGTH_SHORT).show();


}else {
    Toast.makeText(this,"Failed," + result,Toast.LENGTH_SHORT).show();


}
    }

    public void Show(View view) {
        startActivity(new Intent(AddStudentActivity.this,StudentList.class));

    }
}