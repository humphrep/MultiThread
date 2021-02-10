package com.example.multithread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.lang.ref.WeakReference;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void countByOdds(View view){
       CountByOdds count = new CountByOdds(this);
       Thread newThread = new Thread(count);
       newThread.start();
    }

    public void countByEvens(View view) {
        CountByEvens count = new CountByEvens(this);
        Thread newThread = new Thread(count);
        newThread.start();

    }

}