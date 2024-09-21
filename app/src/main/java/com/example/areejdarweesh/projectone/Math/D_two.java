package com.example.areejdarweesh.projectone.Math;

/**
 * Created by Areej darweesh on 4/10/2019.
 */
        import java.math.*;
        import java.security.PublicKey;

public class D_two extends oneVariable {
    ///aX+b=c
    float cons[]=new float[3];
    //const [0] = a , cons [1]=b , cons [2]=c
    int ok=-1;
    /// array of x's var
    float x[]=new float[100];
    int k=0;
    /// array of constant
    float a[]=new float[100];
    int j=0;
    /// array of x^2's var
    float xQ[]=new float[100];
    int p=0;
    ///the solution of Quadricate equation
    Float solution1,solution2;
    //var for solution
    float res_a=0,res_x=0,res_xq=0,delta=0;
    Complex complex[]=new Complex[2];


    public float[] getCons() {
        return cons;
    }

    public void setCons(float[] cons) {
        this.cons = cons;
    }

    //=================================Analyze ==============================

    public void Analyze(String eq)
    {
        int oketo=0,ok1=0;
        String t="";
        char ch;
        int q=0;

        for (int i=0;i<eq.length();i++) {
            ch = eq.charAt(i);
            if (ch=='(')
            {ok1=0;
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
            else if (Character.isDigit(ch)) {
                if(i>0 && eq.charAt(i-1)==')')
                    t+='*';
                t += ch;
                if(i<eq.length()-1 && eq.charAt(i+1)=='(')
                    t+='*';
                if (i < eq.length() - 1 && eq.charAt(i + 1) == '.') {

                    t += eq.charAt(i + 1);
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
                } else if (ch == '*' && !(Character.isDigit(eq.charAt(i + 1))) && IsOperation(eq.charAt(i + 1)) == -1 ) {
                    if(var=="")
                        var=eq.charAt(i + 1)+"";
                    if(!t.isEmpty())
                    {
                        if(i<eq.length()-2 && eq.charAt(i+2)=='^')
                        {
                            if (oketo == 1) {
                                xQ[p] = (-1) * answer(t);
                            } else {
                                xQ[p] = answer(t);
                            }
                            p++;
                            i+=3;
                            t="";
                        }
                        else
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
                    }
                    else{
                        if(i<eq.length()-2 && eq.charAt(i+2)=='^')
                        {
                            if (oketo == 1) {
                                xQ[p] = (-1);
                            } else {
                                xQ[p] = 1;
                            }
                            p++;
                            i+=3;
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

                }
                else if(((ch=='+')&& !t.isEmpty()))
                {
                    if (oketo == 1) {
                        a[j] = (-1) * answer(t);
                    } else {
                        a[j] = answer(t);
                    }
                    t="";
                    j++;
                }
                else if ((ch != '=' && Character.isDigit(eq.charAt(i + 1)) && !t.isEmpty())|| ch=='-') {
                    t += ch;
                } /*else if (IsOperation(eq.charAt(i + 1)) != -1) {
                    i++;
                } */
            }
            else {
                if(var=="")
                    var=ch+"";
                if (eq.charAt(i) == '^' && eq.charAt(i + 1) == '2') {

                    xQ[p]=answer(t);
                    p++;
                    t="";
                    i++;
                }
                else if ((i == 0) || (i != 0 && !Character.isDigit(eq.charAt(i - 1)) && eq.charAt(i-1)!=')') || (i!=0 && eq.charAt(i-1)==')' && t.isEmpty())){
                    t += '1';
                    if(i<eq.length()-2 && eq.charAt(i+1)=='^' && eq.charAt(i+2)=='2')
                    {
                        if (oketo == 1) {
                            xQ[p] = (-1) * answer(t);
                        } else {
                            xQ[p] = answer(t);
                        }
                        p++;
                        i+=2;
                        t="";
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
                else
                {
                    if(i<eq.length()-2 && eq.charAt(i+1)=='^' && eq.charAt(i+2)=='2')
                    {
                        if (oketo == 1) {
                            xQ[p] = (-1) * answer(t);
                        } else {
                            xQ[p] = answer(t);
                        }
                        p++;
                        i+=2;
                        t="";
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
              /*  else if (eq.charAt(i+1)=='^')
                {
                    if(t.isEmpty())
                        t+='1';
                    if (oketo == 1) {
                        xQ[p] = (-1) * answer(t);
                    } else {
                        xQ[p] = answer(t);
                    }
                    i+=2;
                    p++;
                    t = "";
                }*/
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
        }
    }
    //============================= solve ===================================
    public void solve(String eq)
    {

        Analyze(eq);
        for (int i=0;i<k;i++)
            res_x+=x[i];
        for (int i=0;i<j;i++)
            res_a+=a[i];
        for (int i=0;i<p;i++)
            res_xq+=xQ[i];
        delta=(res_x*res_x)-4*res_xq*res_a;
        if (delta==0)
        {
            if(res_x==0)
                solution1=solution2=0f;
            else
                solution1=solution2=-res_x/(2*res_xq);
        }
        else if (delta>0)
        {
            if((-res_x)+(float)Math.sqrt(delta)==0)
            {
                solution1=(float)0;
            }
            else{
                solution1=((-res_x)+(float)Math.sqrt(delta))/(2*res_xq);
            }
            if(((-res_x)-(float)Math.sqrt(delta))==0)
            {
                solution2=(float)0;
            }
            else {
                solution2=((-res_x)-(float)Math.sqrt(delta))/(2*res_xq);
            }

        }
        else {
            complex[0]=new Complex(-res_x/(2*res_xq),Math.sqrt(-delta)/(2*res_xq));
            complex[1]=new Complex(-res_x/(2*res_xq),(-1)*(Math.sqrt(-delta)/(2*res_xq)));
        }
    }
    //===========================Show Steps solution ========================
    public void Show(String eq)
    {
        Analyze(eq);
        for (int i=0;i<k;i++)
            res_x+=x[i];
        for (int i=0;i<j;i++)
            res_a+=a[i];
        for (int i=0;i<p;i++)
            res_xq+=xQ[i];

        for (int i=0;i<p;i++)
        {
            if(xQ[i]<0)
            {
                System.out.print(xQ[i]+"X^2+");
            }
            else
            {
                System.out.print("+"+xQ[i]+"X^2");
            }
        }
        while (p>=0)
        {
            if (res_xq<0)
            {
                System.out.print(-res_xq+"X^2");
            }
        }

        if(res_x<0)
        {
            System.out.print(-res_xq+"X^2");
        }
    }
    ///==============================FIND POINTS (X,Y)============
    public float[] findPoints(String func)
    {
        Analyze(func);
        float y[]=new float[801];
        float res_a=0,res_x=0,res_x2=0;
        for(int i=0;i<j;i++)
        {
            res_a+=a[i];
        }
        for(int i=0;i<k;i++)
        {
            res_x+=x[i];
        }
        for(int i=0;i<p;i++)
        {
            res_x2+=xQ[i];
        }
        int q=0;
        for (float x=-2;x<=2;x+=0.005)
        {
            y[q]=(res_x2*(x)*(x))+(res_x*(x))+res_a;
            q++;
        }
        return y;
    }
    ///================SHOW STEPS==================================
    public String showstips()
    {
        String steps="";
        steps+=" 1) "+res_xq+""+var+"^2 "+"+"+res_x+""+var+"+"+res_a+"=0";
        steps+="\n 2) delta=b^2-(4*a*c)";
        steps+="\n  a="+res_xq+" ,b="+res_x+" ,c="+res_a;
        steps+="\n 3) delta="+(res_x*res_x)+"-"+(4*res_xq*res_a);
        steps+="\n 4) delta="+delta;
        if(delta>0)
        {
            steps+="\n 5) delta>0 => there is tow solutions .";
            steps+="\n 6) x1=(-b+sqrt(delta))/(2a)";
            steps+="\n    x1=("+((-1)*res_x)+"+"+Math.sqrt(delta)+")/(2*"+res_xq+")";
            steps+="\n    x1="+(((-1)*res_x)+Math.sqrt(delta))+"/"+(2*res_xq);
            steps+="\n    x1="+solution1;
            steps+="\n\n 7) x2=(-b-sqrt(delta))/(2a)";
            steps+="\n    x2=("+((-1)*res_x)+"-"+Math.sqrt(delta)+")/(2*"+res_xq+")";
            steps+="\n    x2="+(((-1)*res_x)-Math.sqrt(delta))+"/"+(2*res_xq);
            steps+="\n    x2="+solution2;
        }else if(delta==0)
        {
            steps+="\n 5) delta=0 => there is one solution .";
            steps+="\n 6) x=(-b)/(2a)";
            steps+="\n    x=("+((-1)*res_x)+")/(2*"+res_xq+")";
            steps+="\n    x="+((-1)*res_x)+"/"+(2*res_xq);
            steps+="\n    x="+solution1;
        }
        else
        {
            Complex complex1=new Complex(-res_x/(2*res_xq),Math.sqrt(-delta)/(2*res_xq));
            Complex complex2=new Complex(-res_x/(2*res_xq),(-1)*(Math.sqrt(-delta)/(2*res_xq)));
            steps+="\n 5) delta<0 => ther is no real solutions .";
            steps+="\n but there is two imagin solutions are : ";
            steps+="\n 6) x1=(-b+sqrt(-delta)i)/(2a)";
            steps+="\n    x1=("+((-1)*res_x)+"+"+Math.sqrt(-delta)+"i)/(2*"+res_xq+")";
            steps+="\n    x1="+complex1.toString();
            steps+="\n\n 7) x2=(-b-sqrt(-delta)i)/(2a)";
            steps+="\n    x2=("+((-1)*res_x)+"-"+Math.sqrt(-delta)+"i)/(2*"+res_xq+")";
            steps+="\n    x2="+complex2.toString();
        }
        return steps;

    }
    ///==============get solution==================================
    public Object[] getSolution(){
        if(delta>=0)
        {
            Float sol[]=new Float[2];
            sol[0]=solution1;
            sol[1]=solution2;
            return sol;
        }
        else
        {
            return complex;
        }
    }


}


