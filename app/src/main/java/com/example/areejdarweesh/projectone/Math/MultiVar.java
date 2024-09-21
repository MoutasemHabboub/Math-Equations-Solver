
package com.example.areejdarweesh.projectone.Math;


import java.security.PublicKey;

public class MultiVar extends Eqution{
    public java.util.List<String> var= new java.util.ArrayList<String>();
    int k=0;
    float s[][];
    Float sol[]=new Float[100];
    Boolean impos=false,unlim=false;
    String steps="";
    String imposable=new String("this equations is imposable to solve");
    String unlimted="this equations have unlimted solution ";

    public String AnalyzeOne(String eq){
        float x[]=new float[100];
        int kk=0;

        /// array of constant
        float a[]=new float[100];
        int j=0;
        String finaleq="",varr="";
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
                    AnalyzeOne(t);
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
                        a[j] = (-1)*answer(t);
                        j++;
                        t = "";
                    }
                } else if (ch == '*' && !(Character.isDigit(eq.charAt(i + 1))) && IsOperation(eq.charAt(i + 1)) == -1) {
                    int w=i+1;
                    while(IsOperation(eq.charAt(w))==-1)
                    {
                        varr=eq.charAt(w)+"";
                        w++;
                    }
                    kk=hasplace(varr);
                    if(!t.isEmpty())
                    {
                        if (oketo == 1) {
                            x[kk] += (-1) * answer(t);
                        } else {
                            x[kk] += answer(t);
                        }
                        t = "";
                    }
                    else
                    {
                        if (oketo == 1) {
                            x[kk] += (-1);
                        } else {
                            x[kk] += 1;
                        }
                    }
                    i=w-1;

                }
                else if(((ch=='+' || ch=='-' )&& !t.isEmpty()))
                {
                    if (oketo == 1) {
                        a[j] =  answer(t);
                    } else {
                        a[j] = (-1) *answer(t);
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
                int w=i;
                while(IsOperation(eq.charAt(w))==-1)
                {
                    varr+=eq.charAt(w)+"";
                    w++;
                }
                kk=hasplace(varr);
                varr="";
                if ((i == 0) || (i != 0 && !Character.isDigit(eq.charAt(i - 1)) && eq.charAt(i-1)!=')') || (i!=0 && eq.charAt(i-1)==')' && t.isEmpty())) {
                    t += '1';
                    if (oketo == 1) {
                        x[kk] = (-1) * answer(t);
                    } else {
                        x[kk] = answer(t);
                    }
                    t = "";
                }
                else
                {
                    if (oketo == 1) {
                        x[kk] += (-1) * answer(t);
                    } else {
                        x[kk] += answer(t);
                    }
                    t = "";
                }
                i=w-1;
            }
        }
        if( !t.isEmpty() )
        {
            if (oketo == 1) {
                a[j] =  answer(t);
            } else {
                a[j] = (-1) *answer(t);
            }
            j++;
            t="";
        }
        for(int i=1;i<j;i++)
            a[0]+=a[i];
        for(int i=0;i<var.size();i++)
        {
            if(x[i]>=0)
                finaleq+=x[i]+var.get(i);
            else if(x[i]<0){
                System.out.println("8888 "+finaleq);
                finaleq=finaleq.substring(0,finaleq.length()-1);
                finaleq+=x[i]+var.get(i);
            }
            if(i<var.size()-1)
                finaleq+="+";
        }
        finaleq+="="+a[0];
        return finaleq;
    }
    ///Matrix
    void matrex(String eqs[]){
        String eq;
        int y;
        float a[];
        float temp[][]=new float[eqs.length][eqs.length+1];
        a=new float[eqs.length];
        String tempD="",tempCh="";
        for (int i=0;i<eqs.length;i++)
        {
            eq=eqs[i];
            eq=AnalyzeOne(eq);
            steps+="\n "+eq+"\n";
            for (int j=0;j<eq.length();j++)
            {
                char ch=eq.charAt(j);
                if(isD(ch))
                {
                    tempD+=ch;
                    if(j<eq.length()-1 && eq.charAt(j+1)=='.')
                    {
                        tempD+=eq.charAt(j+1);
                        j++;
                    }
                }
                else if((ch=='-' || ch=='+') && tempD.isEmpty())
                {
                    tempD=""+ch;
                }
                else if(isO(ch))
                {
                    float d;
                    if(ch=='=')
                    {
                        d=Float.parseFloat(tempD);
                        if(isO(eq.charAt(j+1)))
                        {
                            tempD=""+eq.charAt(j+1);
                            j++;
                        }
                        else
                            tempD="";
                    }
                    else
                    {
                        d=Float.parseFloat(tempD);
                        tempD=""+ch;
                    }
                    y=hasplace(tempCh);
                    temp[i][y]=d;
                    System.out.println(d+"   "+tempCh+" "+temp[i][y]);
                    tempCh="";

                }
                else
                {
                    while (!isO(ch))
                    {
                        tempCh+=ch;
                        j++;
                        ch=eq.charAt(j);
                    }
                    j--;
                    if(tempD.isEmpty()||(isO(tempD.charAt(0)) && tempD.length()==1)){

                        tempD+="1";
                    }
                }
            }//end for
            float d=Float.parseFloat(tempD);
            // System.out.println(d+"   "+tempCh);
            a[i]=d;
            tempCh="";
            tempD="";


        }//end for
        for(int i=0;i<eqs.length;i++)
            temp[i][eqs.length]=a[i];
        s=new float[eqs.length][var.size()+1];
        for(int i=0;i<s.length;i++)
        {
            for (int j=0;j<var.size();j++)
            {
                s[i][j]=temp[i][j];
                System.out.println("it is s"+s[i][j]);
            }
            s[i][var.size()]=a[i];
        }
        StoreStep();


    }
    //is degite ----
    boolean isD(char ch)
    {
        if(Character.isDigit(ch))
            return true;
        else return false;

    }
    //is operation ----
    boolean isO(char ch){
        if(ch=='+'||ch=='-'||ch=='=')
            return true;
        else return false;
    }
    // place for variable ----
    int hasplace(String v){
        int j=0;
        for (String i : var)
        {
            if(v.equals(i)){
                return j;
            }
            j++;
        }
        var.add(v);
        k++;
        return k-1;

    }

    // print matrix -----
    void printm(){System.out.print(" | ");
        for(String x:var)
        {
            System.out.print(x+"  ");

        }
        System.out.println(" | ");
        for (float x[]:s)
        {
            System.out.print(" | ");
            for (float y:x)
            {
                System.out.print(y+"  ");
            }
            System.out.println(" | ");

        }
    }

    // solve equation -----
    public void solve(String eqs[]){

        matrex(eqs);
        for(int j=0;j<s.length-1;j++)
        {
            reduce();
        }
        last();
    }
    //-------
    void reduce1(int x){

        for(int i =x+1;i<s.length;i++)
        {
            float temp1=-1*s[i][x];
            if(temp1==0){

                break;
            }
            for (int j=x;j<var.size()+1;j++)
            {
                s[i][j] += (s[x][j] * temp1);
            }
        System.out.println(x+"lopoo");
            this.printm();
        }
        System.out.println(x+"lopvvvoo");
    }
    void reduce2(int x)
    {if(x==var.size()-1){

        return;
    }
        float temp=s[x][x];
        if(temp==0)
            return;
        for(int j=x;j<var.size()+1;j++)
        {
            s[x][j]=s[x][j]/temp;
        }
    }
    void reduce()
    {
        for (int i=0;i<s.length;i++)
        {
            reduce2(i);
            reduce1(i);
            StoreStep();
        }
    }
    //============
    void last()
    {
        int j=0,ok=0;
        String vv[]=new String[var.size()];
        this.printm();
        System.out.println("pleas help me god ");
        this.arranged();
        this.printm();
        for(int i=0;i<s.length;i++){
            if(s[i][i]!=0) {
                j++;
            }
            for(int q=0;q<var.size();q++)
                if(s[i][q]!=0)
                {
                    ok=1;
                    break;
                }
            if(ok==0 && s[i][var.size()]!=0){
                //System.out.println(imposable);
                steps+="\n"+imposable;
                impos=true;
                return;
            }
        }
        if(j<var.size())
        {
            steps+="\n"+unlimted;
            unlim=true;
        }

        //System.out.println(this.unlimted);
        else if (j==var.size()){
            //float sol[]=new float[var.size()];
            for (int i=0;i<var.size();i++){
                sol[i]=back(i);
                System.out.println(sol[i]+" hole mother of monky");
            }

            for (int i=0;i<vv.length;i++) {
                vv[i] = var.get(i) + "=" + sol[i];
                steps+="\n "+vv[i];
                //System.out.println(vv[i]);
            }
        }

    }
    //--------------
    void arranged()
    {
        for (int i=1;i<s.length;i++){
            for (int j=0 ;j<var.size();j++){
                if(s[i][j]!=0){
                    if(i==j)
                        continue;
                    else if(s[j][j-1]==0 && s[j][j]!=0)
                        continue;
                    else {
                        float temp;
                        for (int k=0; k<var.size()+1;k++)
                        {
                            temp=s[i][k];
                            s[i][k]=s[j][k];
                            s[j][k]=temp;
                        }
                        j--;
                    }
                }

            }
        }


    }
    //---------------
    float back(int i){
        if(i>var.size())
            return 0;
        else if(i==var.size()-1)
        {
            return s[i][i+1]/s[i][i];
        }
        else {
            float s1=0;
            for (int j=i+1;j<var.size();j++)
            {
                s1+=(s[i][j]*back(j));
            }
            System.out.println(s[i][i]+"once there is a way"+i);
            return ((s[i][var.size()]-s1)/s[i][i]);
        }

    }
    /// String showsteps
    void StoreStep(){
        steps+="\n | ";
        for(String x:var)
        {
            steps+=" "+x+"    ";
        }
        steps+="      |\n";
        for (float x[]:s)
        {
            steps+=" | ";
            for (float y:x)
            {
                if(y>=0)
                    steps+=" "+y+"  ";
                else
                    steps+=y+"  ";
            }
            steps+=" | \n";

        }
    }
    /// Show Steps
    public String showstips(){
        return steps;
    }
    /// get solution
    public Object[] getSolution()
    {
        if(impos)
        {
            String solution[]={imposable};
            return solution;
        }
        else if(unlim)
        {
            String solution[]={unlimted};
            return solution;
        }
        else {
            Float solution[]=new Float[var.size()];
            for(int i=0;i<var.size();i++)
                solution[i]=sol[i];

            return solution;
        }

    }
}


