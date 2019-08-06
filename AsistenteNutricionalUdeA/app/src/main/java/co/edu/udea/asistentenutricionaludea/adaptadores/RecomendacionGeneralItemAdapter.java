package co.edu.udea.asistentenutricionaludea.adaptadores;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.udea.asistentenutricionaludea.R;
import co.edu.udea.asistentenutricionaludea.entidades.RecomendacionGeneralItem;

public class RecomendacionGeneralItemAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<RecomendacionGeneralItem> recomendacionesGeneralesItem;

    public RecomendacionGeneralItemAdapter(Activity activity, ArrayList<RecomendacionGeneralItem> recomendacionesGeneralesItem) {
        this.activity = activity;
        this.recomendacionesGeneralesItem = recomendacionesGeneralesItem;
    }

    @Override
    public int getCount() { return recomendacionesGeneralesItem.size();}

    @Override
    public Object getItem(int position) {
        return recomendacionesGeneralesItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if(convertView == null){
            v = activity.getLayoutInflater().inflate(R.layout.lista_recomendaciones_generales_item, parent,false);
        }

        RecomendacionGeneralItem Item = recomendacionesGeneralesItem.get(position);

        TextView itemGroup = (TextView) v.findViewById(R.id.item_group);

        itemGroup.setText(Item.getTitle());

        return v;
    }
}
