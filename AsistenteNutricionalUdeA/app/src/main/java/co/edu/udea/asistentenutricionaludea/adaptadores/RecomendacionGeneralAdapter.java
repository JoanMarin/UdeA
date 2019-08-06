package co.edu.udea.asistentenutricionaludea.adaptadores;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.udea.asistentenutricionaludea.R;
import co.edu.udea.asistentenutricionaludea.entidades.RecomendacionGeneral;

public class RecomendacionGeneralAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<RecomendacionGeneral> recomendacionesGenerales;

    public RecomendacionGeneralAdapter(Activity activity, ArrayList<RecomendacionGeneral> recomendacionesGenerales) {
        this.activity = activity;
        this.recomendacionesGenerales = recomendacionesGenerales;
    }

    @Override
    public int getCount() { return recomendacionesGenerales.size();}

    @Override
    public Object getItem(int position) {
        return recomendacionesGenerales.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if(convertView == null){
            v = activity.getLayoutInflater().inflate(R.layout.lista_recomendaciones_generales,parent,false);
        }

        //recomendaciones Item = (recomendaciones) getItem(position);

        RecomendacionGeneral Item = recomendacionesGenerales.get(position);

        ImageView imageRecomendacion = (ImageView) v.findViewById(R.id.imageRecomendacion);
        TextView group = (TextView) v.findViewById(R.id.group);

        imageRecomendacion.setImageResource(Item.getImageRecomendacion());
        group.setText(Item.getGroup());

        return v;
    }
}
