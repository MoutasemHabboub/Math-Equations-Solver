package com.example.areejdarweesh.projectone.Extra;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.areejdarweesh.projectone.R;

import java.lang.reflect.Array;

/**
 * Created by Areej darweesh on 4/15/2019.
 */

public class Moudulo extends android.support.v4.app.Fragment {
    TextView viewmod;
    Button btnmod,clear;
    EditText editTextmod;
    View view;
    Long number;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.modulo,container,false);
        findId(view);
        onclick();
        return view;
    }

    private void findId(View view) {
        viewmod = view.findViewById(R.id.textViewmod);
        btnmod = view.findViewById(R.id.mod);
        editTextmod = view.findViewById(R.id.editTextmod);
        clear=view.findViewById(R.id.clrmod);
    }
    public void onclick()
    {
        btnmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s="";
                String a="",b="";
                long aa=0,bb=0;
                int k=0;
                s=editTextmod.getText().toString();
                for (int i = 0; i <s.length() ; i++) {
                   if(s.charAt(i)!='/')
                   {
                       a+=s.charAt(i);
                   }
                   if(s.charAt(i)=='/')
                   {
                       k=i;
                       break;
                   }

                }
                for (int i = k+1; i <s.length() ; i++) {
                    b+=s.charAt(i);
                }
                aa=Long.parseLong(a);
                bb=Long.parseLong(b);
                Log.e("aa",a);
                Log.e("bb",b);
                viewmod.setText("Mod  "+aa+" / "+bb+" is : "+mod(aa,bb));

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewmod.setText("");
                editTextmod.setText("");
            }
        });
    }
    public long mod(long a,long b)
    {
        long divided = a / b;
        long result = a - (divided * b);
        return result;
    }
}
