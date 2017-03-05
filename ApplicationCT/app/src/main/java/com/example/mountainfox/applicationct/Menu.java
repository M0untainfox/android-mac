package com.example.mountainfox.applicationct;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;


import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class Menu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fragmentManager;
    TextView Donnee;
    Toolbar tb;
    FloatingActionButton fab;
    TextView Data_user;
    public static ArrayList<Vehicule> ListeV;
    public static ArrayList<categorie> ListeC;
    public static int numList;


    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tb = (Toolbar) findViewById(R.id.toolbar);
        Donnee = (TextView) findViewById(R.id.Data_Activity_imat);
        Data_user = (TextView) findViewById(R.id.Data_Activity_Username);

        fragmentManager = getFragmentManager();

        ListeV = new ArrayList();

        ajouterListV("peugeot","boxer","BB-123-CC",2012,54000,1);
        ajouterListV("Iveco","35c13","BB-789-CC",2001,220000,2);
        ajouterListV("Iveco","35c15","BB-753-CC",2012,120000,2);
        ajouterListV("Yamaha","450 wrf","BB-951-CC",2006,0,3);
        ajouterListV("Honda","250 cr","BB-486-CC",1993,0,3);
        ajouterListV("Honda","125 cr",null,1993,0,3);


        ListeC = new ArrayList();

        ajouterListC(0,"Voiture");
        ajouterListC(1,"camion 3t5");
        ajouterListC(2,"moto");
        ajouterListC(3,"tracteur");
        ajouterListC(4,"Camion");

    }

    public static void ajouterListV(String Marq,String Nom,String Imat,int Annee,int km,int type){
        Vehicule v1 = new Vehicule(Marq,Nom,Imat,Annee,km,type);
        ListeV.add(v1);
    }

    public static void ajouterListC(int nb,String str){
        categorie v1 = new categorie(nb,str);
        ListeC.add(v1);
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
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
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
            fab.setVisibility(INVISIBLE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame,new Fragment_pref());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();



        if (id == R.id.nav_voiture) {
            /*
            // Handle the camera action
            Intent intent = new Intent(Menu.this, SecondActivity.class);
            intent.putExtra("VAL","6");
            startActivity(intent);
            */
            tb.setTitle("Home");
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame,new Fragment_Home());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();


        } else if (id == R.id.nav_gallery) {

            fab.setVisibility(INVISIBLE);
            tb.setTitle("Info");
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame,new Fragmentun());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();


        } else if (id == R.id.nav_slideshow) {
            fab.setVisibility(INVISIBLE);
            tb.setTitle("Ajout");
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame,new Fragment_AjoutVehicule());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = getIntent();

        if(intent!=null){
            Data_user.setText(intent.getStringExtra("USER"));
        }

        tb.setTitle("Home");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame,new Fragment_Home());
        fragmentTransaction.commit();
    }
}
