package com.example.areejdarweesh.projectone;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Start extends AppCompatActivity {

    ImageView startt;
    TextView start1;
    Animation animation,animation1;
   // private SlidrInterface slidr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        startt=findViewById(R.id.imageView2);
        start1=findViewById(R.id.starttt);
       /* animation = AnimationUtils.loadAnimation(this,R.anim.bink);
        start1.setAnimation(animation);
        animation.start();*/
        animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        startt.setAnimation(animation1);
        animation1.start();

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        startsplash();
    }

    private void startsplash()
    {
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Start.this,MainActivity.class);
                startActivity(intent);
            }
        },600);

    }
}
