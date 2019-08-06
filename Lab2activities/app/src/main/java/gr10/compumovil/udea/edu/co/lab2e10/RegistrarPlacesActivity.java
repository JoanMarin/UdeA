package gr10.compumovil.udea.edu.co.lab2e10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarPlacesActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    Button Regi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_places);

        Regi =(Button)findViewById(R.id.btnRegistrar);
    }

    public void registrarPlaces(View v) {
        if(v.getId() == R.id.btnRegistrar) {
            EditText nombreLugar = (EditText) findViewById(R.id.editText);
            EditText pequeñaDescription = (EditText) findViewById(R.id.editText2);
            EditText puntuacion = (EditText) findViewById(R.id.editText3);
            EditText informacionGeneral = (EditText) findViewById(R.id.editText4);
            EditText sitiosRecomendados = (EditText) findViewById(R.id.editText5);
            EditText temperatura = (EditText) findViewById(R.id.editText6);
            EditText ubicacion = (EditText) findViewById(R.id.editText7);

            String nombreLugarStr = nombreLugar.getText().toString();
            String pequeñaDescriptionStr = pequeñaDescription.getText().toString();
            double puntuacionLong = Double.parseDouble(puntuacion.getText().toString());
            String informacionGeneralStr = informacionGeneral.getText().toString();
            String sitiosRecomendadosStr = sitiosRecomendados.getText().toString();
            double temperaturaDouble = Double.parseDouble(temperatura.getText().toString());
            String ubicacionStr = ubicacion.getText().toString();

            //insert database
            Places p = new Places();
            p.setNombre_lugar(nombreLugarStr);
            p.setPequeña_descripcion(pequeñaDescriptionStr);
            p.setPuntuacion(puntuacionLong);
            p.setInformacion_general(informacionGeneralStr);
            p.setUbicacion(ubicacionStr);
            p.setTemperatura(temperaturaDouble);
            p.setSitios_recomendados(sitiosRecomendadosStr);
            p.setImagen("ruta/");

            helper.insertPlaces(p);

            Toast placesRegi = Toast.makeText(RegistrarPlacesActivity.this, "Lugar Registrado", Toast.LENGTH_SHORT);
            placesRegi.show();

            Intent iniciar = new Intent(RegistrarPlacesActivity.this, DrawerActivity.class);
            startActivity(iniciar);
        }
    }
}
