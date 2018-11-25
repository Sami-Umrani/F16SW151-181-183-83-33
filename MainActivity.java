package com.umrani.sami.task02application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText textField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textField = findViewById(R.id.textField);
    }
    public void buttonCameraClick(View view)
    {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(i);
    }
    public void buttonGalaryClick(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("content://media/external/images/media/"));
        startActivity(i);
    }
    public void buttonCallLogClick(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("content://call_log/calls/1"));
        startActivity(i);
    }
    public void buttonBrowserClick(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://"+textField.getText().toString()+"/"));
        startActivity(i);

    }
    public void buttonContactsClick(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("content://contacts/people/"));
        startActivity(i);
    }
    public void buttonCallClick(View view)
    {
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:"+textField.getText().toString()));
        startActivity(i);
    }
    public void buttonDialPad(View view)
    {
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:"+textField.getText().toString()));
        startActivity(i);
    }

}
