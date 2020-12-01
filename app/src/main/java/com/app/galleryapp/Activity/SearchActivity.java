package com.app.galleryapp.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.app.galleryapp.R;
import com.app.galleryapp.databinding.ActivitySearchBinding;

public class SearchActivity extends AppCompatActivity {
    ActivitySearchBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);
    }

    // https://m.facebook.com/notifications.php?soft=search : 아무것도 검색 안했을시

    // https://m.facebook.com/search/videos/?q=dks : 동영상 검색 - 동영상 표지, 동영상 이름, 게시자명, 몇명시청 또는 조회수, WatchVideo Download 선택가능

    // https://m.facebook.com/search/people/?q=hi : 사람 검색 - 프로필 이름

    // https://m.facebook.com/search/pages/?q=yes : 페이지 검색 - 프로필 이름 페이지몇명이좋아하는지 간단한한줄설명같은거
}
