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

public class PrimeNumber extends android.support.v4.app.Fragment {

    TextView viewprim;
    Button btnprim, clrprim;
    EditText editTextprim;
    View view;
    Set<Integer> primefactors = new HashSet<>();
    int num;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.prim_umber, container, false);
        findId(view);
        onclick();
        return view;

    }

    public void findId(View view) {
        viewprim = view.findViewById(R.id.textViewprim);
        btnprim = view.findViewById(R.id.primnumber);
        editTextprim = view.findViewById(R.id.editTextprimnumber);
        clrprim = view.findViewById(R.id.clrprim);
    }

    public void onclick() {
        btnprim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i, m = 0, flag = 0;
                //int n = 3;//it is the number to be checked
                m =  num / 2;
                if (editTextprim.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Empty Enter", Toast.LENGTH_LONG).show();
                    return;
                }
                num = Integer.parseInt(editTextprim.getText().toString());
                if (num == 0 || num == 1) {
                    viewprim.setText(num + " is prime number");
                } else {
                    for (i = 2; i <= m; i++) {
                        if (num % i == 0) {
                            viewprim.setText(num + " is not prime number");
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        viewprim.setText(num + " is prime number");
                    }
                }//end of else
                //  viewprim.setText(primeFactors(num)+"");
            }
        });
        clrprim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewprim.setText("");
                editTextprim.setText("");
            }
        });
    }

}



