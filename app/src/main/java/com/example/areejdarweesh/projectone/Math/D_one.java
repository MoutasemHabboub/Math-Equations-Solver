package com.example.areejdarweesh.projectone.Math;

import android.util.Log;

/**
 * Created by Areej darweesh on 4/10/2019.
 */



public class D_one extends oneVariable
{
    ///aX+b=c

    /// array of x's var
    float x[]=new float[100];
    int k=0;

    /// array of constant
    float a[]=new float[100];
    int j=0;

    ///the solution of equation
    Float solution;
    //=================================Analyze ==============================
    @Override
    public void Analyze(String eq)
    {
        int oketo=0,ok1=0;
        String t="";
        char ch;
        int q=0;

        for (int i=0;i<eq.length();i++) {
            ch = eq.charAt(i);
            if (ch=='(')
            {
                ok1=0;
                for (q=i+1;q<eq.length();q++)
                {
                    if (eq.charAt(q)==')')
                        break;
                    if(!Character.isDigit(eq.charAt(q))&& IsOperation(eq.charAt(q))==-1)
                    {
                        ok1=1;
                    }
                    t+=eq.charAt(q);
                }
                i=q;
                if (ok1==1)
                {
                    Analyze(t);
                    t="";
                }
                else if(!t.isEmpty())
                {
                    t=answer(t)+"";
                }
            }
            else if (Character.isDigit(ch))
            {
                if(i>0 && eq.charAt(i-1)==')')
                    t+='*';
                t += ch;
                if(i<eq.length()-1 && eq.charAt(i+1)=='(')
                    t+='*';
                if (i<eq.length()-1 && eq.charAt(i+1)=='.')
                {

                    t+=eq.charAt(i+1);
                    i++;
                }
            }
            else if (IsOperation(ch) != -1) {
                if (ch == '=')
                {
                    oketo = 1;
                    if(!t.isEmpty()) {
                        a[j] = answer(t);
                        j++;
                        t = "";
                    }
                } else if (ch == '*' && !(Character.isDigit(eq.charAt(i + 1))) && IsOperation(eq.charAt(i + 1)) == -1) {
                    if(var=="")
                        var=eq.charAt(i + 1)+"";
                    if(!t.isEmpty())
                    {
                        if (oketo == 1) {
                            x[k] = (-1) * answer(t);
                        } else {
                            x[k] = answer(t);
                        }
                        k++;
                        i++;
                        t = "";
                    }
                    else
                    {
                        if (oketo == 1) {
                            x[k] = (-1);
                        } else {
                            x[k] = 1;
                        }
                        k++;
                        i++;
                    }

                }
                else if(((ch=='+' || ch=='-' )&& !t.isEmpty()))
                {
                    if (oketo == 1) {
                        a[j] = (-1) * answer(t);
                    } else {
                        a[j] = answer(t);
                    }
                    if(ch=='-')
                        t=ch+"";
                    else
                        t="";
                    j++;
                }
                else if (ch != '=' && Character.isDigit(eq.charAt(i + 1)) && t != "") {
                    t += ch;
                }
                else if (ch == '-') {
                    t += ch;
                }
            }   else {
                if(var=="")
                    var=ch+"";
                if ((i == 0) || (i != 0 && !Character.isDigit(eq.charAt(i - 1)) && eq.charAt(i-1)!=')') || (i!=0 && eq.charAt(i-1)==')' && t.isEmpty())) {
                    t += '1';
                    if (oketo == 1) {
                        x[k] = (-1) * answer(t);
                    } else {
                        x[k] = answer(t);
                    }
                    k++;
                    t = "";
                }
                else
                {
                    if (oketo == 1) {
                        x[k] = (-1) * answer(t);
                    } else {
                        x[k] = answer(t);
                    }
                    k++;
                    t = "";
                }
            }
        }
        if( !t.isEmpty() )
        {
            if (oketo == 1) {
                a[j] = (-1) * answer(t);
            } else {
                a[j] = answer(t);
            }
            j++;
            t="";
        }
    }
    //============================= solve ===================================
    public void solve(String eq)
    {
        float res_a=0,res_x=0;
        Analyze(eq);
        for (int i=0;i<k;i++)
            res_x+=x[i];
        for (int i=0;i<j;i++)
            res_a+=a[i];
        solution=((-1)*res_a)/res_x;
    }
    //=====================FIND POINTS (X,Y) =========================
        public float[] findPoints(String func)
        {
            Log.e("kk","kkkkk");
            Analyze(func);
            Log.e("k",k+"\nj "+j);
            float y[]=new float[4*200+1];
            float res_a=0,res_x=0;
            for(int i=0;i<j;i++)
            {
                res_a+=a[i];
            }
            for(int i=0;i<k;i++)
            {
                res_x+=x[i];
            }
            Log.e("x",res_x+"\ny "+res_a);
            int q=0;
            for (float x=-2;x<=2;x+=0.005)
            {
                y[q]=(res_x*(x))+res_a;
                q++;
            }
            return y;
        }
    ///================SHOW STEPS==================================
    public String showstips()
    {
        String steps="";
        float res_a=0,res_x=0;
        for(int i=0;i<j;i++)
            res_a+=a[i];
        for(int i=0;i<k;i++)
            res_x+=x[i];
        steps+=" 1) "+res_x+""+var+"+"+res_a+"=0";
        steps+="\n 2) "+res_x+""+var+"="+((-1)*res_a);
        steps+="\n 3) "+var+"="+((-1)*res_a)+"/"+res_x;
        steps+="\n 4) "+var+"="+solution;

        // System.out.println(steps);
        return steps;
    }
    ///==============get solution==================================
    public Object[] getSolution(){
        Float sol[]=new Float[1];
        sol[0]=solution;
        return sol;
    }
}