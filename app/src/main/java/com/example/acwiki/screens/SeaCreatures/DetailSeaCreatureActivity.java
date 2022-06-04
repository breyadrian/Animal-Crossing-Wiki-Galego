package com.example.acwiki.screens.SeaCreatures;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acwiki.R;
import com.example.acwiki.screens.fish.DetailFishActivity;
import com.example.acwiki.screens.fish.FishData;
import com.example.acwiki.screens.fish.FishFragment1;
import com.example.acwiki.screens.fish.FishFragment2;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailSeaCreatureActivity extends AppCompatActivity {
    private TabLayout tabLayout1;
    private ViewPager2 viewPager2;
    private SeaCreatureData data;
    private TextView meses;
    private TextView horas;
    private String fraseCaptura;
    private String fraseMuseo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sea_creature);

        data = getIntent().getParcelableExtra("data");

        Bitmap bm= BitmapFactory.decodeByteArray(data.getImage_uri(), 0 ,data.getImage_uri().length);

        tabLayout1=findViewById(R.id.tabLayout);
        viewPager2=findViewById(R.id.viewPager2);

        viewPager2.setAdapter(new AdaptadorFragment(getSupportFragmentManager(),getLifecycle()));
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout1.selectTab(tabLayout1.getTabAt(position));
            }
        });

        tabLayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        String mesesNorte = null;
        String horario = null;

        JSONArray mesesArrayNorte =null;
        JSONArray horasArray=null;

        boolean isAllDay=false;
        boolean isAllYear=false;
        try {
            JSONObject jsonObject = new JSONObject(data.getAvailability());
            System.out.println("OBJECT : "+jsonObject.toString());

            mesesNorte = jsonObject.getString("month-northern");
            String mesesSur = jsonObject.getString("month-southern");
            horario =  jsonObject.getString("time");
            isAllDay = jsonObject.getBoolean("isAllDay");
            isAllYear = jsonObject.getBoolean("isAllYear");

            mesesArrayNorte = jsonObject.getJSONArray("month-array-northern");
            JSONArray mesesArraySur = jsonObject.getJSONArray("month-array-southern");
            horasArray = jsonObject.getJSONArray("time-array");

        } catch (JSONException e) {
            e.printStackTrace();
        }




        meses=findViewById(R.id.creatureMeses);
        if(isAllYear) {
            meses.setText("Todo o ano");
        }else{
            meses.setText(mesesNorte);
        }
        horas=findViewById(R.id.tituloHoras);
        if(isAllDay) {
            horas.setText("Todo o dia");
        }else{
            horas.setText(horario);
        }

        fraseCaptura=primeraMayuscula(data.getFraseCaptura());
        fraseMuseo=primeraMayuscula((data.getFraseMuseo()));
        setMonths(mesesArrayNorte);
        setHoras(horasArray);
        System.out.println("holas"+data.getPrecio());


      //TextView rarezaFish = findViewById(R.id.creatureCatch_phrase);
      //rarezaFish.setText("Rareza: "+primeraMayuscula(data.getFraseCaptura()));
      //TextView fishLocation = findViewById(R.id.museo);
      //fishLocation.setText("Ubicación: "+primeraMayuscula(data.getFraseMuseo()));



        TextView fishName = findViewById(R.id.creatureName);
        fishName.setText(primeraMayuscula(data.getName()));

        ImageView fishImagen =  findViewById(R.id.creatureImage);
        fishImagen.setImageBitmap(bm);


    }
    class AdaptadorFragment extends FragmentStateAdapter {
        public AdaptadorFragment(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0: return new SeaCreatureFragment1(data);
                default: return new SeaCreatureFragment2(fraseCaptura,fraseMuseo);
            }
        }

        @Override
        public int getItemCount() {
            return 2;
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


    public String getShadow (String shadow){

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

    public void setMonths(JSONArray mesesArrayNorte){
        TextView mes=null;
        TextView mesC=null;

        for (int i=0;i<mesesArrayNorte.length();i++) {

            try {

                switch (mesesArrayNorte.getInt(i)){
                    case(1):
                        mes=findViewById(R.id.Xanerio);
                        mes.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(2):
                        mes=findViewById(R.id.Febreiro);
                        mes.setBackgroundColor(Color.parseColor("#40ECF6"));

                        break;
                    case(3):
                        mes=findViewById(R.id.Marzo);
                        mes.setBackgroundColor(Color.parseColor("#40ECF6"));

                        break;
                    case(4):
                        mes=findViewById(R.id.Abril);
                        mes.setBackgroundColor(Color.parseColor("#40ECF6"));

                        break;
                    case(5):
                        mes=findViewById(R.id.Maio);
                        mes.setBackgroundColor(Color.parseColor("#40ECF6"));

                        break;
                    case(6):
                        mes=findViewById(R.id.Xunio);
                        mes.setBackgroundColor(Color.parseColor("#40ECF6"));

                        break;
                    case(7):
                        mes=findViewById(R.id.Xullo);
                        mes.setBackgroundColor(Color.parseColor("#40ECF6"));

                        break;
                    case(8):
                        mes=findViewById(R.id.Agosto);
                        mes.setBackgroundColor(Color.parseColor("#40ECF6"));

                        break;
                    case(9):
                        mes=findViewById(R.id.Septembo);
                        mes.setBackgroundColor(Color.parseColor("#40ECF6"));

                        break;
                    case(10):
                        mes=findViewById(R.id.Outubro);
                        mes.setBackgroundColor(Color.parseColor("#40ECF6"));

                        break;
                    case(11):
                        mes=findViewById(R.id.Novembro);
                        mes.setBackgroundColor(Color.parseColor("#40ECF6"));

                        break;
                    case(12):
                        mes=findViewById(R.id.Decembro);
                        mes.setBackgroundColor(Color.parseColor("#40ECF6"));

                        break;
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }



    }


    public void setHoras(JSONArray horasArray){
        TextView hora=null;


        for (int i=0;i<horasArray.length();i++) {

            try {

                switch (horasArray.getInt(i)){
                    case(0):
                        hora=findViewById(R.id.hora0);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(1):
                        hora=findViewById(R.id.hora1);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(2):
                        hora=findViewById(R.id.hora2);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(3):
                        hora=findViewById(R.id.hora3);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(4):
                        hora=findViewById(R.id.hora4);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(5):
                        hora=findViewById(R.id.hora5);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(6):
                        hora=findViewById(R.id.hora6);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(7):
                        hora=findViewById(R.id.hora7);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(8):
                        hora=findViewById(R.id.hora8);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(9):
                        hora=findViewById(R.id.hora9);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(10):
                        hora=findViewById(R.id.hora10);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(11):
                        hora=findViewById(R.id.hora11);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(12):
                        hora=findViewById(R.id.hora12);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(13):
                        hora=findViewById(R.id.hora13);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(14):
                        hora=findViewById(R.id.hora14);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(15):
                        hora=findViewById(R.id.hora15);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(16):
                        hora=findViewById(R.id.hora16);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(17):
                        hora=findViewById(R.id.hora17);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(18):
                        hora=findViewById(R.id.hora18);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(19):
                        hora=findViewById(R.id.hora19);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(20):
                        hora=findViewById(R.id.hora20);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(21):
                        hora=findViewById(R.id.hora21);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(22):
                        hora=findViewById(R.id.hora22);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                    case(23):
                        hora=findViewById(R.id.hora23);
                        hora.setBackgroundColor(Color.parseColor("#40ECF6"));
                        break;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}