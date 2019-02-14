package com.umrani.sami.flyingfish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class GameOverActivity extends AppCompatActivity {

    private Button StartGameAgain;
    private TextView DisplayScore;
    private String Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        Score= (getIntent().getExtras().get("Score")).toString();

        StartGameAgain =(Button) findViewById(R.id.Play_Again_btn);

        DisplayScore = (TextView) findViewById(R.id.DisplayScore);

        StartGameAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainIntent = new Intent(GameOverActivity.this, MainActivity.class);
                startActivity(mainIntent);
            }
        });


DisplayScore.setText( "Score = "+ Score);

           

    }
}
