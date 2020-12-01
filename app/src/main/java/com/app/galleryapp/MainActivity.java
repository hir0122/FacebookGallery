package com.app.galleryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.app.galleryapp.Fragment.AlbumMainFragment;
import com.app.galleryapp.Fragment.PhotoMainFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    // FramLayout에 각 메뉴의 Fragment를 바꿔 준다
    private FragmentManager fragmentManager=getSupportFragmentManager();

    // 2개의 메뉴에 들어갈 Fragment들
    Fragment photoFrag;
    Fragment albumFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photoFrag=new PhotoMainFragment();
        albumFrag=new AlbumMainFragment();

        // 초기화면 설정
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, photoFrag).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener(){
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item){
                        switch(item.getItemId()){
                            case R.id.PHOTO_ITEM:
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, photoFrag).commit();
                                return true;

                            case R.id.GALLERY_ITEM:
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, albumFrag).commit();
                                return true;
                        }
                        return false;
                    }
                }
        );
    }
}