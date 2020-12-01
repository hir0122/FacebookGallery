package com.app.galleryapp.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.galleryapp.R;
import com.app.galleryapp.databinding.FragmentAlbumMainBinding;

public class AlbumMainFragment extends Fragment {

    private View view;
    FragmentAlbumMainBinding binding;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_album_main, container, false);
        return view;
    }
}