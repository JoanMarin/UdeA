package co.edu.udea.asistentenutricionaludea.fragments;

import android.content.Context;
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
import co.edu.udea.asistentenutricionaludea.adaptadores.RecomendacionGeneralItemAdapter;
import co.edu.udea.asistentenutricionaludea.entidades.RecomendacionGeneral;
import co.edu.udea.asistentenutricionaludea.entidades.RecomendacionGeneralItem;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecomendacionGeneralItemFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RecomendacionGeneralItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecomendacionGeneralItemFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ListView listRecomendacionesGeneralesItem;
    private RecomendacionGeneralItemAdapter RecomendacionGeneralItemAdapter;

    private RecomendacionGeneral Item;

    public RecomendacionGeneralItemFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecomendacionGeneralItemFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecomendacionGeneralItemFragment newInstance(String param1, String param2) {
        RecomendacionGeneralItemFragment fragment = new RecomendacionGeneralItemFragment();
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
        View v = inflater.inflate(R.layout.fragment_recomendacion_general_item, container, false);

        final ArrayList<RecomendacionGeneralItem> seleccionados = new ArrayList<>();
        Item = (RecomendacionGeneral) getActivity().getIntent().getSerializableExtra("ObjectData");
        int  recomendacionGeneralId= Item.getId();

        for (RecomendacionGeneralItem i:getArrayItems()) {
                if(i.getRecomendacionGeneralId()==recomendacionGeneralId) {
                    seleccionados.add(i);
                }
        }
        /*
        Bundle bundle = this.getArguments();

        if (bundle != null) {
            int recomendacionGeneralId= bundle.getInt("ObjectData");
            for (RecomendacionGeneralItem i:getArrayItems()) {
                if(i.getRecomendacionGeneralId()==recomendacionGeneralId) {
                    seleccionados.add(i);
                }
            }
        }
        */
        RecomendacionGeneralItemAdapter = new RecomendacionGeneralItemAdapter(getActivity(),seleccionados);
        listRecomendacionesGeneralesItem = (ListView) v.findViewById(R.id.listRecomendacionesGeneralesItem);
        listRecomendacionesGeneralesItem.setAdapter(RecomendacionGeneralItemAdapter);

        listRecomendacionesGeneralesItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment miFragment = new RecomendacionGeneralItemDetalleFragment();
                getActivity().getIntent().putExtra("ObjectData", seleccionados.get(position));
                getActivity().getSupportFragmentManager()
                        .beginTransaction().replace(R.id.content_main, miFragment).addToBackStack(null).commit();
            }
        });
        return v;
    }

    private ArrayList<RecomendacionGeneralItem> getArrayItems(){
        ArrayList<RecomendacionGeneralItem> listItems = new ArrayList<>();

        listItems.add(new RecomendacionGeneralItem(1,1,R.drawable.recomendaciongeneralitem1a1,
                "El ícono de las GABA de Colombia, es un plato que reúne los alimentos en 6 grupos e incluye el " +
                        "consumo de Agua y la práctica de la Actividad física, importantes para la buena salud:",
                "El Plato saludable de la Familia Colombiana nos ayuda a elegir una alimentación variada. " +
                        "Nos indica que en cada tiempo de comida, se deben incluir alimentos de todos los grupos o su " +
                        "mayoría, en cantidades o porciones adecuadas.\n\n" +
                        "Por otra parte, los alimentos representados en el Plato saludable de la Familia Colombiana nos " +
                        "invitan a comer más alimentos frescos y menos alimentos procesados industrialmente, ya que estos " +
                        "pueden contener azúcares, sodio y grasa añadidos, que los hacen poco saludables.\n\n" +
                        "También nos invita a consumir los alimentos que se producen y preparan en nuestras regiones y " +
                        "que hacen parte de nuestra cultura, especialmente cuando están en cosecha y se pueden obtener o " +
                        "comprar a mejor precio.\n\n" +
                        "Adicionalmente, y con igual importancia nos invita a consumir agua durante el día y a realizar " +
                        "actividad física."));
        listItems.add(new RecomendacionGeneralItem(2,2,R.drawable.recomendaciongeneralitem2a1,
                "¿Por qué es importante este mensaje?",
                "Este mensaje nos invita a consumir todos los días leche y productos provenientes de la leche " +
                        "como yogurt, kumis y todos los tipos de queso, excepto aquellos de alto contenido graso como los " +
                        "de untar (mantequilla, queso crema, crema de leche). Dado su alto contenido de proteínas y " +
                        "calcio, su consumo favorece el crecimiento de huesos y dientes sanos y fuertes en niñas y niños, " +
                        "y en personas adultas previene la aparición de enfermedades como la osteoporosis, la cual " +
                        "consiste en un debilitamiento de los huesos que nos expone a mayores riesgos de fracturas.\n\n" +
                        "Otros productos como el queso “petit” no corresponden a este grupo, ya que no son elaborados con " +
                        "leche propiamente dicha, sino con sus derivados, como el suero, que tienen menos nutrientes que " +
                        "la leche.\n\n" +
                        "El mensaje también invita a incluir el huevo en la alimentación diaria, que es uno de los " +
                        "alimentos más completos y económicos de la canasta familiar. Al ser fuente de proteína de alta " +
                        "calidad, también favorece la salud de músculos, dientes y huesos. En niñas y niños contribuye " +
                        "al crecimiento, y en personas adultas sanas ayuda a mantener el funcionamiento del cuerpo. Aunque " +
                        "es un alimento fuente de colesterol, no tiene un efecto negativo en la salud, siempre y cuando " +
                        "haga parte de una alimentación balanceada."));
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
