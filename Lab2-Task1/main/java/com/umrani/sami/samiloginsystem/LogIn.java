package com.umrani.sami.samiloginsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {
    EditText et1, et2;
    String username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        et1=findViewById(R.id.t_myusername);
        et2=findViewById(R.id.p_mypassword);
        Intent in1 = getIntent();
        username = in1.getStringExtra("username");
        password = in1.getStringExtra("password");

    }
    public void loginButtonClick(View v)
    {

        if(username.equalsIgnoreCase(et1.getText().toString()) ) {
            if (password.equals(et2.getText().toString())) {
                Intent in1 = getIntent();
                Intent intent = new Intent(LogIn.this, Info.class);
                intent.putExtra("username", in1.getStringExtra("username"));
                intent.putExtra("email", in1.getStringExtra("email"));
                intent.putExtra("dob", in1.getStringExtra("dob"));
                intent.putExtra("gender", in1.getStringExtra("gender"));
                startActivity(intent);
            }
            else
                Toast.makeText(getApplicationContext(),"Invalid Password!",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(),"Invalid Username!",Toast.LENGTH_SHORT).show();


    }
}
