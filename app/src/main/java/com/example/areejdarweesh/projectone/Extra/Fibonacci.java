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
import android.widget.Toast;

import com.example.areejdarweesh.projectone.R;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Areej darweesh on 4/15/2019.
 */

public class Fibonacci extends android.support.v4.app.Fragment {
    TextView viewFib;
    Button btnfib,clrfib;
    EditText editTextfib;
    View view;
    int num;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.fibonumber,container,false);
       findId(view);
       onclick();
       return view;
    }

    public void findId(View view)
    {
        viewFib = view.findViewById(R.id.textViewfibo);
        btnfib = view.findViewById(R.id.fibo);
        editTextfib = view.findViewById(R.id.editTextfibo);
        clrfib=view.findViewById(R.id.clrfibo);
    }
    public void onclick()
    {
        btnfib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextfib.getText().toString().isEmpty())
                {
                    Toast.makeText(getActivity(),"Empty Enter",Toast.LENGTH_LONG).show();
                    return;
                }
                num=Integer.parseInt(editTextfib.getText().toString());
                viewFib.setText(fib(num)+"");
            }
        });
        clrfib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFib.setText("");
                editTextfib.setText("");
            }
        });
    }
    public static Set<Integer> fib(int n)
    {
        Set<Integer> fibo = new HashSet<>();
        int f[] = new int[n+2];
        int i;
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++)
        {
            f[i] = f[i-1] + f[i-2];
            fibo.add(f[i]);
        }

        return fibo;
    }
}

