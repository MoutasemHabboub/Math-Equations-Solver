package com.example.areejdarweesh.projectone.Math;

/**
 * Created by moten on 7/4/2019.
 */



import java.util.ArrayList;
import java.util.Scanner;

public class dev {


    public ArrayList derv (String eq)

    {
        ///////////analyse
        ArrayList<Character> C1 = new ArrayList<Character>();
        ArrayList<String> C2 = new ArrayList<String>();
        int de=0;
        try

        {

            int j = 0;
            if(eq.charAt(0)!='-'&& eq.charAt(0)!='+')
            {
                C1.add('+');
            }
            if(Character.isDigit(eq.charAt(0)))
            {
                if(eq.charAt(1)=='-'|| eq.charAt(1)=='+')
                    de=2;
            }

            for (int i = de; i < eq.length(); i += j) {
                char ch = eq.charAt(i);

                if (Character.isDigit(ch)/*&&eq.charAt( i+1)!='+'&&eq.charAt(i+ 1)!='-'*/) {
                    if(i+1 <eq.length()/*&&!Character.isDigit(eq.charAt(0))*/){
                        if (eq.charAt(i + 1) == 'x') {
                            char chx = eq.charAt(i + 1);
                            C1.add(ch);
                            C1.add(chx);
                            j = 2;}

                        if(i+2 <eq.length()){
                            char ch3 = eq.charAt(i + 2);
                            if (ch3 == '^') {
                                if(eq.charAt(i+3)=='-') {

                                    C1.add(eq.charAt(i + 2));
                                    C1.add(eq.charAt(i + 3));
                                    C1.add(eq.charAt(i + 4));
                                    j = 5;
                                }
                                else{
                                    C1.add(eq.charAt(i + 2));
                                    C1.add('+');
                                    C1.add(eq.charAt(i + 3));
                                    j = 4;
                                }
                            }
                            else {
                                C1.add('^');
                                C1.add('+');
                                C1.add('1');
                                j = 2;
                            }}

                    } else {
                        C1.add('0');
                        //j=1;
                        // C1.add('0');
                    }
                }/*else {
                        C1.add('0');
                        j=1;
                        // C1.add('0');
                    }*/

                else if (eq.charAt(i) == 'x') {
                    C1.add('1');
                    char chx = eq.charAt(i);
                    C1.add(chx);
                    j = 1;
                    //char ch3 = eq.charAt(i + 1);
                    if(i+2 <eq.length()){
                        if (eq.charAt(i + 1) == '^') {
                            if(eq.charAt(i+2)=='-') {

                                C1.add(eq.charAt(i + 1));
                                C1.add(eq.charAt(i + 2));
                                C1.add(eq.charAt(i + 3));
                                j = 4;
                            }
                            else{
                                C1.add(eq.charAt(i + 1));
                                C1.add('+');
                                C1.add(eq.charAt(i + 2));
                                j = 3;
                            }
                        }
                        else {
                            C1.add('^');
                            C1.add('+');
                            C1.add('1');
                            j = 1;
                        }}

                }

                if (ch == '-' || ch == '+') {
                    if(i+2 <eq.length())
                    {
                        if(Character.isDigit(eq.charAt(i+1))){
                            if(eq.charAt(i+2)=='-'|| eq.charAt(i+2)=='+')
                            {
                                j=2;
                            }
                            else {C1.add(ch);
                                j = 1;}
                        }else {C1.add(ch);
                            j = 1;}
                    }
                    else {C1.add(ch);
                        j = 1;}
                }
                // System.out.println("11112222");

            }
            int k=0;
            for (int i = 0; i < C1.size(); i +=k)
            {
                if(C1.get(i)!='-' && C1.get(i)!='+') {
                    if(C1.get(i)=='0')
                    {int zer = 0;
                        String c6 = "" + zer;
                        C2.add(c6);
                        k = 1;}

                    else{

                        int l = Integer.parseInt(""+C1.get(i))*Integer.parseInt(""+C1.get(i+4));
                        String c1 = "" + l;
                        C2.add(c1);
                        int ll=0;
                        if(C1.get(i+3)=='-')
                            ll = Integer.parseInt(""+C1.get(i+4)) + 1;
                        else if(C1.get(i+3)=='+')
                            ll = Integer.parseInt(""+C1.get(i+4)) - 1;

                        if (ll > 0) {

                            String c2 = "" + C1.get(i + 1);
                            C2.add(c2);
                            String c3 = "" + C1.get(i + 2);
                            C2.add(c3);
                            String c4 = "" + C1.get(i + 3);
                            C2.add(c4);

                            String c5 = "" + ll;
                            C2.add(c5);
                        }
                        k=5;}
                }
                else {
                    // System.out.println("55555555555");
                    if(i+4<C1.size()) {
                        String c5 =dot(C1.get(i ),C1.get(i + 4));
                        C2.add(c5);
                        k = 1;
                    }
                    else{
                        String c5 ="" + C1.get(i);
                        C2.add(c5);
                        k = 1;
                    }
                }



            }


        } catch (Exception e) {
            System.out.println(e);
        }
        return C2;
    }



    public   String dot(char a,char b)
    {
        char c='-';
        if(a=='+'&&b=='-')
            c='-';

        if(a=='+'&&b=='+')
            c='+';

        if(a=='-'&&b=='+')
            c='-';

        if(a=='-'&&b=='-')
            c='+';
        String D="" +c;
        return D ;


    }

}