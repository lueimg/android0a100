package com.tutorial.myapplication2.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by luismori on 27/06/14.
 */
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Log.d("Application", "onCreate");

        String varString = getIntent().getStringExtra("valorTest");
        Log.d("Variable desde segunda clase", varString);

    }

}
