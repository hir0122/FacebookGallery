package com.app.galleryapp;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    public void Toast(String text){
        Toast.makeText(this,text, Toast.LENGTH_SHORT).show();
    }
}
