package co.edu.udea.asistentenutricionaludea.fragments;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import co.edu.udea.asistentenutricionaludea.ConexionSQLiteOpenHelper;
import co.edu.udea.asistentenutricionaludea.R;
import co.edu.udea.asistentenutricionaludea.Utilidades;
import co.edu.udea.asistentenutricionaludea.entidades.PhysicalActivity;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CaracterizacionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CaracterizacionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CaracterizacionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    View vista;

    TextView user;
    TextView weight;
    TextView height;
    TextView age;
    RadioButton man;
    RadioButton woman;
    Spinner physicalActivity;

    ConexionSQLiteOpenHelper conn;

    boolean userExists;

    ArrayList<String> listaPhysicalActivity;
    ArrayList<PhysicalActivity> physicalActivityList;
    ArrayAdapter adaptador;

    DatePickerDialog dpd;
    Calendar currentDate;

    public CaracterizacionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CaracterizacionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CaracterizacionFragment newInstance(String param1, String param2) {
        CaracterizacionFragment fragment = new CaracterizacionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_caracterizacion, container, false);

        conn=new ConexionSQLiteOpenHelper(getActivity(),"bd_asistente_nutricional",null,1);

        user = (TextView) vista.findViewById(R.id.user);
        weight = (TextView) vista.findViewById(R.id.weight);
        height = (TextView) vista.findViewById(R.id.height);
        age = (TextView) vista.findViewById(R.id.age);
        man = (RadioButton) vista.findViewById(R.id.man);
        woman = (RadioButton) vista.findViewById(R.id.woman);
        physicalActivity = (Spinner) vista.findViewById(R.id.physicalActivity);

        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentDate = Calendar.getInstance();
                int yearCurrent = currentDate.get(Calendar.YEAR);
                int monthCurrent = currentDate.get(Calendar.MONTH);
                int dayCurrent = currentDate.get(Calendar.DAY_OF_MONTH);

                dpd = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String temporal = dosDigitos(dayOfMonth) + "/" + dosDigitos(month + 1) + "/" + year;
                        age.setText(temporal);
                    }

                    private String dosDigitos(int n) {
                        return (n<=9) ? ("0"+n) : String.valueOf(n);
                    }
                }, dayCurrent, monthCurrent, yearCurrent);
                dpd.updateDate(yearCurrent,monthCurrent,dayCurrent);
                dpd.show();
            }
        });

        consultarPhysicalActivity();

        userExists = consultarCaracterizacion();

        Button button = (Button) vista.findViewById(R.id.buttonSave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userExists){
                    actualizarCaracterizacion();
                }
                else {
                    registrarCaracterizacion();
                }
            }
        });

        return vista;
    }

    private boolean consultarCaracterizacion() {
        SQLiteDatabase db = conn.getReadableDatabase();

        String[] parametros={"0"};
        String[] campos={
                Utilidades.CAMPO_CARACTERIZACION_USER,
                Utilidades.CAMPO_CARACTERIZACION_WEIGHT,
                Utilidades.CAMPO_CARACTERIZACION_HEIGHT,
                Utilidades.CAMPO_CARACTERIZACION_AGE,
                Utilidades.CAMPO_CARACTERIZACION_GENDER,
                Utilidades.CAMPO_CARACTERIZACION_PHYSICAL_ACTIVITY_ID
        };

        try {
            Cursor cursor = db.query(Utilidades.TABLA_CARACTERIZACION,campos,Utilidades.CAMPO_CARACTERIZACION_ID +"=?",parametros,null,null,null);
            cursor.moveToFirst();

            user.setText(cursor.getString(0));
            weight.setText(cursor.getString(1));
            height.setText(cursor.getString(2));
            age.setText(cursor.getString(3));

            if(cursor.getString(4).equals("Hombre")){
                man.setChecked(true);
            }
            else{
                woman.setChecked(true);
            }

            physicalActivity.setSelection(Integer.parseInt(cursor.getString(5)));

            cursor.close();

            Toast.makeText(getContext(),"Bienvenido usuario: " + user.getText().toString(),Toast.LENGTH_LONG).show();
            db.close();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    private void registrarCaracterizacion() {
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Utilidades.CAMPO_CARACTERIZACION_ID, "0");
        values.put(Utilidades.CAMPO_CARACTERIZACION_USER, user.getText().toString());
        values.put(Utilidades.CAMPO_CARACTERIZACION_WEIGHT, weight.getText().toString());
        values.put(Utilidades.CAMPO_CARACTERIZACION_HEIGHT, height.getText().toString());
        values.put(Utilidades.CAMPO_CARACTERIZACION_AGE, age.getText().toString());

        if(man.isChecked()){
            values.put(Utilidades.CAMPO_CARACTERIZACION_GENDER, "Hombre");
        }
        else{
            values.put(Utilidades.CAMPO_CARACTERIZACION_GENDER, "Mujer");
        }

        values.put(Utilidades.CAMPO_CARACTERIZACION_PHYSICAL_ACTIVITY_ID, String.valueOf(physicalActivity.getSelectedItemPosition()));

        float calories = calcularCalorias();

        values.put(Utilidades.CAMPO_CARACTERIZACION_CALORIES, String.valueOf(calories));

        db.insert(Utilidades.TABLA_CARACTERIZACION, Utilidades.CAMPO_CARACTERIZACION_USER, values);
        Toast.makeText(getContext(),"Se registro el usuario: " + user.getText().toString(), Toast.LENGTH_SHORT).show();
        db.close();
    }

    private float calcularCalorias(){
        int edad = 2018 - Integer.parseInt(age.getText().toString().substring(6));
        float peso = Float.valueOf(weight.getText().toString());
        int actividad = physicalActivity.getSelectedItemPosition();

        float formula;
        //Hombre
        if(man.isChecked()){
            //Dependencia Edad
            if(edad <= 3){formula = (float) (60.9 * peso - 54);}
            else if(edad <= 10){formula = (float) (22.7 * peso + 495);}
            else if(edad <= 18){formula = (float) (17.5 * peso + 651);}
            else if(edad <= 30){formula = (float) (15.3 * peso + 679);}
            else if(edad <= 60){formula = (float) (11.6 * peso + 879);}
            else{formula = (float) (13.5 * peso + 487);}

            //Dependencia Actividad Fisica
            if(actividad == 0){formula = (float) (formula * 1.2);}
            else if(actividad == 1){formula = (float) (formula * 1.55);}
            else if(actividad == 2){formula = (float) (formula * 1.8);}
            else{formula = (float) (formula * 2.1);}
        }
        //Mujer
        else{
            //Dependencia Edad
            if(edad <= 3){formula = (float) (61 * peso - 51);}
            else if(edad <= 10){formula = (float) (22.5 * peso + 499);}
            else if(edad <= 18){formula = (float) (12.2 * peso + 746);}
            else if(edad <= 30){formula = (float) (14.7 * peso + 496);}
            else if(edad <= 60){formula = (float) (8.7 * peso + 829);}
            else{formula = (float) (10.5 * peso + 596);}

            //Dependencia Actividad Fisica
            if(actividad == 0){formula = (float) (formula * 1.2);}
            else if(actividad == 1){formula = (float) (formula * 1.56);}
            else if(actividad == 2){formula = (float) (formula * 1.64);}
            else{formula = (float) (formula * 1.82);}
        }

        return formula;
    }

    private void actualizarCaracterizacion() {
        SQLiteDatabase db=conn.getWritableDatabase();

        String[] parametros={"0"};

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_CARACTERIZACION_USER, user.getText().toString());
        values.put(Utilidades.CAMPO_CARACTERIZACION_WEIGHT, weight.getText().toString());
        values.put(Utilidades.CAMPO_CARACTERIZACION_HEIGHT, height.getText().toString());
        values.put(Utilidades.CAMPO_CARACTERIZACION_AGE, age.getText().toString());
        if(man.isChecked()){
            values.put(Utilidades.CAMPO_CARACTERIZACION_GENDER, "Hombre");
        }
        else{
            values.put(Utilidades.CAMPO_CARACTERIZACION_GENDER, "Mujer");
        }

        values.put(Utilidades.CAMPO_CARACTERIZACION_PHYSICAL_ACTIVITY_ID, String.valueOf(physicalActivity.getSelectedItemPosition()));

        float calories = calcularCalorias();

        if (calories != 0){
            values.put(Utilidades.CAMPO_CARACTERIZACION_CALORIES, String.valueOf(calories));
        }
        else{
            values.put(Utilidades.CAMPO_CARACTERIZACION_CALORIES, age.getText().toString().substring(6));
        }

        db.update(Utilidades.TABLA_CARACTERIZACION,values,Utilidades.CAMPO_CARACTERIZACION_ID +"=?", parametros);
        Toast.makeText(getContext(),"Se actualizó el usuario: " + user.getText().toString(), Toast.LENGTH_LONG).show();
        db.close();
    }

    private void consultarPhysicalActivity() {
        SQLiteDatabase db = conn.getReadableDatabase();

        PhysicalActivity actividad = null;
        physicalActivityList = new ArrayList<PhysicalActivity>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_PHYSICAL_ACTIVITY,null);

        while (cursor.moveToNext()){
            actividad = new PhysicalActivity(cursor.getInt(0),cursor.getString(1),cursor.getFloat(2),cursor.getFloat(3));

            physicalActivityList.add(actividad);
        }

        listaPhysicalActivity = new ArrayList<String>();

        for(int i = 0; i < physicalActivityList.size(); i++){
            listaPhysicalActivity.add(physicalActivityList.get(i).getName());
        }

        adaptador = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, listaPhysicalActivity);
        physicalActivity.setAdapter(adaptador);
        db.close();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
