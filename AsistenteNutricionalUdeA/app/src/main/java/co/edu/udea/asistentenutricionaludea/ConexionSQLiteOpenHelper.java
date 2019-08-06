package co.edu.udea.asistentenutricionaludea;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionSQLiteOpenHelper extends SQLiteOpenHelper {



    public ConexionSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_CARACTERIZACION);
        db.execSQL(Utilidades.CREAR_TABLA_PHYSICAL_ACTIVITY);
        db.execSQL(Utilidades.LLENAR_TABLA_PHYSICAL_ACTIVITY_0);
        db.execSQL(Utilidades.LLENAR_TABLA_PHYSICAL_ACTIVITY_1);
        db.execSQL(Utilidades.LLENAR_TABLA_PHYSICAL_ACTIVITY_2);
        db.execSQL(Utilidades.LLENAR_TABLA_PHYSICAL_ACTIVITY_3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.TABLA_CARACTERIZACION);
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.TABLA_PHYSICAL_ACTIVITY);
        onCreate(db);
    }
}
