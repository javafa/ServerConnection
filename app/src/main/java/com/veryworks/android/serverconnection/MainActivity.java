package com.veryworks.android.serverconnection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.androidannotations.annotations.EActivity;


@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    public void goWrite(View view){
        Intent intent = new Intent(this, WriteActivity.class);
        startActivity(intent);
    }
}
