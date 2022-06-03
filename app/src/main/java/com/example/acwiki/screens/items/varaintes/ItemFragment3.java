package com.example.acwiki.screens.items.varaintes;

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
import com.example.acwiki.screens.items.DetailItemActivity;
import com.example.acwiki.screens.items.ItemData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ItemFragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemFragment3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View root;
    AdminSQLiteOpenHelper conn;
    private ItemData data;
    ArrayList<ItemData> listarItem;
    ItemVariantRecyclerViewAdapter adapter;
    private Activity activity;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ItemFragment3() {
        // Required empty public constructor
    }
    public ItemFragment3(Activity activity, ItemData data) {
        // Required empty public constructor
        this.activity=activity;
        this.data=data;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ItemFragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static ItemFragment3 newInstance(String param1, String param2) {
        ItemFragment3 fragment = new ItemFragment3();
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
        root = inflater.inflate(R.layout.fragment_item3, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.itemVariantRecycler);


        conn= new AdminSQLiteOpenHelper(getActivity(),"administracion",null,1);

        ArrayList<ItemData> info= consultar(String.valueOf(data.getInternal_id()));
        adapter = new ItemVariantRecyclerViewAdapter(info);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        // Inflate the layout for this fragment
        return root;
    }


    private ArrayList<ItemData> consultar(String cod){
        SQLiteDatabase db=conn.getReadableDatabase();
        ItemData itemData = null;
        listarItem= new ArrayList<ItemData>();
        Cursor cursor = db.rawQuery("SELECT * FROM Items where internal_id='"+cod+"'",null);

        if(cursor.moveToFirst()){
            do{
                listarItem.add(new ItemData(
                        cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                        cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getInt(8), cursor.getString(9),
                        cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14),
                        cursor.getString(15), cursor.getString(16), cursor.getString(17), cursor.getString(18), cursor.getString(19),
                        cursor.getString(20), cursor.getString(21), cursor.getString(22), cursor.getString(23), cursor.getString(24),
                        cursor.getString(25), cursor.getString(26), cursor.getString(27), cursor.getInt(28), cursor.getString(29),
                        cursor.getInt(30), cursor.getInt(31), cursor.getBlob(32)));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return listarItem;
    }
}