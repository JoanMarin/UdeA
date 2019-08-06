package co.edu.udea.asistentenutricionaludea.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import co.edu.udea.asistentenutricionaludea.R;
import co.edu.udea.asistentenutricionaludea.adaptadores.RecomendacionGeneralAdapter;
import co.edu.udea.asistentenutricionaludea.entidades.RecomendacionGeneral;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecomendacionGeneralFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RecomendacionGeneralFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecomendacionGeneralFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ListView listRecomendacionesGenerales;
    private RecomendacionGeneralAdapter RecomendacionGeneralAdapter;
    private ArrayList<RecomendacionGeneral> recomendacionesGenerales;

    public RecomendacionGeneralFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecomendacionGeneralFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecomendacionGeneralFragment newInstance(String param1, String param2) {
        RecomendacionGeneralFragment fragment = new RecomendacionGeneralFragment();
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
        View v = inflater.inflate(R.layout.fragment_recomendacion_general, container, false);
        recomendacionesGenerales = getArrayItems();
        RecomendacionGeneralAdapter = new RecomendacionGeneralAdapter(getActivity(),recomendacionesGenerales);
        listRecomendacionesGenerales = (ListView) v.findViewById(R.id.listRecomendacionesGenerales);
        listRecomendacionesGenerales.setAdapter(RecomendacionGeneralAdapter);

        listRecomendacionesGenerales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment miFragment = new RecomendacionGeneralItemFragment();
                /*
                Bundle bundle = new Bundle();
                bundle.putInt("ObjectData", recomendacionesGenerales.get(position).getId());
                miFragment.setArguments(bundle);
                */
                getActivity().getIntent().putExtra("ObjectData", recomendacionesGenerales.get(position));
                getActivity().getSupportFragmentManager()
                        .beginTransaction().replace(R.id.content_main, miFragment).addToBackStack(null).commit();
            }
        });
        return v;
    }

    private ArrayList<RecomendacionGeneral> getArrayItems(){
        ArrayList<RecomendacionGeneral> listItems = new ArrayList<>();

        listItems.add(new RecomendacionGeneral(1, R.drawable.group1,"Consuma alimentos frescos y variados como lo indica " +
                "el Plato saludable de la Familia Colombiana."));
        listItems.add(new RecomendacionGeneral(2, R.drawable.group2,"Para favorecer la salud de músculos, huesos y dientes, " +
                "consuma diariamente leche u otros productos lácteos huevo."));
        listItems.add(new RecomendacionGeneral(3, R.drawable.group3,"Para una buena digestión y prevenir enfermedades del " +
                "corazón, incluya en cada una de las comidas frutas enteras y verduras frescas."));
        listItems.add(new RecomendacionGeneral(4, R.drawable.group4,"Para complementar su alimentación consuma al menos " +
                "dos veces por semana leguminosas como frijol, lenteja, arveja y garbanzo."));
        listItems.add(new RecomendacionGeneral(5, R.drawable.group5,"Para prevenir la anemia, los niños, niñas, adolescentes " +
                "y mujeres jóvenes deben comer vísceras una vez por semana."));
        listItems.add(new RecomendacionGeneral(6, R.drawable.group6,"Para mantener un peso saludable, reduzca el consumo " +
                "de “productos de paquete”, comidas rápidas, gaseosas y bebidas azucaradas."));
        listItems.add(new RecomendacionGeneral(7, R.drawable.group7,"Para tener una presión arterial normal, reduzca el " +
                "consumo de sal y alimentos como carnes embutidas, enlatados y “productos de paquete”, altos en sodio."));
        listItems.add(new RecomendacionGeneral(8, R.drawable.group8,"Cuide su corazón, consuma aguacate, maní y nueces; " +
                "disminuya el consumo de aceite vegetal y margarina; evite grasas de origen animal como mantequilla y manteca."));
        listItems.add(new RecomendacionGeneral(9, R.drawable.group9,"Por el placer de vivir saludablemente realice actividad " +
                "física de forma regular."));

        return listItems;
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
