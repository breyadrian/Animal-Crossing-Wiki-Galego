package com.example.acwiki.screens.items;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.acwiki.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ItemFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemFragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    View root;
    ItemData data;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ItemFragment2() {
        // Required empty public constructor
    }
    public ItemFragment2(ItemData data) {
        this.data=data;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ItemFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static ItemFragment2 newInstance(String param1, String param2) {
        ItemFragment2 fragment = new ItemFragment2();
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
        root = inflater.inflate(R.layout.fragment_item2, container, false);

        TextView hha_concept1 = root.findViewById(R.id.hha_concept1);
        if(data.getHha_concept_2().equals("null")){
            hha_concept1.setText("Hha_concept_1: Non ten");
        }else {
            hha_concept1.setText("Hha_concept_1: " + data.getHha_concept_1());
        }
        TextView hha_concept2 = root.findViewById(R.id.hha_concept2);
        if(data.getHha_concept_2().equals("null")){
            hha_concept2.setText("Hha_concept_2: Non ten");
        }else {
            hha_concept2.setText("Hha_concept_2: " + data.getHha_concept_2());
        }

        TextView hha_set = root.findViewById(R.id.hha_set);
        if(data.getHha_set().equals("null")){
            hha_set.setText("Hha_set: Non ten");
        }else {
            hha_set.setText("Hha_set: " + data.getHha_set());
        }

        TextView hha_series = root.findViewById(R.id.hha_series);
        if(data.getHha_series().equals("null")){
            hha_series.setText("Hha_series: Non ten");
        }else {
            hha_series.setText("Hha_series: " + data.getHha_series());
        }
        TextView version = root.findViewById(R.id.version);
        version.setText("Version: "+data.getVersion());

        TextView speakerType = root.findViewById(R.id.speakerType);
        if(data.getSpeaker_type().equals("null")){
            speakerType.setText("Tipo de son: Non ten sonido");
        }else {
            speakerType.setText("Tipo de son: " + data.getSpeaker_type());
        }
        TextView iluminacion = root.findViewById(R.id.iluminacion);
        if(data.getLighting_type().equals("null")){
            iluminacion.setText("Tipo de iluminación: Non emite luz");
        }else {
            iluminacion.setText("Tipo de iluminación: " + data.getLighting_type());
        }

        return root;
    }
}