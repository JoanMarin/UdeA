package gr10.compumovil.udea.edu.co.lab2e10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class User extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    TextView nombre;
    TextView email;
    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        String[][] user = helper.searchUser();

        nombre =(TextView) findViewById(R.id.nombre);
        email =(TextView) findViewById(R.id.email);
        username =(TextView) findViewById(R.id.username);
        nombre.setText(user[0][0]);
        email.setText(user[0][1]);
        username.setText(user[0][2]);
    }

}
