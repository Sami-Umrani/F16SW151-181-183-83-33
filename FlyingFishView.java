package com.umrani.sami.flyingfish;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import org.w3c.dom.Text;

public class FlyingFishView extends View {
    private Bitmap fish[]=new Bitmap[2];
    private int fishx=10;
    private int fishy;
    private int fishspeed;
    private int canvaswidth, canvasheight;
    private int yellowx,yellowy,yellowspeed=16;
    private  Paint yellowpaint=new Paint();
    private int greenx,greeny,greenspeed=20;
    private Paint greenpaint= new Paint();

    private int redx,redy,redspeed=25;
    private Paint redpaint= new Paint();

    private int Score ,lifecounteroffish;

    private int score;
    private boolean touch=false;
    private Bitmap backgroundImage;
    private Paint scorePaint=new Paint();
    private Bitmap life[]=new Bitmap[2];

    public FlyingFishView(Context context) {
        super(context);
        fish[0]=BitmapFactory.decodeResource(getResources(), R.drawable.fish1);
        fish[1]=BitmapFactory.decodeResource(getResources(), R.drawable.fish2);
        backgroundImage= BitmapFactory.decodeResource(getResources(),R.drawable.background);
        yellowpaint.setColor(Color.YELLOW);
        yellowpaint.setAntiAlias(false);
        greenpaint.setColor(Color.GREEN);
        greenpaint.setAntiAlias(false);

        redpaint.setColor(Color.RED);
        redpaint.setAntiAlias(false);


        scorePaint.setColor(Color.BLACK);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        life[0]= BitmapFactory.decodeResource(getResources(), R.drawable.hearts);
        life[1]= BitmapFactory.decodeResource(getResources(),R.drawable.heart_grey);
        fishy=550;
        score=0;
        lifecounteroffish=3;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvaswidth= canvas.getWidth();
        canvasheight= canvas.getHeight();
        canvas.drawBitmap(backgroundImage,0,0,null);
        int minFishy=fish[0].getHeight();
        int maxFishy= canvasheight-fish[0].getHeight() * 3;
        fishy=fishy+fishspeed;
        if (fishy<minFishy){
            fishy=minFishy;
        }
        if (fishy>maxFishy){
            fishy=maxFishy;
        }
        fishspeed=fishspeed+2;

        if (touch){
             canvas.drawBitmap(fish[1], fishx, fishy,null);
             touch=false;
        }
        else{
            canvas.drawBitmap(fish[0],fishx,fishy,null);
        }


        yellowx=yellowx-yellowspeed;

        if (hitBallChecker(yellowx,yellowy)){

            score=score+10;
            yellowx= -100;
        }

        if (yellowx<0){
            yellowx=canvaswidth+21;
            yellowy=(int) Math.floor(Math.random()*(maxFishy-minFishy))+minFishy;
        }
           canvas.drawCircle(yellowx,yellowy,30,yellowpaint);

        greenx=greenx-greenspeed;

        if (hitBallChecker(greenx,greeny)){

            score=score+30;
            greenx= -100;
        }





        if (greenx<0){
            greenx=canvaswidth+21;
            greeny=(int) Math.floor(Math.random()*(maxFishy-minFishy))+minFishy;
        }
        canvas.drawCircle(greenx,greeny,30,greenpaint);

        redx=redx-redspeed;

        if (hitBallChecker(redx,redy)){

            score=score+30;
            redx= -100;
            lifecounteroffish--;

            if (lifecounteroffish==0){

                Toast.makeText(getContext(), "Game Over", Toast.LENGTH_SHORT).show();

                Intent GameOverIntent= new Intent(getContext(),GameOverActivity.class);

                GameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                GameOverIntent.putExtra("Score",Score);

                getContext().startActivity(GameOverIntent);
            }
        }

        if (redx<0){
            redx=canvaswidth+21;
            redy=(int) Math.floor(Math.random()*(maxFishy-minFishy))+minFishy;
        }
        canvas.drawCircle(redx,redy,35,redpaint);

        canvas.drawText("Score: "+ score,20, 60, scorePaint);

        for (int i=0; i<3; i++){

            int X= (int) (580+life[0].getWidth()*1.5*i);

            int y=30;
            if (i<lifecounteroffish)
            {
                canvas.drawBitmap(life[0], X, y, null);

            }

            else{

                canvas.drawBitmap(life[1], X, y, null);
            }
        }



    }
         public boolean hitBallChecker(int x, int y){

              if (fishx < x && x < (fishx + fish[0].getWidth()) && fishy < y && y < (fishy + fish[0].getHeight())){

                  return true;
              }

              return false;
         }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN){
            touch=true;
            fishspeed=-22;
        }
        return true;
    }
}
