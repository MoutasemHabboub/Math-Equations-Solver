package com.example.areejdarweesh.projectone.learning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.areejdarweesh.projectone.R;

public class two_test extends AppCompatActivity {

    EditText ans1,ans2;
    TextView eq,var1,var2;
    double sol1,sol2;
    String type="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_test);

        ans1=findViewById(R.id.ans1);
        ans2=findViewById(R.id.ans2);

        eq=findViewById(R.id.quastion);

        var1=findViewById(R.id.var1);
        var2=findViewById(R.id.var2);

        String test_eq=getIntent().getStringExtra("eq");
        String varr=getIntent().getStringExtra("var");
        sol1=getIntent().getDoubleExtra("ans1",0);
        sol2=getIntent().getDoubleExtra("ans2",0);
        type=getIntent().getStringExtra("sol");

        eq.setText(test_eq);
        var1.setText(varr+"1= ");
        var2.setText(varr+"2= ");
    }

    public void next(View view) {
        String s1,s2;
        s1=ans1.getText().toString();
        s2=ans2.getText().toString();
        if(type=="one"){
            if(s1.isEmpty() && !s2.isEmpty()){
                if(sol1==Double.parseDouble(s2))
                {

                }
                else{
                    Toast.makeText(this.getBaseContext(),"Wrong answer",Toast.LENGTH_LONG).show();
                    ans1.setText("");
                    ans2.setText("");
                }
            }
        }
        else{
            if(!s1.isEmpty() && !s2.isEmpty() && (Double.parseDouble(s1)==sol1 || Double.parseDouble(s1)==sol2) && (Double.parseDouble(s2)==sol1 || Double.parseDouble(s2)==sol2) )
            {

            }
            else{
                Toast.makeText(this.getBaseContext(),"Wrong answer",Toast.LENGTH_LONG).show();
                ans1.setText("");
                ans2.setText("");
            }
        }
    }
}
