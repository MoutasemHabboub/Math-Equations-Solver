package com.example.areejdarweesh.projectone.graph;

/**
 * Created by moten on 7/3/2019.
 */

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.areejdarweesh.projectone.MainActivity;
import com.example.areejdarweesh.projectone.Math.Analyse;
import com.example.areejdarweesh.projectone.Math.D_four;
import com.example.areejdarweesh.projectone.Math.D_one;
import com.example.areejdarweesh.projectone.Math.D_three;
import com.example.areejdarweesh.projectone.Math.D_two;
import com.example.areejdarweesh.projectone.Math.Eqution;
import com.example.areejdarweesh.projectone.R;

public class Main2Activity extends AppCompatActivity {
    EditText editText;
    Button btn;
    String s = "";
    float a[];
    D_one aa=null;
    MainActivity M;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph);
        editText = findViewById(R.id.editgraph);

        btn=findViewById(R.id.drow);
        //System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity22.class);
                myIntent.putExtra("float[]",hi());
                Toast.makeText(getApplication(),"goooo",Toast.LENGTH_LONG).show();
                Log.e("goooo","gll");
                startActivity(myIntent);
            }


        });
    };


    @RequiresApi(api = Build.VERSION_CODES.N)
    public float[] hi (){
        s = editText.getText().toString();
        Log.e("s= ",s);
        int ok=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='='){
                ok=1;
                break;
            }
        }
        if (ok==0){
            s+="=0";
        }
        Analyse analyse=new Analyse();
        Eqution aa=analyse.analyse(s);
        if(aa.getClass()==D_one.class){
            D_one eq=(D_one)aa;
            //eq.solve(s);
            a = eq.findPoints(s);
        }
        else if(aa.getClass()== D_two.class){
            D_two eq=(D_two)aa;
          //  eq.solve(s);
            a = eq.findPoints(s);
        }
        else if(aa.getClass()== D_three.class){
            D_three eq=(D_three)aa;
           // eq.solve(s);
            a = eq.findPoints(s);
        }
       /* else if(aa.getClass()== D_four.class){
            D_four eq=(D_four)aa;
            a = eq.findPoints(s);
        }*/

        return a;

    }

}
