package com.example.acwiki.screens.fossils;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.acwiki.R;
import com.example.acwiki.screens.fish.FishData;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FossilFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FossilFragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View root;
    private FossilData data;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FossilFragment1() {
        // Required empty public constructor
    }
    public FossilFragment1(FossilData data) {
        // Required empty public constructor
        this.data=data;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FossilFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static FossilFragment1 newInstance(String param1, String param2) {
        FossilFragment1 fragment = new FossilFragment1();
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
        root = inflater.inflate(R.layout.fragment_fossil1, container, false);


        TextView museumPhrase = root.findViewById(R.id.museum_phrase);
        museumPhrase.setText("Frase do museo: "+data.getMuseum_phrase());

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