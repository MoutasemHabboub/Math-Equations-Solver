package com.example.areejdarweesh.projectone.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.areejdarweesh.projectone.Math.dev;
import com.example.areejdarweesh.projectone.R;

import java.util.ArrayList;

/**
 * Created by Areej Darweesh on 7/4/2019.
 */

public class drivationFragment extends Fragment {
   View view;
   Button b1,b2;
   EditText ed1;
   TextView t1;
   ArrayList<String> de;
   String s=" ",result=" ";
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.drivation_fragment,container,false);
        findId(view);
        onclick();
        return view;
    }
    public void findId(View view)
    {
        b1=view.findViewById(R.id.driv_result);
        b2=view.findViewById(R.id.clrdriv);
        ed1=view.findViewById(R.id.editTextdriv);
        t1=view.findViewById(R.id.textViewdriv);
    }
    public void onclick()
    {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s=ed1.getText().toString();
                dev d=new dev();
                de=d.derv(s);
                Log.e("sss "," "+de.size());
                for (int i=0;i<de.size();i++){
                    t1.setText(de.get(i));
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(" ");
                t1.setText(" ");
                s=" ";
                result=" ";
            }
        });
    }
}
