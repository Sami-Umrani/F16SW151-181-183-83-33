package com.umrani.sami.samiloginsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Info extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        t1=findViewById(R.id.l_username);
        t2=findViewById(R.id.l_email);
        t3=findViewById(R.id.l_dob);
        t4=findViewById(R.id.l_gender);
        imageView = findViewById(R.id.i_imageView);
        Intent in2 = getIntent();
        t1.setText(in2.getStringExtra("username"));
        t2.setText(in2.getStringExtra("email"));
        t3.setText(in2.getStringExtra("dob"));
        t4.setText(in2.getStringExtra("gender"));

    }
    public void changeImageButtonClick(View v)
    {
        imageView.setImageResource(R.drawable.sami);
    }
}
