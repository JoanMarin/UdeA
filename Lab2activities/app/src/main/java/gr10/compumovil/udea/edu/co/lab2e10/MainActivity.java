package gr10.compumovil.udea.edu.co.lab2e10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button botonRegi;
    Button botonIng;
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonRegi =(Button)findViewById(R.id.btnRegistrar);
        botonIng =(Button)findViewById(R.id.btnIniciar);

        Intent i = new Intent(MainActivity.this, DrawerActivity.class);

        if (helper.searchSession()){
            startActivity(i);
        }
    }

    public void onClick(View v){

        if (v.getId()==R.id.btnRegistrar) {

            Intent registrar = new Intent(MainActivity.this, Registrar.class);
            startActivity(registrar);

        }

        if (v.getId()== R.id.btnIniciar) {

            Intent iniciar = new Intent(MainActivity.this, Login.class);
            startActivity(iniciar);

        }


    }

}
