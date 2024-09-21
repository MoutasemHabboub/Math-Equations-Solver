package com.example.areejdarweesh.projectone.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.areejdarweesh.projectone.Math.Matrix;
import com.example.areejdarweesh.projectone.R;

import java.util.ArrayList;

import static com.example.areejdarweesh.projectone.R.array.matrix;

/**
 * Created by Areej darweesh on 4/15/2019.
 */

public class MatrixFragment extends android.support.v4.app.Fragment {
    @Nullable

    View view;
    Context context;
    Dialog dialogA,dialogB,dialogresult;
    Button cancelA,cancelB,creata,creatb,creatbutA,creatbutB,cancelresult,result;
    Spinner spinner;
    int Rowa,Cola,rowb,colb;
    TextView textViewsoul;
    static int ii=-1,jj=-1,jb=-1,ib=-1;
    ImageView closeSoul;
    boolean equal;
    EditText colmatrixa,colBb,rowmatrixa,rowBb;
    ArrayList<String> listStringgA = new ArrayList<>();
    ArrayList<String> listStringgB = new ArrayList<>();
    LinearLayout linearLayouttA,linearLayoutB,lla,llb,linearLayoutBb,linearLayoutAa;
    ViewGroup.LayoutParams paramsA = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    ViewGroup.LayoutParams paramsB = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.matrix,container,false);
        dialogA=new Dialog(getContext());
        dialogB=new Dialog(getContext());
        dialogresult=new Dialog(getContext());
        context = getActivity();
        paramsA = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        paramsB = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        ArrayAdapter adaptermatrix = ArrayAdapter.createFromResource(getContext(), R.array.matrix, R.layout.my_spinner_item);
        adaptermatrix.setDropDownViewResource(R.layout.spinner_dropdown_item);
        findId(view);
        spinner.setAdapter(adaptermatrix);
        ocClike();
        return view;
    }

    public void findId(View view)
    {
        cancelA=view.findViewById(R.id.cancelA);
        cancelB=view.findViewById(R.id.cancelB);
        creata=view.findViewById(R.id.creatA);
        creatb=view.findViewById(R.id.creatB);
        creatbutA=view.findViewById(R.id.creatAA);
        creatbutB=view.findViewById(R.id.creatBB);
        //cancelresult=view.findViewById(R.id.cancelsoul);
        spinner=view.findViewById(R.id.spinnermatrix);
        textViewsoul=view.findViewById(R.id.textsoul);
        result=view.findViewById(R.id.resultmatrix);
        linearLayouttA=view.findViewById(R.id.linearmatrixA);
        linearLayoutB=view.findViewById(R.id.linearmatrixB);
        rowBb=view.findViewById(R.id.rowB);
      //  colmatrixa=view.findViewById(R.id.columnmatrixA);
        colBb=view.findViewById(R.id.columnB);
        //rowmatrixa.setText("roww");
       // colmatrixa.setText("coll");
        spinner=view.findViewById(R.id.spinnermatrix);

    }


    public void ocClike()
    {

        creatbutA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               linearLayouttA.clearDisappearingChildren();
                linearLayouttA.removeAllViews();
                linearLayouttA.removeAllViewsInLayout();
                showdialogA();

            }
        });

        creatbutB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               linearLayoutB.clearDisappearingChildren();
                linearLayoutB.removeAllViews();
                linearLayoutB.removeAllViewsInLayout();
                showdialogB();
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showdialogsoul();
                listStringgA.clear();
                listStringgB.clear();


            }
        });


    }

    // Show Dialog ----
    public  void showdialogA()
    {

        dialogA.setContentView(R.layout.dialogmatrix);
        cancelA=dialogA.findViewById(R.id.cancelA);
        creata=dialogA.findViewById(R.id.creatA);
        rowmatrixa=dialogA.findViewById(R.id.rowmatrixA);
        colmatrixa=dialogA.findViewById(R.id.columnmatrixA);
        cancelA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogA.dismiss();
            }
        });
        creata.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ii=0;
            jj=0;
            linearLayouttA.clearDisappearingChildren();
            linearLayouttA.removeAllViews();
            linearLayouttA.removeAllViewsInLayout();
            Toast.makeText(getContext(),"creat",Toast.LENGTH_LONG).show();
            Log.e("rowa :",Rowa+"\n");
            Log.e("cola :",Cola+"\n");
            if ((rowmatrixa.getText().toString().isEmpty()) || (colmatrixa.getText().toString().isEmpty()))
            {
                Toast.makeText(context, "Empty num", Toast.LENGTH_SHORT).show();
                return;
            }
           /* rowmatrixa.setText("rowww");
            colmatrixa.setText("rowww");*/
            Rowa=Integer.parseInt(rowmatrixa.getText().toString());
            Cola=Integer.parseInt(colmatrixa.getText().toString());

            Log.e("rowa :",Rowa+"\n");
            Log.e("col a:",Cola+"\n");
            Log.e("rowa :",colmatrixa.getText().toString()+"\n");
            Log.e("col a:",rowmatrixa.getText().toString()+"\n");

            for (int i = 0; i < Rowa ; i++) {
                lla = new LinearLayout(context);
                LinearLayout.LayoutParams pa= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                lla.setLayoutParams(pa);
                lla.setOrientation(LinearLayout.HORIZONTAL);
                ii++;
                for (int j = 0; j < Cola; j++) {
                    jj++;
                    createEditTextA();
                    lla.addView(createEditTextA());
                }
                linearLayouttA.addView(lla);
            }
            dialogA.dismiss();
        }

    });
        dialogA.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogA.show();
    }


    public  void showdialogB()
    {
        ib=0;
        jb=0;
        dialogB.setContentView(R.layout.dialogmatrixb);
        cancelB=dialogB.findViewById(R.id.cancelB);
        creatb=dialogB.findViewById(R.id.creatB);
        rowBb=dialogB.findViewById(R.id.rowB);
        colBb=dialogB.findViewById(R.id.columnB);
        cancelB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogB.dismiss();
            }
        });
        creatb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutB.clearDisappearingChildren();
                linearLayoutB.removeAllViews();
                linearLayoutB.removeAllViewsInLayout();
                Toast.makeText(getContext(),"creat",Toast.LENGTH_LONG).show();
                Log.e("rowb :",rowb+"\n");
                Log.e("colb :",colb+"\n");
                if ((rowBb.getText().toString().isEmpty()) || (colBb.getText().toString().isEmpty()))
                {
                    Toast.makeText(context, "Empty num", Toast.LENGTH_SHORT).show();
                    return;
                }

                rowb=Integer.parseInt(rowBb.getText().toString());
                colb=Integer.parseInt(colBb.getText().toString());

                Log.e("row :",Rowa+"\n");
                Log.e("col :",Cola+"\n");
                Log.e("col :",rowBb.getText().toString()+"\n");
                Log.e("col :",colBb.getText().toString()+"\n");

                for (int i = 0; i < rowb ; i++) {
                    llb = new LinearLayout(context);
                    LinearLayout.LayoutParams pa= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    llb.setLayoutParams(pa);
                    llb.setOrientation(LinearLayout.HORIZONTAL);
                    ib++;
                    for (int j = 0; j < colb; j++) {
                        jb++;
                        createEditTextB();
                        llb.addView(createEditTextB());
                    }
                    linearLayoutB.addView(llb);
                }
                dialogB.dismiss();
            }

        });
        dialogB.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogB.show();
    }


    public  void showdialogsoul()
    { 
       // A=new Matrix(Rowa,Cola);
        //B=new Matrix(rowb,colb);
        double A[][]=new double[Rowa][Cola];
        double B[][]=new double[rowb][colb];
        int k=0,h=0;
        int item;
        dialogresult.setContentView(R.layout.dialogsolutionmaatrix);

        textViewsoul=dialogresult.findViewById(R.id.textsoul);
        closeSoul=dialogresult.findViewById(R.id.closesoulmatrix);
        closeSoul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogresult.dismiss();
            }
        });
        textViewsoul.setText("");
        for(int i=0;i<linearLayouttA.getChildCount();i++)
        {
            LinearLayout l2=(LinearLayout)linearLayouttA.getChildAt(i);
            for (int j=0;j<l2.getChildCount();j++)
            {
                EditText editText=(EditText)l2.getChildAt(j);
                if(editText.getText().toString().isEmpty())
                {
                    Toast.makeText(getContext(),"EMPTY TABLE ..",Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

        for (int i=0;i<linearLayouttA.getChildCount();i++)
        {
            LinearLayout l2=(LinearLayout)linearLayouttA.getChildAt(i);
            for (int j=0;j<l2.getChildCount();j++)
            {
                EditText editText=(EditText)l2.getChildAt(j);
                listStringgA.add(editText.getText().toString());


            }
        }
        for (int i = 0; i <Rowa ; i++) {
            for (int j = 0; j <Cola ; j++) {
                A[i][j]=Double.parseDouble(listStringgA.get(k));
                k++;
            }
        }


        for(int i=0;i<linearLayoutB.getChildCount();i++)
        {
            LinearLayout l1=(LinearLayout)linearLayoutB.getChildAt(i);
            for (int j=0;j<l1.getChildCount();j++)
            {
                EditText editText=(EditText)l1.getChildAt(j);
                if(editText.getText().toString().isEmpty())
                {
                    Toast.makeText(getContext(),"EMPTY TABLE ..",Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

        for (int i=0;i<linearLayoutB.getChildCount();i++)
        {
            LinearLayout l1=(LinearLayout)linearLayoutB.getChildAt(i);
            for (int j=0;j<l1.getChildCount();j++)
            {
                EditText editText=(EditText)l1.getChildAt(j);
                listStringgB.add(editText.getText().toString());
            }
        }
        for (int i = 0; i <rowb ; i++) {
            for (int j = 0; j <colb ; j++) {
                B[i][j]=Double.parseDouble(listStringgB.get(h));
                h++;
            }
        }

        item=spinner.getSelectedItemPosition();
        Matrix result=evaluate(A,B,item);
       Toast.makeText(getContext(),"itemmm : "+item+"A is \n"+A[0][0]+" "+A[0][1]+"\n"+A[1][1]+A[1][0],Toast.LENGTH_LONG).show();
      //  Log.e("result",result.showw());
        if(result!=null)
        textViewsoul.setText(result.showw()+"");
        else if (evaluate(A,B,item)==null) {
            if (equal) {
                textViewsoul.setText(equal + " the Matrixs is equal");

            }
            textViewsoul.setText(equal + " the Matrixs is not equal");
        }
        dialogresult.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogresult.show();


}
    private EditText createEditTextA() {

        EditText editText = new EditText(context);
        LinearLayout.LayoutParams pa= new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        editText.setLayoutParams(pa);
        editText.setTextColor(Color.WHITE);//ex...
        editText.setTextSize(20);
        editText.setInputType(1);
        //editText.setPadding(2, 2, 2, 2);
       editText.setHint("["+ii+","+jj+"]");
        return editText;
    }
    private EditText createEditTextB() {
        EditText editText = new EditText(context);
        LinearLayout.LayoutParams pa= new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        editText.setLayoutParams(pa);
        editText.setTextColor(Color.WHITE);//ex...
        editText.setTextSize(20);
        //editText.setPadding(2, 2, 2, 2);
        editText.setHint("["+ib+","+jb+"]");
        return editText;
    }

    private LinearLayout creatLinearlayout()
    {
        LinearLayout linearLayout=new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        return linearLayout;
    }

    public Matrix evaluate(double A[][],double B[][],int item) {

        Matrix MA=new Matrix(A);
        Matrix MB=new Matrix(B);
        Matrix M=null;
       // Double Mat[][];
            switch (item) {
                case 0:
                    M = MA.plus(MB);
                    Log.e("0evaluate: ", M.showw());
                    Toast.makeText(getContext(),"itemmm : "+item+"A is"+A.length+" "+A[0],Toast.LENGTH_LONG).show();
                    break;
                case 1:
                    M = MA.minus(MB);
                    Log.e("1evaluate: ",M.showw());
                    Toast.makeText(getContext(),          "itemmm : "+item+"A is"+A.length+" "+A[0],Toast.LENGTH_LONG).show();
                    break;
                case 2:
                    M = MA.times(MB);
                    Log.e("2evaluate: ",M.showw());
                    Toast.makeText(getContext(),"itemmm : "+item+"A is"+A.length+" "+A[0],Toast.LENGTH_LONG).show();
                    break;
                case 3:
                   // M=MA;
                    M=MA.solve(MB);
                    Log.e("3evaluate: ",M.showw());
                    Toast.makeText(getContext(),"itemmm : "+item+"A is"+A.length+" "+A[0],Toast.LENGTH_LONG).show();
                    break;
                case 4:
                    M=MB.solve(MA);
                    Log.e("4evaluate: ",M.showw());
                    Toast.makeText(getContext(),"itemmm : "+item+"A is"+A.length+" "+A[0],Toast.LENGTH_LONG).show();
                    break;
                case 5:
                    M = MA.transpose();
                    Log.e( "5evaluate: ",M.showw());
                    Toast.makeText(getContext(),"itemmm : "+item+"A is"+A.length+" "+A[0],Toast.LENGTH_LONG).show();
                    break;
                case 6:
                    M = MB.transpose();
                    Log.e("6evaluate: ",M.showw());
                    Toast.makeText(getContext(),"itemmm : "+item+"A is"+A.length+" "+A[0],Toast.LENGTH_LONG).show();
                    break;
                case 7:
                    equal=MA.eq(MB);
                    return null;


            }

        return M;
    }
}
