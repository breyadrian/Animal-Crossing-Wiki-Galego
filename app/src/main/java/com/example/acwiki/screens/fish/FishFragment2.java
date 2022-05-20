package com.example.acwiki.screens.fish;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.acwiki.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FishFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FishFragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View root;
    private String fraseCaptura;
    private String fraseMuseo;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FishFragment2() {
        // Required empty public constructor
    }

    public FishFragment2(String fraseCaptura, String fraseMuseo){
        this.fraseCaptura =fraseCaptura;
        this.fraseMuseo=fraseMuseo;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FishFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static FishFragment2 newInstance(String param1, String param2) {
        FishFragment2 fragment = new FishFragment2();
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
        root = inflater.inflate(R.layout.fragment_fish2, container, false);

        TextView captura = root.findViewById(R.id.catch_phrase);
        captura.setText("Frase de captura: "+fraseCaptura);

        TextView museo = root.findViewById(R.id.museum_phrase);
        museo.setText("Frase de museo: "+fraseMuseo);

        return root;
    }
}