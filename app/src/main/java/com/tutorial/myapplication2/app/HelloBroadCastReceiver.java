package com.tutorial.myapplication2.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by luismori on 27/06/14.
 */
public class HelloBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Usando bradcast receiver","Power is connected");
    }
}
