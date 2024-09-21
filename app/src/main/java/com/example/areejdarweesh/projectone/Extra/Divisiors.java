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

public class Divisiors extends android.support.v4.app.Fragment {
    TextView viewdiv;
    Button btnciv,clr;
    EditText editTextdiv;
    View view;
    Long number;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.divisior,container,false);
       findId(view);
       onclick();
       return view;
    }
    public void findId(View view)
    {
        viewdiv = view.findViewById(R.id.textViewdiv);
        btnciv = view.findViewById(R.id.divisior);
        editTextdiv = view.findViewById(R.id.editTextdiv);
        clr=view.findViewById(R.id.clrdiv);
    }
    public void onclick()
    {
        btnciv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextdiv.getText().toString().isEmpty())
                {
                    Toast.makeText(getActivity(),"Empty Enter",Toast.LENGTH_LONG).show();
                    return;
                }
                number=Long.parseLong(editTextdiv.getText().toString());
                viewdiv.setText(Divisior(number)+"");
            }
        });
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewdiv.setText("");
                editTextdiv.setText("");
            }
        });
    }

    public static Set<Integer> Divisior(Long number) {
        Set<Integer> div = new HashSet<>();
        Long copyOfInput = number;
        for (int i = 1; i <= copyOfInput / 2; i++) {
            if (number % i == 0) {
                div.add(i);
            }
        }

        return div;
    }

}
