package com.example.areejdarweesh.projectone.Math;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.example.areejdarweesh.projectone.DFA.DFA;
import com.example.areejdarweesh.projectone.DFA.TransitionTable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Areej darweesh on 4/10/2019.
 */

public class Analyse {
    String []var=new String[100];
    int os[]=new int[100];
    int v=0;
    public int Get_var_num()
    {
        return v;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Eqution analyse(String eq)
    {
        char ch;
        int ok=0;
        String oss="";
        DFA dfa=getEquationAutomata();
        String temp="";
        for(int i=0;i<eq.length();i++){
            ch=eq.charAt(i);
            if(!(ch==')' || ch=='(')){
                temp+=ch;
            }
        }
        if(dfa.matches(temp)==-1){
           // System.out.println("ERROR this not an equation");
            Log.e("sss ","ERROR this not an equation");
            return null;
        }
        for(int i=0;i<eq.length();i++)
        {
            ch=eq.charAt(i);
            if(!Character.isDigit(ch) && Eqution.IsOperation(ch)==-1 && ch!='^' && ch!='(' && ch!=')' && ch!='.')
            {
                var[v]=ch+"";
                while (i+1<eq.length() && Eqution.IsOperation(eq.charAt(i+1))==-1 && eq.charAt(i+1)!='^')
                {
                    var[v]+=eq.charAt(i+1);
                    i++;
                }
                i++;
                if(i+1<eq.length() && eq.charAt(i)=='^')
                {
                    oss+=eq.charAt(i+1);
                    i++;
                    while (i+1<eq.length() && Character.isDigit(eq.charAt(i+1)))
                    {
                        oss+=eq.charAt(i+1);
                        i++;
                    }
                    os[v]=Integer.parseInt(oss);
                    oss="";
                }
                else
                {
                    os[v]=1;
                }
                ok=0;
                for(int j=v-1;j>=0;j--)
                {
                    if(var[j].equals(var[v]))
                    {
                        if(os[v]>os[j])
                            os[j]=os[v];
                        ok=1;
                    }
                }
                if(ok==0) {
                    v++;
                    ch = ' ';
                }
            }
        }
        ok=0;
        if(v==1)
        {
            if(os[0]==1)
            {
                Eqution eqution=new D_one();
                return eqution;
            }
            else if(os[0]==2)
            {
                Eqution eqution=new D_two();
                return eqution;
            }
            else if(os[0]==3)
            {
                Eqution eqution=new D_three();
                return eqution;
            }
            else if (os[0]==4)
            {
                Eqution eqution=new D_four();
                return eqution;
            }
        }
        else
        {
            for(int i=0;i<v;i++)
            {
                if(os[i]>1) {
                    ok = 1;
                    break;
                }
            }
            if(ok==0)
            {
                Eqution eqution=new MultiVar();
                // System.out.println("Multi Variable");
                return eqution;
            }
        }

        return null;


    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public DFA getEquationAutomata(){
        TransitionTable transitionFunction = new TransitionTable();


        transitionFunction.setTransition(0, 1, "0123456789");
        transitionFunction.setTransition(0, 4,"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" );
        transitionFunction.setTransition(0, 0,"-\n\t " );

        transitionFunction.setTransition(1, 1,"0123456789" );
        transitionFunction.setTransition(1, 2,"." );
        transitionFunction.setTransition(1, 0,"+-*" );
        transitionFunction.setTransition(1, 4,"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" );
        transitionFunction.setTransition(1, 1,"\n\t " );

        transitionFunction.setTransition(2, 3,"0123456789" );
        transitionFunction.setTransition(2, 2,"\n\t " );

        transitionFunction.setTransition(3, 3,"0123456789" );
        transitionFunction.setTransition(3, 11,"/" );
        transitionFunction.setTransition(3, 4,"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" );
        transitionFunction.setTransition(3, 0,"+-*" );
        transitionFunction.setTransition(3, 3,"\n\t " );

        transitionFunction.setTransition(11, 1,"0123456789" );
        transitionFunction.setTransition(11, 11,"\n\t " );

        transitionFunction.setTransition(4, 4,"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_123456789" );
        transitionFunction.setTransition(4, 5,"^" );
        transitionFunction.setTransition(4, 7,"+-*" );
        transitionFunction.setTransition(4, 13,"=" );
        transitionFunction.setTransition(4, 4,"\n\t " );

        transitionFunction.setTransition(5, 6,"0123456789" );
        transitionFunction.setTransition(5, 5,"\n\t " );

        transitionFunction.setTransition(6, 6,"0123456789" );
        transitionFunction.setTransition(6, 7,"+-*" );
        transitionFunction.setTransition(6, 13,"=" );
        transitionFunction.setTransition(6, 6,"\n\t " );

        transitionFunction.setTransition(7, 4,"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" );
        transitionFunction.setTransition(7, 8,"0123456789" );
        transitionFunction.setTransition(7, 7,"\n\t " );

        transitionFunction.setTransition(8, 8,"0123456789" );
        transitionFunction.setTransition(8, 7,"+-*" );
        transitionFunction.setTransition(8, 4,"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" );
        transitionFunction.setTransition(8, 9,"." );
        transitionFunction.setTransition(8, 13,"=" );
        transitionFunction.setTransition(8, 8,"\n\t " );
        transitionFunction.setTransition(8, 8,"\n\t " );

        transitionFunction.setTransition(9, 10,"0123456789" );
        transitionFunction.setTransition(9, 9,"\n\t " );

        transitionFunction.setTransition(10, 10,"0123456789" );
        transitionFunction.setTransition(10, 7,"+-*" );
        transitionFunction.setTransition(10, 13,"=" );
        transitionFunction.setTransition(10, 12,"/" );
        transitionFunction.setTransition(10, 10,"\n\t " );
        transitionFunction.setTransition(10, 4,"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" );

        transitionFunction.setTransition(12, 8,"0123456789" );
        transitionFunction.setTransition(12, 12,"\n\t " );

        transitionFunction.setTransition(13, 14,"0123456789" );
        transitionFunction.setTransition(13, 17,"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" );
        transitionFunction.setTransition(13, 13,"-\n\t " );

        transitionFunction.setTransition(14, 15,"." );
        transitionFunction.setTransition(14, 17,"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" );
        transitionFunction.setTransition(14, 13,"+-*" );
        transitionFunction.setTransition(14, 14,"0123456789" );
        transitionFunction.setTransition(14, 14,"\n\t " );

        transitionFunction.setTransition(15, 16,"0123456789" );
        transitionFunction.setTransition(15, 15,"\n\t " );

        transitionFunction.setTransition(16, 16,"0123456789" );
        transitionFunction.setTransition(16, 13,"+-*" );
        transitionFunction.setTransition(16, 20,"/" );
        transitionFunction.setTransition(16, 16,"\n\t " );

        transitionFunction.setTransition(20, 21,"0123456789" );
        transitionFunction.setTransition(20, 20,"\n\t " );

        transitionFunction.setTransition(21, 21,"0123456789" );
        transitionFunction.setTransition(21, 15,"." );
        transitionFunction.setTransition(21, 13,"+-*" );
        transitionFunction.setTransition(21, 21,"\n\t " );

        transitionFunction.setTransition(17, 17,"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_123456789" );
        transitionFunction.setTransition(17, 18,"^" );
        transitionFunction.setTransition(17, 13,"+-*" );
        transitionFunction.setTransition(17, 17,"\n\t " );

        transitionFunction.setTransition(18, 19,"0123456789" );
        transitionFunction.setTransition(18, 18,"\n\t " );

        transitionFunction.setTransition(19, 19,"0123456789" );
        transitionFunction.setTransition(19, 13,"+-*" );
        transitionFunction.setTransition(19, 19,"\n\t " );



        Set<Integer> acceptingStates = new HashSet<>(Arrays.asList(14,17,19,16,21));
        DFA dfa = new DFA(transitionFunction, 0, acceptingStates);
        return dfa;
    }
}

