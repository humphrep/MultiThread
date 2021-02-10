package com.example.multithread;

import android.app.Activity;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class CountByEvens implements Runnable {


    private final WeakReference<Activity> mainActivity;

    public CountByEvens(Activity mainActivity) {
        this.mainActivity = new WeakReference<Activity>(mainActivity);
    }

    @Override
    public void run() {
        for (int i = 2; i <= 100; i += 2) {
            System.out.println(i);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.mainActivity.get().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if (!mainActivity.equals(null)) {
                    //Toast the Success!!
                    Toast.makeText(mainActivity.get(), "Counting by Evens is finished", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    
}
