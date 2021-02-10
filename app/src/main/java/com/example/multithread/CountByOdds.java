package com.example.multithread;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class CountByOdds implements Runnable {
    private final WeakReference<Activity> mainActivity;

    public CountByOdds(Activity mainActivity) {
        this.mainActivity = new WeakReference<Activity>(mainActivity);
    }

    @Override
    public void run() {

        for (int i = 1; i <= 100; i+=2) {
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
                //Toast the Success!!
                if (!mainActivity.equals(null)) {
                    Toast.makeText(mainActivity.get(), "Counting by Odds is finished", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
