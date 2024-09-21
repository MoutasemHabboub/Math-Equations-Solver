package com.example.areejdarweesh.projectone.learning;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.areejdarweesh.projectone.R;

public class Mainlearnnn extends Fragment {

    View view;
    Button b1,b2,b3,b5;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.activity_mainlearnnn,container,false);
       fidId(view);
       onclick();
       return view;
    }
    public void fidId(View view)
    {
        b1=view.findViewById(R.id.button);
        b2=view.findViewById(R.id.button2);
        b3=view.findViewById(R.id.button3);
        b5=view.findViewById(R.id.button5);
    }
public void onclick()
{
    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String s="",ex="";
            s+="\nالشكل العام لمعادلة من الدرجة الأولى :";
            s+="\n ax+b=0";
            s+="\n و لحل معادلة من الدرجة الأولى علينا اتباع الخطوات التالية:";
            s+="\n 1] نكتب المعادلة بالشكل العام ax+b=0.";
            s+="\n 2] نحعل المتغيرات في طرف من المساواة و الثوابت في الطرف الآخر ax=-b.";
            s+="\n 3] نقسم على أمثال المتغير a.";
            s+="\n 4] و هكذا نكون قد وصلنا إلى الحل x=-b/a.";
            ex+="\n    5x+8=x";
            ex+="\n 1] 5x+8-x=0";
            ex+="\n   (5-1)x+8=0";
            ex+="\n    4x+8=0";
            ex+="\n 2] 4x=-8";
            ex+="\n 3] x=-8/4";
            ex+="\n 4] x=-2";

            Intent intent=new Intent(getContext(),learnsteps.class);
            intent.putExtra("steps",s);
            intent.putExtra("example",ex);
            intent.putExtra("type","one");
            startActivity(intent);
        }
    });

    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String s="",ex="";
            s+="\nالشكل العام لمعادلة من الدرجة الثانية :";
            s+="\n ax^2+bx+c=0";
            s+="\n و لحل معادلة من الدرجة الثانية علينا اتباع الخطوات التالية:";
            s+="\n 1] نكتب المعادلة بالشكل العام ax^2+bx+c=0.";
            s+="\n 2] نطبق قانون الدلتا delta=b^2-4ac.";
            s+="\n 3] نقارن الدلتا: \n   1)delta>0 : أي هناك حلين حقيقيين للمعادلة";
            s+="\n      x1=(-b+sqrt(delta))/(2a)";
            s+="\n      x2=(-b-sqrt(delta))/(2a)";
            s+="\n    2)delta=0 : أي هناك حل مضاعف";
            s+="\n      x=-b/2a";
            s+="\n   3)delta>0 : أي هناك حلين خياليين للمعادلة";
            s+="\n      x1=(-b+sqrt(-delta)i)/(2a)";
            s+="\n      x2=(-b-sqrt(-delta)i)/(2a)";

            ex+="\n    2x^2+4x+2=x^2-1";
            ex+="\n 1] (2-1)x^2+4x+(2+1)=0";
            ex+="\n    x^2+4x+3=0";
            ex+="\n    a=1 , b=4 , c=3 ";
            ex+="\n 2] delta=(4)^2-4(1)(3)";
            ex+="\n    delta=16-12=4";
            ex+="\n 3] delta=4>0 ==> هناك حلين حقيقيين للمعادلة";
            ex+="\n    x1=(-4+sqrt(4))/(2*1)";
            ex+="\n    x1=(-4+2)/(2)";
            ex+="\n    x1=-2/2";
            ex+="\n    x1=-1";
            ex+="\n\n    x2=(-4-sqrt(4))/(2*1)";
            ex+="\n    x2=(-4-2)/(2)";
            ex+="\n    x2=-6/2";
            ex+="\n    x2=-3";

            Intent intent=new Intent(getContext(),learnsteps.class);
            intent.putExtra("steps",s);
            intent.putExtra("example",ex);
            intent.putExtra("type","two");
            startActivity(intent);
        }

    });

    b3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String s="",ex="";
            s+="بفرض لدينا المعادلة التكعيبية التالية :\n" +
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
            s+="بفرض لدينا المعادلة التالية " +
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

            ex+="\n x^3+2x^2+1=0";
            Intent intent=new Intent(getContext(),learnsteps.class);
            intent.putExtra("steps",s);
            intent.putExtra("example",ex);
            intent.putExtra("type","three");
            startActivity(intent);
        }
    });
    b5.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String s="",ex="";
            s+="\n: الشكل العام لجملة معادلات خطية ";
            s+="\n a1x+b1y+c1z=d1";
            s+="\n a2x+b2y+c2z=d1";
            s+="\n a3x+b3y+c3z=d3";
            s+="\n نستطيع تمثيلهم في مصفوفة كم الشكل التالي :";
            s+="\n | a1  b1  c1  d1 |";
            s+="\n | a2  b2  c2  d2 |";
            s+="\n | a3  b3  c3  d3 |";
            s+="\n لحل جملة معادلات خطية نتبيع الخطوات التالية :";
            s+="\n بداية نقوم بتدريج المصفوفة باتباع الخطوات التالية :";
            s+="\n 1] جعل الأسطر الغير صفرية تسبق الأسطر الصفرية.";
            s+="\n 2] جعل العناصر في عامود العنصر الأول الذي تم جعله واحد\n في الخطوة السسابقة جميعها تساوي الصفر عن طريق بعض التحويلات السطرية ";
            s+="\n 3] يستمر التدريج حيث نجعل العنصر الثاني في السطر الثاني يساوي الواحد \nوالعناصر التي تحته في نفس العامود تساوي الصفر وهكذا حتى العنصر الثالث  ";
            s+="\n ثانيا : بعد عملية تدريج المصفوفة نقوم باتباع طريقة كرامر لحل المصفوفة :";
            s+="\n 1] نحسب رتبة المصفوفة A وهي مصفوفة معاملات الجملة ونحسب رتبة المصفوفة المتبعة H";
            s+="\n فإذا كان r(A)!=r(H) نتوقف عند هذه الخطوة لأن الجملة في هذه الحالة غير مشتركة ";
            s+="\n أما اذا كانت r(A)=r(H) فالجملة مشتركة وننتقل للخطوة التالية .";
            s+="\n 2] اذا كان r(A)=r فهذا يعني أنه انه توجد r معادلة خطية مستقلة خطيا مكافئة للجملة الأصلية وبقية المعادلات التي عددها (m-r)تكون مرتبطة خطية بالمعادلات r الستقلة خطيا التي اخترناها ونستغني عما سواها من المعادلات ";
            s+="\n لتحديد هذه الجملة المكافئة نختار صغيرا لا يساوي الصفر في A من المرتبة r فتكون معادلات الجملة المكافئة مقابلة لأسطر المصفوفة الموسغة H التي ياوضع عليها هذا الصغر .";
            s+="\n 3]  اذا كان عدد معادلات الجملة المكافئة يساوي عدد المجاهيل فالحل وحيد";
            s+="\n نجده باستخدام دساتير كرامر .";
            s+="\n 4] اذا كانت عدد معادلات الجملة المكافئة أقل من عدد مجاهيل الجملة الأصلية فهناك عدد غير منته من الحلول ";
            s+="\n نحددها بأن نبقي في الأطراف اليسرى  من معادلات الجملة المكافئة ";
            s+="\n الحدود التي تحوي المجاهيل الواقعة على الأعمدة التي يتوضع عليها الصغير نسميها المجاهيل الأسساسية وننقل جميع الحدود التي تحوي المجاهيل الأخرى";
            s+="\n التي تسمى المجاهيل الحرة إلى الأطراف اليمنى فنحصل بذلك على جملة جديدة محددها يقابل الصغير الذي لا ياوي الصفر .";

            ex+="\n x1-5x2-8x3=0";
            Intent intent=new Intent(getContext(),learnsteps.class);
            intent.putExtra("steps",s);
            intent.putExtra("example",ex);
            intent.putExtra("type","multi");
            startActivity(intent);
        }
    });
}

}
