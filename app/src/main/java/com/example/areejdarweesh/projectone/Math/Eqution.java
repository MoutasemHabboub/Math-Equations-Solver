package com.example.areejdarweesh.projectone.Math;

/**
 * Created by Areej darweesh on 4/10/2019.
 */
public abstract class Eqution {
    static final char operation[]={'+','=','/','*','-'};
    abstract public Object[] getSolution();
    abstract public String showstips();
    ///==============================is smaller========================
    static public boolean issmaller(char c1,char c2)
    {
        if((c1=='+' || c1=='-') && (c2=='*' || c2=='/'))
            return true;
        return false;
    }
    ///===================== Answer =====================================
    static public float answer(String s)
    {
        final int in=(int)(s.length()/2);
        float opr[]=new float[in+1];
        char op[]=new char[in];
        int k=0,j=0,i,q=0;
        String temp="";
        float result=0;
        for(i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(Character.isDigit(ch))
            {
                temp+=ch;
                if(i!=s.length()-1 && !Character.isDigit(s.charAt(i+1)))
                {

                    if (s.charAt(i+1)=='.')
                    {
                        temp+=s.charAt(i+1);
                        i++;

                    }
                    else
                    {
                        opr[k]=Float.parseFloat(temp);
                        k++;
                        temp="";
                    }

                }
                else if(i==s.length()-1)
                {
                    opr[k]=Float.parseFloat(temp);
                    k++;
                    temp="";
                }

            }
            else
            {
                if ((j==0 && ch!='.')||(j==k))
                {
                    if(ch=='-' && j==k)
                        temp+=ch;
                    else{
                        op[j]=ch;
                        j++;
                    }
                }
                else
                {
                    if(issmaller(op[j-1],ch))
                    {
                        float l1=opr[k-1];
                        k--;
                        float l2=Float.parseFloat(s.charAt(i+1)+"");
                        i++;
                        switch(ch)
                        {
                            case '+':
                            {
                                result=l1+l2;
                                break;
                            }
                            case '*':
                            {
                                result=l1*l2;
                                break;
                            }
                            case '-':
                            {
                                result=l1-l2;
                                break;
                            }
                            case '/':
                            {
                                result=l1/l2;
                                break;
                            }
                        }
                        opr[k]=result;
                        k++;
                    }
                    else
                    {
                        op[j]=ch;
                        j++;
                    }


                }
            }
        }
        for(i=0;i<j;i++)
        {
            switch(op[i])
            {
                case '*':
                {
                    result=opr[q]*opr[q+1];
                    opr[q]=result;
                    for(int r=q+1;r<k-1;r++)
                    {
                        opr[r]=opr[r+1];
                    }
                    k--;

                    break;
                }
                case '+':
                {
                    result=opr[q]+opr[q+1];
                    opr[q]=result;
                    for(int r=q+1;r<k-1;r++)
                    {
                        opr[r]=opr[r+1];
                    }
                    k--;

                    break;
                }
                case '-':
                {
                    result=opr[q]-opr[q+1];
                    opr[q]=result;
                    for(int r=q+1;r<k-1;r++)
                    {
                        opr[r]=opr[r+1];
                    }
                    k--;

                    break;
                }
                case '/':
                {
                    result=opr[q]/opr[q+1];
                    opr[q]=result;
                    for(int r=q+1;r<k-1;r++)
                    {
                        opr[r]=opr[r+1];
                    }
                    k--;

                    break;
                }
            }
        }
        return opr[0];
    }
    ///=============================== IsOperation =========================
    static public int IsOperation(char ch)
    {
        for (int j=0;j<5;j++)
        {
            if(ch==operation[j])
            {
                return j;
            }

        }
        return -1;
    }

}

