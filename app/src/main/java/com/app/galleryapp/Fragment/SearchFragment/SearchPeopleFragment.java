package com.app.galleryapp.Fragment.SearchFragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.app.galleryapp.Activity.SearchActivity;
import com.app.galleryapp.Adapter.SearchPageAdapter;
import com.app.galleryapp.ItemObject;
import com.app.galleryapp.R;
import com.facebook.AccessToken;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import static com.facebook.FacebookSdk.getApplicationContext;
import static org.jsoup.nodes.Document.OutputSettings.Syntax.html;

public class SearchPeopleFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<ItemObject> list = new ArrayList();

    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    EditText et_get_fb_searchbar;

    AccessToken accessToken = AccessToken.getCurrentAccessToken();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_search_pages, container, false);

        //AsyncTask 작동시킴(파싱)
        new Description().execute();

        recyclerView = (RecyclerView) rootView.findViewById(R.id.peopleRecycleView);

//        recyclerView.setHasFixedSize(true);
//        adapter = new SearchPageAdapter(getActivity(), mList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.setAdapter(adapter);

        return rootView;
    }

    private class Description extends AsyncTask<Void, Void, Void> {

        //진행바표시
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //진행다이어로그 시작
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("잠시 기다려 주세요.");
            progressDialog.show();

        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document doc = Jsoup.connect("https://graph.facebook.com/search?q="+"hello"+"&type=user&accessToken"+accessToken).get();
                Elements mElementDataSize = doc.select("div[class=_45fu _45fx _4d7h _1e0o]").select("div[class=_a5o _9_7 _2rgt _1j-f]"); //필요한 녀석만 꼬집어서 지정
                int mElementSize = mElementDataSize.size(); //목록이 몇개인지 알아낸다. 그만큼 루프를 돌려야 하나깐.
                Log.d("size","mElementDataSize : " + mElementSize);

                for(Element elem : mElementDataSize){ //이렇게 요긴한 기능이
                    Element inclueAllElem = elem.select("div [class=_9_7 _2rgt _1j-f _2rgt] div").next().first();


                    //영화목록 <li> 에서 다시 원하는 데이터를 추출해 낸다.
                    String my_imgUrl = inclueAllElem.select("div[class=_k7v _2rgt _1j-f _2rgt _3zi4 _2rgt _1j-f _2rgt img] img").attr("src");
                    //특정하기 힘들다... 저 앞에 있는집의 오른쪽으로 두번째집의 건너집이 바로 우리집이야 하는 식이다.

                    Element nameElem = inclueAllElem.select("div[_a5o _a5t _9_7 _2rgt _1j-f _2rgt]")
                            .select("div [class=_a58 _9_7 _2rgt _1j-f _2rgt] div")
                            .select("div [class=_a5o _9_7 _2rgt _1j-f _2rgt] div")
                            .next().first();
                    String user_Title = nameElem.select("div[class=_59k _2rgt _1j-f _2rgt] span").text();
                    //Log.d("test", "test" + mTitle);
                    //ArrayList에 계속 추가한다.
                    list.add(new ItemObject(user_Title, my_imgUrl));
                }

                //추출한 전체 <li> 출력해 보자.
                Log.d("debug :", "List " + mElementDataSize);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            recyclerView.setHasFixedSize(true);

            //ArraList를 인자로 해서 어답터와 연결한다.
            SearchPageAdapter adapter = new SearchPageAdapter(list);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
            progressDialog.dismiss();
        }
    }
}