package com.example.acwiki.screens.items;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acwiki.AdminSQLiteOpenHelper;
import com.example.acwiki.R;
import com.example.acwiki.screens.items.varaintes.ItemFragment3;
import com.example.acwiki.screens.items.varaintes.ItemVariantRecyclerViewAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class DetailItemActivity extends AppCompatActivity {

    private ItemData data;
    private Activity activity;
    private TabLayout tabLayout1;
    private ViewPager2 itemViewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);
        tabLayout1=findViewById(R.id.tabLayoutItem);
        itemViewPager2=findViewById(R.id.ViewPagerItem);
        activity=this;
        itemViewPager2.setAdapter(new AdaptadorFragment(getSupportFragmentManager(),getLifecycle()));
        itemViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout1.selectTab(tabLayout1.getTabAt(position));
            }
        });

        tabLayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                itemViewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




        data = getIntent().getParcelableExtra("data");
        Bitmap bm=null;
        if(data.getImage_uri()!=null) {
            bm= BitmapFactory.decodeByteArray(data.getImage_uri(), 0, data.getImage_uri().length);
            ImageView  imagenItem= findViewById(R.id.imageView2);
            imagenItem.setImageBitmap(bm);
        }


        TextView nombreItem = findViewById(R.id.nombreItem);
        nombreItem.setText("Nome: "+primeraMayuscula(data.getName()));


/*
        TextView hha_concept1 = findViewById(R.id.hha_concept1);
        hha_concept1.setText("getHha_concept_1: "+data.getHha_concept_1());

        TextView hha_concept2 = findViewById(R.id.hha_concept2);
        hha_concept2.setText("getHha_concept_2: "+data.getHha_concept_2());

        TextView hha_set = findViewById(R.id.hha_set);
        hha_set.setText("getHha_set: "+data.getHha_set());


        TextView hha_series = findViewById(R.id.hha_series);
        hha_series.setText("getHha_series: "+data.getHha_series());
*/


   //     TextView version = findViewById(R.id.version);
   //     version.setText("Version: "+data.getVersion());



   //     TextView speakerType = findViewById(R.id.speakerType);
   //     speakerType.setText("getSpeaker_type: "+data.getSpeaker_type());


   //    TextView iluminacion = findViewById(R.id.iluminacion);
   //     iluminacion.setText("getLighting_type: "+data.getLighting_type());




        System.out.println("skere");



        int Diy=Integer.parseInt(data.getIsDiy());
        if(Diy==1){
            TextView siDiyC = findViewById(R.id.siDiyC);
            TextView siDiy = findViewById(R.id.siDiy);
            siDiyC.setText("Si");
            siDiyC.setBackgroundColor(Color.parseColor("#FF9DFFB0"));
            siDiy.setBackgroundColor(Color.parseColor("#FF9DFFB0"));
        }

        int body=Integer.parseInt(data.getCanCustomizeBody());
        if(body==1){
            TextView canCustomizeBodyC = findViewById(R.id.canCustomizeBodyC);
            TextView canCustomizeBody = findViewById(R.id.canCustomizeBody);
            canCustomizeBodyC.setText("Si");
            canCustomizeBodyC.setBackgroundColor(Color.parseColor("#FF9DFFB0"));
            canCustomizeBody.setBackgroundColor(Color.parseColor("#FF9DFFB0"));
        }
        int CustomizePattern=Integer.parseInt(data.getCanCustomizePattern());
        if(CustomizePattern==1){
            TextView canCustomizePatternC = findViewById(R.id.canCustomizePatternC);
            TextView canCustomizePattern = findViewById(R.id.canCustomizePattern);
            canCustomizePatternC.setText("Si");
            canCustomizePatternC.setBackgroundColor(Color.parseColor("#FF9DFFB0"));
            canCustomizePattern.setBackgroundColor(Color.parseColor("#FF9DFFB0"));
        }
        int Interactive=Integer.parseInt(data.getIsInteractive());
        if(Interactive==1){
            TextView interactivoC = findViewById(R.id.interactivoC);
            TextView interactivo = findViewById(R.id.interactivo);
            interactivoC.setText("Si");
            interactivoC.setBackgroundColor(Color.parseColor("#FF9DFFB0"));
            interactivo.setBackgroundColor(Color.parseColor("#FF9DFFB0"));
        }
        int catalog=Integer.parseInt(data.getIsCatalog());
        if(catalog==1){
            TextView isCatalogC = findViewById(R.id.isCatalogC);
            TextView isCatalog = findViewById(R.id.isCatalog);
            isCatalogC.setText("Si");
            isCatalogC.setBackgroundColor(Color.parseColor("#FF9DFFB0"));
            isCatalog.setBackgroundColor(Color.parseColor("#FF9DFFB0"));
        }
        int Outdoor=Integer.parseInt(data.getIsOutdoor());
        if(Outdoor==1){
            TextView outDoorC = findViewById(R.id.outDoorC);
            TextView outDoor = findViewById(R.id.outDoor);
            outDoorC.setText("Si");
            outDoorC.setBackgroundColor(Color.parseColor("#FF9DFFB0"));
            outDoor.setBackgroundColor(Color.parseColor("#FF9DFFB0"));
        }
        int DoorDeco=Integer.parseInt(data.getIsDoorDeco());
        if(DoorDeco==1){
            TextView doorDecoC = findViewById(R.id.doorDecoC);
            TextView doorDeco = findViewById(R.id.doorDeco);
            doorDecoC.setText("Si");
            doorDecoC.setBackgroundColor(Color.parseColor("#FF9DFFB0"));
            doorDeco.setBackgroundColor(Color.parseColor("#FF9DFFB0"));

        }





    //    doorDeco.setText("getIsDoorDeco: "+data.getIsDoorDeco());

    }



    class AdaptadorFragment extends FragmentStateAdapter {
        public AdaptadorFragment(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {


            switch (position){
                case 0: return new ItemFragment1(data);
                case 1: return new ItemFragment2();
                default: return new ItemFragment3(activity,data);
            }
        }

        @Override
        public int getItemCount() {
            return 3;
        }
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