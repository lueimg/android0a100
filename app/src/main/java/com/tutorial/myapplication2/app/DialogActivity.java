package com.tutorial.myapplication2.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by luismori on 27/06/14.
 */
public class DialogActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showDialog();

    }

    private void showDialog(){
        new AlertDialog.Builder(this)
                .setTitle("Title")
                .setMessage("Cerrar Aplicacion ?")
                .setPositiveButton(android.R.string.yes , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Seguimos en la aplicacion",Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }



}
