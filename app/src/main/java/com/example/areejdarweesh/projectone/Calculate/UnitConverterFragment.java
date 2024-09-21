package com.example.areejdarweesh.projectone.Calculate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.areejdarweesh.projectone.Extra.UnitArea;
import com.example.areejdarweesh.projectone.Extra.UnitLength;
import com.example.areejdarweesh.projectone.Extra.UnitTemperature;
import com.example.areejdarweesh.projectone.Extra.UnitWeight;
import com.example.areejdarweesh.projectone.R;

/**
 * Created by Areej darweesh on 4/15/2019.
 */

    public class UnitConverterFragment extends android.support.v4.app.Fragment {
    @Nullable

    View view;
    Button b1, b2, b3, b4;


    View.OnClickListener onClickListener;

    public UnitConverterFragment()
    {

    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.content_unit_coverter, container, false);
        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                switch (v.getId()){
                    case R.id.area:
                        i = new Intent(getActivity(), UnitArea.class);
                        startActivity(i);
                        break;
                    case R.id.length:
                        i = new Intent(getActivity(), UnitLength.class);
                        startActivity(i);
                        break;
                    case R.id.weight:
                        i = new Intent(getActivity(), UnitWeight.class);
                        startActivity(i);
                        break;
                    case R.id.tempearture:
                        i = new Intent(getActivity(), UnitTemperature.class);
                        startActivity(i);
                        break;
                }
            }
        };
        findId(view);
        onClick2();
        return view;
    }

    public void findId(View view) {
        b1 = view.findViewById(R.id.area);
        b2 = view.findViewById(R.id.length);
        b3 = view.findViewById(R.id.weight);
        b4 = view.findViewById(R.id.tempearture);
    }

    public void onClick2(){
        b1.setOnClickListener(onClickListener);
        b2.setOnClickListener(onClickListener);
        b3.setOnClickListener(onClickListener);
        b4.setOnClickListener(onClickListener);
    }

}

