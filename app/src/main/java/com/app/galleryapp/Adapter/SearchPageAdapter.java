package com.app.galleryapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.galleryapp.ItemObject;
import com.app.galleryapp.R;

import java.util.ArrayList;

public class SearchPageAdapter extends RecyclerView.Adapter<SearchPageAdapter.SearchViewHolder> {
    private ArrayList<ItemObject> mList;

    public static class SearchViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView_img;
        private TextView textView_title, textView_release, texView_director;
        public SearchViewHolder(View itemView) {
            super(itemView);
            imageView_img = (ImageView) itemView.findViewById(R.id.imageView_img);
            textView_title = (TextView) itemView.findViewById(R.id.textView_title);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public SearchPageAdapter(ArrayList<ItemObject> list) {
        this.mList = list;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SearchPageAdapter.SearchViewHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_search_pages, parent, false);
        return new SearchViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {

        holder.textView_title.setText(String.valueOf(mList.get(position).getTitle()));
        //다 해줬는데도 GlideApp 에러가 나면 rebuild project를 해주자.
        GlideApp.with(holder.itemView).load(mList.get(position).getImg_url())
                .override(300,400)
                .into(holder.imageView_img);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mList.size();
    }
}
