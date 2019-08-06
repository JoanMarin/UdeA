package co.edu.udea.asistentenutricionaludea.adaptadores;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.udea.asistentenutricionaludea.R;
import co.edu.udea.asistentenutricionaludea.entidades.Recomendacion;

public class RecomendacionAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<Recomendacion> recomendaciones;

    public RecomendacionAdapter(Activity activity, ArrayList<Recomendacion> recomendaciones) {
        this.activity = activity;
        this.recomendaciones = recomendaciones;
    }

    @Override
    public int getCount() { return recomendaciones.size();}

    @Override
    public Object getItem(int position) {
        return recomendaciones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v =convertView;

        if(convertView == null){
            v = activity.getLayoutInflater().inflate(R.layout.lista_recomendaciones,parent,false);
        }

        //recomendaciones Item = (recomendaciones) getItem(position);

        Recomendacion Item = recomendaciones.get(position);

        ImageView imageFood = (ImageView) v.findViewById(R.id.imageFood);
        TextView food = (TextView) v.findViewById(R.id.food);
        TextView carbohidratos = (TextView) v.findViewById(R.id.carbohydrates);
        TextView grasas = (TextView) v.findViewById(R.id.fats);
        TextView proteinas = (TextView) v.findViewById(R.id.proteins);
        TextView calorias = (TextView) v.findViewById(R.id.calories);

        imageFood.setImageResource(Item.getImageFood());
        food.setText(Item.getFood());
        carbohidratos.setText(Item.getCarbohidratos());
        grasas.setText(Item.getGrasas());
        proteinas.setText(Item.getProteinas());
        calorias.setText(Item.getCalorias());

        return v;
    }
}
