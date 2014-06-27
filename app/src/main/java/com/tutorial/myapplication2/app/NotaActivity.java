package com.tutorial.myapplication2.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;

/**
 * Created by luismori on 27/06/14.
 */
public class NotaActivity extends Activity {


    private Button notesButton;
    private LinearLayout linearLayout;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_notas);
        linearLayout = (LinearLayout) findViewById(R.id.layoutNotes);
        notesButton = (Button) findViewById(R.id.buttonCreate);
        readAndDisplayNotes();
        notesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SaveNoteActivity.class);
                startActivity(i);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Nota Activity","resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Nota Activity","restart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Nota Activity","pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Nota Activity","destroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Nota Activity","start");
    }

    private void readAndDisplayNotes() {
        File dirFiles = getFilesDir();
        for (String strFile : dirFiles.list()) {
            TextView mTextView = new TextView(this);
            mTextView.setText(strFile);
            mTextView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));

            linearLayout.addView(mTextView);
        }
    }

}
