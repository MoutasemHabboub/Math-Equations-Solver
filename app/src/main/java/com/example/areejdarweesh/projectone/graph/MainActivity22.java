package com.example.areejdarweesh.projectone.graph;

/**
 * Created by moten on 7/3/2019.
 */

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.example.areejdarweesh.projectone.R;

///

public class MainActivity22 extends Activity {
    private GLSurfaceView gLView;
    // AttributeSet attrs=new AttributeSet();
    private MyGLSurfaceViewMaster stage;
    private float y[] ;
    Switch s;
     boolean d2=true;

    LinearLayout linearLayout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mzin2);
        MyGLSurfaceViewMaster myGLSurfaceViewMaster = new MyGLSurfaceViewMaster(this);
//        stage =  findViewById(R.id.my_stage);
        s=findViewById(R.id.sw);
        linearLayout=findViewById(R.id.ll);
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                refrech(b);
                //stage.rebuild(b);
            }
        });
        y=(float[])getIntent().getFloatArrayExtra("float[]");
        // Create a GLSurfaceView instance and set it
        // as the ContentView for this Activity.

        myGLSurfaceViewMaster.sety(y);
        myGLSurfaceViewMaster.rebuild(false);


        linearLayout.addView(myGLSurfaceViewMaster);


//        if(!d2)
//        {
//            gLView = new MyGLSurfaceView(this,y);
//            setContentView(gLView);
//        }
//        else{
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
//            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
//            setContentView(R.layout.mzin2);
//
//            stage =  findViewById(R.id.my_stage);
//            stage.sety(y);
//            stage.rebuild(false);
//        }
    }


    public void refrech(boolean b){
        linearLayout.removeAllViews();
        MyGLSurfaceViewMaster myGLSurfaceViewMaster = new MyGLSurfaceViewMaster(this);
        myGLSurfaceViewMaster.sety(y);
        myGLSurfaceViewMaster.rebuild(b);
        linearLayout.addView(myGLSurfaceViewMaster);
    }



}

