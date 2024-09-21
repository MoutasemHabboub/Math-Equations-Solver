package com.example.areejdarweesh.projectone.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.areejdarweesh.projectone.R;

/**
 * Created by Areej darweesh on 4/15/2019.
 */

public class GraphFragment extends android.support.v4.app.Fragment{
    View view;
    EditText editgraph;
    Button droww;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.graph,container,false);

       return view;
    }
    public void findId(View view)
    {
        /*editgraph=view.findViewById(R.id.editgraph);
        droww=view.findViewById(R.id.drow);*/

    }

    public void onclick()
    {

    }
}
