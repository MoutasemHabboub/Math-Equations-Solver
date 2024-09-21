package com.example.areejdarweesh.projectone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.areejdarweesh.projectone.Calculate.ScientificCalFragment;
import com.example.areejdarweesh.projectone.Calculate.UnitConverterFragment;
import com.example.areejdarweesh.projectone.Extra.Divisiors;
import com.example.areejdarweesh.projectone.Extra.Fibonacci;
import com.example.areejdarweesh.projectone.Extra.Moudulo;
import com.example.areejdarweesh.projectone.Extra.PiNumber;
import com.example.areejdarweesh.projectone.Extra.PrimFactor;
import com.example.areejdarweesh.projectone.Extra.PrimeNumber;
import com.example.areejdarweesh.projectone.Fragment.AnalyseFragment;
import com.example.areejdarweesh.projectone.Fragment.MatrixFragment;
import com.example.areejdarweesh.projectone.Fragment.MultiVariable;
import com.example.areejdarweesh.projectone.Fragment.drivationFragment;
import com.example.areejdarweesh.projectone.Fragment.intergaratFragment;
import com.example.areejdarweesh.projectone.graph.Main2Activity;
import com.example.areejdarweesh.projectone.learning.Mainlearnnn;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageView imageView;
    TextView textView,textView11;
   LinearLayout about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image);
        about=findViewById(R.id.linearbout);
      /*  textView=findViewById(R.id.textview);
        textView11=findViewById(R.id.textview1);*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Solve_Equation) {
           /* textView11.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.INVISIBLE);*/
           about.removeAllViews();
           about.removeAllViewsInLayout();
            displayFragment(new AnalyseFragment(), this, false);

        } else if (id == R.id.Scien_cal) {
            /* textView11.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.INVISIBLE);*/
            about.removeAllViews();
            about.removeAllViewsInLayout();
            displayFragment(new ScientificCalFragment(), this, false);

        } else if (id == R.id.Unit_Converter) {
              /* textView11.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.INVISIBLE);*/
            about.removeAllViews();
            about.removeAllViewsInLayout();
            displayFragment(new UnitConverterFragment(), this, false);
            Toast.makeText(this, "hiiii", Toast.LENGTH_LONG).show();

        } else if (id == R.id.multi) {
            /* textView11.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.INVISIBLE);*/
            about.removeAllViews();
            about.removeAllViewsInLayout();
            displayFragment(new MultiVariable(), this, false);
        } else if (id == R.id.Matrix) {
           /* textView11.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.INVISIBLE);*/
            about.removeAllViews();
            about.removeAllViewsInLayout();
            displayFragment(new MatrixFragment(), this, false);

        } else if (id == R.id.Prime_Factor) {
          /* textView11.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.INVISIBLE);*/
            about.removeAllViews();
            about.removeAllViewsInLayout();
            displayFragment(new PrimFactor(),this,false);

        }else if (id == R.id.Divisor) {
          /* textView11.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.INVISIBLE);*/
            about.removeAllViews();
            about.removeAllViewsInLayout();
            displayFragment(new Divisiors(),this,false);

        }
        else if (id == R.id.Modulo) {
             /* textView11.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.INVISIBLE);*/
            about.removeAllViews();
            about.removeAllViewsInLayout();
            displayFragment(new Moudulo(),this,false);

        }
        else if (id == R.id.PI_number) {
            /* textView11.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.INVISIBLE);*/
            about.removeAllViews();
            about.removeAllViewsInLayout();
            displayFragment(new PiNumber(),this,false);

        }
        else if (id == R.id.Fibo_num) {
            /* textView11.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.INVISIBLE);*/
            about.removeAllViews();
            about.removeAllViewsInLayout();
            displayFragment(new Fibonacci(),this,false);

        }
        else if (id == R.id.Solving) {
            /* textView11.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.INVISIBLE);*/
            about.removeAllViews();
            about.removeAllViewsInLayout();
            displayFragment(new Mainlearnnn(),this,false);

        }
        else if (id == R.id.Prim_Number) {
            /* textView11.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.INVISIBLE);*/
            about.removeAllViews();
            about.removeAllViewsInLayout();
            displayFragment(new PrimeNumber(),this,false);

        }
        else if (id == R.id.Integrate) {
            /* textView11.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.INVISIBLE);*/
            about.removeAllViews();
            about.removeAllViewsInLayout();
            displayFragment(new intergaratFragment(),this,false);

        }
        else if (id == R.id.Div) {
            /* textView11.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.INVISIBLE);*/
            about.removeAllViews();
            about.removeAllViewsInLayout();
            displayFragment(new drivationFragment(),this,false);

        }
        else if (id == R.id.Graph) {

           /* about.removeAllViews();
            about.removeAllViewsInLayout();
            displayFragment(new GraphFragment(),this,false);*/
            Intent intent=new Intent(this, Main2Activity.class);
            startActivity(intent);

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /*
    * decs...
    * currentFragment in first Run = null
    * canRefresh  : for Refresh Fragment
    * !fragment.getClass().toString().equals(currentFragment.getTag()) : currentFragment != new Fragment
    */
    public void displayFragment(android.support.v4.app.Fragment fragment, Activity activity, boolean canRefresh) {
        android.support.v4.app.Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragmentMain);
        if (currentFragment == null || canRefresh || !fragment.getClass().toString().equals(currentFragment.getTag())) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragmentMain, fragment, fragment.getClass().toString());
            ft.commit();
        }
    }
}
