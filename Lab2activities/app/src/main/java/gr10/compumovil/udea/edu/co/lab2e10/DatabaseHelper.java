package gr10.compumovil.udea.edu.co.lab2e10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.IOException;


/**
 * Created by personal on 5/09/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "lab2activitie.db";
    SQLiteDatabase db;
    private static final String TABLE_CONTACTS_NAME = "contacts";
    private static final String COLUMN_CONTACTS_ID = "id";
    private static final String COLUMN_CONTACTS_NAME = "nombre";
    private static final String COLUMN_CONTACTS_EMAIL = "email";
    private static final String COLUMN_CONTACTS_UNAME = "unombre";
    private static final String COLUMN_CONTACTS_PASSWORD = "contraseña";
    private static final String COLUMN_CONTACTS_SESSION = "session";
    private static final String TABLE_CONTACTS_CREATE = "CREATE TABLE if not exists contacts" +
            "(id INTEGER PRIMARY KEY, "+
            "nombre TEXT," +
            "email TEXT," +
            "unombre TEXT," +
            "contraseña TEXT," +
            "session INTEGER);";
    private static final String TABLE_PLACES_NAME = "places";
    private static final String COLUMN_PLACES_ID = "id";
    private static final String COLUMN_PLACES_NOMBRE_LUGAR = "nombre_lugar";
    private static final String COLUMN_PLACES_PEQUEÑA_DESCRIPCION = "pequeña_descripcion";
    private static final String COLUMN_PLACES_PUNTUACION = "puntuacion";
    private static final String COLUMN_PLACES_INFORMACION_GENERAL = "informacion_general";
    private static final String COLUMN_PLACES_UBICACION = "ubicacion";
    private static final String COLUMN_PLACES_TEMPERATURA = "temperatura";
    private static final String COLUMN_PLACES_SITIOS_RECOMENDADOS = "sitios_recomendados";
    private static final String COLUMN_PLACES_IMAGEN = "imagen";
    private static final String TABLE_PLACE_CREATE =
            "CREATE TABLE if not exists places" +
            "(id INTEGER PRIMARY KEY," +
            "nombre_lugar TEXT," +
            "pequeña_descripcion TEXT," +
            "puntuacion DOUBLE," +
            "informacion_general TEXT," +
            "ubicacion TEXT," +
            "temperatura DOUBLE," +
            "sitios_recomendados TEXT," +
            "imagen TEXT);";
    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CONTACTS_CREATE);
        db.execSQL(TABLE_PLACE_CREATE);
        this.db = db;
    }

    public void insertContact(Contact c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "SELECT * FROM " + TABLE_CONTACTS_NAME;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_CONTACTS_ID, count);
        values.put(COLUMN_CONTACTS_NAME, c.getNombre());
        values.put(COLUMN_CONTACTS_EMAIL, c.getEmail());
        values.put(COLUMN_CONTACTS_UNAME, c.getUnombre());
        values.put(COLUMN_CONTACTS_PASSWORD, c.getContraseña());
        values.put(COLUMN_CONTACTS_SESSION, c.getSession());

        db.insert(TABLE_CONTACTS_NAME, null, values);
        db.close();
    }

    public void insertPlaces(Places p){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        Cursor cursor;
        int count;
        String query = "SELECT * FROM " + TABLE_PLACES_NAME;
        cursor = db.rawQuery(query, null);
        count = cursor.getCount();

        values.put(COLUMN_PLACES_ID, count);
        values.put(COLUMN_PLACES_NOMBRE_LUGAR, p.getNombre_lugar());
        values.put(COLUMN_PLACES_PEQUEÑA_DESCRIPCION, p.getPequeña_descripcion());
        values.put(COLUMN_PLACES_PUNTUACION, p.getPuntuacion());
        values.put(COLUMN_PLACES_INFORMACION_GENERAL, p.getInformacion_general());
        values.put(COLUMN_PLACES_UBICACION, p.getUbicacion());
        values.put(COLUMN_PLACES_TEMPERATURA, p.getTemperatura());
        values.put(COLUMN_PLACES_SITIOS_RECOMENDADOS, p.getSitios_recomendados());
        values.put(COLUMN_PLACES_IMAGEN, p.getImagen());

        db.insert(TABLE_PLACES_NAME, null, values);
        db.close();
    }

    public String searchPass(String unombre){

        db = this.getReadableDatabase();
        String query = "SELECT unombre, contraseña FROM " + TABLE_CONTACTS_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b= "no found";

        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);

                if (a.equals(unombre))
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }

    public void UpdateSession(String usuario){
        db.execSQL("UPDATE " + TABLE_CONTACTS_NAME + " SET session = 1");
    }
    public String[][] searchUser(){

        db = this.getReadableDatabase();
        String query = "SELECT nombre,email,unombre FROM " + TABLE_CONTACTS_NAME + " WHERE session = 1";
        Cursor cursor = db.rawQuery(query, null);
        String[][] user = new String[1][3];



        if(cursor.moveToFirst()){
            user[0][0] = cursor.getString(0);
            user[0][1] = cursor.getString(1);
            user[0][2] = cursor.getString(2);
        }
        return user;
    }

    public boolean searchSession(){

        db = this.getReadableDatabase();
        String query = "SELECT unombre, session FROM " + TABLE_CONTACTS_NAME;
        Cursor cursor = db.rawQuery(query, null);
        boolean a = false;

        if(cursor.moveToFirst())
        {
            do{
                if(cursor.getInt(1)==1){
                    a = true;
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return a;
    }

    public String[][] searchPlaces(){
        db = this.getReadableDatabase();
        String query = "SELECT nombre_lugar,pequeña_descripcion,puntuacion FROM " + TABLE_PLACES_NAME;
        String[][] a;
        Cursor cursor1 = db.rawQuery(query, null);
        Cursor cursor2 = db.rawQuery(query, null);
        int contador = 0,lista = 0;

        if(cursor1.moveToFirst())
        {
            do{
                contador++;
            }
            while(cursor1.moveToNext());
        }

        a = new String[contador][3];

        if(cursor2.moveToFirst())
        {
            do{
                a[lista][0] = cursor2.getString(0);
                a[lista][1] = cursor2.getString(1);
                a[lista][2] = cursor2.getString(2);
                lista++;
            }
            while(cursor2.moveToNext());
        }
        return a;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String query1 = "DROP TABLE IF EXITS " + TABLE_CONTACTS_NAME ;
        String query2 = "DROP TABLE IF EXITS " + TABLE_PLACES_NAME ;
        db.execSQL(query1);
        db.execSQL(query2);
        this.onCreate(db);
    }
}
