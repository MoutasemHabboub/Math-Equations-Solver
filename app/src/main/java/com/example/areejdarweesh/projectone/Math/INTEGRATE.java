package com.example.areejdarweesh.projectone.Math;

/**
 * Created by Areej Darweesh on 7/3/2019.
 */


public class INTEGRATE extends Eqution {
    double var [], a, b;
    public void Analyze(String eq) {
        double variable [];
        int oketo=0,ok1=0;
        int dgr=0;
        String t="";
        variable = new double[10];
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
                        variable[0] += answer(t);
                        t = "";
                    }
                } else if (ch == '*' && !(Character.isDigit(eq.charAt(i + 1))) && IsOperation(eq.charAt(i + 1)) == -1 ) {
                    if(i<eq.length()-3 && eq.charAt(i+2)=='^' && eq.charAt(i+3)=='2')
                    {
                        if (oketo == 1) {
                            variable[2] += (-1) * answer(t);
                        } else {
                            variable[2] += answer(t);
                        }
                        if(dgr<2)
                            dgr=2;
                        i+=3;
                        t="";
                    }
                    else if(i<eq.length()-3 && eq.charAt(i+2)=='^' && eq.charAt(i+3)=='3')
                    {
                        if (oketo == 1) {
                            variable[3] += (-1) * answer(t);
                        } else {
                            variable[3] += answer(t);
                        }
                        if(dgr<3)
                            dgr=3;
                        i+=3;
                        t="";
                    }
                    else if(i<eq.length()-3 && eq.charAt(i+2)=='^' && eq.charAt(i+3)=='4')
                    {
                        if (oketo == 1) {
                            variable[4] += (-1) * answer(t);
                        } else {
                            variable[4] += answer(t);
                        }
                        if(dgr<4)
                            dgr=4;
                        i+=3;
                        t="";
                    }
                    else if(i<eq.length()-3 && eq.charAt(i+2)=='^' && eq.charAt(i+3)=='5')
                    {
                        if (oketo == 1) {
                            variable[5] += (-1) * answer(t);
                        } else {
                            variable[5] += answer(t);
                        }
                        if(dgr<5)
                            dgr=5;
                        i+=3;
                        t="";
                    }

                    else
                    {
                        if (oketo == 1) {
                            variable[1]+= (-1) * answer(t);
                        } else {
                            variable[1] += answer(t);
                        }
                        if(dgr<1)
                            dgr=1;
                        i++;
                        t = "";
                    }
                }
                else if(((ch=='+')&& !t.isEmpty()))
                {
                    if (oketo == 1) {
                        variable[0] += (-1) * answer(t);
                    } else {
                        variable[0]= answer(t);
                    }
                    t="";
                }
                else if ((ch != '=' && Character.isDigit(eq.charAt(i + 1)) && !t.isEmpty())|| ch=='-') {
                    t += ch;
                }
            }
            else {
                if (eq.charAt(i) == '^' && eq.charAt(i + 1) == '2') {
                    variable[2]+=answer(t);
                    if(dgr<2)
                        dgr=2;
                    t="";
                    i++;
                }
                else if (eq.charAt(i) == '^' && eq.charAt(i + 1) == '3') {
                    variable[3]+=answer(t);
                    if(dgr<3)
                        dgr=3;
                    t="";
                    i++;
                }
                else if (eq.charAt(i) == '^' && eq.charAt(i + 1) == '4') {
                    variable[4]+=answer(t);
                    t="";
                    i++;
                    if(dgr<3)
                        dgr=3;
                }
                else if ((i == 0) || (i != 0 && !Character.isDigit(eq.charAt(i - 1)))){
                    t += '1';
                    if(i<eq.length()-2 && eq.charAt(i+1)=='^' && eq.charAt(i+2)=='2')
                    {
                        if (oketo == 1) {
                            variable[2] += (-1) * answer(t);
                        } else {
                            variable[2]+= answer(t);
                        }
                        if(dgr<2)
                            dgr=2;
                        i+=2;
                        t="";
                    }
                    else if(i<eq.length()-2 && eq.charAt(i+1)=='^' && eq.charAt(i+2)=='3')
                    {
                        if (oketo == 1) {
                            variable[3]+= (-1) * answer(t);
                        } else {
                            variable[3] += answer(t);
                        }
                        if(dgr<3)
                            dgr=3;
                        i+=2;
                        t="";
                    }
                    else if(i<eq.length()-2 && eq.charAt(i+1)=='^' && eq.charAt(i+2)=='4')
                    {
                        if (oketo == 1) {
                            variable[4] += (-1) * answer(t);
                        } else {
                            variable[4] += answer(t);
                        }
                        if(dgr<4)
                            dgr=4;
                        i+=2;
                        t="";
                    }
                    else if(i<eq.length()-2 && eq.charAt(i+1)=='^' && eq.charAt(i+2)=='5')
                    {
                        if (oketo == 1) {
                            variable[5] += (-1) * answer(t);
                        } else {
                            variable[5] += answer(t);
                        }
                        if(dgr<5)
                            dgr=5;
                        i+=2;
                        t="";
                    }

                    else
                    {
                        if (oketo == 1) {
                            variable[1] += (-1) * answer(t);
                        } else {
                            variable[1] += answer(t);
                        }
                        if(dgr<1)
                            dgr=1;
                        t = "";
                    }
                }
                else
                {
                    if(i<eq.length()-2 && eq.charAt(i+1)=='^' && eq.charAt(i+2)=='2')
                    {
                        if (oketo == 1) {
                            variable[2] += (-1) * answer(t);
                        } else {
                            variable[2] += answer(t);
                        }
                        if(dgr<2)
                            dgr=2;
                        i+=2;
                        t="";
                    }
                    else  if(i<eq.length()-2 && eq.charAt(i+1)=='^' && eq.charAt(i+2)=='3')
                    {
                        if (oketo == 1) {
                            variable[3] += (-1) * answer(t);
                        } else {
                            variable[3] += answer(t);
                        }
                        if(dgr<3)
                            dgr=3;

                        i+=2;
                        t="";
                    }
                    else  if(i<eq.length()-2 && eq.charAt(i+1)=='^' && eq.charAt(i+2)=='4')
                    {
                        if (oketo == 1) {
                            variable[4] += (-1) * answer(t);
                        } else {
                            variable[4] += answer(t);
                        }
                        if(dgr<4)
                            dgr=4;
                        i+=2;
                        t="";
                    }
                    else  if(i<eq.length()-2 && eq.charAt(i+1)=='^' && eq.charAt(i+2)=='5')
                    {
                        if (oketo == 1) {
                            variable[5] += (-1) * answer(t);
                        } else {
                            variable[5] += answer(t);
                        }
                        if(dgr<5)
                            dgr=5;
                        i+=2;
                        t="";
                    }

                    else
                    {
                        if (oketo == 1) {
                            variable[1] += (-1) * answer(t);
                        } else {
                            variable[1] += answer(t);
                        }
                        if(dgr<1)
                            dgr=1;
                        t = "";
                    }

                }
            }
        }
        if( !t.isEmpty() )
        {
            if (oketo == 1) {
                variable[0]+= (-1) * answer(t);
            } else {
                variable[0] += answer(t);
            }

        }
        var=new double[dgr+1];
        for (int i=0;i<dgr+1;i++){
            var[i]=variable[i];
        }

    }
   public double solve(double a,double b){
        double res=0;
        this.a=a;
        this.b=b;
        double h1;
        if(Math.abs(b-a)<2){
            h1= 0.1;
        }
        else if(Math.abs(b-a)<50) h1= 1;
        else h1=10;
        double i,j=1;
        res+=this.res(a);
        for (i=a+h1;i<b-h1;i++){

            if(j%2.0== 0){

                res+=2*this.res(i);

            }
            else {
                res+=4*this.res(i);
            }
            j++;
            System.out.println(res +"it is ras");
        }

        if((j+1)%2.0!=0){
            j++;}
        else {
            res+=4*this.res(i);
            res+=2*this.res( i-0.9);
            j++;
            j++;

        }
        res+=this.res(b);
        j++;

        double h=(b-a)/(3*(j));
        res*=h;
        return  res;
    }
    double res(double e){
       double temp;
        double result=var[0];
        for ( int i=1;i<var.length;i++){
            temp=e;
            for ( int j=1;j<i;j++){
                temp*=e;
            }
            temp*=var[i];

            result+=temp;

        }

        return result;
    }

    @Override
    public Object[] getSolution() {
        return new Object[0];
    }

    @Override
    public String showstips() {
        return null;
    }
}
