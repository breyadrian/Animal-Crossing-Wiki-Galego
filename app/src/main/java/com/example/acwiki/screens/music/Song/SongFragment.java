package com.example.acwiki.screens.music.Song;

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
import com.example.acwiki.screens.music.SongData;
import com.example.acwiki.screens.music.background.MusicRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SongFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SongFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    AdminSQLiteOpenHelper conn;
    private View root;
    private Activity activity;
    SongRecyclerViewAdapter adapter;
    ArrayList<SongData> listarCancion;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SongFragment() {
        // Required empty public constructor
    }
    public SongFragment(Activity activity) {
     this.activity=activity;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SomgFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SongFragment newInstance(String param1, String param2) {
        SongFragment fragment = new SongFragment();
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
        root = inflater.inflate(R.layout.fragment_somg, container, false);
        conn= new AdminSQLiteOpenHelper(getActivity(),"administracion",null,1);
        RecyclerView recyclerView = root.findViewById(R.id.songRecyclerView);


        ArrayList<SongData> data= consultar();
        adapter = new SongRecyclerViewAdapter(data,activity);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return root;
    }


    private ArrayList<SongData> consultar(){
        SQLiteDatabase db=conn.getReadableDatabase();


        listarCancion= new ArrayList<SongData>();
        Cursor cursor = db.rawQuery("SELECT * FROM Canciones",null);

        if(cursor.moveToFirst()){
            do{
                listarCancion.add(new SongData(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4),cursor.getString(5),cursor.getBlob(7)));
            }while(cursor.moveToNext());
        }
        return listarCancion;
    }

}