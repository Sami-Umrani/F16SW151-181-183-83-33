package com.umrani.sami.messageapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    EditText textField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textField = findViewById(R.id.textField);
    }

    public void buttonSubmit(View view) {

        Intent returnIntent = new Intent();
        returnIntent.putExtra("Message", textField.getText().toString());
        setResult(RESULT_OK,returnIntent);
        finish();
    }
}
