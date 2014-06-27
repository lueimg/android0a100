package com.tutorial.myapplication2.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;



/**
 * Created by luismori on 27/06/14.
 */
public class DialogActivity extends Activity {

    final CharSequence[] items = {"blue","red","yellow"};


    private ProgressDialog barProgressDialog;
    private Handler updateBarHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //showDialog();
        //showDialogWithList();

       // showDialogWithCheckbox();

        //showRingDialog();

        showBarDialog();

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

    private void showDialogWithList(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Pick a color");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),items[i],Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();


    }

    private void showDialogWithCheckbox(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Pick a color");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), items[i], Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();


    }


    private void showRingDialog(){
        final ProgressDialog ringProgressDialog = ProgressDialog.show(DialogActivity.this,"Espere","Descargando...",true);
        ringProgressDialog.setCancelable(true);

        new Thread( new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                ringProgressDialog.dismiss();
            }
        }).start();


    }

    private void showBarDialog() {

        barProgressDialog = new ProgressDialog(DialogActivity.this);

        barProgressDialog.setTitle("Espere...");
        barProgressDialog.setMessage("Descargando...");
        barProgressDialog.setProgressStyle(barProgressDialog.STYLE_HORIZONTAL);
        barProgressDialog.setProgress(0);
        barProgressDialog.setMax(20);
        barProgressDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while ( barProgressDialog.getProgress() <= barProgressDialog.getMax()) {

                        Thread.sleep(2000);
                        updateBarHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                barProgressDialog.incrementProgressBy(2);
                            }
                        });
                        if (barProgressDialog.getProgress() == barProgressDialog.getMax()) {
                            barProgressDialog.dismiss();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }).start();
    }


}
