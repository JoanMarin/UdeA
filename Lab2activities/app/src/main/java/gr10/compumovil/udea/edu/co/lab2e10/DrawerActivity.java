package gr10.compumovil.udea.edu.co.lab2e10;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DatabaseHelper helper = new DatabaseHelper(this);

    String[][] listview;
    int contador = 0;
    int[] listviewImagen;


    /*int[] listviewImag = new int[]{
            R.drawable.ic_menu_share, R.drawable.profile_pc, R.drawable.profile_pc, R.drawable.profile_pc,
            R.drawable.profile_pc, R.drawable.profile_pc, R.drawable.profile_pc, R.drawable.profile_pc,
    };
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        /*String username = getIntent().getStringExtra("Username");
        TextView tv =(TextView) findViewById(R.id.textView9);
        tv.setText(username);*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listview = helper.searchPlaces();
        contador = listview.length;
        listviewImagen = new int[contador];

        for(int i = 0; i < contador ; i++){
            listviewImagen[i] = R.drawable.ic_menu_share;
        }

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < contador; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_nombre_lugar", listview[i][0]);
            hm.put("listview_pequeña_description", listview[i][1]);
            hm.put("listview_puntuacion", listview[i][2]);
            hm.put("listview_imagen", Integer.toString(listviewImagen[i]));
            aList.add(hm);
        }

        String[] from = {"listview_imagen", "listview_nombre_lugar", "listview_pequeña_description", "listview_puntuacion"};
        int[] to = {R.id.listview_imagen, R.id.listview_nombre_lugar, R.id.listview_pequeña_description, R.id.listview_puntuacion};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.places_list_view, from, to);
        ListView androidListView = (ListView) findViewById(R.id.list_places);
        androidListView.setAdapter(simpleAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registrarPlace = new Intent(DrawerActivity.this, RegistrarPlacesActivity.class);
                startActivity(registrarPlace);
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.drawer, menu);
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

        Intent iniciar = new Intent(DrawerActivity.this, DrawerActivity.class);
        Intent User = new Intent(DrawerActivity.this, User.class);
        if (id == R.id.nav_places) {
            startActivity(iniciar);
        } else if (id == R.id.nav_cuenta) {
            startActivity(User);

        } else if (id == R.id.nav_info) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
