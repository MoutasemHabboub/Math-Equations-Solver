package com.example.areejdarweesh.projectone.Fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.areejdarweesh.projectone.Math.Analyse;
import com.example.areejdarweesh.projectone.Math.Eqution;
import com.example.areejdarweesh.projectone.Math.oneVariable;
import com.example.areejdarweesh.projectone.R;


/**
 * Created by Areej darweesh on 4/15/2019.
 */

public class AnalyseFragment extends android.support.v4.app.Fragment {
    @Nullable

    View view;
    TextView tv1;
    EditText editText1, editText2;
    TextView textView, textView1,showstepss;
    Button button, showsteps, clearr;
    String eq,result="";
    Dialog showwsteps;
    ImageView cancel;

    //--------------------------CREAT FRAGMENT-----------------------------

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.analyse, container, false);
        findId(view);
        onClick();
        showwsteps=new Dialog(getContext());
        //code here...
        return view;
    }

    //----------------------FIND ID-------------------------------------
    private void findId(View view) {
        editText1 = view.findViewById(R.id.e1);
        textView = view.findViewById(R.id.T1);
        button = view.findViewById(R.id.solve);
        showsteps = view.findViewById(R.id.show);
       // textView1 = view.findViewById(R.id.T2);
        clearr = view.findViewById(R.id.clear);
        cancel=view.findViewById(R.id.closesteps);
        showstepss=view.findViewById(R.id.textsteps);

    }

    //--------------------------ON CLICK-------------------------------
    private void onClick() {
        //---------------------BUTTON SOLVE--------------------------
            button.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onClick(View v) {
                    if (editText1.getText().toString().isEmpty()) {

                        Toast.makeText(getContext(), "Empty input", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Analyse analyse = new Analyse();
                    eq = editText1.getText().toString();
                    Eqution eqution = analyse.analyse(eq);
                    if (eqution != null) {
                        if (analyse.Get_var_num() == 1) {
                            oneVariable oneVariable = (oneVariable) eqution;
                            oneVariable.solve(eq);
                            Object o[] = oneVariable.getSolution();

                            for (int i = 0; i < o.length; i++)
                                result += oneVariable.var + "=" + o[i] + "\n";
                            textView.setText(result);
                            result=" ";
//                            textView1.setText(" ");
                            //  System.out.println("\n" + oneVariable.showstips());
                        } else {

                            textView.setText("This equation is a multi variable equation \n If you want to solve it please go to the Multi variable section ..^_^");
                           // textView1.setText(" ");
                        }
                    }
                    else{
                        textView.setText("This String either dosn't represent an equation..^_^");
                        showsteps.setEnabled(false);

                    }

                }
            });


            //------------------------BUTTON SHOW STEPS FOR ONE VARIABLE------------------------------------
            showsteps.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onClick(View v) {
                    if (editText1.getText().toString().isEmpty()) {

                        Toast.makeText(getContext(), "Empty input", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else {
                        showdialogsteps();
                    }
                }
            });

            //----------------------BUTTON CLEAR ALL TEXT----------------------------
            clearr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  //  textView1.setText(" ");
                    showstepss.setText(" ");
                    textView.setText(" ");
                    editText1.setText(" ");
                }
            });


    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public  void showdialogsteps()
    {
        showwsteps.setContentView(R.layout.dialogsteps);
        cancel=showwsteps.findViewById(R.id.closesteps);
        showstepss=showwsteps.findViewById(R.id.textsteps);
        Analyse analyse = new Analyse();
        eq = editText1.getText().toString();
        Eqution eqution = analyse.analyse(eq);
        if (eqution != null) {
            if (analyse.Get_var_num() == 1) {
                oneVariable oneVariable = (oneVariable) eqution;
                oneVariable.solve(eq);
                Object o[] = oneVariable.getSolution();
                for (int i = 0; i < o.length; i++)
                    showstepss.setText("\n" + oneVariable.showstips());
                //  System.out.println("\n" + oneVariable.showstips());
            } else {
                showstepss.setText("THIS EQUATION IS A MULTI VARIABLE EQUATION \n IF YOU WANT TO SOLVE IT GO TO THE MULTI VARIABLE SECTION ..^_^");
            }
        }
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showstepss.setText(" ");
                showwsteps.dismiss();
            }
        });
        showwsteps.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        showwsteps.show();
    }

}


