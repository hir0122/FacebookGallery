package com.app.galleryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.app.galleryapp.Fragment.AlbumMainFragment;
import com.app.galleryapp.Fragment.PhotoMainFragment;
import com.app.galleryapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    // FramLayout에 각 메뉴의 Fragment를 바꿔 준다

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;

    // 2개의 메뉴에 들어갈 Fragment들
    Fragment photoFrag;
    Fragment albumFrag;

    // Search ImageView
    ImageView iv_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);

        iv_search = binding.facebookSearchIcon;
        iv_search.setImageResource(R.drawable.ic_baseline_search_24);
        iv_search.setOnClickListener(SearchIV);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.PHOTO_ITEM:
                        setFrag(0);
                        break;
                    case R.id.GALLERY_ITEM:
                        setFrag(1);
                        break;
                }
                return true;
            }
        });

        photoFrag=new PhotoMainFragment();
        albumFrag=new AlbumMainFragment();
        setFrag(0); // 첫 프래그먼트 화면 지정
    }

    // 프레그먼트 교체
    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 0:
                ft.replace(R.id.frameLayout, photoFrag);
                ft.commit();
                break;

            case 1:
                ft.replace(R.id.frameLayout, albumFrag);
                ft.commit();
                break;

        }
    }

    View.OnClickListener SearchIV=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(getApplicationContext(), SearchActivity.class);
            startActivity(intent);
        }
    };
}