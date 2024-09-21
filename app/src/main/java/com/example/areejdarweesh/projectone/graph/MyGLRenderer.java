package com.example.areejdarweesh.projectone.graph;

/**
 * Created by moten on 7/3/2019.
 */

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;

import javax.microedition.khronos.opengles.GL10;

public class MyGLRenderer implements GLSurfaceView.Renderer {

    private Line xLine,yLine,zLine,vLine,rLine,r1Line,r2Line,r3Line,r4Line,r5Line,r6Line,r7Line,r8Line,r9Line,r10Line;
    private float[] rotationMatrix = new float[16];
    public volatile float mAngle;


    // vPMatrix is an abbreviation for "Model View Projection Matrix"
    private final float[] vPMatrix = new float[16];
    private final float[] projectionMatrix = new float[16];
    private final float[] viewMatrix = new float[16];

    ///**///

    private int beginx = -2, endx = 2;
    private int mjal = endx-beginx;//4
    private int smallmajal = 200;//عدد المجالات
    private int rownum=4;

    ///**///
    private float verticesy[] ;


    public void sety(float a[])
    {
        verticesy=new float[a.length];
        System.arraycopy(a, 0, verticesy, 0, a.length);
    }


    @Override
    public void onSurfaceCreated(GL10 gl10, javax.microedition.khronos.egl.EGLConfig eglConfig) {
        // Set the background frame color
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        float[] x_axis={-2,0,0,2,0,0};
        float y_axis[] = {0, 4, 0, 0, -4, 0};
        float z_axis[] = {0, 0, 2, 0, 0, -2};
        float [] verticesx = new float[mjal * smallmajal];
        float b = -2;
        for (int i = 0; i < verticesx.length; i++) {
            verticesx[i] = b;
            b += 0.005;
        }

//x2+3x-3=y;
        /*float verticesy[] = new float[mjal * smallmajal];
        for (int i = 0; i < mjal * smallmajal; i++) {
            verticesy[i] = 1 * 1;


        }*/
        float verticesz[] = new float[mjal * smallmajal];
        for (int i = 0; i < mjal * smallmajal; i++) {

            verticesz[i] = 0;


        }


        float v[] = new float[verticesx.length * 3];
        int j = 0;
        for (int i = 0; i < mjal * smallmajal * 3; i += 3) {

            v[i] = verticesx[j];
            v[i + 1] = verticesy[j];
            v[i + 2] = verticesz[j];
            j++;

        }

        float[] repeat1 = morelines(v, 2.5f);
        float[] repeat2 = morelines(v, 2f);
        float[] repeat3 = morelines(v, 1.5f);
        float[] repeat4 = morelines(v, 1f);
        float[] repeat5 = morelines(v, 0.5f);
        float[] repeat6 = morelines(v, -0.5f);
        float[] repeat7 = morelines(v, -1f);
        float[] repeat8 = morelines(v, -1.5f);
        float[] repeat9 = morelines(v, -2f);
        float[] repeat10 = morelines(v, -2.5f);

        float[] row=new float[(mjal*rownum*3*3)];//3عددد نقاط رسم روحة ورجعة و 3 كمان لانة اكس وواي وزد


        int k=0;
        for(int i=0;i<row.length;i+=9){
            row[i]=repeat1[k];
            row[i+1]=repeat1[k+1];
            row[i+2]=repeat1[k+2];
            row[i+3]=repeat10[k];
            row[i+4]=repeat10[k+1];
            row[i+5]=repeat10[k+2];
            row[i+6]=repeat1[k];
            row[i+7]=repeat1[k+1];
            row[i+8]=repeat1[k+2];
            k+=((smallmajal*3)/rownum);
        }
        /////
        xLine = new Line(x_axis);
        yLine =new Line(y_axis);
        zLine= new Line(z_axis);
        vLine =new Line(v);
        rLine =new Line(row);
        r1Line =new Line(repeat1);
        r2Line =new Line(repeat2);
        r3Line =new Line(repeat3);
        r4Line =new Line(repeat4);
        r5Line =new Line(repeat5);
        r6Line =new Line(repeat6);
        r7Line =new Line(repeat7);
        r8Line =new Line(repeat8);
        r9Line =new Line(repeat9);
        r10Line =new Line(repeat10);


    }

    public void onDrawFrame(GL10 unused) {
        float[] scratch = new float[16];

        // Redraw background color
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        // Set the camera position (View matrix)
        Matrix.setLookAtM(viewMatrix, 0, 0, 0, -7, 0f, 0f, 10f, 0f, 1.0f, 0.0f);
        // Calculate the projection and view transformation
        Matrix.multiplyMM(vPMatrix, 0, projectionMatrix, 0, viewMatrix, 0);
        // Create a rotation for the triangle
        Matrix.setRotateM(rotationMatrix, 0, mAngle, -0.01f, -0.01f, -0.01f);
        // Combine the rotation matrix with the projection and camera view
        // Note that the vPMatrix factor *must be first* in order
        // for the matrix multiplication product to be correct.
        Matrix.multiplyMM(scratch, 0, vPMatrix, 0, rotationMatrix, 0);
        // Draw triangle
        // mTriangle.draw(scratch);
        float color[] = { 1f, 1f, 1f, 1.0f };
        float color2[] = { 1f, 0f, 0f, 0.0f };
        float color3[] = { 0f, 1f, 0f, 0.0f };
        float color4[] = { 0f, 0f, 1f, 0.0f };

        xLine.draw(scratch,color2);
        yLine.draw(scratch,color3);
        zLine.draw(scratch,color4);
        vLine.draw(scratch,color);
        rLine.draw(scratch,color);
        r1Line.draw(scratch,color);
        r2Line.draw(scratch,color);
        r3Line.draw(scratch,color);
        r4Line.draw(scratch,color);
        r5Line.draw(scratch,color);
        r6Line.draw(scratch,color);
        r7Line.draw(scratch,color);
        r8Line.draw(scratch,color);
        r9Line.draw(scratch,color);
        r10Line.draw(scratch,color);






    }

    public void onSurfaceChanged(GL10 unused, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
        float ratio = (float) width / height;
        // this projection matrix is applied to object coordinates
        // in the onDrawFrame() method
        Matrix.frustumM(projectionMatrix, 0, -ratio, ratio, -1, 1, 2, 8);

    }

    public static int loadShader(int type, String shaderCode){

        // create a vertex shader type (GLES20.GL_VERTEX_SHADER)
        // or a fragment shader type (GLES20.GL_FRAGMENT_SHADER)
        int shader = GLES20.glCreateShader(type);

        // add the source code to the shader and compile it
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);

        return shader;
    }

    public float getAngle() {
        return mAngle;
    }

    public void setAngle(float angle) {
        mAngle = angle;
    }


    public float[] morelines(float x[], float z) {
        float luli[] = new float[x.length];
        for (int i = 0; i < x.length ; i += 3) {
            luli[i] = x[i];
            luli[i + 1] = x[i + 1];
            luli[i+2] = z;
        }
        return luli;
    }



}

