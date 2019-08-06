package gr10.compumovil.udea.edu.co.lab2e10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    Button Regi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        Regi =(Button)findViewById(R.id.btnRegi);
    }

    public void onRegi(View view){

        if(view.getId() == R.id.btnRegi)
        {
            EditText nombre= (EditText)findViewById(R.id.Tnombre);
            EditText email= (EditText)findViewById(R.id.Temail);
            EditText unombre= (EditText)findViewById(R.id.Tusuario);
            EditText contraseña = (EditText)findViewById(R.id.Tcontraseña);
            EditText contraseña2 = (EditText)findViewById(R.id.Tconfirmar);

            String nombrestr = nombre.getText().toString();
            String emailstr = email.getText().toString();
            String unombrestr = unombre.getText().toString();
            String contraseñastr = contraseña.getText().toString();
            String contraseña2str = contraseña2.getText().toString();

            if (!contraseñastr.equals(contraseña2str)){

                //popup
                Toast contraseñaNoEqual = Toast.makeText(Registrar.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT);
                contraseñaNoEqual.show();
            }
            else {
                //insert database
                Contact c = new Contact();
                c.setNombre(nombrestr);
                c.setEmail(emailstr);
                c.setUnombre(unombrestr);
                c.setContraseña(contraseñastr);
                c.setSession(0);

                helper.insertContact(c);

                Toast contraseñaEqual = Toast.makeText(Registrar.this, "Usuario registrado", Toast.LENGTH_SHORT);
                contraseñaEqual.show();

                Intent iniciar = new Intent(Registrar.this, Login.class);
                startActivity(iniciar);
            }
        }

    }
}
