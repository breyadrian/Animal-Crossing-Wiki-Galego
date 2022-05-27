package com.example.acwiki.screens.fossils;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acwiki.R;
import com.example.acwiki.screens.fossils.partes.FossilFragment2;
import com.google.android.material.tabs.TabLayout;

public class DetailFossilActivity extends AppCompatActivity {
    private TabLayout tabLayout1;
    private ViewPager2 viewPager2;
    private FossilData data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_fossil);
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




        data = getIntent().getParcelableExtra("data");



        Bitmap bm= BitmapFactory.decodeByteArray(data.getImage_uri(), 0 ,data.getImage_uri().length);



        TextView fossilName = findViewById(R.id.fossilName);
        fossilName.setText(primeraMayuscula(data.getName()));

        ImageView fossilImagen =  findViewById(R.id.fossilImage);
        fossilImagen.setImageBitmap(bm);


        TextView fossilPrice = findViewById(R.id.fossilPrice);
        fossilPrice.setText("Prezo: "+data.getPrice());

        TextView fossilPart = findViewById(R.id.fossilPart);
        fossilPart.setText("Parte de: "+primeraMayuscula(data.getPart_of()));


    }

    class AdaptadorFragment extends FragmentStateAdapter {
        public AdaptadorFragment(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {


            switch (position){
                case 0: return new FossilFragment1(data);
                default: return new FossilFragment2(data);
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

}