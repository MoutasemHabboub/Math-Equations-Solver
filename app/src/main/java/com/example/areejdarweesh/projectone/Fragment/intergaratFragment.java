package com.example.areejdarweesh.projectone.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.areejdarweesh.projectone.Math.Analyse;
import com.example.areejdarweesh.projectone.Math.Eqution;
import com.example.areejdarweesh.projectone.Math.INTEGRATE;
import com.example.areejdarweesh.projectone.R;

import static com.example.areejdarweesh.projectone.R.layout.intergratefragment;

/**
 * Created by Areej Darweesh on 7/3/2019.
 */

public class intergaratFragment extends Fragment {


    View view;
    EditText edit,ed_a,ed_b;
    Button b_solve,b_clear;
    double a,b,result;
    String equation;
    TextView resultintergrate;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.intergratefragment,container,false);
        findId(view);
        onclick();
        return view;

    }

    public void findId(View view)
    {

        edit=view.findViewById(R.id.e1_intergrate);
        ed_a=view.findViewById(R.id.e1_a);
        ed_b=view.findViewById(R.id.e1_b);
        b_solve=view.findViewById(R.id.solveintergrate);
        b_clear=view.findViewById(R.id.clearintergrate);
        resultintergrate=view.findViewById(R.id.T1_intergrate);
    }
    public void onclick()
    {

        b_solve.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
              //  equation=Double.parseDouble(edit.getText().toString());
                equation=edit.getText().toString();
                a=Double.parseDouble(ed_a.getText().toString());
                b=Double.parseDouble(ed_b.getText().toString());
                if(equation.isEmpty() ||ed_a.getText().toString().isEmpty() || ed_b.getText().toString().isEmpty())
                {
                    Toast.makeText(getContext(),"Wrong...Empty Enter",Toast.LENGTH_LONG).show();
                }

                    INTEGRATE integrate=new INTEGRATE();
                    integrate.Analyze(equation);
                    result=integrate.solve(a,b);
                    resultintergrate.setText("the value of this intergrate is : "+result);
            }

        });

        b_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result=0;
                equation=" ";
                edit.setText(" ");
                ed_a.setText(" ");
                ed_b.setText(" ");
                resultintergrate.setText(" ");
            }
        });

    }
}
