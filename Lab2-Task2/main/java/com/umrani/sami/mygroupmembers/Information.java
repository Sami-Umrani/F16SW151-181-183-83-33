package com.umrani.sami.mygroupmembers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Information extends AppCompatActivity {
    ImageView imageView;
    TextView t1,t2,t3,t4;
    String arr[][]={{"Sami","F16SW151","A.sami.umrani@gmail.com","30-05-1998"},{"Safder","F16SW83","safderameertalpur@gmail.com","02-05-1999"},{"Rashid","F16SW185","RashidMajeed294@gmail.com","28-12-1997"},{"Muqadas","F16SW183","Muqadasbaloch54@gmail.com","05-07-1998"},{"Shabana","F16SW33","Shabanatanwar@gmail.com","11-07-1998"}};
    int i=0, j=0;

    ImageView image[]=new ImageView[6];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        imageView = findViewById(R.id.i_imageView);
        t1=findViewById(R.id.t_name);
        t2=findViewById(R.id.t_rollno);
        t3=findViewById(R.id.t_email);
        t4=findViewById(R.id.t_dob);
        imageView.setImageResource(R.drawable.sami);
        t1.setText(arr[i][j]);
        t2.setText(arr[i][j + 1]);
        t3.setText(arr[i][j + 2]);
        t4.setText(arr[i][j + 3]);
    }

    public void nextButtonClick(View v)

    {
        if(i>=0&&i<4) {
            i++;
            checkImages();
            t1.setText(arr[i][j]);
            t2.setText(arr[i][j + 1]);
            t3.setText(arr[i][j + 2]);
            t4.setText(arr[i][j + 3]);
        }
        else
            Toast.makeText(getApplicationContext(),"Last Member!",Toast.LENGTH_SHORT).show();
    }
    public void previousButtonClick(View v)

    {
        if(i>0&&i<5) {
            i--;
            checkImages();
            t1.setText(arr[i][j]);
            t2.setText(arr[i][j + 1]);
            t3.setText(arr[i][j + 2]);
            t4.setText(arr[i][j + 3]);
        }
        else
            Toast.makeText(getApplicationContext(),"First Member!",Toast.LENGTH_SHORT).show();

    }
    public void checkImages()
    {

        if(i==0)
        {
            imageView.setImageResource(R.drawable.sami);
        }
        else if(i==1)
        {
            imageView.setImageResource(R.drawable.safder);
        }
        else if(i==2)
        {
            imageView.setImageResource(R.drawable.rashid);
        }
        else if(i==3)
        {
            imageView.setImageResource(R.drawable.mukri);
        }
        else if(i==4)
        {
            imageView.setImageResource(R.drawable.ess);
        }
    }
}