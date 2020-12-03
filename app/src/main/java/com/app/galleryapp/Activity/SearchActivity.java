package com.app.galleryapp.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.app.galleryapp.Fragment.SearchFragment.SearchPeopleFragment;
import com.app.galleryapp.Fragment.SearchFragment.SearchPagesFragment;
import com.app.galleryapp.Fragment.SearchFragment.SearchVideosFragment;
import com.app.galleryapp.R;
import com.app.galleryapp.databinding.ActivitySearchBinding;

public class SearchActivity extends AppCompatActivity {
    ActivitySearchBinding binding;

    EditText FacebookSearch;
    Button SearchPeopleBtn, SearchPagesBtn, SearchVideosBtn;

    private FragmentManager fm;
    private FragmentTransaction ft;

    // 2개의 메뉴에 들어갈 Fragment들
    Fragment pageFrag;
    Fragment peopleFrag;
    Fragment videoFrag;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);

        FacebookSearch = binding.etFacebookSearchbar;
        //FacebookSearch.addTextChangedListener(textWatcher);

        SearchPeopleBtn=binding.btnPeople;
        SearchPagesBtn=binding.btnPages;
        SearchVideosBtn=binding.btnVideos;

        SearchPeopleBtn.setOnClickListener(ClickSearchPeople);
        SearchPagesBtn.setOnClickListener(ClickSearchPages);
        SearchVideosBtn.setOnClickListener(ClickSearchVideos);

        peopleFrag=new SearchPagesFragment();
        pageFrag=new SearchPeopleFragment();
        videoFrag=new SearchVideosFragment();
        setFrag(0);

    }

//    private final TextWatcher textWatcher=new TextWatcher() {
//        @Override
//        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//            // 입력하기 전에
//        }
//
//        @Override
//        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//            // 입력되는 텍스트에 변화가 있을 때
//        }
//
//        @Override
//        public void afterTextChanged(Editable editable) {
//            // 입력이 끝났을 때
//        }
//    };

    // 프레그먼트 교체
    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 0:
                ft.replace(R.id.SearchFrameLayout, peopleFrag);
                ft.commit();
                break;

            case 1:
                ft.replace(R.id.SearchFrameLayout, pageFrag);
                ft.commit();
                break;

            case 2:
                ft.replace(R.id.SearchFrameLayout, videoFrag);
                ft.commit();
                break;

        }
    }

    View.OnClickListener ClickSearchPeople=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setFrag(0);
        }
    };

    View.OnClickListener ClickSearchPages=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setFrag(1);
        }
    };

    View.OnClickListener ClickSearchVideos=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setFrag(2);
        }
    };

    // https://m.facebook.com/notifications.php?soft=search : 아무것도 검색 안했을시

    // https://m.facebook.com/search/videos/?q=dks : 동영상 검색 - 동영상 표지, 동영상 이름, 게시자명, 몇명시청 또는 조회수, WatchVideo Download 선택가능

    // https://m.facebook.com/search/people/?q=hi : 사람 검색 - 프로필 이름

    // https://m.facebook.com/search/pages/?q=yes : 페이지 검색 - 프로필 이름 페이지몇명이좋아하는지 간단한한줄설명같은거
}
