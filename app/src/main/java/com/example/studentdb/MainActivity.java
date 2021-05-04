package com.example.studentdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private int Progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.Pro);
        Thread thread= new Thread(new  Runnable() {
            @Override
            public void run() {
                dowork();
                start();
            }
        });
        thread.start();
    }
    public void dowork(){
        for(Progress=20;Progress<=100;Progress=Progress+20){


            try {
                Thread.sleep(1000);
                progressBar.setProgress(Progress);
            }
            catch (InterruptedException e){

                e.printStackTrace();}}}

    public void start(){

        Intent intent=new Intent(MainActivity.this,AddStudentActivity.class);
        startActivity(intent);
        finish();




    }

}