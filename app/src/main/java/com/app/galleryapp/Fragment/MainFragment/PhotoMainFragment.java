package com.app.galleryapp.Fragment.MainFragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.galleryapp.R;
import com.app.galleryapp.databinding.FragmentPhotoMainBinding;

public class PhotoMainFragment extends Fragment {

    private View view;
    FragmentPhotoMainBinding binding;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_photo_main, container, false);
        return view;
    }
}