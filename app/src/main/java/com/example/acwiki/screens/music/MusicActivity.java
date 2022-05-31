package com.example.acwiki.screens.music;

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
import android.os.Bundle;

import com.example.acwiki.AdminSQLiteOpenHelper;
import com.example.acwiki.R;
import com.example.acwiki.screens.fish.DetailFishActivity;
import com.example.acwiki.screens.fish.FishFragment1;
import com.example.acwiki.screens.fish.FishFragment2;
import com.example.acwiki.screens.music.Song.SongFragment;
import com.example.acwiki.screens.music.background.MusicFragment;
import com.example.acwiki.screens.music.background.MusicRecyclerViewAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MusicActivity extends AppCompatActivity{

    private TabLayout tabLayout1;
    private ViewPager2 viewPager2;
    Activity activity;
    AdminSQLiteOpenHelper conn;
    ArrayList<String> listarinfo;
    ArrayList<MusicData> listarMusica;
    MusicRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);


        activity=this;
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
    }

    class AdaptadorFragment extends FragmentStateAdapter {
        public AdaptadorFragment(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {

            switch (position){
                case 0: return new SongFragment(activity);
                default: return new MusicFragment(activity);
            }
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }


}