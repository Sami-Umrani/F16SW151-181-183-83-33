package com.umrani.sami.messageapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_CODE = 1;
    TextView setMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMessage = findViewById(R.id.showMessage);
    }

    public void buttonGetMessage(View view)
    {     Intent messageIntent = new Intent(MainActivity.this, Main2Activity.class);
        startActivityForResult(messageIntent, REQUEST_CODE);
    }

    public void onActivityResult(int requestCode, int resultCode,  Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE)
        {
            if (resultCode == RESULT_OK)
            {
                String reply = data.getStringExtra("Message");
                setMessage.setText(reply);
            }
        }
    }
}
