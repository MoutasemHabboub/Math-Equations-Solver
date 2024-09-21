package com.example.areejdarweesh.projectone.Fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.areejdarweesh.projectone.Math.Analyse;
import com.example.areejdarweesh.projectone.Math.MultiVar;
import com.example.areejdarweesh.projectone.R;

import java.util.ArrayList;

/**
 * Created by Areej darweesh on 4/24/2019.
 */

public class MultiVariable extends Fragment {
    @Nullable

    View view;
    Button solvemult, showmult, clear, GOO;
    EditText numberEQ, eqqq, eq11, eq22, eq33;
    TextView show, solve,showstepss,solvemulti;
    String eq, result = "";
    Context context;
    ImageView cancel,cancel2;
    Dialog showwsteps,solvedialog;
    ArrayList<String> listString = new ArrayList<>();
    float num = 0;
    LinearLayout linearLayout;
    ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

    //--------------------------CREAT FRAGMENT-----------------------------

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.multivariable, container, false);
        context = getActivity();
        params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        findId(view);
        showwsteps=new Dialog(getContext());
        solvedialog=new Dialog(getContext());
        onClick(view);
        return view;
    }

    //----------------------FIND ID-------------------------------------

    @SuppressLint("WrongConstant")
    private void findId(View view) {
        solvemult = view.findViewById(R.id.bsolvemult);
        showmult = view.findViewById(R.id.bshowmult);
        numberEQ = view.findViewById(R.id.num);
        //show = view.findViewById(R.id.tshowmultsteps);
        //solve = view.findViewById(R.id.tsolvemunlt);
        linearLayout = view.findViewById(R.id.linear);
        clear = view.findViewById(R.id.clearmunlt);
        GOO = view.findViewById(R.id.Goo);
        clear.setVisibility(View.INVISIBLE);
        solvemult.setVisibility(View.INVISIBLE);
        showmult.setVisibility(View.INVISIBLE);
        cancel=view.findViewById(R.id.closesteps);
        showstepss=view.findViewById(R.id.textsteps);

    }

    //--------------------------ON CLICK-------------------------------

    private void onClick(final View view) {

        //--------------------BUTTON NUMBER OF EQUATION---------------------------
        GOO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberEQ.getText().toString().isEmpty()) {
                    Toast.makeText(context, "Empty num", Toast.LENGTH_SHORT).show();
                    return;
                }

                num = Float.parseFloat(numberEQ.getText().toString());
                clear.setVisibility(View.VISIBLE);
                solvemult.setVisibility(View.VISIBLE);
                showmult.setVisibility(View.VISIBLE);
                for (int i = 0; i < num; i++) {
                    linearLayout.addView(createEditText());
                }
                GOO.setEnabled(false);
            }

        });

        //---------------------------BUTTON SOLVE EQUATION----------------------------
        solvemult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i <linearLayout.getChildCount() ; i++) {
                    if(linearLayout.getChildAt(i)==null)
                        return;

                }
                showdialogsolve();
           /*     GOO.setVisibility(View.INVISIBLE);
                Analyse analyse = new Analyse();
                String eqs[] = new String[(int) num];
                MultiVar multiVar = new MultiVar();
                for (int i = 0; i < linearLayout.getChildCount(); i++) {
                    EditText editText = (EditText) linearLayout.getChildAt(i);
                    if (editText.getText().toString().isEmpty()) {
                        listString.clear();
                        Toast.makeText(getContext(),"Empty ",Toast.LENGTH_LONG).show();
                        return;
                    }
                    listString.add(editText.getText().toString());
                }
                for (int i = 0; i < listString.size(); i++) {
                    eqs[i] = listString.get(i);
                }
                if (analyse.Get_var_num() != 1) {
                    multiVar.solve(eqs);
                    Object o[] = multiVar.getSolution();
                    if (o.getClass() != Float[].class) {
                        Toast.makeText(context, "Wrong ", Toast.LENGTH_LONG).show();
                        return;
                    }
                    else {

                        for (int i = 0; i < o.length; i++)
                           result +=multiVar.var.get(i)+ "="+o[i]+"\n";
                           solve.setText(result);
                           result = "";
                          // show.setText("");
                    }
                } else {
                    solve.setText("THIS EQUATION IS AN ONE VARIABLE EQUATION \n IF YOU WANT TO SOLVE IT GO TO THE ONE VARIABLE SECTION ..^_^");

                }*/

            }
        });

        //---------------------------BUTTON SHOW STEPS EQUATION----------------------------

        showmult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i <linearLayout.getChildCount() ; i++) {
                    if(linearLayout.getChildAt(i)==null)
                        return;

                }
                showdialogsteps();
            }

        });

        //---------------------------BUTTON CLEAR ALL STRING----------------------------

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberEQ.setText(" ");
                solve.setText(" ");
                //show.setText(" ");
                for (int i = 0; i <listString.size() ; i++) {
                    listString.clear();
                }
                for (int i = 0; i <linearLayout.getChildCount() ; i++) {
                    linearLayout.clearDisappearingChildren();
                    linearLayout.removeAllViewsInLayout();
                    linearLayout.removeAllViews();
                }
                clear.setVisibility(View.INVISIBLE);
                solvemult.setVisibility(View.INVISIBLE);
                showmult.setVisibility(View.INVISIBLE);
                GOO.setVisibility(View.VISIBLE);


            }
        });

        //----------------------CREAT EDIT TEXT------------------------------------

    }
    private EditText createEditText() {
        EditText editText = new EditText(context);
        editText.setTextColor(Color.WHITE);//ex...
        editText.setTextSize(20);
       // editText.setPadding(2,2,2,2);
        editText.setLayoutParams(params);
        return editText;
    }

    public  void showdialogsteps()
    {
        showwsteps.setContentView(R.layout.dialogsteps);
        cancel=showwsteps.findViewById(R.id.closesteps);
        showstepss=showwsteps.findViewById(R.id.textsteps);
        Analyse analyse = new Analyse();
        String eqs[] = new String[(int) num];
        MultiVar multiVar = new MultiVar();
        for (int i = 0; i < listString.size(); i++) {
            eqs[i] = listString.get(i);
        }
        for (int i = 0; i < eqs.length; i++) {
            Log.e(i + "", eqs[i] + "\n");
        }
        if (analyse.Get_var_num() != 1) {
            multiVar.solve(eqs);
            Object o[] = multiVar.getSolution();

            for (int i = 0; i < o.length; i++)
                showstepss.setText(multiVar.showstips() + "\n");
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

    public void showdialogsolve()
    {
       solvedialog.setContentView(R.layout.dialogmultivar);
       cancel2=solvedialog.findViewById(R.id.solvemulticlose);
        solvemulti=solvedialog.findViewById(R.id.solvemulti);

               GOO.setVisibility(View.INVISIBLE);
                Analyse analyse = new Analyse();
                String eqs[] = new String[(int) num];
                MultiVar multiVar = new MultiVar();
                for (int i = 0; i < linearLayout.getChildCount(); i++) {
                    EditText editText = (EditText) linearLayout.getChildAt(i);
                    if (editText.getText().toString().isEmpty()) {
                        listString.clear();
                        Toast.makeText(getContext(),"Empty ",Toast.LENGTH_LONG).show();
                        return;
                    }
                    listString.add(editText.getText().toString());
                }
                for (int i = 0; i < listString.size(); i++) {
                    eqs[i] = listString.get(i);
                }
                if (analyse.Get_var_num() != 1) {
                    multiVar.solve(eqs);
                    Object o[] = multiVar.getSolution();
                    if (o.getClass() != Float[].class) {
                        Toast.makeText(context, "Wrong ", Toast.LENGTH_LONG).show();
                        return;
                    }
                    else {

                        for (int i = 0; i < o.length; i++)
                           result +=multiVar.var.get(i)+ "="+o[i]+"\n";
                        solvemulti.setText(result);
                           result = "";
                          // show.setText("");
                    }
                } else {
                    solvemulti.setText("THIS EQUATION IS AN ONE VARIABLE EQUATION \n IF YOU WANT TO SOLVE IT GO TO THE ONE VARIABLE SECTION ..^_^");

                }
        cancel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solvemulti.setText(" ");
                solvedialog.dismiss();
            }
        });
        solvedialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        solvedialog.show();

    }

}
