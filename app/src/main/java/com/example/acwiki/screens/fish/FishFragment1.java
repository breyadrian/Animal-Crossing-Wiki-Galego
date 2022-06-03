package com.example.acwiki.screens.fish;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acwiki.R;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FishFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FishFragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View root;
    private FishData data;
    private String rareza;
    private String ubicacion;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FishFragment1() {
        // Required empty public constructor
    }

    public FishFragment1(FishData data,String rareza, String ubicacion){
        this.data=data;
        this.rareza=rareza;
        this.ubicacion=ubicacion;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FishFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static FishFragment1 newInstance(String param1, String param2) {
        FishFragment1 fragment = new FishFragment1();
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


       root = inflater.inflate(R.layout.fragment_fish1, container, false);



        TextView fishPrice = root.findViewById(R.id.precioFish);
        fishPrice.setText("Prezo: "+String.valueOf(data.getPrecio()));

        TextView fishPrice_cj = root.findViewById(R.id.precioFishCJ);
        fishPrice_cj.setText("Prezo CJ: "+String.valueOf(data.getPrecio_cj()));

        TextView fishShadow = root.findViewById(R.id.fishShadow);
        fishShadow.setText("Sombra: "+getshadow(data.getShadow()));

        TextView rerezaTxt = root.findViewById(R.id.rareza);
        rerezaTxt.setText("Rareza: "+rareza);

        TextView ubicacionTxt = root.findViewById(R.id.localizacion);
        ubicacionTxt.setText("Localización: "+ubicacion);

        TextView fishId = root.findViewById(R.id.fishId);
        fishId.setText("Identificador: "+String.valueOf(data.getId()));

        ImageView bolsaDinero1 =  root.findViewById(R.id.bolsaDinero1);
        if(data.getPrecio()<1500){
            bolsaDinero1.setImageResource(R.drawable.bolsa_pequenha);
        }else if(data.getPrecio()<10000) {
            bolsaDinero1.setImageResource(R.drawable.bolsa_mediana);
        }else {
            bolsaDinero1.setImageResource(R.drawable.bolsa_grande);
        }

        ImageView bolsaDinero2 =  root.findViewById(R.id.bolsaDinero2);
        if(data.getPrecio_cj()<1500){
            bolsaDinero2.setImageResource(R.drawable.bolsa_pequenha);
        }else if(data.getPrecio_cj()<10000) {
            bolsaDinero2.setImageResource(R.drawable.bolsa_mediana);
        }else {
            bolsaDinero2.setImageResource(R.drawable.bolsa_grande);
        }


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


    public String getshadow (String shadow){

        switch (shadow){
            case ("Smallest (1)"):
                shadow="A máis pequena";
                break;
            case ("Small (2)"):
                shadow="Pequena";
                break;
            case ("Medium (3)"):
                shadow="Media";
                break;
            case ("Medium (4)"):
                shadow="Media-grande";
                break;
            case (" Medium with fin (4)"):
                shadow="Media-grande con aleta";
                break;
            case ("Large (5)"):
                shadow="Grande";
                break;
            case ("Largest (6)"):
                shadow="A máis grande";
                break;
            case ("Largest with fin (6)"):
                shadow="A máis grande con aleta";
                break;
            case ("Narrow"):
                shadow="Estreita";
                break;
        }

        return shadow;
    }

    public String getLocation(String ubicacion){
        String location="";
        if(ubicacion.equalsIgnoreCase("Sea")){
            location="Mar";
        }else if(ubicacion.equalsIgnoreCase("River")){
            location="Río";
        }else if(ubicacion.equalsIgnoreCase("River (Mouth)")){
            location="Desembocadura do río";
        }else if(ubicacion.equalsIgnoreCase("Pond")){
            location="Charca";
        }else if(ubicacion.equalsIgnoreCase("Pier")){
            location="Peirao";
        }
        return location;
    }


}