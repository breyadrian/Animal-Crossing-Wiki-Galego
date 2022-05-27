package com.example.acwiki.screens.fossils.partes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acwiki.AdminSQLiteOpenHelper;
import com.example.acwiki.R;
import com.example.acwiki.screens.fossils.FossilData;
import com.example.acwiki.screens.items.ItemData;
import com.example.acwiki.screens.items.varaintes.ItemVariantRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FossilFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FossilFragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View root;
    private FossilData data;
    ArrayList<FossilData> listarFosiles;
    FosilPartRecyclerViewAdapter adapter;
    AdminSQLiteOpenHelper conn;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FossilFragment2() {
        // Required empty public constructor
    }
    public FossilFragment2(FossilData data) {
        // Required empty public constructor
        this.data=data;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FossilFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static FossilFragment2 newInstance(String param1, String param2) {
        FossilFragment2 fragment = new FossilFragment2();
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
        root =  inflater.inflate(R.layout.fragment_fossil2, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.fossilRecyclerView);


        conn= new AdminSQLiteOpenHelper(getActivity(),"administracion",null,1);

        ArrayList<FossilData> info= consultar(data.getPart_of());
        adapter = new FosilPartRecyclerViewAdapter(info);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        return root;
    }


    private ArrayList<FossilData> consultar(String parte){
        SQLiteDatabase db=conn.getReadableDatabase();

        FossilData fossilData = null;
        listarFosiles= new ArrayList<FossilData>();
        Cursor cursor = db.rawQuery("SELECT * FROM Fossils where part_of='"+parte+"'",null);

        if(cursor.moveToFirst()){
            do{
                listarFosiles.add(new FossilData(cursor.getString(1),cursor.getInt(2),cursor.getString(3),cursor.getBlob(4),cursor.getString(5)));
            }while(cursor.moveToNext());
        }
        return listarFosiles;
    }
}