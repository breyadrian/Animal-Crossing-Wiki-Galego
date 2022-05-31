package com.example.acwiki.screens.music.background;

import android.app.Activity;
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
import com.example.acwiki.screens.music.MusicData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MusicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusicFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    AdminSQLiteOpenHelper conn;
    ArrayList<MusicData> listarMusica;
    private View root;
    private Activity activity;
    MusicRecyclerViewAdapter adapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MusicFragment() {
        // Required empty public constructor
    }
    public MusicFragment(Activity activity) {
        this.activity=activity;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MusicFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MusicFragment newInstance(String param1, String param2) {
        MusicFragment fragment = new MusicFragment();
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
        root = inflater.inflate(R.layout.fragment_music, container, false);

        conn= new AdminSQLiteOpenHelper(getActivity(),"administracion",null,1);
        RecyclerView recyclerView = root.findViewById(R.id.songRecyclerView);


        ArrayList<MusicData> data= consultar();
        adapter = new MusicRecyclerViewAdapter(data,activity);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return root;
    }



    private ArrayList<MusicData> consultar(){
        SQLiteDatabase db=conn.getReadableDatabase();


        listarMusica= new ArrayList<MusicData>();
        Cursor cursor = db.rawQuery("SELECT * FROM Musica",null);

        if(cursor.moveToFirst()){
            do{
                listarMusica.add(new MusicData(cursor.getInt(0),cursor.getInt(2),cursor.getString(3)));
            }while(cursor.moveToNext());
        }
        return listarMusica;
    }


}