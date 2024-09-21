package com.example.areejdarweesh.projectone.Math;

/**
 * Created by Areej darweesh on 4/25/2019.
 */


public class D_three extends oneVariable {
    float a=0,b=0,c=0,d=0;
    Object solution[]=new Object[3];
    float delta;
    float q;
    float p;

    /// array of x's var
    float x[]=new float[100];
    int k=0;
    /// array of constant
    float cost[]=new float[100];
    int j=0;
    /// array of x^2's var
    float x2[]=new float[100];
    int pp=0;
    /// array of x^3's var
    float x3[]=new float[100];
    int z=0;

    //================================= Analyze ==============================
    public float[] findPoints(String func) {
        Analyze(func);
        float y[] = new float[801];
        float res_a = 0, res_x = 0, res_x2 = 0, res_x3 = 0;
        for (int i = 0; i < j; i++) {
            res_a += cost[i];
        }
        for (int i = 0; i < k; i++) {
            res_x += x[i];
        }
        for (int i = 0; i < pp; i++) {
            res_x2 += x2[i];
        }
        for (int i = 0; i < z; i++) {
            res_x3 += x3[i];
        }
        int q = 0;
        for (float x = -2; x <= 2; x += 0.005) {
            y[q] = (res_x3 * (x) * (x) * (x)) + (res_x2 * (x) * (x)) + (res_x * (x)) + res_a;
            q++;
        }
        return y;
    }

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
                        cost[j] = answer(t);
                        j++;
                        t = "";
                    }
                } else if (ch == '*' && !(Character.isDigit(eq.charAt(i + 1))) && IsOperation(eq.charAt(i + 1)) == -1 ) {
                    if(var=="")
                        var=eq.charAt(i + 1)+"";
                    if(!t.isEmpty())
                    {
                        if(i<eq.length()-3 && eq.charAt(i+2)=='^' && eq.charAt(i+3)=='2')
                        {
                            if (oketo == 1) {
                                x2[pp] = (-1) * answer(t);
                            } else {
                                x2[pp] = answer(t);
                            }
                            pp++;
                            i+=3;
                            t="";
                        }
                        else if(i<eq.length()-3 && eq.charAt(i+2)=='^' && eq.charAt(i+3)=='3')
                        {
                            if (oketo == 1) {
                                x3[z] = (-1) * answer(t);
                            } else {
                                x3[z] = answer(t);
                            }
                            z++;
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
                        if(i<eq.length()-3 && eq.charAt(i+2)=='^' && eq.charAt(i+3)=='2')
                        {
                            if (oketo == 1) {
                                x2[pp] = (-1);
                            } else {
                                x2[pp] = 1;
                            }
                            pp++;
                            i+=3;
                        }
                        else if(i<eq.length()-3 && eq.charAt(i+2)=='^' && eq.charAt(i+3)=='3')
                        {
                            if (oketo == 1) {
                                x3[z] = (-1);
                            } else {
                                x3[z] = 1;
                            }
                            z++;
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
                        cost[j] = (-1) * answer(t);
                    } else {
                        cost[j] = answer(t);
                    }
                    t="";
                    j++;
                }
                else if ((ch != '=' && Character.isDigit(eq.charAt(i + 1)) && !t.isEmpty())|| ch=='-') {
                    t += ch;
                }
            }
            else {
                if(var=="")
                    var=ch+"";
                if (eq.charAt(i) == '^' && eq.charAt(i + 1) == '2') {
                    x2[pp]=answer(t);
                    pp++;
                    t="";
                    i++;
                }
                else if (eq.charAt(i) == '^' && eq.charAt(i + 1) == '3') {
                    x3[z]=answer(t);
                    z++;
                    t="";
                    i++;
                }
                else if ((i == 0) || (i != 0 && !Character.isDigit(eq.charAt(i - 1)) && eq.charAt(i-1)!=')') || (i!=0 && eq.charAt(i-1)==')' && t.isEmpty())){
                    t += '1';
                    if(i<eq.length()-2 && eq.charAt(i+1)=='^' && eq.charAt(i+2)=='2')
                    {
                        if (oketo == 1) {
                            x2[pp] = (-1) * answer(t);
                        } else {
                            x2[pp] = answer(t);
                        }
                        pp++;
                        i+=2;
                        t="";
                    }
                    else if(i<eq.length()-2 && eq.charAt(i+1)=='^' && eq.charAt(i+2)=='3')
                    {
                        if (oketo == 1) {
                            x3[z] = (-1) * answer(t);
                        } else {
                            x3[z] = answer(t);
                        }
                        z++;
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
                            x2[pp] = (-1) * answer(t);
                        } else {
                            x2[pp] = answer(t);
                        }
                        pp++;
                        i+=2;
                        t="";
                    }
                    else  if(i<eq.length()-2 && eq.charAt(i+1)=='^' && eq.charAt(i+2)=='3')
                    {
                        if (oketo == 1) {
                            x3[z] = (-1) * answer(t);
                        } else {
                            x3[z] = answer(t);
                        }
                        z++;
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
            }
        }
        if( !t.isEmpty() )
        {
            if (oketo == 1) {
                cost[j] = (-1) * answer(t);
            } else {
                cost[j] = answer(t);
            }
            j++;
        }
        for(int i=0;i<j;i++)
            c+=cost[i];
        for(int i=0;i<k;i++)
            b+=x[i];
        for(int i=0;i<pp;i++)
            a+=x2[i];
        for(int i=0;i<z;i++)
            d+=x3[i];
        this.d=d;
        if(d!=1){
            this.a=a/d;
            this.b=b/d;
            this.c=c/d;
        }
        else{
            this.a=a;
            this.b=b;
            this.c=c;

        }

        p=-a*a/3+b;
        this.q=c+(2*a*a*a/27)-(b*a/3);
        delta=(this.q*this.q/4)+(p*p*p/27);

    }
    /// ======================= solve =================================
    @Override
    public void solve(String eq){
        //      System.out.println("p= "+p+" q= "+q+" delta = "+delta);
        Analyze(eq);
        if(delta==0){
            float alpha=(float) Math.cbrt((-q/2));
            solution[0]=2*alpha-a/3;
            solution[1]=-alpha-a/3;
            solution[2]=-alpha-a/3; }
        else if(delta>0)
        {
            float d1= (float) Math.sqrt(delta);
            float a1= (float) Math.cbrt((-q/2)+d1);
            float b1= (float) Math.cbrt((-q/2)-d1);
            System.out.println(d1+" "+a1+" "+b1);
            solution[0]=(float)a1+b1;

            solution[1]= new Complex(-0.5*(a1+b1)-(a/3),(Math.sqrt(3)/2)*(a1-b1));
            solution[2]=  new Complex(-0.5*(a1+b1)-(a/3),(Math.sqrt(3)/-2)*(a1-b1));

        }
        else {
            double d1=(Math.pow((-p/3),1.5));
            double d2=q/d1;
            double theta=  1/(Math.cos(d2));
//System.out.println("d1="+d1+"d2= "+d2+ "  theata ="+theta);
            for (int i=0;i<3;i++){
                solution[i]= (float)( (2*Math.sqrt(-p/3)*Math.cos((theta+2*3.14*i)/3))+a/3);
            }

        }
    }
    ///============================ Show Steps ============================
    @Override
    public String showstips() {
        String  step="";
        String k;
        if(var.equals("X")||var.equals("x"))
            k="y";
        else
            k="x";
        step+="-  a= "+a+" ,b= "+b+" ,c= "+c+"\n";
        step+="- "+var+"="+k+"-a/3"+"\n";
        step+="- "+var+"="+k+op(-a/3)+(-a/3)+"\n";

        step+="- "+k+"^3"+op(p)+p+k+op(q)+q+"=0\n";
        step+="1) delta=q^2/4+p^3/27="+delta+"\n";
        if(delta==0){
            step+="2) alpha=sqrt3-q/2 = "+Math.cbrt(-q/2)+"\n";
            for (int i =0;i<3;i++)
                step+=var+i+" = "+k+i+"-a/3 = 2*alpha-a/3 = "+solution[i]+"\n";
        }
        else if (delta>0){
            step+="2) alpha = sqrt3(-q/2+sqrt(delta))\n";
            step+="3) beta = sqrt3(-q/2-sqrt(delta))\n";
            step+=var+"1 "+k+"1-a/3"+"=alpha+beta-a/3 = "+solution[0]+"\n";
            step+=var+="2  "+k+"2-a/3 = -1/2(alpha+beta)+i*sqrt(3)/2(alpha-beta)-a/3 = "+solution[1]+"/n";
            step+=var+="3  "+k+"2-a/3 = -1/2(alpha+beta)+i*sqrt(3)/2(alpha-beta)-a/3 = "+solution[2]+"/n";
        }
        else {
            for (int i=0;i<3;i++){
                step+="2) theata = 1/cos(q/(-p/3)^3/2)/n";
                step+=var+i+" = "+k+i+"-a/3 = 2*sqrt(-p/3)*cos(theata+2*3.14"+i+"/3)-a/3 = "+solution[i]+"\n";
            }
        }
        return step;
    }
    ///============================ Get Solution ============================
    public Object[] getSolution(){
        return solution;
    }

    String op(float d){
        if (d>0)
            return "+";
        else
            return "";
    }
}
