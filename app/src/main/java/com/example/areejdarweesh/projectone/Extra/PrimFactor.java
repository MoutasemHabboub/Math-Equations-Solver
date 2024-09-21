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

public class PrimFactor extends android.support.v4.app.Fragment{
    TextView viewFact;
    Button btnFact,clrfact;
    EditText editTextfact;
    View view;
    Set<Integer> primefactors = new HashSet<>();
    Long num;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.primfactor, container, false);
        findId(view);
        onclick();
        return view;

    }

    public void findId(View view) {
        viewFact = view.findViewById(R.id.textViewfact);
        btnFact = view.findViewById(R.id.primfact);
        editTextfact = view.findViewById(R.id.editTextfact);
        clrfact=view.findViewById(R.id.clrfact);
    }

    public void onclick() {
        btnFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextfact.getText().toString().isEmpty())
                {
                    Toast.makeText(getActivity(),"Empty Enter",Toast.LENGTH_LONG).show();
                    return;
                }
                num=Long.parseLong(editTextfact.getText().toString());
                viewFact.setText(primeFactors(num)+"");
            }
        });
        clrfact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFact.setText("");
                editTextfact.setText("");
            }
        });
    }

    public static Set<Integer> primeFactors(Long number) {
        Set<Integer> primefactors = new HashSet<>();
        Long copyOfInput = number;
        for (int i = 2; i<=copyOfInput;i++)
        {
            if (copyOfInput % i == 0) {
                primefactors.add(i);
                copyOfInput /= i;
                i--;
            }
        }
        return primefactors;
    }


}
