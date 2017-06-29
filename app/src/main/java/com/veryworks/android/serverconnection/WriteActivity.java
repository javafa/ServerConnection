package com.veryworks.android.serverconnection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

public class WriteActivity extends AppCompatActivity {
    EditText editTitle;
    EditText editAuthor;
    EditText editContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
    }

    public void onClick(){
        Toast.makeText(this, "불렀나요?",Toast.LENGTH_SHORT).show();
    }
}