package co.edu.udea.asistentenutricionaludea;

public class Utilidades {
    public static int rotacion = 0;
    public static boolean validaPantalla = true;

    //Constantes campos tabla caracterizacion
    public static final String TABLA_CARACTERIZACION = "caracterizacion";
    public static final String CAMPO_CARACTERIZACION_ID = "id";
    public static final String CAMPO_CARACTERIZACION_USER = "user";
    public static final String CAMPO_CARACTERIZACION_WEIGHT = "weight";
    public static final String CAMPO_CARACTERIZACION_HEIGHT = "height";
    public static final String CAMPO_CARACTERIZACION_AGE =" age";
    public static final String CAMPO_CARACTERIZACION_GENDER = "gender";
    public static final String CAMPO_CARACTERIZACION_PHYSICAL_ACTIVITY_ID = "physical_activity_id";
    public static final String CAMPO_CARACTERIZACION_CALORIES = "calories";

    public static final String CREAR_TABLA_CARACTERIZACION="CREATE TABLE " + TABLA_CARACTERIZACION + " (" +
            CAMPO_CARACTERIZACION_ID + " INTEGER, " +
            CAMPO_CARACTERIZACION_USER + " TEXT, " +
            CAMPO_CARACTERIZACION_WEIGHT + " REAL, " +
            CAMPO_CARACTERIZACION_HEIGHT + " INTEGER, " +
            CAMPO_CARACTERIZACION_AGE + " TEXT, " +
            CAMPO_CARACTERIZACION_GENDER + " TEXT, " +
            CAMPO_CARACTERIZACION_PHYSICAL_ACTIVITY_ID + " INTEGER, " +
            CAMPO_CARACTERIZACION_CALORIES + " REAL);";

    //Constantes campos tabla actividad fisica
    public static final String TABLA_PHYSICAL_ACTIVITY = "physical_activity";
    public static final String CAMPO_PHYSICAL_ACTIVITY_ID = "id";
    public static final String CAMPO_PHYSICAL_ACTIVITY_NAME = "name";
    public static final String CAMPO_PHYSICAL_ACTIVITY_VALUE_MAN = "value_man";
    public static final String CAMPO_PHYSICAL_ACTIVITY_VALUE_WOMAN = "value_women";

    public static final String CREAR_TABLA_PHYSICAL_ACTIVITY="CREATE TABLE " + TABLA_PHYSICAL_ACTIVITY + " (" +
            CAMPO_PHYSICAL_ACTIVITY_ID + " INTEGER, " +
            CAMPO_PHYSICAL_ACTIVITY_NAME + " TEXT, " +
            CAMPO_PHYSICAL_ACTIVITY_VALUE_MAN + " REAL, " +
            CAMPO_PHYSICAL_ACTIVITY_VALUE_WOMAN + " REAL);";

    public static final String LLENAR_TABLA_PHYSICAL_ACTIVITY_0 = "INSERT INTO " + TABLA_PHYSICAL_ACTIVITY + " VALUES (0, 'Sedentaria - Sin actividad', 1.2, 1.2);";
    public static final String LLENAR_TABLA_PHYSICAL_ACTIVITY_1 = "INSERT INTO " + TABLA_PHYSICAL_ACTIVITY + " VALUES (1, 'Liviana - 3 horas semanales', 1.55, 1.56);";
    public static final String LLENAR_TABLA_PHYSICAL_ACTIVITY_2 = "INSERT INTO " + TABLA_PHYSICAL_ACTIVITY + " VALUES (2, 'Moderada - 6 horas semanales', 1.8, 1.64);";
    public static final String LLENAR_TABLA_PHYSICAL_ACTIVITY_3 = "INSERT INTO " + TABLA_PHYSICAL_ACTIVITY + " VALUES (3, 'Intensa - 4 a 5 horas diarias', 2.1, 1.82);";
}