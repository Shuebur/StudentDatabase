package com.example.studentdb.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.studentdb.model.Student;

import java.util.ArrayList;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="Student.db";
    private static final int VERSION_NUMBER=6;
    private Context context;
    private SQLiteDatabase db;

    public MyDatabaseHelper( Context context) {
        super(context,DATABASE_NAME, null, VERSION_NUMBER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

db.execSQL("CREATE TABLE tbl_student(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,mobile TEXT,course TEXT, total_fee INTEGER,fee_paid INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS tbl_student");
onCreate(db);

    }

    public long addstudent(Student student) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues =new ContentValues();
       contentValues.put("name",student.getName());
        contentValues.put("mobile",student.getMobile());
        contentValues.put("total_fee",student.getTotalfee());
        contentValues.put("course",student.getCourse());
        contentValues.put("fee_paid",student.getFeepaid());


   long result =   db.insert("tbl_student",null,contentValues);

        return result;
    }
    public ArrayList<Student> getAllStudents(){

        ArrayList<Student> students = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
      Cursor cursor= db.rawQuery("SELECT * from tbl_student",null);
      if (cursor.moveToFirst()){


          do {

int id = cursor.getInt(0);
String name = cursor.getString(1);
String mobile = cursor.getString(2);
String course = cursor.getString(3);
int tf = cursor.getInt(4);
              int fp =cursor.getInt(5);

              Student student=new Student(id, name, course, mobile, tf, fp);
              students.add(student);

          } while (cursor.moveToNext());


      }
        return students;





    }
}
