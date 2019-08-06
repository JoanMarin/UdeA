package co.edu.udea.asistentenutricionaludea;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import co.edu.udea.asistentenutricionaludea.fragments.AboutFragment;
import co.edu.udea.asistentenutricionaludea.fragments.ContenedorRecomendacionesFragment;
import co.edu.udea.asistentenutricionaludea.fragments.RecomendacionAlmuerzoFragment;
import co.edu.udea.asistentenutricionaludea.fragments.RecomendacionCenaFragment;
import co.edu.udea.asistentenutricionaludea.fragments.RecomendacionDesayunoFragment;
import co.edu.udea.asistentenutricionaludea.fragments.RecomendacionGeneralFragment;
import co.edu.udea.asistentenutricionaludea.fragments.RecomendacionGeneralItemDetalleFragment;
import co.edu.udea.asistentenutricionaludea.fragments.RecomendacionGeneralItemFragment;
import co.edu.udea.asistentenutricionaludea.fragments.RecomendacionOtrosFragment;
import co.edu.udea.asistentenutricionaludea.fragments.CaracterizacionFragment;
import co.edu.udea.asistentenutricionaludea.fragments.SummaryFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        ContenedorRecomendacionesFragment.OnFragmentInteractionListener,
        RecomendacionDesayunoFragment.OnFragmentInteractionListener,
        RecomendacionAlmuerzoFragment.OnFragmentInteractionListener,
        RecomendacionCenaFragment.OnFragmentInteractionListener,
        RecomendacionOtrosFragment.OnFragmentInteractionListener,
        CaracterizacionFragment.OnFragmentInteractionListener,
        AboutFragment.OnFragmentInteractionListener,
        SummaryFragment.OnFragmentInteractionListener,
        RecomendacionGeneralFragment.OnFragmentInteractionListener,
        RecomendacionGeneralItemFragment.OnFragmentInteractionListener,
        RecomendacionGeneralItemDetalleFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //INICIAR BASE DE DATOS
        ConexionSQLiteOpenHelper conn=new ConexionSQLiteOpenHelper(this,"bd_asistente_nutricional",null,1);

        //Instanciar contenedor con fragment Caracterizacion
        if (Utilidades.validaPantalla){
            Fragment fragment=new CaracterizacionFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();
            Utilidades.validaPantalla=false;
        };

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //QUITAR LA TINTA DE LOS ICONOS
        navigationView.setItemIconTintList(null);
    }

    @Override
    protected void onResume() {
        super.onResume();
            Fragment fragment=new CaracterizacionFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();
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

        Fragment miFragment = null;
        boolean fragmentSeleccionado = false;

        if (id == R.id.nav_characterization) {
            miFragment = new CaracterizacionFragment();
            fragmentSeleccionado = true;
        }
        else if (id == R.id.nav_summary) {
            miFragment = new SummaryFragment();
            fragmentSeleccionado = true;
        }
        else if (id == R.id.nav_consumed_food) {
            miFragment = new RecomendacionOtrosFragment();
            fragmentSeleccionado = true;
        }
        else if (id == R.id.nav_recommendations) {
            miFragment = new ContenedorRecomendacionesFragment();
            fragmentSeleccionado = true;
        }
        else if (id == R.id.nav_general_recommendations) {
            miFragment = new RecomendacionGeneralFragment();
            fragmentSeleccionado = true;
        }
        else if (id == R.id.nav_share) {
            miFragment = new RecomendacionGeneralItemFragment();
            fragmentSeleccionado = true;
        }
        else if (id == R.id.nav_setting) {

        }
        else if (id == R.id.nav_about) {
            miFragment = new AboutFragment();
            fragmentSeleccionado = true;
        }

        if (fragmentSeleccionado) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, miFragment).addToBackStack(null).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
