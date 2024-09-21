package com.example.areejdarweesh.projectone.graph;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by moten on 7/4/2019.
 */

public class MyGLSurfaceViewMaster extends GLSurfaceView {

    boolean is3D = false;
    float y[];

     MyGLRenderer3d renderer;



    public MyGLSurfaceViewMaster(Context context) {
        super(context);

    }

    public void sety(float a[])
    {
        y=new float[a.length];
        System.arraycopy(a, 0, y, 0, a.length);
    }


    public void rebuild(boolean is3d){
        this.is3D = is3d;
        build();
    }

    public void build(){
        if (is3D){
            run3d();
        }else {
            run2d();
        }
    }



    float w,h;
    int screenW,screenH;

    FloatBuffer vertexBuffer;
    FloatBuffer xBuffer,yBuffer;
    private void run2d(){

        setEGLConfigChooser(8, 8, 8, 8, 0, 0);
        setRenderer(new MyRenderer());

        float x_axis[]={5,0,0,  -5,0,0};
        float y_axis[]={0,5,0,  0,-5,0};
        float verticesx[]=new float[4*200];
        float b=-2;
        for(int i=0;i<4*200;i++)
        {
            verticesx[i]=b;
            b+=0.005;
        }

        //x2+3x-3=y;
        //float verticesy[]=new float[4*200];
        float verticesz[]=new float[4*200];
        for(int i=0;i<4*200;i++)
        {
            verticesz[i]=0;

        }

        float v[]=new float[verticesx.length*3];
        int j=0;
        for(int i=0;i<4*200*3;i+=3)
        {

            v[i]=verticesx[j];
            v[i+1]=-y[j];
            v[i+2]=verticesz[j];
            j++;

        }
        ByteBuffer vbb = ByteBuffer.allocateDirect(v.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(v);
        vertexBuffer.position(0);


        ByteBuffer x_ax = ByteBuffer.allocateDirect(x_axis.length * 4);
        x_ax.order(ByteOrder.nativeOrder());
        xBuffer = x_ax.asFloatBuffer();
        xBuffer.put(x_axis);
        xBuffer.position(0);

        ByteBuffer y_ax = ByteBuffer.allocateDirect(y_axis.length * 4);
        y_ax.order(ByteOrder.nativeOrder());
        yBuffer = y_ax.asFloatBuffer();
        yBuffer.put(y_axis);
        yBuffer.position(0);


    }


    private void run3d(){
        setEGLContextClientVersion(2);
        renderer = new MyGLRenderer3d();
        renderer.sety(y);
        setRenderer(renderer);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }




    private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
    private float previousX;
    private float previousY;
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if (!is3D)return false;
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.

        float x = e.getX();
        float y = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:

                float dx = x - previousX;
                float dy = y - previousY;

                // reverse direction of rotation above the mid-line
                if (y > getHeight() / 2) {
                    dx = dx * -1 ;
                }

                // reverse direction of rotation to left of the mid-line
                if (x < getWidth() / 2) {
                    dy = dy * -1 ;
                }

                renderer.setAngle(
                        renderer.getAngle() +
                                ((dx + dy) * TOUCH_SCALE_FACTOR));
                requestRender();
        }

        previousX = x;
        previousY = y;
        return true;
    }









    private final class MyRenderer implements Renderer {

        public final void onDrawFrame(GL10 gl) {
            gl.glPushMatrix();
            gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
            gl.glTranslatef(w / 2, h / 2, 0);
            gl.glScalef(120, 100, 0);
            gl.glColor4f(0, 1, 0, 1);
            gl.glVertexPointer(3, GL10.GL_FLOAT, 0, xBuffer);
            gl.glDrawArrays(GL10.GL_LINES, 0, 2);
            gl.glColor4f(1, 0, 0, 0);
            gl.glVertexPointer(3, GL10.GL_FLOAT, 0, yBuffer);
            gl.glDrawArrays(GL10.GL_LINES, 0, 2);
            gl.glColor4f(1, 1, 0, 0);
            gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
            gl.glDrawArrays(GL10.GL_LINE_STRIP, 0, 200*4);///tadel 12*4
            gl.glPopMatrix();
        }


        public final void onSurfaceChanged(GL10 gl, int width, int height) {
            gl.glClearColor(0, 0, 0, 1.0f);
            if(width > height) {
                h = 600;
                w = width * h / height;
            } else {
                w = 600;
                h = height * w / width;
            }
            screenW = width;
            screenH = height;
            gl.glViewport(0, 0, screenW, screenH);
            gl.glMatrixMode(GL10.GL_PROJECTION);
            gl.glLoadIdentity();
            gl.glOrthof(0, w, h, 0, -1, 1);
            gl.glMatrixMode(GL10.GL_MODELVIEW);
            gl.glLoadIdentity();
        }

        public final void onSurfaceCreated(GL10 gl, EGLConfig config) {
            // Set up alpha blending
            gl.glEnable(GL10.GL_ALPHA_TEST);
            gl.glEnable(GL10.GL_BLEND);
            gl.glBlendFunc(GL10.GL_ONE, GL10.GL_ONE_MINUS_SRC_ALPHA);
            // We are in 2D, so no need depth
            gl.glDisable(GL10.GL_DEPTH_TEST);
            // Enable vertex arrays (we'll use them to draw primitives).
            gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        }

    }
}