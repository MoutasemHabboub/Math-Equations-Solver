package com.example.areejdarweesh.projectone.Extra;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.areejdarweesh.projectone.R;

public class UnitArea extends AppCompatActivity {

    private EditText e1,e2;
    private Spinner s1,s2;
    private int count1=0;
    private ConvertingUnits.Area ca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_unit_area);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        e1=(EditText)findViewById(R.id.item1);
        e2=(EditText)findViewById(R.id.item2);
        s1=(Spinner)findViewById(R.id.spinner1);
        s2=(Spinner)findViewById(R.id.spinner2);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.area, R.layout.my_spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        s1.setAdapter(adapter);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.area, R.layout.my_spinner_item);
        adapter2.setDropDownViewResource(R.layout.spinner_dropdown_item);
        s2.setAdapter(adapter2);

//
        ca=new ConvertingUnits.Area();
    }

    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.num0:
                    e1.setText(e1.getText()+"0");
                break;

            case R.id.num1:
                    e1.setText(e1.getText()+"1");
                break;

            case R.id.num2:
                    e1.setText(e1.getText()+"2");
                break;

            case R.id.num3:
                    e1.setText(e1.getText()+"3");
                break;

            case R.id.num4:
                    e1.setText(e1.getText()+"4");
                break;

            case R.id.num5:
                    e1.setText(e1.getText()+"5");
                break;

            case R.id.num6:
                    e1.setText(e1.getText()+"6");
                break;

            case R.id.num7:
                    e1.setText(e1.getText()+"7");
                break;

            case R.id.num8:
                    e1.setText(e1.getText()+"8");
                break;

            case R.id.num9:
                    e1.setText(e1.getText()+"9");
                break;

            case R.id.dot:
                if (count1==0)
                {
                    e1.setText(e1.getText()+".");
                    count1++;
                }
                break;

            case R.id.clear:
                e1.setText("");
                e2.setText("");
                count1=0;
                break;

            case R.id.backSpace:
                if(e1.length()!=0)
                {
                    String text=e1.getText().toString();
                    if(text.endsWith("."))
                        count1=0;
                    String newText=text.substring(0,text.length()-1);
                    e1.setText(newText);
                }
                break;

            case R.id.equal:
                int item1=s1.getSelectedItemPosition();
                int item2=s2.getSelectedItemPosition();
                double value1=Double.parseDouble(e1.getText().toString());
                double result=evaluate(item1,item2,value1);
                e2.setText(result+"");
                break;
        }
    }

    public double evaluate(int item1,int item2,double value)
    {
        double temp=0.0;
        if(item1==item2)
            return value;
        else
        {
            switch (item1)
            {
                case 0:
                    temp=ca.sqMilliToMeter(value);
                    break;
                case 1:
                    temp=ca.sqCentiToMeter(value);
                    break;
                case 2:
                    temp=value;
                    break;
                case 3:
                    temp=ca.sqKiloToMeter(value);
                    break;
                case 4:
                    temp=ca.AcreToMeter(value);
                    break;
                case 5:
                    temp=ca.HectareToMeter(value);
                    break;
            }

            switch (item2)
            {
                case 0:
                    temp= ca.sqMeterToMilli(temp);
                    break;
                case 1:
                    temp= ca.sqMeterToCenti(temp);
                    break;
                case 3:
                    temp= ca.sqMeterToKilo(temp);
                    break;
                case 4:
                    temp= ca.sqMeterToAcre(temp);
                    break;
                case 5:
                    temp= ca.sqMeterToHectare(temp);
                    break;
            }
            return temp;
        }
    }
}
