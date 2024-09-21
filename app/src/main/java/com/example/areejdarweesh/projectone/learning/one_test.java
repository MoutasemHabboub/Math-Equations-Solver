package com.example.areejdarweesh.projectone.learning;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.areejdarweesh.projectone.R;
import com.example.areejdarweesh.projectone.learning.Mainlearnnn;

import java.util.Random;

import javax.xml.transform.Result;

public class one_test extends AppCompatActivity {
    TextView quastion,var;
    EditText ans;
    double sol;
    String []Quastions={"\n 9d=0","\n 10w=180","\n 2x-3=55"};
    String []variables={"d","w","x"};
    double []solutions={0,18,29};
    Boolean []used={false,false,false};
    int done=0;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_test);

        quastion=(TextView)findViewById(R.id.quastion);
        var=(TextView)findViewById(R.id.var);
        ans=(EditText)findViewById(R.id.ans);
        String test_eq=getIntent().getStringExtra("eq");
        String varr=getIntent().getStringExtra("var");
        sol=getIntent().getDoubleExtra("ans",0);
        quastion.setText(test_eq);
        var.setText(varr+"= ");


    }

    public void next(View view) {
        if(!ans.getText().toString().isEmpty())
        {
            double anss=Double.parseDouble(ans.getText().toString());
            if(anss==sol)
            {
                if(done!=Quastions.length){
                    ans.setText("");
                    Random random=new Random();
                    int i=random.nextInt(3);
                    while(used[i]){
                        i=random.nextInt(3);
                    }
                    used[i]=true;
                    quastion.setText(Quastions[i]);
                    var.setText(variables[i]+"= ");
                    sol=solutions[i];
                    done++;

                }
                else{
                   /* Intent intent=new Intent(one_test.this,);
                    startActivity(intent);*/
                    finish();
                }

            }
            else{
                Toast.makeText(this.getBaseContext(),"Wrong answer",Toast.LENGTH_LONG).show();
                ans.setText("");
            }
        }
    }

}
