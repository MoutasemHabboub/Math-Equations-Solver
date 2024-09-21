package com.example.areejdarweesh.projectone.Extra;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.areejdarweesh.projectone.R;

/**
 * Created by Areej darweesh on 4/15/2019.
 */

public class PiNumber extends android.support.v4.app.Fragment {
    View view;
    TextView viewpi;
    Button btnpi,clear;
    EditText editTextpi;
    Float numberOfTimes;
    int myCounter = 1;

    double myPi = 4.0;
    double myFooter = 3.0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.pi_number,container,false);
        findId(view);
        onclick();
        return view;
    }

    private void findId(View view) {
        viewpi = view.findViewById(R.id.textViewpi);
        btnpi = view.findViewById(R.id.pi);
        editTextpi = view.findViewById(R.id.editTextpi);
        clear=view.findViewById(R.id.clrpi);
    }
    public void onclick()
    {
        btnpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfTimes=Float.parseFloat( editTextpi.getText().toString()) ;
                /*while (numberOfTimes >= myCounter) {

            /*Here we are going to calculate PI.
             * PI = 4 - 4/3 + 4/5 - 4/7 + 4/9....


                    myPi = myPi - (4/myFooter) + (4/(myFooter+2));
                    viewpi.setText(myPi+",");
                   // System.out.println(myPi);

                    myCounter++;
                    myFooter+=4;


                }
                double newPi = myPi;
                double newFooter = myFooter;*/
                viewpi.setText(Math.PI+"");
             //  System.out.println("PI = " + Math.PI);




            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewpi.setText("");
                editTextpi.setText("");
            }
        });
    }


}
