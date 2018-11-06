package com.umrani.sami.samiloginsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    EditText et_username, et_email, et_password, et_dob;
    RadioButton rb1, rb2;
    Button b;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        et_username=findViewById(R.id.t_username);
        et_email=findViewById(R.id.t_email);
        et_password=findViewById(R.id.p_password);
        et_dob=findViewById(R.id.d_dob);
        rb1=findViewById(R.id.rb_male);
        rb2=findViewById(R.id.rb_female);
        b = findViewById(R.id.b_signup);
    }
    public void signUpButtonClick(View v)
    {
        if(rb1.isChecked())
            gender = "Male";


        if(rb2.isChecked())
            gender = "Female";

        Intent in = new Intent(SignUp.this,LogIn.class);
        in.putExtra("username",et_username.getText().toString());
        in.putExtra("email",et_email.getText().toString());
        in.putExtra("password",et_password.getText().toString());
        in.putExtra("dob",et_dob.getText().toString());
        in.putExtra("gender",gender);
        Toast.makeText(getApplicationContext(),et_username.getText().toString()+"'s Account Created Sucessfully!",Toast.LENGTH_SHORT).show();

        startActivity(in);
    }
}
