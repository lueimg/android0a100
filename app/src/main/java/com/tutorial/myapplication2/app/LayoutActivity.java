package com.tutorial.myapplication2.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by luismori on 27/06/14.
 */
public class LayoutActivity extends Activity {


    private EditText username;
    private EditText password;
    private Button submit;

    @Override
    public void onCreate( Bundle savedInstance ){
        super.onCreate(savedInstance);
        setContentView(R.layout.table_layout);

        username = (EditText)findViewById(R.id.editUsername);
        password = (EditText)findViewById(R.id.editPass);

        submit = (Button)findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( username.getText().toString().equals("admin") ||
                     password.getText().toString().equals("admin")   ){
                    finish();
                }else{
                    Log.d("Login","wrond username/password");
                    Toast.makeText(getApplicationContext(),"wrond username/password",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
