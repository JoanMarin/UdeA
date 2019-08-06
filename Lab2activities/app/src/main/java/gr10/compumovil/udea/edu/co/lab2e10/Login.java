package gr10.compumovil.udea.edu.co.lab2e10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button boton;

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        boton =(Button)findViewById(R.id.btnIngresar);

    }
    public void ingresar(View view) {

        if (view.getId()==R.id.btnIngresar) {

            EditText a= (EditText)findViewById(R.id.usuarioText);
            String str= a.getText().toString();

            EditText b= (EditText)findViewById(R.id.contraseñaText);
            String cont= b.getText().toString();

            String contrase= helper.searchPass(str);

            if (cont.equals(contrase)){

                helper.UpdateSession(str);

                Intent i = new Intent(Login.this, DrawerActivity.class);
                i.putExtra("Username", str);
                startActivity(i);
            }
            else {

                Toast temp = Toast.makeText(Login.this, "Usuario y contraseña no coinciden", Toast.LENGTH_SHORT);
                temp.show();
            }

        }
    }

}
