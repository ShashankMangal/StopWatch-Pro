package com.sharkBytesLab.stopwatchPro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class StopWatch extends AppCompatActivity {
    Button btnstart,btnstop,btnreset,btnpause;
    ImageView icanchor, menu;
    Animation roundingalone;
    Chronometer timerHere;
    TextView lap;
    boolean running=false;
    long time;

    boolean doubleBackToExitPressedOnce = false;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        btnstart = findViewById(R.id.btnstart);
        btnreset=findViewById(R.id.btnreset);
        btnpause=findViewById(R.id.btnpause);
        btnstop = findViewById(R.id.btnstop);
        icanchor = findViewById(R.id.icanchor);
        timerHere =findViewById(R.id.timerHere);
        menu =findViewById(R.id.stopwatch_menu);


        //create optional animation
        btnstop.setAlpha(0);
        btnreset.setAlpha(0);
        btnpause.setAlpha(0);

        //load animation
        roundingalone = AnimationUtils.loadAnimation(this,R.anim.roundingalone);



        //customize font

        btnstart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                //passing animation
                icanchor.startAnimation(roundingalone);
                btnstop.animate().alpha(1).setDuration(300).start();
                btnstart.animate().alpha(1).setDuration(300).start();
                btnreset.animate().alpha(1).setDuration(300).start();
                btnpause.animate().alpha(1).setDuration(300).start();
                if(!running){
                //start timer
                    timerHere.setBase(SystemClock.elapsedRealtime()-time);
                timerHere.start();
                running =true;
            }}
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StopWatch.this, MenuActivity.class));
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {   icanchor.clearAnimation();
                timerHere.stop();

            }
        });

        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(running){
                icanchor.clearAnimation();
                timerHere.stop();
                time=SystemClock.elapsedRealtime()-timerHere.getBase();
                running=false;


            }

            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerHere.setBase(SystemClock.elapsedRealtime());
                time=0;
                }
            }
        );




    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "BACK again to exit", Toast.LENGTH_SHORT).show();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

}