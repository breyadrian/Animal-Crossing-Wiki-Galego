package com.example.acwiki.screens.SeaCreatures;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acwiki.R;
import com.example.acwiki.screens.fish.FishData;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SeaCreatureFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SeaCreatureFragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View root;
    private SeaCreatureData data;
    private String rareza;
    private String ubicacion;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SeaCreatureFragment1() {
        // Required empty public constructor
    }

    public SeaCreatureFragment1(SeaCreatureData data) {
        this.data=data;
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SeaCreatureFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static SeaCreatureFragment1 newInstance(String param1, String param2) {
        SeaCreatureFragment1 fragment = new SeaCreatureFragment1();
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
        root =inflater.inflate(R.layout.fragment_sea_creature1, container, false);

        ImageView bolsaDinero1 =  root.findViewById(R.id.bolsaDinero1);
        if(data.getPrecio()<1500){
            bolsaDinero1.setImageResource(R.drawable.bolsa_pequenha);
        }else if(data.getPrecio()<10000) {
            bolsaDinero1.setImageResource(R.drawable.bolsa_mediana);
        }else {
            bolsaDinero1.setImageResource(R.drawable.bolsa_grande);
        }

        TextView precioCriatura = root.findViewById(R.id.precioCreature);
        precioCriatura.setText("Prezo: "+data.getPrecio());

        TextView speed = root.findViewById(R.id.speed);
        speed.setText("Velocidade: "+data.getSpeed());

        TextView CreatureShadow = root.findViewById(R.id.creatureShadow);
        CreatureShadow.setText("Sombra: "+data.getShadow());

        TextView creatureId = root.findViewById(R.id.creatureId);
        creatureId.setText("Identificador: "+data.getId());



        return root;
    }
    public String primeraMayuscula(String palabra){
        String str = palabra;
        String firstLtr = str.substring(0, 1);
        String restLtrs = str.substring(1, str.length());
        firstLtr = firstLtr.toUpperCase();
        str = firstLtr + restLtrs;

        return str;
    }
}