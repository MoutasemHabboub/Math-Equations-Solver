package com.example.areejdarweesh.projectone.Math;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;

import com.example.areejdarweesh.projectone.Math.Analyse;
import com.example.areejdarweesh.projectone.Math.Complex;
import com.example.areejdarweesh.projectone.Math.Eqution;
import com.example.areejdarweesh.projectone.Math.oneVariable;

public class D_four extends oneVariable {
    float a=0,b=0,c=0,d=0,e=0,p=0,q=0,r=0,m=0,l=0,k1=0;
    Object solution[]=new Object[4];
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
    /// array of x^4's var
    int z=0;
    float x4[]=new float[100];
    int qq=0;
    String temp3d,s1,s2;
    @Override
    public void Analyze(String eq) {
        int oketo=0,ok1=0;
        String t="";
        char ch;
        int q1=0;
        for (int i=0;i<eq.length();i++) {
            ch = eq.charAt(i);
            if (ch=='(')
            {ok1=0;
                for (q1=i+1;q1<eq.length();q1++)
                {
                    if (eq.charAt(q1)==')')
                        break;
                    if(!Character.isDigit(eq.charAt(q1))&& IsOperation(eq.charAt(q1))==-1)
                    {
                        ok1=1;
                    }
                    t+=eq.charAt(q1);
                }
                i=q1;
                if (ok1==1)
                {
                    Analyze(t);
                    t="";
                }
                else
                {
                    t=answer(t)+"";
                }
            }
            else if (Character.isDigit(ch)) {

                t += ch;
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
                    else if(i<eq.length()-3 && eq.charAt(i+2)=='^' && eq.charAt(i+3)=='4')
                    {
                        if (oketo == 1) {
                            x4[z] = (-1) * answer(t);
                        } else {
                            x4[z] = answer(t);
                        }
                        qq++;
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
                else if (eq.charAt(i) == '^' && eq.charAt(i + 1) == '4') {
                    x4[z]=answer(t);
                    qq++;
                    t="";
                    i++;
                }
                else if ((i == 0) || (i != 0 && !Character.isDigit(eq.charAt(i - 1)))){
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
                    else if(i<eq.length()-2 && eq.charAt(i+1)=='^' && eq.charAt(i+2)=='4')
                    {
                        if (oketo == 1) {
                            x4[z] = (-1) * answer(t);
                        } else {
                            x4[z] = answer(t);
                        }
                        qq++;
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
                    else  if(i<eq.length()-2 && eq.charAt(i+1)=='^' && eq.charAt(i+2)=='4')
                    {
                        if (oketo == 1) {
                            x4[z] = (-1) * answer(t);
                        } else {
                            x4[z] = answer(t);
                        }
                        qq++;
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
            d+=cost[i];
        for(int i=0;i<k;i++)
            c+=x[i];
        for(int i=0;i<pp;i++)
            b+=x2[i];
        for(int i=0;i<z;i++)
            a+=x3[i];
        for(int i=0;i<qq;i++)
            e+=x4[i];
        this.d=d;
        if(e!=1){
            this.a=a/e;
            this.b=b/e;
            this.c=c/e;
            this.d=d/e;
        }
        else{
            this.a=a;
            this.b=b;
            this.c=c;
            this.d=d;
        }
        System.out.println("a= "+a+" b= "+b+" c= "+c+" d= "+d+" e= "+e);
        e=1;
        p=b-(3*a*a/8);
        q= (c-(a*b/2)+(a*a*a/8));
        r=d-(a*c/4)+(a*a*b/16)-(a*a*a*a*3/256);
        System.out.println(" r= "+r+" q= "+q+" p= "+p);
    }

    @Override
    public void solve(String eq) {
        System.out.println("koko2");
        Analyze(eq);

        double tempb=(p*p)-(4*r),tempc=-q*q,tempa=2*p;
        String ta="",tb="",tc="";
        if(tempa>=0)
            ta="+";
        if (tempb>=0)
            tb="+";
        if (tempc>=0)
            tc="+";

        temp3d="x^3"+ta+tempa+"x^2"+tb+tempb+"x"+tc+tempc+"=0";
        //  String temp3d  ="x^3-1.8125x^2-26.265625x-20.75=0";
        System.out.println(temp3d);
        Analyse analyse=new Analyse();
        Eqution eqution=analyse.analyse(temp3d);
        oneVariable oneVariable = (oneVariable) eqution;
        oneVariable.solve(temp3d);
        Object o[] = oneVariable.getSolution();
        for (int i = 0; i < o.length; i++){
            if(o[i].getClass()!= Complex.class){
                if((float)o[i]>0){
                    k1= (float) o[i];
                    break; } }
        }
        k1= (float) Math.sqrt(k1);

        System.out.println("k1="+k1);
        l= (float) (0.5*((p+k1*k1)-(q/k1)));
        m= (float) (0.5*(-p+(k1*k1)+(q/k1)));
        String tm="",tk="",tl="";
        String tm1="",tk1="",tl1="";
        if(k1>=0){
            tk="+";

        }
        else tk1="+";
        if(m>=0){
            tm="+";

        }
        else tm1="+";
        if(l>=0){
            tl="+";

        }
        else tl1="+";

        s1="y^2"+tk+k1+"y"+tl+l+"=0";
        s2="y^2"+tk1+(-k1)+"y"+tm+m+"=0";

        System.out.println(m);
        System.out.println(l);
        System.out.println(s1);
        System.out.println(s2);
        Analyse analyse1=new Analyse();
        Eqution eqution1=analyse1.analyse(s1);
        oneVariable oneVariable1 = (oneVariable) eqution1;
        oneVariable1.solve(s1);
        Object o1[] = oneVariable1.getSolution();
        for (int i = 0; i < o1.length; i++){
            System.out.println(o1[i].toString()+"ll");
            if(o1[i].getClass()==Complex.class){
                Complex c1=(Complex)o1[i];
                c1.plus(new Complex((-a/4),0));
                solution[i]=c1;
            }
            else {solution[i]=(float)o1[i]-(a/4);}}
        s1=oneVariable1.showstips();
        Analyse analyse2=new Analyse();
        Eqution  eqution2=analyse2.analyse(s2);
        oneVariable oneVariable2= (oneVariable) eqution2;
        oneVariable2.solve(s2);
        Object o2[] = oneVariable2.getSolution();
        for (int i = 0; i < o2.length; i++){System.out.println(o2[i].toString()+"j");
            if(o2[i].getClass()==Complex.class){
                Complex c1=(Complex)o2[i];
                c1.plus(new Complex(-a/4,0));
                solution[i+2]=c1;
            }
            else {
                solution[i+2]=(float)o2[i]-(a/4);}
        }
        s2=oneVariable2.showstips();
    }

    @Override
    public Object[] getSolution() {
        return solution;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public String showstips() {
        String stip=
                "\n" +
                        "ax3 + b x2 +c x+ d = 0 + x4\n" +
                        "نعوض :x=y-a/4\n" +
                        "فتصبح المعادلة من الشكل التالي : \n" +
                        "Y4 + p y2 +q y + r= 0 (2)\n" +
                        "و هي معادلة من الدرجة الرابعة في y  و خالية من الحد الذي " +
                        "يحوي y3  حيث :\n" +
                        "P=b-3a2/8   ,   q=c-ab/2 + a3/8     ,   r=d-ac/4 + a2b /16 – 3a4/256 \n" +
                        "نفرق الطرف اليساري للمعادلة (2) الى جداء كثيري حدود من الدرجة الثانية من الشكل :\n" +
                        "Y4 + p y2 +q y + r=(y2 + ky+L)(y2 -ky+m)               ……………..(3)\n" +
                        "يتم تعيين m,k,L  من المعادلات التالية الناتجة عن فك الأقواس و المطابقة :\n" +
                        "4) L+m-k2 =p      , 5)k(m-L)=q         , 6)L m=r\n" +
                        "و يتم حل هذه المعادلات بتعيين m,L من المعادلات 4و5 و التعويض في 6 كما يلي : من المعادلتين 4و5 نجد :\n" +
                        "L=1/2(p+k2-q/k)\n" +
                        "M=1/2(p+k2+q/k)\n" +
                        "و نعوض في المعادلة 6 فنجد :\n" +
                        "(p+k2)2 – q2/k2=4r\n" +
                        "و نفرض ان k2=z  فنحصل على المعادلة التالية :\n" +
                        "Z3+2pz2+(p2-4r)z+q2=0\n" +
                        "و هي المعادلة التكعيبية المساعدة :\n" +
                        "اذا كانت المعاملات المعطاة حقيقية و بالتالي للمعادلة السابقة حتما جذر واحد موجب على الاقل Z  و من هذا الجذر الموجب نحصل على K=√z   و منه نحصل على قيمة M,L  و بالتعويض في المعادلة (3) ينتج لدينا حل المعادلتين التاليتين و نحصل على الجذور الاربعة للمعادلة .\n" +
                        "y2 + ky+L=0                                                         y2 -ky+m= 0                   \n"

                ;
        String k;
        if(var.equals("X")||var.equals("x"))
            k="y";
        else
            k="x";
        String  step="";
        step+=var+"="+k+"-"+a/4+"\n";
        step+="which transfers the eqution to this form\n";
        step+="Y^4 + p y^2 +q y + r= ";
        step+="p=b-3*a/8="+p+"\n";
        step+="q=c- a*b/2 -a^3/8="+q+"\n";
        step+="r=d-ac/4 + a^2b /16 – 3a^4/256 "+r+"\n";
        step+="then we transfer the  eqution into multiply two eequtions\n Y^4 + p y^2 +q y + r=(y^2 + ky+L)(y^2 -ky+m)               ……………..(3)";
        step+="to get m , l and k we get the three equtions from the eqution above \n";
        step+="4) L+m-k^2 =p      , 5)k(m-L)=q         , 6)L m=r\n";
        step+="from number 4 and 5 we get that m and l is equal to\n" +
                "L=1/2(p+k2-q/k)\n" +
                "M=1/2(p+k2+q/k)\n ";
        step+="then we put we have get in eqution number 6 \n(p+k^2)^2 – q^2/k^2=4r\n";
        step+="then we replace k^2 whit z to make our eqution be like this \n" +
                "Z3+2pz2+(p2-4r)z+q2=0\n"+temp3d+"\nthen we solve it";

        Analyse analyse=new Analyse();
        Eqution eqution=analyse.analyse(temp3d);
        oneVariable oneVariable = (oneVariable) eqution;
        oneVariable.solve(temp3d);

        step+=oneVariable.showstips();
        step+=s1;
        step+=s2;
        step+="\n y=x-a/4\n";
        for (int i=0;i<solution.length;i++){
            step+=("x"+(i+1)+"="+solution[i].toString())+"\n";
        }
        return step;
    }
    String lern (){
        String step="";

        step+="بفرض لدينا المعادلة التكعيبية التالية :\n" +
                "y3 + a y2 +b y + c = 0\n" +
                "نستبدل المجهول y  بمجهول جديد x  مرتبط مع y  بالعلاقة :\n" +
                "y=x-a/3\n" +
                "فتصبح المعادلة من الشكل :\n" +
                "X3 + p x +q=0\n" +
                "و هي العادلة المخفضة ذات المعاملات الحقيقية :\n" +
                "ان للمعادلة التكعيبية المخفضة ذات المعاملات الحقيقية , جذر جقيقي على الاقل , و الجذرين الباقيين اما حقيقيين او عقديين تبعا لاشارة     = q2/4 + p3/27∆  و نميز ثلاث حالات :\n" +
                "الحالة الاولى  0=∆ :\n" +
                "عندها تكون للمعادلة التكعيبية ثلاثة جذور حقيقية منها جذران متساويان :\n" +
                "α= 3√-q/2\n" +
                "x1=2 α,x2=x3=- α\n" +
                "الحالة الثانية  ∆ 0< يوجد للمعادلة جذر حقيقي واحد هو  :\n" +
                "X1= α+ß\n" +
                "و جذران تخيلان مترافقان هما : \n" +
                "X1,2=-1/2(α+ß) ± i√3/2(α-ß)\n" +
                "حيث ان α,ß القيمتان الحقيقيتين للجذرين التكعيبين على الترتيب , (q/3 + √∆)3√   ,(q/3 - √∆)3√\n" +
                "الحالة الثالثة ∆  :0>يوجد للمعادلة ثلالة جذور حقيقية مختلفة تعطى بالصيغة المثلثية التالية , التي تدعى بالحل المثلثي :\n" +
                "X1,2,3 =2 √(-p/3)cos((θ+2 π k)/3)                                     k=0,1,2;\n" +
                "Θ=cos-1(q/〖(p/(-3))〗^(3⁄2) )\n" +
                "\n";
        step+="بفرض لدينا المعادلة التالية " +
                "\n y^3+3y^2+3x+1=0 " +
                "\n اولا نستبدل المتحول  اي " +
                "\ny=x-a/3=x-3/3=x-1\n" +
                "نحسب قيمة كل من p,q ثم نحسب delta" +
                "\np=-a^2/3 + b=-3+3=0 \n" +
                " q=c+2a^3/27-b*a/3=0\n" +
                "delta=0\n" +
                "و بالتالي نحن امام الحالة الاولى يوجد لدينا ثلاث حلول حقيقية " +
                "\n α= 3√-q/2=0\n" +
                "x1=2α=0,x2=x3=- α=0\n" +
                "ثم نحسب قيمة y" +
                "\n y=x-1\n" +
                "و بالتالي فان جذور المعادلة السابقة هي" +
                "\n y1=-1\ny2=-1\ny3=-1";
        return step;
    }
}

