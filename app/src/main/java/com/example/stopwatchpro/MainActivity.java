package com.example.stopwatchpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
public class MainActivity extends AppCompatActivity {
    TextView tvSplash,tvSubSplash;
    Button btnget;
    ImageView ivSplash;
    Animation atg,btgone,btgtwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSplash =findViewById(R.id.tvSplash);
        tvSubSplash =findViewById(R.id.tvSubSplash);
        btnget= findViewById(R.id.btnget);
        ivSplash= findViewById(R.id.ivSplash);

        //load animation
        btgone = AnimationUtils.loadAnimation(this,R.anim.btgone);
        btgtwo = AnimationUtils.loadAnimation(this,R.anim.btgtwo);
        atg = AnimationUtils.loadAnimation(this,R.anim.atg);

        //passing animation
        ivSplash.startAnimation(atg);
        tvSplash.startAnimation(btgone);
        tvSubSplash.startAnimation(btgone);
        btnget.startAnimation(btgtwo);

        //passing event
        btnget.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent a = new Intent(MainActivity.this,StopWatch.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

    }
}