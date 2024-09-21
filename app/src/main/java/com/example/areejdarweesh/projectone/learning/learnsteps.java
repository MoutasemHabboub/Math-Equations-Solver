package com.example.areejdarweesh.projectone.learning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.areejdarweesh.projectone.R;

public class learnsteps extends AppCompatActivity {
TextView view1,ex;
String type="",test_eq="",var="";
double ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learnsteps);
        view1=findViewById(R.id.view1);
        ex=findViewById(R.id.example);

        String steps=getIntent().getStringExtra("steps");
        String example=getIntent().getStringExtra("example");
        type=getIntent().getStringExtra("type");

        view1.setText(steps);
        ex.setText(example);
    }

    public void next(View view) {

        if(type.equals("one")) {
            Intent intent=new Intent(learnsteps.this,one_test.class);
            test_eq += "\n 15+x=-15";
            var += "x";
            ans = -30;

            intent.putExtra("eq",test_eq);
            intent.putExtra("var",var);
            intent.putExtra("ans",ans);
            startActivity(intent);
        }
        else if(type.equals("two")){
            Intent intent=new Intent(learnsteps.this,two_test.class);
            String sol="one";
            test_eq += "\n x^2+2x+1=0";
            var += "x";
            ans = -1;
            double ans2=0;

            intent.putExtra("eq",test_eq);
            intent.putExtra("var",var);
            intent.putExtra("ans1",ans);
            intent.putExtra("ans2",ans2);
            intent.putExtra("sol",sol);
            startActivity(intent);
        }
        finish();
    }
}
