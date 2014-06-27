package com.tutorial.myapplication2.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by luismori on 27/06/14.
 */
public class SaveNoteActivity extends Activity {

    private EditText editText;
    private Button saveNote;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_note);
        saveNote = (Button) findViewById(R.id.saveNote);
        editText = (EditText) findViewById(R.id.editText);

        saveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long unixTime = System.currentTimeMillis() / 1000L;
                String nameFile = String.valueOf(unixTime);
                saveIntoFile(nameFile);
            }
        });
    }

    private void saveIntoFile( String namefile) {
        try {
            FileOutputStream outputStream = openFileOutput(namefile, Context.MODE_PRIVATE);
            outputStream.write(editText.getText().toString().getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("save note  Activity", "start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("save note  Activity", "resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("save note  Activity", "restart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("save note  Activity", "pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("save note  Activity", "destroy");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d("save note  Activity", "stop");
    }
}




